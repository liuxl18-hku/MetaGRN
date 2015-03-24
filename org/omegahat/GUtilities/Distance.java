

  package org.omegahat.GUtilities;

   
    import Jama.Matrix;

    /* none */


public class Distance
{
    
        /* none */

        
        /* none */

    
        /* none */

    

    static Matrix cachedCovMat  = null;
    static Matrix cachedInverse = null;

    static int cacheLength = 20;
    static int cacheIndex  = 0;
    static double[][][]  covKey   = new double[cacheLength][][];
    static Matrix[]      matCache = new Matrix[cacheLength];
    static Matrix[]      invCache = new Matrix[cacheLength];

    static protected void cacheCov( double[][] cov )
    {
        boolean found = false;
        for(int i = 0 ; !found && i < cacheLength; i++ )
            if (cov == covKey[i])
                {
                    //System.err.println("cov found in Cache.  Using cached values for covMat and invMat. ");
                    found = true;
                    cachedCovMat  = matCache[i];
                    cachedInverse = invCache[i];
                }
        if(!found)
            {
                //System.err.println("cov NOT found in Cache.  Adding  covMat and invMat to cache. ");
                cacheIndex = (cacheIndex+1) % cacheLength;
                covKey[cacheIndex]                   = cov;
                cachedCovMat  = matCache[cacheIndex] = new Matrix(cov);
                cachedInverse = invCache[cacheIndex] = cachedCovMat.inverse();
            }
    }



    /** squared Mahalanobis distance **/
    static public double mahalanobis_2( double[] x, double[] y, double[][] cov)
    {
        Matrix yMat = new Matrix(y, y.length);
        Matrix xMat = (new Matrix(x, x.length)).minus(yMat) ;


        //    Matrix covMat = new Matrix(cov);
        //    Matrix iCov   = covMat.inverse();

        cacheCov( cov );

        Matrix covMat = cachedCovMat;
        Matrix iCov   = cachedInverse;

        double retval = (((xMat.transpose()).times(iCov)).times(xMat)).get(0,0);

        return retval;
    }

    /** Mahalanobis distance **/
    static public double mahalanobis( double[] x, double[] y, double[][] cov)
    {
        return Math.sqrt(mahalanobis_2(x,y,cov));
    }

    /** squared euclidean distance **/
    static public double euclidean_2( double[] x, double[] y)
    {
        if( x.length != y.length ) throw new RuntimeException("Arguments must have same number of dimensions.");

        double cumssq = 0.0;
        for(int i=0; i < x.length; i++)
            cumssq += (x[i] - y[i]) * (x[i] - y[i]);

        return cumssq;
    }

    /** euclidean distance **/
    static public double euclidean( double[] x, double[] y)
    {
        return Math.sqrt( euclidean_2(x,y) );
    }


    
        /* none */

}
