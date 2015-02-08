/* Generated By:JJTree&JavaCC: Do not edit this line. ArffParserConstants.java */
package edu.ksu.cis.kdd.data.converter.arff;
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

public interface ArffParserConstants {

  int EOF = 0;
  int SINGLE_LINE_COMMENT = 10;
  int FORMAL_COMMENT = 11;
  int MULTI_LINE_COMMENT = 12;
  int INTEGER = 14;
  int REAL = 15;
  int STRING = 16;
  int RELATION = 17;
  int ATTRIBUTE = 18;
  int DATA = 19;
  int PRIMARY = 20;
  int REFERENCE = 21;
  int INTEGER_LITERAL = 22;
  int DECIMAL_LITERAL = 23;
  int HEX_LITERAL = 24;
  int OCTAL_LITERAL = 25;
  int FLOATING_POINT_LITERAL = 26;
  int EXPONENT = 27;
  int CHARACTER_LITERAL = 28;
  int STRING_LITERAL = 29;
  int NON_ESCAPED_LITERAL = 31;
  int ESCAPE_SEQ = 32;
  int ESCAPE_OCTAL = 33;
  int ESCAPE_UNICODE = 34;
  int IDENTIFIER = 36;
  int LETTER = 37;
  int DIGIT = 38;
  int LPAREN = 39;
  int RPAREN = 40;
  int LBRACE = 41;
  int RBRACE = 42;
  int LBRACKET = 43;
  int RBRACKET = 44;
  int SEMICOLON = 45;
  int COMMA = 46;
  int DOT = 47;
  int ASSIGN = 48;
  int GT = 49;
  int LT = 50;
  int BANG = 51;
  int TILDE = 52;
  int HOOK = 53;
  int COLON = 54;
  int EQ = 55;
  int LE = 56;
  int GE = 57;
  int NE = 58;
  int SC_OR = 59;
  int SC_AND = 60;
  int SC_XOR = 61;
  int INCR = 62;
  int DECR = 63;
  int PLUS = 64;
  int MINUS = 65;
  int STAR = 66;
  int SLASH = 67;
  int BIT_AND = 68;
  int BIT_OR = 69;
  int BIT_XOR = 70;
  int LSHIFT = 71;
  int RSIGNEDSHIFT = 72;
  int RUNSIGNEDSHIFT = 73;
  int PLUSASSIGN = 74;
  int MINUSASSIGN = 75;
  int STARASSIGN = 76;
  int SLASHASSIGN = 77;
  int ANDASSIGN = 78;
  int ORASSIGN = 79;
  int XORASSIGN = 80;
  int REMASSIGN = 81;
  int LSHIFTASSIGN = 82;
  int RSIGNEDSHIFTASSIGN = 83;
  int RUNSIGNEDSHIFTASSIGN = 84;
  int TOWARD = 85;
  int ASG_OPR = 86;

  int DEFAULT = 0;
  int IN_SINGLE_LINE_COMMENT = 1;
  int IN_FORMAL_COMMENT = 2;
  int IN_MULTI_LINE_COMMENT = 3;
  int CHAR_LIT = 4;
  int ESCAPED_CHAR_LIT = 5;
  int CHAR_LIT_CLOSE = 6;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"//\"",
    "\"%\"",
    "<token of kind 8>",
    "\"/*\"",
    "<SINGLE_LINE_COMMENT>",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 13>",
    "\"integer\"",
    "\"real\"",
    "\"string\"",
    "\"@RELATION\"",
    "\"@ATTRIBUTE\"",
    "\"@DATA\"",
    "\"@PRIMARY\"",
    "\"@REFERENCE\"",
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
