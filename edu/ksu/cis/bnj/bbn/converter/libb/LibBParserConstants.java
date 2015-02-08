/* Generated By:JJTree&JavaCC: Do not edit this line. LibBParserConstants.java */
package edu.ksu.cis.bnj.bbn.converter.libb;

/*
 * 
 * This file is part of Bayesian Network for Java (BNJ).
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
 * 
 */
public interface LibBParserConstants {

  int EOF = 0;
  int SINGLE_LINE_COMMENT = 7;
  int VAR = 9;
  int NETWORK = 10;
  int PARENTS = 11;
  int PROBABILITY = 12;
  int INTEGER_LITERAL = 13;
  int DECIMAL_LITERAL = 14;
  int HEX_LITERAL = 15;
  int OCTAL_LITERAL = 16;
  int FLOATING_POINT_LITERAL = 17;
  int EXPONENT = 18;
  int STRING_LITERAL = 19;
  int IDENTIFIER = 20;
  int LETTER = 21;
  int DIGIT = 22;
  int LPAREN = 23;
  int RPAREN = 24;
  int LBRACE = 25;
  int RBRACE = 26;
  int LBRACKET = 27;
  int RBRACKET = 28;
  int SEMICOLON = 29;
  int COMMA = 30;
  int DOT = 31;
  int ASSIGN = 32;
  int GT = 33;
  int LT = 34;
  int BANG = 35;
  int TILDE = 36;
  int HOOK = 37;
  int COLON = 38;
  int EQ = 39;
  int LE = 40;
  int GE = 41;
  int NE = 42;
  int SC_OR = 43;
  int SC_AND = 44;
  int SC_XOR = 45;
  int INCR = 46;
  int DECR = 47;
  int PLUS = 48;
  int MINUS = 49;
  int STAR = 50;
  int SLASH = 51;
  int BIT_AND = 52;
  int BIT_OR = 53;
  int BIT_XOR = 54;
  int LSHIFT = 55;
  int RSIGNEDSHIFT = 56;
  int RUNSIGNEDSHIFT = 57;
  int PLUSASSIGN = 58;
  int MINUSASSIGN = 59;
  int STARASSIGN = 60;
  int SLASHASSIGN = 61;
  int ANDASSIGN = 62;
  int ORASSIGN = 63;
  int XORASSIGN = 64;
  int REMASSIGN = 65;
  int LSHIFTASSIGN = 66;
  int RSIGNEDSHIFTASSIGN = 67;
  int RUNSIGNEDSHIFTASSIGN = 68;
  int TOWARD = 69;
  int ASG_OPR = 70;

  int DEFAULT = 0;
  int IN_SINGLE_LINE_COMMENT = 1;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"%\"",
    "<SINGLE_LINE_COMMENT>",
    "<token of kind 8>",
    "\"var\"",
    "\"network\"",
    "\"parents\"",
    "\"probability\"",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<STRING_LITERAL>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\",\"",
    "\".\"",
    "\"=\"",
    "\">\"",
    "\"<\"",
    "\"!\"",
    "\"~\"",
    "\"?\"",
    "\":\"",
    "\"==\"",
    "\"<=\"",
    "\">=\"",
    "\"!=\"",
    "\"||\"",
    "\"&&\"",
    "\"^^\"",
    "\"++\"",
    "\"--\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"&\"",
    "\"|\"",
    "\"^\"",
    "\"<<\"",
    "\">>\"",
    "\">>>\"",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\"&=\"",
    "\"|=\"",
    "\"^=\"",
    "\"%=\"",
    "\"<<=\"",
    "\">>=\"",
    "\">>>=\"",
    "\"->\"",
    "<ASG_OPR>",
    "\"\\\'\"",
  };

}
