/*
 * Created on Mar 7, 2003
 *
 * This file is part of Bayesian Network tools in Java (BNJ).
 *
 * BNJ is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * BNJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BNJ in LICENSE.txt file; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edu.ksu.cis.bnj.bbn.inference.approximate.sampling;

import java.io.*;
import java.util.*;

import javax.swing.JDialog;

import edu.ksu.cis.bnj.bbn.*;
import edu.ksu.cis.bnj.bbn.inference.*;
import edu.ksu.cis.bnj.bbn.inference.ls.LS;
import edu.ksu.cis.kdd.util.*;
import edu.ksu.cis.kdd.data.*;
//import edu.ksu.cis.kdd.data.converter.*;

/**
 * Pearl MCMC method
 * 
 * @author Roby Joehanes
 */
public class PearlMCMC extends MCMC {
    public PearlMCMC(){}
	/**
	 * @param g
	 */
	public PearlMCMC(BBNGraph g) {
		super(g);
	}

    public String getName() {
        return "Pearl MCMC";
    }

	/**
	 * @see edu.ksu.cis.bnj.bbn.inference.Inference#getMarginals()
	 */
	public InferenceResult getMarginals() {
        InferenceResult result = new InferenceResult();
        Hashtable valueCache = new Hashtable();
        BBNNode[] nodes = (BBNNode[]) graph.topologicalSort().toArray(new BBNNode[0]);
        int max = nodes.length;
        if (generateSamples) tuples = new Table();

        // pre-process
        for (int i = 0; i < max; i++) {
            BBNNode node = nodes[i];
            String nodeName = node.getName();
            BBNDiscreteValue dval = (BBNDiscreteValue) node.getValues();
            Hashtable values = new Hashtable();
            String[] valueArray = new String[dval.size()];
            Attribute attr = new Attribute(nodeName);
            int idx = 0;
            for (Iterator j = dval.iterator(); j.hasNext(); idx++) {
                String value = j.next().toString();
                valueArray[idx] = value;
                values.put(value, new Double(0.0));
                if (generateSamples) attr.addValue(value);
            }
            valueCache.put(nodeName, valueArray);
            result.put(nodeName, values);
            if (generateSamples) {
                tuples.addAttribute(attr);
            }
        }

        Hashtable chosen = new Hashtable();

        // choose the values randomly
        for (int i = 0; i < max; i++) {
            BBNNode node = nodes[i];
            String nodeName = node.getName();
            String chosenValue;
            if (!node.isEvidence()) {
                String[] values = (String[]) valueCache.get(nodeName);
                int arity = values.length;
                chosenValue = values[random.nextInt(arity)]; 
            } else {
                chosenValue = node.getEvidenceValue().toString();
            }
            chosen.put(nodeName, chosenValue);
        }
        
        if (rmseWriter != null) rmseWriter.setGraph(graph);

        // XXX
        setAbortTimer();    

        // main loop
        // note: This is not optimized yet. the proper way to do it is
        // starting from the root and proceed. Also eliminate unused
        // entries from chosen Hashtable.
        for (int iteration = 0; (!abort && (iteration < maxIteration)); iteration++) { //XXX
            Hashtable newChosen = new Hashtable();

            if (generateSamples) {
                Tuple t = new Tuple();
                for (int i = 0; i < max; i++) {
                    BBNNode node = nodes[i];
                    String nodeName = node.getName();
                    String chosenVal = (String) chosen.get(nodeName);
                    t.addValue(chosenVal);
                }
                tuples.addTuple(t);
            }

            for (int i = 0; i < max; i++) {
                BBNNode node = nodes[i];
                Hashtable markov = getMarkovBlanketScore(node, chosen);
                String nodeName = node.getName();
                double total = 0.0;
                double rouletteValue = random.nextDouble();

                Hashtable resultTbl = (Hashtable) result.get(nodeName);
                for (Enumeration j = markov.keys(); j.hasMoreElements(); ) {
                    Object value = j.nextElement();
                    double d = ((Double) markov.get(value)).doubleValue();
                    total += d;
                    double p = ((Double) resultTbl.get(value)).doubleValue();

                    if (!useMarkovBlanketScore) {
                        if (total > rouletteValue) {
                            resultTbl.put(value, new Double(p+1.0));
                            newChosen.put(nodeName, value);
                            break;
                        }
                    } else {
                        resultTbl.put(value, new Double(p+d));
                        if (total > rouletteValue && newChosen.get(nodeName) == null) {
                            newChosen.put(nodeName, value);
                        }
                    }
                }
            }
            chosen = newChosen;
            
            if (rmseWriter != null) {
                InferenceResult rclone = (InferenceResult) result.clone();
                rclone.normalize();
                rmseWriter.calculateRMSE(rclone);
            }
        }

        // Normalize
        for (int i = 0; i < max; i++) {
            BBNNode node = nodes[i];
            String nodeName = node.getName();
            Hashtable resultTbl = (Hashtable) result.get(nodeName);

            double total = 0.0;
            for (Enumeration e = resultTbl.keys(); e.hasMoreElements(); ) {
                double d = ((Double) resultTbl.get(e.nextElement())).doubleValue();
                total += d;
            }

            for (Enumeration e = resultTbl.keys(); e.hasMoreElements(); ) {
                Object value = e.nextElement();
                if (node.isEvidence()) {
                    if (value.equals(node.getEvidenceValue())) {
                        resultTbl.put(value, new Double(1.0));
                    } else {
                        resultTbl.put(value, new Double(0.0));
                    }
                } else {
                    double d = ((Double) resultTbl.get(value)).doubleValue();
                    resultTbl.put(value, new Double(d/total));
                }
            }
        }
		
        // XXX
        cancelAbortTimer();    

        if (rmseWriter != null) {
            rmseWriter.dump();
            rmseWriter.close();
        }
        return result;
	}
	
    public static void main(String[] args) {
        ParameterTable params = Parameter.process(args);
        String inputFile = params.getString("-i");
        String evidenceFile = params.getString("-e");
        String outputFile = params.getString("-o");
        String dataOutput = params.getString("-d");
		String rmseOut = params.getString("-ro");
        int numIter = params.getInt("-n", defaultMaxIteration);
        boolean quiet = params.getBool("-q");
        boolean rmse = params.getBool("-r");
        boolean markov = params.getBool("-m");
        long runningTimeLimit = params.getLong("-l", MCMC.NO_TIME_LIMIT); // XXX

        if (inputFile == null) {
            System.out.println("Usage: edu.ksu.cis.bnj.bbn.inference.approximate.sampling.PearlMCMC -i:inputfile [-e:evidencefile] [-o:outputfile] [-q] [-n:numiteration] [-l:runTimeLimit] [-r] [-ro:rmseOutputFile] [-m] [-d:generateddataoutputfile]"); // XXX
            System.out.println("-q = quiet mode");
            System.out.println("-n = number of iteration, default = "+defaultMaxIteration);
            System.out.println("-l = use Running time limit"); // XXX
            System.out.println("-r = calculate RMSE error");
            System.out.println("-m = use Markov blanket score");
            System.out.println("-d = generate data and output it to a file");
			System.out.println("-ro = output RMSE result per iteration into a file");
            return;
        }

        if (!quiet) {
            System.out.println("Pearl MCMC");
        }

        Runtime r = Runtime.getRuntime();
        long origfreemem = r.freeMemory();
        long freemem;

        BBNGraph g = BBNGraph.load(inputFile);
        if (evidenceFile != null) g.loadEvidence(evidenceFile);

        long origTime = System.currentTimeMillis();

        PearlMCMC pearlmcmc = new PearlMCMC(g);
        pearlmcmc.setMaxIteration(numIter);
        pearlmcmc.setUseMarkovBlanketScore(markov);
        pearlmcmc.generateData(dataOutput != null);
        pearlmcmc.setRunningTimeLimit(runningTimeLimit); // XXX
        
		if (rmseOut != null) {
			try {
				FileOutputStream outfile = new FileOutputStream(rmseOut);
				pearlmcmc.setRMSEfile(outfile);
			}
			catch (IOException ioe) {
				System.out.println("error writing to rmse file");
			}
		}

        InferenceResult result = pearlmcmc.getMarginals();

        freemem = origfreemem - r.freeMemory();
        long learnTime = System.currentTimeMillis();

        if (outputFile != null) result.save(outputFile);
        if (dataOutput != null) pearlmcmc.tuples.save(dataOutput);

        if (!quiet) {
            System.out.println("Final result:");
            System.out.println(result.toString());
            System.out.println("Memory needed for Pearl MCMC = "+freemem);
            System.out.println("Inference time = "+((learnTime - origTime) / 1000.0));
        }

        if (rmse) {
             LS ls = new LS(g);
             InferenceResult lsResult = ls.getMarginals();
             double rmseError = lsResult.computeRMSE(result);
             System.out.println("RMSE = "+rmseError);
             if (outputFile != null) {
                 try {
                     String ln = System.getProperty("line.separator");
                     FileWriter fw = new FileWriter(outputFile, true);
                     fw.write("RMSE = "+rmseError+ln);
                     fw.flush();
                     fw.close();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}
