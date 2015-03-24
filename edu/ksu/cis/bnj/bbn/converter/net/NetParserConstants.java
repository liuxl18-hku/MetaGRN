/* Generated By:JJTree&JavaCC: Do not edit this line. NetParserConstants.java */
package edu.ksu.cis.bnj.bbn.converter.net;
/*
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
 */

public interface NetParserConstants {

  int EOF = 0;
  int SINGLE_LINE_COMMENT = 7;
  int CLASS = 9;
  int NET = 10;
  int NODE = 11;
  int POTENTIAL = 12;
  int LABEL = 13;
  int POSITION = 14;
  int STATES = 15;
  int DATA = 16;
  int NORMAL = 17;
  int INPUTS = 18;
  int OUTPUTS = 19;
  int NODE_SIZE = 20;
  int CONTINUOUS = 21;
  int DISCRETE = 22;
  int SUBTYPE = 23;
  int UTILITY = 24;
  int DECISION = 25;
  int INTEGER_LITERAL = 26;
  int DECIMAL_LITERAL = 27;
  int HEX_LITERAL = 28;
  int OCTAL_LITERAL = 29;
  int FLOATING_POINT_LITERAL = 30;
  int EXPONENT = 31;
  int CHARACTER_LITERAL = 32;
  int STRING_LITERAL = 33;
  int NON_ESCAPED_LITERAL = 35;
  int ESCAPE_SEQ = 36;
  int ESCAPE_OCTAL = 37;
  int ESCAPE_UNICODE = 38;
  int IDENTIFIER = 40;
  int LETTER = 41;
  int DIGIT = 42;
  int LPAREN = 43;
  int RPAREN = 44;
  int LBRACE = 45;
  int RBRACE = 46;
  int LBRACKET = 47;
  int RBRACKET = 48;
  int SEMICOLON = 49;
  int COMMA = 50;
  int DOT = 51;
  int ASSIGN = 52;
  int GT = 53;
  int LT = 54;
  int BANG = 55;
  int TILDE = 56;
  int HOOK = 57;
  int COLON = 58;
  int EQ = 59;
  int LE = 60;
  int GE = 61;
  int NE = 62;
  int SC_OR = 63;
  int SC_AND = 64;
  int SC_XOR = 65;
  int INCR = 66;
  int DECR = 67;
  int PLUS = 68;
  int MINUS = 69;
  int STAR = 70;
  int SLASH = 71;
  int BIT_AND = 72;
  int BIT_OR = 73;
  int BIT_XOR = 74;
  int LSHIFT = 75;
  int RSIGNEDSHIFT = 76;
  int RUNSIGNEDSHIFT = 77;
  int PLUSASSIGN = 78;
  int MINUSASSIGN = 79;
  int STARASSIGN = 80;
  int SLASHASSIGN = 81;
  int ANDASSIGN = 82;
  int ORASSIGN = 83;
  int XORASSIGN = 84;
  int REMASSIGN = 85;
  int LSHIFTASSIGN = 86;
  int RSIGNEDSHIFTASSIGN = 87;
  int RUNSIGNEDSHIFTASSIGN = 88;
  int TOWARD = 89;
  int ASG_OPR = 90;

  int DEFAULT = 0;
  int IN_SINGLE_LINE_COMMENT = 1;
  int CHAR_LIT = 2;
  int ESCAPED_CHAR_LIT = 3;
  int CHAR_LIT_CLOSE = 4;

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
    "\"class\"",
    "\"net\"",
    "\"node\"",
    "\"potential\"",
    "\"label\"",
    "\"position\"",
    "\"states\"",
    "\"data\"",
    "\"normal\"",
    "\"inputs\"",
    "\"outputs\"",
    "\"node_size\"",
    "\"continuous\"",
    "\"discrete\"",
    "\"subtype\"",
    "\"utility\"",
    "\"decision\"",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "\"\\\'\"",
    "<STRING_LITERAL>",
    "\"\\\\\"",
    "<NON_ESCAPED_LITERAL>",
    "<ESCAPE_SEQ>",
    "<ESCAPE_OCTAL>",
    "<ESCAPE_UNICODE>",
    "\"\\\'\"",
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
  };

}
