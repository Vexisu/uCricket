/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package pl.polsl.student.maciwal866.ucricket;



import java.text.MessageFormat;
import java.util.ArrayList;
/* "%code imports" blocks.  */
/* "./src/main/resources/UCricketParser.y":3  */

import pl.polsl.student.maciwal866.ucricket.ast.Program;
import pl.polsl.student.maciwal866.ucricket.ast.Scope;
import pl.polsl.student.maciwal866.ucricket.ast.Function;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.Statement;
import pl.polsl.student.maciwal866.ucricket.ast.ValueType;
import pl.polsl.student.maciwal866.ucricket.ast.StatementChain;
import pl.polsl.student.maciwal866.ucricket.ast.statement.AssignmentStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.ExpressionStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.IfStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.ReturnStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.WhileStatement;
import pl.polsl.student.maciwal866.ucricket.ast.expression.BinaryExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.UnaryExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.ValueExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.VariableExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.ArgumentsExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.FunctionCallExpression;

/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":67  */

/**
 * A Bison parser, automatically generated from <tt>./src/main/resources/UCricketParser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class UCricketParser
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.8.2";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";



  /**
   * True if verbose error messages are enabled.
   */
  private boolean yyErrorVerbose = true;

  /**
   * Whether verbose error messages are enabled.
   */
  public final boolean getErrorVerbose() { return yyErrorVerbose; }

  /**
   * Set the verbosity of error messages.
   * @param verbose True to request verbose error messages.
   */
  public final void setErrorVerbose(boolean verbose)
  { yyErrorVerbose = verbose; }




  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_IDENTIFIER(3),               /* IDENTIFIER  */
    S_INTEGER(4),                  /* INTEGER  */
    S_FLOAT(5),                    /* FLOAT  */
    S_IMPORT(6),                   /* IMPORT  */
    S_SCOPE(7),                    /* SCOPE  */
    S_IF(8),                       /* IF  */
    S_WHILE(9),                    /* WHILE  */
    S_FUNC(10),                    /* FUNC  */
    S_VAR(11),                     /* VAR  */
    S_RETURN(12),                  /* RETURN  */
    S_TRUE(13),                    /* TRUE  */
    S_FALSE(14),                   /* FALSE  */
    S_15_(15),                     /* "=="  */
    S_16_(16),                     /* "!="  */
    S_17_(17),                     /* "<="  */
    S_18_(18),                     /* ">="  */
    S_19_(19),                     /* "<"  */
    S_20_(20),                     /* ">"  */
    S_21_(21),                     /* '+'  */
    S_22_(22),                     /* '-'  */
    S_23_(23),                     /* '*'  */
    S_24_(24),                     /* '/'  */
    S_ARITHM_NEGATION(25),         /* ARITHM_NEGATION  */
    S_LOGICAL_NEGATION(26),        /* LOGICAL_NEGATION  */
    S_27_(27),                     /* ';'  */
    S_28_(28),                     /* '{'  */
    S_29_(29),                     /* '}'  */
    S_30_(30),                     /* '('  */
    S_31_(31),                     /* ')'  */
    S_32_(32),                     /* ','  */
    S_33_(33),                     /* '<'  */
    S_34_(34),                     /* '>'  */
    S_35_(35),                     /* '='  */
    S_36_(36),                     /* '!'  */
    S_YYACCEPT(37),                /* $accept  */
    S_program(38),                 /* program  */
    S_scope(39),                   /* scope  */
    S_scopeContent(40),            /* scopeContent  */
    S_function(41),                /* function  */
    S_argumentsChain(42),          /* argumentsChain  */
    S_returnedType(43),            /* returnedType  */
    S_statements(44),              /* statements  */
    S_statement(45),               /* statement  */
    S_variableStatement(46),       /* variableStatement  */
    S_condition(47),               /* condition  */
    S_expression(48),              /* expression  */
    S_binary(49),                  /* binary  */
    S_unary(50),                   /* unary  */
    S_primary(51),                 /* primary  */
    S_functionCall(52),            /* functionCall  */
    S_arguments(53);               /* arguments  */


    private final int yycode_;

    SymbolKind (int n) {
      this.yycode_ = n;
    }

    private static final SymbolKind[] values_ = {
      SymbolKind.S_YYEOF,
      SymbolKind.S_YYerror,
      SymbolKind.S_YYUNDEF,
      SymbolKind.S_IDENTIFIER,
      SymbolKind.S_INTEGER,
      SymbolKind.S_FLOAT,
      SymbolKind.S_IMPORT,
      SymbolKind.S_SCOPE,
      SymbolKind.S_IF,
      SymbolKind.S_WHILE,
      SymbolKind.S_FUNC,
      SymbolKind.S_VAR,
      SymbolKind.S_RETURN,
      SymbolKind.S_TRUE,
      SymbolKind.S_FALSE,
      SymbolKind.S_15_,
      SymbolKind.S_16_,
      SymbolKind.S_17_,
      SymbolKind.S_18_,
      SymbolKind.S_19_,
      SymbolKind.S_20_,
      SymbolKind.S_21_,
      SymbolKind.S_22_,
      SymbolKind.S_23_,
      SymbolKind.S_24_,
      SymbolKind.S_ARITHM_NEGATION,
      SymbolKind.S_LOGICAL_NEGATION,
      SymbolKind.S_27_,
      SymbolKind.S_28_,
      SymbolKind.S_29_,
      SymbolKind.S_30_,
      SymbolKind.S_31_,
      SymbolKind.S_32_,
      SymbolKind.S_33_,
      SymbolKind.S_34_,
      SymbolKind.S_35_,
      SymbolKind.S_36_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_program,
      SymbolKind.S_scope,
      SymbolKind.S_scopeContent,
      SymbolKind.S_function,
      SymbolKind.S_argumentsChain,
      SymbolKind.S_returnedType,
      SymbolKind.S_statements,
      SymbolKind.S_statement,
      SymbolKind.S_variableStatement,
      SymbolKind.S_condition,
      SymbolKind.S_expression,
      SymbolKind.S_binary,
      SymbolKind.S_unary,
      SymbolKind.S_primary,
      SymbolKind.S_functionCall,
      SymbolKind.S_arguments
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
    return new String[]
    {
  "\"end of file\"", "error", "\"invalid token\"", "IDENTIFIER",
  "INTEGER", "FLOAT", "IMPORT", "SCOPE", "IF", "WHILE", "FUNC", "VAR",
  "RETURN", "TRUE", "FALSE", "\"==\"", "\"!=\"", "\"<=\"", "\">=\"",
  "\"<\"", "\">\"", "'+'", "'-'", "'*'", "'/'", "ARITHM_NEGATION",
  "LOGICAL_NEGATION", "';'", "'{'", "'}'", "'('", "')'", "','", "'<'",
  "'>'", "'='", "'!'", "$accept", "program", "scope", "scopeContent",
  "function", "argumentsChain", "returnedType", "statements", "statement",
  "variableStatement", "condition", "expression", "binary", "unary",
  "primary", "functionCall", "arguments", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>UCricketParser</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token IDENTIFIER, to be returned by the scanner.  */
    static final int IDENTIFIER = 258;
    /** Token INTEGER, to be returned by the scanner.  */
    static final int INTEGER = 259;
    /** Token FLOAT, to be returned by the scanner.  */
    static final int FLOAT = 260;
    /** Token IMPORT, to be returned by the scanner.  */
    static final int IMPORT = 261;
    /** Token SCOPE, to be returned by the scanner.  */
    static final int SCOPE = 262;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 263;
    /** Token WHILE, to be returned by the scanner.  */
    static final int WHILE = 264;
    /** Token FUNC, to be returned by the scanner.  */
    static final int FUNC = 265;
    /** Token VAR, to be returned by the scanner.  */
    static final int VAR = 266;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 267;
    /** Token TRUE, to be returned by the scanner.  */
    static final int TRUE = 268;
    /** Token FALSE, to be returned by the scanner.  */
    static final int FALSE = 269;
    /** Token ARITHM_NEGATION, to be returned by the scanner.  */
    static final int ARITHM_NEGATION = 276;
    /** Token LOGICAL_NEGATION, to be returned by the scanner.  */
    static final int LOGICAL_NEGATION = 277;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public UCricketParser(Lexer yylexer)
  {
/* "%code init" blocks.  */
/* "./src/main/resources/UCricketParser.y":54  */

    program = new Program();

/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":383  */

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors() { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push(int state, Object value) {
      height++;
      if (size == height) {
        int[] newStateStack = new int[size * 2];
        System.arraycopy(stateStack, 0, newStateStack, 0, height);
        stateStack = newStateStack;

        Object[] newValueStack = new Object[size * 2];
        System.arraycopy(valueStack, 0, newValueStack, 0, height);
        valueStack = newValueStack;

        size *= 2;
      }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop() {
      pop(1);
    }

    public final void pop(int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt(int i) {
      return stateStack[height - i];
    }

    public final Object valueAt(int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print(java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++) {
        out.print(' ');
        out.print(stateStack[i]);
      }
      out.println();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState(int yystate, int yysym) {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 3: /* program: program scope  */
  if (yyn == 3)
    /* "./src/main/resources/UCricketParser.y":61  */
                      { program.addScope(((Scope)(yystack.valueAt (0)))); };
  break;


  case 5: /* scope: SCOPE IDENTIFIER '{' scopeContent '}'  */
  if (yyn == 5)
    /* "./src/main/resources/UCricketParser.y":66  */
                                              { yyval = new Scope(((String)(yystack.valueAt (3))), ((Scope.ScopeContent)(yystack.valueAt (1)))); };
  break;


  case 6: /* scopeContent: scopeContent function  */
  if (yyn == 6)
    /* "./src/main/resources/UCricketParser.y":70  */
                              { yyval = new Scope.ScopeContent<Function>(((Function)(yystack.valueAt (0))), ((Scope.ScopeContent)(yystack.valueAt (1)))); };
  break;


  case 7: /* scopeContent: scopeContent variableStatement  */
  if (yyn == 7)
    /* "./src/main/resources/UCricketParser.y":71  */
                                       { yyval = new Scope.ScopeContent<VariableStatement>(((VariableStatement)(yystack.valueAt (0))), ((Scope.ScopeContent)(yystack.valueAt (1)))); };
  break;


  case 8: /* scopeContent: %empty  */
  if (yyn == 8)
    /* "./src/main/resources/UCricketParser.y":72  */
        { yyval = null; };
  break;


  case 9: /* function: FUNC returnedType IDENTIFIER '(' argumentsChain ')' '{' statements '}'  */
  if (yyn == 9)
    /* "./src/main/resources/UCricketParser.y":76  */
                                                                               { yyval = new Function(((ValueType)(yystack.valueAt (7))), ((String)(yystack.valueAt (6))), ((Function.ArgumentsChain)(yystack.valueAt (4))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 10: /* argumentsChain: argumentsChain ',' IDENTIFIER IDENTIFIER  */
  if (yyn == 10)
    /* "./src/main/resources/UCricketParser.y":80  */
                                                 { yyval = new Function.ArgumentsChain(ValueType.parse(((String)(yystack.valueAt (1)))), ((String)(yystack.valueAt (0))), ((Function.ArgumentsChain)(yystack.valueAt (3)))); };
  break;


  case 11: /* argumentsChain: IDENTIFIER IDENTIFIER  */
  if (yyn == 11)
    /* "./src/main/resources/UCricketParser.y":81  */
                              { yyval = new Function.ArgumentsChain(ValueType.parse(((String)(yystack.valueAt (1)))), ((String)(yystack.valueAt (0))), null); };
  break;


  case 12: /* argumentsChain: %empty  */
  if (yyn == 12)
    /* "./src/main/resources/UCricketParser.y":82  */
        { yyval = null; };
  break;


  case 13: /* returnedType: '<' IDENTIFIER '>'  */
  if (yyn == 13)
    /* "./src/main/resources/UCricketParser.y":86  */
                           { yyval = ValueType.parse(((String)(yystack.valueAt (1)))); };
  break;


  case 14: /* returnedType: %empty  */
  if (yyn == 14)
    /* "./src/main/resources/UCricketParser.y":87  */
        { yyval = null; };
  break;


  case 15: /* statements: statements statement  */
  if (yyn == 15)
    /* "./src/main/resources/UCricketParser.y":91  */
                             { yyval = new StatementChain(((Statement)(yystack.valueAt (0))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 16: /* statements: %empty  */
  if (yyn == 16)
    /* "./src/main/resources/UCricketParser.y":92  */
        { yyval = null; };
  break;


  case 17: /* statement: expression ';'  */
  if (yyn == 17)
    /* "./src/main/resources/UCricketParser.y":96  */
                       {yyval = new ExpressionStatement(((Expression)(yystack.valueAt (1)))); };
  break;


  case 18: /* statement: IF '(' condition ')' '{' statements '}'  */
  if (yyn == 18)
    /* "./src/main/resources/UCricketParser.y":97  */
                                                { yyval = new IfStatement(((Expression)(yystack.valueAt (4))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 19: /* statement: WHILE '(' condition ')' '{' statements '}'  */
  if (yyn == 19)
    /* "./src/main/resources/UCricketParser.y":98  */
                                                   { yyval = new WhileStatement(((Expression)(yystack.valueAt (4))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 20: /* statement: variableStatement  */
  if (yyn == 20)
    /* "./src/main/resources/UCricketParser.y":99  */
                          { yyval = ((VariableStatement)(yystack.valueAt (0))); };
  break;


  case 21: /* statement: IDENTIFIER '=' expression ';'  */
  if (yyn == 21)
    /* "./src/main/resources/UCricketParser.y":100  */
                                      { yyval = new AssignmentStatement(((String)(yystack.valueAt (3))), ((Expression)(yystack.valueAt (1)))); };
  break;


  case 22: /* statement: RETURN expression ';'  */
  if (yyn == 22)
    /* "./src/main/resources/UCricketParser.y":101  */
                              { yyval = new ReturnStatement(((Expression)(yystack.valueAt (1)))); };
  break;


  case 23: /* variableStatement: VAR returnedType IDENTIFIER ';'  */
  if (yyn == 23)
    /* "./src/main/resources/UCricketParser.y":105  */
                                        { yyval = new VariableStatement(((ValueType)(yystack.valueAt (2))), ((String)(yystack.valueAt (1))), null); };
  break;


  case 24: /* variableStatement: VAR returnedType IDENTIFIER '=' expression ';'  */
  if (yyn == 24)
    /* "./src/main/resources/UCricketParser.y":106  */
                                                       { yyval = new VariableStatement(((ValueType)(yystack.valueAt (4))), ((String)(yystack.valueAt (3))), ((Expression)(yystack.valueAt (1)))); };
  break;


  case 30: /* binary: expression "==" expression  */
  if (yyn == 30)
    /* "./src/main/resources/UCricketParser.y":121  */
                                   { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 31: /* binary: expression "!=" expression  */
  if (yyn == 31)
    /* "./src/main/resources/UCricketParser.y":122  */
                                   { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.NOT_EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 32: /* binary: expression "<" expression  */
  if (yyn == 32)
    /* "./src/main/resources/UCricketParser.y":123  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.LESS, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 33: /* binary: expression ">" expression  */
  if (yyn == 33)
    /* "./src/main/resources/UCricketParser.y":124  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.GREATER, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 34: /* binary: expression "<=" expression  */
  if (yyn == 34)
    /* "./src/main/resources/UCricketParser.y":125  */
                                   { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.LESS_EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 35: /* binary: expression ">=" expression  */
  if (yyn == 35)
    /* "./src/main/resources/UCricketParser.y":126  */
                                   { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.GREATER_EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 36: /* binary: expression '+' expression  */
  if (yyn == 36)
    /* "./src/main/resources/UCricketParser.y":127  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.ADD, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 37: /* binary: expression '-' expression  */
  if (yyn == 37)
    /* "./src/main/resources/UCricketParser.y":128  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.SUBTRACT, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 38: /* binary: expression '*' expression  */
  if (yyn == 38)
    /* "./src/main/resources/UCricketParser.y":129  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.MULTIPLY, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 39: /* binary: expression '/' expression  */
  if (yyn == 39)
    /* "./src/main/resources/UCricketParser.y":130  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.DIVIDE, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 40: /* unary: '(' expression ')'  */
  if (yyn == 40)
    /* "./src/main/resources/UCricketParser.y":134  */
                           { yyval = new UnaryExpression(((Expression)(yystack.valueAt (1))), UnaryExpression.Type.PARENTHESIS); };
  break;


  case 41: /* unary: '!' expression  */
  if (yyn == 41)
    /* "./src/main/resources/UCricketParser.y":135  */
                                              { yyval = new UnaryExpression(((Expression)(yystack.valueAt (0))), UnaryExpression.Type.LOGICAL_NEGATION); };
  break;


  case 42: /* unary: '-' expression  */
  if (yyn == 42)
    /* "./src/main/resources/UCricketParser.y":136  */
                                             { yyval = new UnaryExpression(((Expression)(yystack.valueAt (0))), UnaryExpression.Type.ARITHMETICAL_NEGATION); };
  break;


  case 43: /* primary: INTEGER  */
  if (yyn == 43)
    /* "./src/main/resources/UCricketParser.y":140  */
                { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.INTEGER); };
  break;


  case 44: /* primary: FLOAT  */
  if (yyn == 44)
    /* "./src/main/resources/UCricketParser.y":141  */
              { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.FLOAT); };
  break;


  case 45: /* primary: TRUE  */
  if (yyn == 45)
    /* "./src/main/resources/UCricketParser.y":142  */
             { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.BOOLEAN); };
  break;


  case 46: /* primary: FALSE  */
  if (yyn == 46)
    /* "./src/main/resources/UCricketParser.y":143  */
              { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.BOOLEAN); };
  break;


  case 47: /* primary: IDENTIFIER  */
  if (yyn == 47)
    /* "./src/main/resources/UCricketParser.y":144  */
                   { yyval = new VariableExpression(((String)(yystack.valueAt (0)))); };
  break;


  case 48: /* functionCall: IDENTIFIER '(' arguments ')'  */
  if (yyn == 48)
    /* "./src/main/resources/UCricketParser.y":148  */
                                     { yyval = new FunctionCallExpression(((String)(yystack.valueAt (3))), ((Expression)(yystack.valueAt (1)))); };
  break;


  case 49: /* arguments: arguments ',' expression  */
  if (yyn == 49)
    /* "./src/main/resources/UCricketParser.y":152  */
                                 { yyval = new ArgumentsExpression(((Expression)(yystack.valueAt (2))), ((Expression)(yystack.valueAt (0)))); };
  break;


  case 50: /* arguments: expression  */
  if (yyn == 50)
    /* "./src/main/resources/UCricketParser.y":153  */
                   { yyval = ((Expression)(yystack.valueAt (0))); };
  break;


  case 51: /* arguments: %empty  */
  if (yyn == 51)
    /* "./src/main/resources/UCricketParser.y":154  */
        { yyval = null; };
  break;



/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":837  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Object yylval = null;



    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode()) {
              label = YYDEFAULT;
            }

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError(yyn)) {
                  label = YYERRLAB;
                } else {
                  yyn = -yyn;
                  label = YYREDUCE;
                }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push(yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt(0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError(new Context(this, yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt(0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt(0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context {
    Context(UCricketParser parser, YYStack stack, SymbolKind token) {
      yyparser = parser;
      yystack = stack;
      yytoken = token;
    }

    private UCricketParser yyparser;
    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken() {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = UCricketParser.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens(SymbolKind yyarg[], int yyargn) {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt(0)];
      if (!yyPactValueIsDefault(yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
                if (yyarg == null)
                  yycount += 1;
                else if (yycount == yyargn)
                  return 0; // FIXME: this is incorrect.
                else
                  yyarg[yycount++] = SymbolKind.get(yyx);
              }
        }
      if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
        yyarg[yycount] = null;
      return yycount - yyoffset;
    }
  }




  private int yysyntaxErrorArguments(Context yyctx, SymbolKind[] yyarg, int yyargn) {
    /* There are many possibilities here to consider:
       - If this state is a consistent state with a default action,
         then the only way this function was invoked is if the
         default action is an error action.  In that case, don't
         check for expected tokens because there are none.
       - The only way there can be no lookahead present (in tok) is
         if this state is a consistent state with a default action.
         Thus, detecting the absence of a lookahead is sufficient to
         determine that there is no unexpected or expected token to
         report.  In that case, just report a simple "syntax error".
       - Don't assume there isn't a lookahead just because this
         state is a consistent state with a default action.  There
         might have been a previous inconsistent state, consistent
         state with a non-default action, or user semantic action
         that manipulated yychar.  (However, yychar is currently out
         of scope during semantic actions.)
       - Of course, the expected token list depends on states to
         have correct lookahead information, and it depends on the
         parser not to perform extra reductions after fetching a
         lookahead from the scanner and before detecting a syntax
         error.  Thus, state merging (from LALR or IELR) and default
         reductions corrupt the expected token list.  However, the
         list is correct for canonical LR with one exception: it
         will still contain any token that will not be accepted due
         to an error action in a later state.
    */
    int yycount = 0;
    if (yyctx.getToken() != null)
      {
        if (yyarg != null)
          yyarg[yycount] = yyctx.getToken();
        yycount += 1;
        yycount += yyctx.getExpectedTokens(yyarg, 1, yyargn);
      }
    return yycount;
  }


  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
  private void yyreportSyntaxError(Context yyctx) {
      if (yyErrorVerbose) {
          final int argmax = 5;
          SymbolKind[] yyarg = new SymbolKind[argmax];
          int yycount = yysyntaxErrorArguments(yyctx, yyarg, argmax);
          String[] yystr = new String[yycount];
          for (int yyi = 0; yyi < yycount; ++yyi) {
              yystr[yyi] = yyarg[yyi].getName();
          }
          String yyformat;
          switch (yycount) {
              default:
              case 0: yyformat = "syntax error"; break;
              case 1: yyformat = "syntax error, unexpected {0}"; break;
              case 2: yyformat = "syntax error, unexpected {0}, expecting {1}"; break;
              case 3: yyformat = "syntax error, unexpected {0}, expecting {1} or {2}"; break;
              case 4: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3}"; break;
              case 5: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3} or {4}"; break;
          }
          yyerror(new MessageFormat(yyformat).format(yystr));
      } else {
          yyerror("syntax error");
      }
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault(int yyvalue) {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError(int yyvalue) {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -64;
  private static final byte yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     -64,     6,   -64,     4,    19,   -64,    14,     5,   -64,   -64,
      -9,    17,    17,   -64,   -64,   -64,    48,    51,    52,    23,
      28,   -24,   -64,    56,   -64,   105,    62,   -27,    36,   -64,
     -64,   -64,   -64,   105,   105,   105,   144,   -64,   -64,   -64,
     -64,   -64,    43,    69,   105,   -64,   127,   -64,   105,   105,
     105,   105,   105,   105,   105,   105,   105,   105,   -64,   -64,
      72,   196,   -17,   -64,    25,    25,    25,    25,    25,    25,
      -6,    -6,   -64,   -64,    31,   -64,   -64,   105,   -14,    53,
      54,   105,   -64,   -64,   -64,   157,   196,   105,   105,   105,
     170,   -64,   183,    61,   196,    66,   -64,   -64,    68,    70,
     -64,   -64,    65,    77,   -64,   -64
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       4,     0,     1,     0,     0,     3,     0,     0,     2,     8,
       0,    14,    14,     5,     6,     7,     0,     0,     0,     0,
       0,     0,    13,    12,    23,     0,     0,     0,    47,    43,
      44,    45,    46,     0,     0,     0,     0,    26,    27,    28,
      29,    11,     0,     0,    51,    42,     0,    41,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,    24,    16,
       0,    50,     0,    40,    30,    31,    34,    35,    32,    33,
      36,    37,    38,    39,     0,    10,    48,     0,    47,     0,
       0,     0,     9,    15,    20,     0,    49,     0,     0,     0,
       0,    17,     0,     0,    25,     0,    22,    21,     0,     0,
      16,    16,     0,     0,    18,    19
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -64,   -64,   -64,   -64,   -64,   -64,    81,   -63,   -64,    90,
      13,   -25,   -64,   -64,   -64,   -64,   -64
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     1,     5,    10,    14,    27,    17,    74,    83,    84,
      93,    85,    37,    38,    39,    40,    62
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final byte[] yytable_ = yytable_init();
  private static final byte[] yytable_init()
  {
    return new byte[]
    {
      36,    11,    12,    24,    42,    43,     2,     6,    45,    46,
      47,    25,     3,     4,    76,    77,    44,    56,    57,    61,
      13,    87,     7,    64,    65,    66,    67,    68,    69,    70,
      71,    72,    73,     9,    78,    29,    30,   102,   103,    79,
      80,     8,    12,    81,    31,    32,    54,    55,    56,    57,
      16,    19,    86,    33,    20,    21,    90,    22,    23,    26,
      82,    34,    92,    94,    94,    41,    44,    35,    78,    29,
      30,    59,    60,    79,    80,    75,    12,    81,    31,    32,
      78,    29,    30,    88,    89,    79,    80,    33,    12,    81,
      31,    32,    98,    18,   104,    34,   100,    99,   101,    33,
      15,    35,    95,     0,     0,     0,   105,    34,    28,    29,
      30,     0,     0,    35,     0,     0,     0,     0,    31,    32,
       0,     0,     0,     0,     0,     0,     0,    33,     0,     0,
       0,     0,     0,     0,     0,    34,     0,     0,     0,     0,
       0,    35,    48,    49,    50,    51,    52,    53,    54,    55,
      56,    57,     0,     0,     0,     0,     0,     0,    63,    48,
      49,    50,    51,    52,    53,    54,    55,    56,    57,     0,
       0,    58,    48,    49,    50,    51,    52,    53,    54,    55,
      56,    57,     0,     0,    91,    48,    49,    50,    51,    52,
      53,    54,    55,    56,    57,     0,     0,    96,    48,    49,
      50,    51,    52,    53,    54,    55,    56,    57,     0,     0,
      97,    48,    49,    50,    51,    52,    53,    54,    55,    56,
      57
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
      25,    10,    11,    27,    31,    32,     0,     3,    33,    34,
      35,    35,     6,     7,    31,    32,    30,    23,    24,    44,
      29,    35,     3,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    28,     3,     4,     5,   100,   101,     8,
       9,    27,    11,    12,    13,    14,    21,    22,    23,    24,
      33,     3,    77,    22,     3,     3,    81,    34,    30,     3,
      29,    30,    87,    88,    89,     3,    30,    36,     3,     4,
       5,    28,     3,     8,     9,     3,    11,    12,    13,    14,
       3,     4,     5,    30,    30,     8,     9,    22,    11,    12,
      13,    14,    31,    12,    29,    30,    28,    31,    28,    22,
      10,    36,    89,    -1,    -1,    -1,    29,    30,     3,     4,
       5,    -1,    -1,    36,    -1,    -1,    -1,    -1,    13,    14,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    22,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    30,    -1,    -1,    -1,    -1,
      -1,    36,    15,    16,    17,    18,    19,    20,    21,    22,
      23,    24,    -1,    -1,    -1,    -1,    -1,    -1,    31,    15,
      16,    17,    18,    19,    20,    21,    22,    23,    24,    -1,
      -1,    27,    15,    16,    17,    18,    19,    20,    21,    22,
      23,    24,    -1,    -1,    27,    15,    16,    17,    18,    19,
      20,    21,    22,    23,    24,    -1,    -1,    27,    15,    16,
      17,    18,    19,    20,    21,    22,    23,    24,    -1,    -1,
      27,    15,    16,    17,    18,    19,    20,    21,    22,    23,
      24
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,    38,     0,     6,     7,    39,     3,     3,    27,    28,
      40,    10,    11,    29,    41,    46,    33,    43,    43,     3,
       3,     3,    34,    30,    27,    35,     3,    42,     3,     4,
       5,    13,    14,    22,    30,    36,    48,    49,    50,    51,
      52,     3,    31,    32,    30,    48,    48,    48,    15,    16,
      17,    18,    19,    20,    21,    22,    23,    24,    27,    28,
       3,    48,    53,    31,    48,    48,    48,    48,    48,    48,
      48,    48,    48,    48,    44,     3,    31,    32,     3,     8,
       9,    12,    29,    45,    46,    48,    48,    35,    30,    30,
      48,    27,    48,    47,    48,    47,    27,    27,    31,    31,
      28,    28,    44,    44,    29,    29
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    37,    38,    38,    38,    39,    40,    40,    40,    41,
      42,    42,    42,    43,    43,    44,    44,    45,    45,    45,
      45,    45,    45,    46,    46,    47,    48,    48,    48,    48,
      49,    49,    49,    49,    49,    49,    49,    49,    49,    49,
      50,    50,    50,    51,    51,    51,    51,    51,    52,    53,
      53,    53
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     4,     2,     0,     5,     2,     2,     0,     9,
       4,     2,     0,     3,     0,     2,     0,     2,     7,     7,
       1,     4,     3,     4,     6,     1,     1,     1,     1,     1,
       3,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     2,     2,     1,     1,     1,     1,     1,     4,     3,
       1,     0
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 277;
    if (t <= 0)
      return SymbolKind.S_YYEOF;
    else if (t <= code_max)
      return SymbolKind.get(yytranslate_table_[t]);
    else
      return SymbolKind.S_YYUNDEF;
  }
  private static final byte[] yytranslate_table_ = yytranslate_table_init();
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    36,     2,     2,     2,     2,     2,     2,
      30,    31,    23,    21,    32,    22,     2,    24,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    27,
      33,    35,    34,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    28,     2,    29,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    25,    26
    };
  }


  private static final int YYLAST_ = 220;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 2;
  private static final int YYNTOKENS_ = 37;

/* Unqualified %code blocks.  */
/* "./src/main/resources/UCricketParser.y":50  */

    private Program program;

/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":1496  */

}
/* "./src/main/resources/UCricketParser.y":156  */
