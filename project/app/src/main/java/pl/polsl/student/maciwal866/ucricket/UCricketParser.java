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
import pl.polsl.student.maciwal866.ucricket.ast.AssignmentType;
import pl.polsl.student.maciwal866.ucricket.ast.StatementChain;
import pl.polsl.student.maciwal866.ucricket.ast.statement.AssignmentStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.ExpressionStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.IfStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.ReturnStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.VariableStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.PointerStatement;
import pl.polsl.student.maciwal866.ucricket.ast.statement.WhileStatement;
import pl.polsl.student.maciwal866.ucricket.ast.expression.BinaryExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.UnaryExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.ValueExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.VariableExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.ArgumentsExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.FunctionCallExpression;

import lombok.Getter;

/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":71  */

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
    S_PTR(12),                     /* PTR  */
    S_RETURN(13),                  /* RETURN  */
    S_TRUE(14),                    /* TRUE  */
    S_FALSE(15),                   /* FALSE  */
    S_EQUAL_EQUAL(16),             /* EQUAL_EQUAL  */
    S_BANG_EQUAL(17),              /* BANG_EQUAL  */
    S_LESS_EQUAL(18),              /* LESS_EQUAL  */
    S_GREATER_EQUAL(19),           /* GREATER_EQUAL  */
    S_ASSIGN_ADDRESS(20),          /* ASSIGN_ADDRESS  */
    S_21_(21),                     /* '<'  */
    S_22_(22),                     /* '>'  */
    S_23_(23),                     /* '+'  */
    S_24_(24),                     /* '-'  */
    S_25_(25),                     /* '*'  */
    S_26_(26),                     /* '/'  */
    S_27_(27),                     /* '&'  */
    S_28_(28),                     /* '|'  */
    S_29_(29),                     /* '^'  */
    S_ARITHM_NEGATION(30),         /* ARITHM_NEGATION  */
    S_LOGICAL_NEGATION(31),        /* LOGICAL_NEGATION  */
    S_32_(32),                     /* ';'  */
    S_33_(33),                     /* '{'  */
    S_34_(34),                     /* '}'  */
    S_35_(35),                     /* '('  */
    S_36_(36),                     /* ')'  */
    S_37_(37),                     /* ','  */
    S_38_(38),                     /* '='  */
    S_39_(39),                     /* '!'  */
    S_YYACCEPT(40),                /* $accept  */
    S_program(41),                 /* program  */
    S_scope(42),                   /* scope  */
    S_scopeContent(43),            /* scopeContent  */
    S_function(44),                /* function  */
    S_argumentChain(45),           /* argumentChain  */
    S_returnedType(46),            /* returnedType  */
    S_statements(47),              /* statements  */
    S_statement(48),               /* statement  */
    S_variableStatement(49),       /* variableStatement  */
    S_pointerStatement(50),        /* pointerStatement  */
    S_condition(51),               /* condition  */
    S_expression(52),              /* expression  */
    S_binary(53),                  /* binary  */
    S_unary(54),                   /* unary  */
    S_primary(55),                 /* primary  */
    S_functionCall(56),            /* functionCall  */
    S_arguments(57);               /* arguments  */


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
      SymbolKind.S_PTR,
      SymbolKind.S_RETURN,
      SymbolKind.S_TRUE,
      SymbolKind.S_FALSE,
      SymbolKind.S_EQUAL_EQUAL,
      SymbolKind.S_BANG_EQUAL,
      SymbolKind.S_LESS_EQUAL,
      SymbolKind.S_GREATER_EQUAL,
      SymbolKind.S_ASSIGN_ADDRESS,
      SymbolKind.S_21_,
      SymbolKind.S_22_,
      SymbolKind.S_23_,
      SymbolKind.S_24_,
      SymbolKind.S_25_,
      SymbolKind.S_26_,
      SymbolKind.S_27_,
      SymbolKind.S_28_,
      SymbolKind.S_29_,
      SymbolKind.S_ARITHM_NEGATION,
      SymbolKind.S_LOGICAL_NEGATION,
      SymbolKind.S_32_,
      SymbolKind.S_33_,
      SymbolKind.S_34_,
      SymbolKind.S_35_,
      SymbolKind.S_36_,
      SymbolKind.S_37_,
      SymbolKind.S_38_,
      SymbolKind.S_39_,
      SymbolKind.S_YYACCEPT,
      SymbolKind.S_program,
      SymbolKind.S_scope,
      SymbolKind.S_scopeContent,
      SymbolKind.S_function,
      SymbolKind.S_argumentChain,
      SymbolKind.S_returnedType,
      SymbolKind.S_statements,
      SymbolKind.S_statement,
      SymbolKind.S_variableStatement,
      SymbolKind.S_pointerStatement,
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
  "PTR", "RETURN", "TRUE", "FALSE", "EQUAL_EQUAL", "BANG_EQUAL",
  "LESS_EQUAL", "GREATER_EQUAL", "ASSIGN_ADDRESS", "'<'", "'>'", "'+'",
  "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "ARITHM_NEGATION",
  "LOGICAL_NEGATION", "';'", "'{'", "'}'", "'('", "')'", "','", "'='",
  "'!'", "$accept", "program", "scope", "scopeContent", "function",
  "argumentChain", "returnedType", "statements", "statement",
  "variableStatement", "pointerStatement", "condition", "expression",
  "binary", "unary", "primary", "functionCall", "arguments", null
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
    /** Token PTR, to be returned by the scanner.  */
    static final int PTR = 267;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 268;
    /** Token TRUE, to be returned by the scanner.  */
    static final int TRUE = 269;
    /** Token FALSE, to be returned by the scanner.  */
    static final int FALSE = 270;
    /** Token EQUAL_EQUAL, to be returned by the scanner.  */
    static final int EQUAL_EQUAL = 271;
    /** Token BANG_EQUAL, to be returned by the scanner.  */
    static final int BANG_EQUAL = 272;
    /** Token LESS_EQUAL, to be returned by the scanner.  */
    static final int LESS_EQUAL = 273;
    /** Token GREATER_EQUAL, to be returned by the scanner.  */
    static final int GREATER_EQUAL = 274;
    /** Token ASSIGN_ADDRESS, to be returned by the scanner.  */
    static final int ASSIGN_ADDRESS = 275;
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
/* "./src/main/resources/UCricketParser.y":62  */

    program = new Program();

/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":408  */

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
          case 3: /* program: scope program  */
  if (yyn == 3)
    /* "./src/main/resources/UCricketParser.y":69  */
                      { program.addScope(((Scope)(yystack.valueAt (1)))); };
  break;


  case 5: /* scope: SCOPE IDENTIFIER '{' scopeContent '}'  */
  if (yyn == 5)
    /* "./src/main/resources/UCricketParser.y":74  */
                                              { yyval = new Scope(((String)(yystack.valueAt (3))), ((Scope.ScopeContent)(yystack.valueAt (1)))); };
  break;


  case 6: /* scopeContent: function scopeContent  */
  if (yyn == 6)
    /* "./src/main/resources/UCricketParser.y":78  */
                              { yyval = new Scope.ScopeContent<Function>(((Function)(yystack.valueAt (1))), ((Scope.ScopeContent)(yystack.valueAt (0)))); };
  break;


  case 7: /* scopeContent: variableStatement scopeContent  */
  if (yyn == 7)
    /* "./src/main/resources/UCricketParser.y":79  */
                                       { yyval = new Scope.ScopeContent<VariableStatement>(((VariableStatement)(yystack.valueAt (1))), ((Scope.ScopeContent)(yystack.valueAt (0)))); };
  break;


  case 8: /* scopeContent: %empty  */
  if (yyn == 8)
    /* "./src/main/resources/UCricketParser.y":80  */
        { yyval = null; };
  break;


  case 9: /* function: FUNC returnedType IDENTIFIER '(' argumentChain ')' '{' statements '}'  */
  if (yyn == 9)
    /* "./src/main/resources/UCricketParser.y":84  */
                                                                              { yyval = new Function(((ValueType)(yystack.valueAt (7))), ((String)(yystack.valueAt (6))), ((Function.ArgumentChain)(yystack.valueAt (4))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 10: /* function: FUNC returnedType IDENTIFIER '(' ')' '{' statements '}'  */
  if (yyn == 10)
    /* "./src/main/resources/UCricketParser.y":85  */
                                                                { yyval = new Function(((ValueType)(yystack.valueAt (6))), ((String)(yystack.valueAt (5))), null, ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 11: /* argumentChain: argumentChain ',' IDENTIFIER IDENTIFIER  */
  if (yyn == 11)
    /* "./src/main/resources/UCricketParser.y":89  */
                                                { yyval = new Function.ArgumentChain(ValueType.parse(((String)(yystack.valueAt (1)))), ((String)(yystack.valueAt (0))), ((Function.ArgumentChain)(yystack.valueAt (3)))); };
  break;


  case 12: /* argumentChain: IDENTIFIER IDENTIFIER  */
  if (yyn == 12)
    /* "./src/main/resources/UCricketParser.y":90  */
                              { yyval = new Function.ArgumentChain(ValueType.parse(((String)(yystack.valueAt (1)))), ((String)(yystack.valueAt (0))), null); };
  break;


  case 13: /* returnedType: '<' IDENTIFIER '>'  */
  if (yyn == 13)
    /* "./src/main/resources/UCricketParser.y":94  */
                           { yyval = ValueType.parse(((String)(yystack.valueAt (1)))); };
  break;


  case 14: /* returnedType: %empty  */
  if (yyn == 14)
    /* "./src/main/resources/UCricketParser.y":95  */
        { yyval = ValueType.NONE; };
  break;


  case 15: /* statements: statement statements  */
  if (yyn == 15)
    /* "./src/main/resources/UCricketParser.y":99  */
                             { yyval = new StatementChain(((Statement)(yystack.valueAt (1))), ((StatementChain)(yystack.valueAt (0)))); };
  break;


  case 16: /* statements: %empty  */
  if (yyn == 16)
    /* "./src/main/resources/UCricketParser.y":100  */
        { yyval = null; };
  break;


  case 17: /* statement: expression ';'  */
  if (yyn == 17)
    /* "./src/main/resources/UCricketParser.y":104  */
                       {yyval = new ExpressionStatement(((Expression)(yystack.valueAt (1)))); };
  break;


  case 18: /* statement: IF '(' condition ')' '{' statements '}'  */
  if (yyn == 18)
    /* "./src/main/resources/UCricketParser.y":105  */
                                                { yyval = new IfStatement(((Expression)(yystack.valueAt (4))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 19: /* statement: WHILE '(' condition ')' '{' statements '}'  */
  if (yyn == 19)
    /* "./src/main/resources/UCricketParser.y":106  */
                                                   { yyval = new WhileStatement(((Expression)(yystack.valueAt (4))), ((StatementChain)(yystack.valueAt (1)))); };
  break;


  case 20: /* statement: variableStatement  */
  if (yyn == 20)
    /* "./src/main/resources/UCricketParser.y":107  */
                          { yyval = ((VariableStatement)(yystack.valueAt (0))); };
  break;


  case 21: /* statement: pointerStatement  */
  if (yyn == 21)
    /* "./src/main/resources/UCricketParser.y":108  */
                         { yyval = ((PointerStatement)(yystack.valueAt (0))); };
  break;


  case 22: /* statement: IDENTIFIER '=' expression ';'  */
  if (yyn == 22)
    /* "./src/main/resources/UCricketParser.y":109  */
                                      { yyval = new AssignmentStatement(AssignmentType.VALUE, ((String)(yystack.valueAt (3))), ((Expression)(yystack.valueAt (1)))); };
  break;


  case 23: /* statement: IDENTIFIER ASSIGN_ADDRESS expression ';'  */
  if (yyn == 23)
    /* "./src/main/resources/UCricketParser.y":110  */
                                                 { yyval = new AssignmentStatement(AssignmentType.ADDRESS, ((String)(yystack.valueAt (3))), ((Expression)(yystack.valueAt (1)))); };
  break;


  case 24: /* statement: RETURN expression ';'  */
  if (yyn == 24)
    /* "./src/main/resources/UCricketParser.y":111  */
                              { yyval = new ReturnStatement(((Expression)(yystack.valueAt (1)))); };
  break;


  case 25: /* variableStatement: VAR returnedType IDENTIFIER ';'  */
  if (yyn == 25)
    /* "./src/main/resources/UCricketParser.y":115  */
                                        { yyval = new VariableStatement(((ValueType)(yystack.valueAt (2))), ((String)(yystack.valueAt (1))), null); };
  break;


  case 26: /* variableStatement: VAR returnedType IDENTIFIER '=' expression ';'  */
  if (yyn == 26)
    /* "./src/main/resources/UCricketParser.y":116  */
                                                       { yyval = new VariableStatement(((ValueType)(yystack.valueAt (4))), ((String)(yystack.valueAt (3))), ((Expression)(yystack.valueAt (1)))); };
  break;


  case 27: /* pointerStatement: PTR returnedType IDENTIFIER ';'  */
  if (yyn == 27)
    /* "./src/main/resources/UCricketParser.y":120  */
                                        { yyval = new PointerStatement(((ValueType)(yystack.valueAt (2))), ((String)(yystack.valueAt (1))), AssignmentType.NONE, null); };
  break;


  case 28: /* pointerStatement: PTR returnedType IDENTIFIER '=' expression ';'  */
  if (yyn == 28)
    /* "./src/main/resources/UCricketParser.y":121  */
                                                       { yyval = new PointerStatement(((ValueType)(yystack.valueAt (4))), ((String)(yystack.valueAt (3))), AssignmentType.VALUE, ((Expression)(yystack.valueAt (1)))); };
  break;


  case 29: /* pointerStatement: PTR returnedType IDENTIFIER ASSIGN_ADDRESS expression ';'  */
  if (yyn == 29)
    /* "./src/main/resources/UCricketParser.y":122  */
                                                                  { yyval = new PointerStatement(((ValueType)(yystack.valueAt (4))), ((String)(yystack.valueAt (3))), AssignmentType.ADDRESS, ((Expression)(yystack.valueAt (1)))); };
  break;


  case 35: /* binary: expression EQUAL_EQUAL expression  */
  if (yyn == 35)
    /* "./src/main/resources/UCricketParser.y":137  */
                                          { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 36: /* binary: expression BANG_EQUAL expression  */
  if (yyn == 36)
    /* "./src/main/resources/UCricketParser.y":138  */
                                         { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.NOT_EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 37: /* binary: expression '<' expression  */
  if (yyn == 37)
    /* "./src/main/resources/UCricketParser.y":139  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.LESS, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 38: /* binary: expression '>' expression  */
  if (yyn == 38)
    /* "./src/main/resources/UCricketParser.y":140  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.GREATER, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 39: /* binary: expression LESS_EQUAL expression  */
  if (yyn == 39)
    /* "./src/main/resources/UCricketParser.y":141  */
                                         { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.LESS_EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 40: /* binary: expression GREATER_EQUAL expression  */
  if (yyn == 40)
    /* "./src/main/resources/UCricketParser.y":142  */
                                            { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.GREATER_EQUAL, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 41: /* binary: expression '+' expression  */
  if (yyn == 41)
    /* "./src/main/resources/UCricketParser.y":143  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.ADD, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 42: /* binary: expression '-' expression  */
  if (yyn == 42)
    /* "./src/main/resources/UCricketParser.y":144  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.SUBTRACT, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 43: /* binary: expression '*' expression  */
  if (yyn == 43)
    /* "./src/main/resources/UCricketParser.y":145  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.MULTIPLY, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 44: /* binary: expression '/' expression  */
  if (yyn == 44)
    /* "./src/main/resources/UCricketParser.y":146  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.DIVIDE, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 45: /* binary: expression '&' expression  */
  if (yyn == 45)
    /* "./src/main/resources/UCricketParser.y":147  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.AND, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 46: /* binary: expression '|' expression  */
  if (yyn == 46)
    /* "./src/main/resources/UCricketParser.y":148  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.OR, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 47: /* binary: expression '^' expression  */
  if (yyn == 47)
    /* "./src/main/resources/UCricketParser.y":149  */
                                  { yyval = new BinaryExpression(((Expression)(yystack.valueAt (2))), BinaryExpression.Operator.XOR, ((Expression)(yystack.valueAt (0)))); };
  break;


  case 48: /* unary: '(' expression ')'  */
  if (yyn == 48)
    /* "./src/main/resources/UCricketParser.y":153  */
                           { yyval = new UnaryExpression(((Expression)(yystack.valueAt (1))), UnaryExpression.Type.PARENTHESIS); };
  break;


  case 49: /* unary: '!' expression  */
  if (yyn == 49)
    /* "./src/main/resources/UCricketParser.y":154  */
                                              { yyval = new UnaryExpression(((Expression)(yystack.valueAt (0))), UnaryExpression.Type.LOGICAL_NEGATION); };
  break;


  case 50: /* unary: '-' expression  */
  if (yyn == 50)
    /* "./src/main/resources/UCricketParser.y":155  */
                                             { yyval = new UnaryExpression(((Expression)(yystack.valueAt (0))), UnaryExpression.Type.ARITHMETICAL_NEGATION); };
  break;


  case 51: /* primary: INTEGER  */
  if (yyn == 51)
    /* "./src/main/resources/UCricketParser.y":159  */
                { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.INTEGER); };
  break;


  case 52: /* primary: FLOAT  */
  if (yyn == 52)
    /* "./src/main/resources/UCricketParser.y":160  */
              { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.FLOAT); };
  break;


  case 53: /* primary: TRUE  */
  if (yyn == 53)
    /* "./src/main/resources/UCricketParser.y":161  */
             { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.BOOLEAN); };
  break;


  case 54: /* primary: FALSE  */
  if (yyn == 54)
    /* "./src/main/resources/UCricketParser.y":162  */
              { yyval = new ValueExpression(((String)(yystack.valueAt (0))), ValueType.BOOLEAN); };
  break;


  case 55: /* primary: IDENTIFIER  */
  if (yyn == 55)
    /* "./src/main/resources/UCricketParser.y":163  */
                   { yyval = new VariableExpression(((String)(yystack.valueAt (0)))); };
  break;


  case 56: /* functionCall: IDENTIFIER '(' arguments ')'  */
  if (yyn == 56)
    /* "./src/main/resources/UCricketParser.y":167  */
                                     { yyval = new FunctionCallExpression(((String)(yystack.valueAt (3))), ((ArgumentsExpression)(yystack.valueAt (1)))); };
  break;


  case 57: /* functionCall: IDENTIFIER '(' ')'  */
  if (yyn == 57)
    /* "./src/main/resources/UCricketParser.y":168  */
                           { yyval = new FunctionCallExpression(((String)(yystack.valueAt (2))), null); };
  break;


  case 58: /* arguments: expression ',' arguments  */
  if (yyn == 58)
    /* "./src/main/resources/UCricketParser.y":172  */
                                 { yyval = new ArgumentsExpression(((Expression)(yystack.valueAt (2))), ((ArgumentsExpression)(yystack.valueAt (0)))); };
  break;


  case 59: /* arguments: expression  */
  if (yyn == 59)
    /* "./src/main/resources/UCricketParser.y":173  */
                   { yyval = new ArgumentsExpression(((Expression)(yystack.valueAt (0))), null); };
  break;



/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":918  */

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

  private static final short yypact_ninf_ = -73;
  private static final short yytable_ninf_ = -1;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      17,     4,    36,    20,    17,    28,    40,   -73,   -73,    17,
      47,   -73,    69,    69,    59,    47,    47,    94,    95,    97,
     -73,   -73,   -73,    80,    74,    15,   -73,     2,   -73,    60,
     105,    81,    30,    75,   -73,   -73,   -73,   -73,    60,    60,
      60,   134,   -73,   -73,   -73,   -73,   -73,    37,    82,   108,
      77,   -73,   118,   -73,    60,    60,    60,    60,    60,    60,
      60,    60,    60,    60,    60,    60,    60,   -73,   -16,    86,
      96,    69,    60,    98,    37,   -73,   -73,   151,    37,   130,
     -73,   101,   112,   -73,   -11,   -11,   -11,   -11,   -11,   -11,
      78,    78,    58,    58,   -73,   -73,   -73,    60,    60,    60,
      60,   146,   168,   -73,   -73,   -73,   131,   -73,    60,   -73,
     185,   202,   128,   253,   135,    24,   -73,   -73,   -73,   -73,
     -73,   148,   149,    60,   -73,    60,    37,    37,   219,   236,
     154,   164,   -73,   -73,   -73,   -73
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
       4,     0,     0,     0,     4,     0,     0,     1,     3,     4,
       8,     2,    14,    14,     0,     8,     8,     0,     0,     0,
       5,     6,     7,     0,     0,     0,    13,     0,    25,     0,
       0,     0,     0,    55,    51,    52,    53,    54,     0,     0,
       0,     0,    31,    32,    33,    34,    12,    16,     0,     0,
       0,    50,     0,    49,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    26,    55,     0,
       0,    14,     0,     0,    16,    20,    21,     0,    16,     0,
      57,    59,     0,    48,    35,    36,    39,    40,    37,    38,
      41,    42,    43,    44,    45,    46,    47,     0,     0,     0,
       0,     0,     0,    10,    15,    17,     0,    11,     0,    56,
       0,     0,     0,    30,     0,     0,    24,     9,    58,    23,
      22,     0,     0,     0,    27,     0,    16,    16,     0,     0,
       0,     0,    29,    28,    18,    19
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final byte[] yypgoto_ = yypgoto_init();
  private static final byte[] yypgoto_init()
  {
    return new byte[]
    {
     -73,    -1,   -73,    62,   -73,   -73,   -12,   -72,   -73,    73,
     -73,    99,   -29,   -73,   -73,   -73,   -73,   107
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final byte[] yydefgoto_ = yydefgoto_init();
  private static final byte[] yydefgoto_init()
  {
    return new byte[]
    {
       0,     3,     4,    14,    15,    32,    18,    73,    74,    75,
      76,   112,    77,    42,    43,    44,    45,    82
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      41,    19,   104,     8,    97,    30,   106,     5,    11,    51,
      52,    53,    60,    61,    62,    63,    64,    65,    66,    50,
       7,    81,    98,     1,     2,    84,    85,    86,    87,    88,
      89,    90,    91,    92,    93,    94,    95,    96,    31,     6,
      68,    34,    35,   102,   123,    69,    70,    28,    13,    71,
      72,    36,    37,    29,   130,   131,   124,    12,    13,   101,
       9,    38,   125,    33,    34,    35,    48,    49,   110,   111,
     113,   113,    39,    10,    36,    37,    40,    21,    22,    81,
      33,    34,    35,    16,    38,    64,    65,    66,    16,    16,
      17,    36,    37,    20,   128,    39,   129,    23,    24,    40,
      25,    38,    26,    62,    63,    64,    65,    66,    46,    27,
      50,    79,    39,    80,    47,    78,    40,    54,    55,    56,
      57,    99,    58,    59,    60,    61,    62,    63,    64,    65,
      66,   100,   103,   107,    54,    55,    56,    57,   108,    58,
      59,    60,    61,    62,    63,    64,    65,    66,   109,   115,
      54,    55,    56,    57,    83,    58,    59,    60,    61,    62,
      63,    64,    65,    66,   121,   117,    67,    54,    55,    56,
      57,   122,    58,    59,    60,    61,    62,    63,    64,    65,
      66,   126,   127,   105,    54,    55,    56,    57,   134,    58,
      59,    60,    61,    62,    63,    64,    65,    66,   135,   114,
     116,    54,    55,    56,    57,     0,    58,    59,    60,    61,
      62,    63,    64,    65,    66,   118,     0,   119,    54,    55,
      56,    57,     0,    58,    59,    60,    61,    62,    63,    64,
      65,    66,     0,     0,   120,    54,    55,    56,    57,     0,
      58,    59,    60,    61,    62,    63,    64,    65,    66,     0,
       0,   132,    54,    55,    56,    57,     0,    58,    59,    60,
      61,    62,    63,    64,    65,    66,     0,     0,   133,    54,
      55,    56,    57,     0,    58,    59,    60,    61,    62,    63,
      64,    65,    66
    };
  }

private static final byte[] yycheck_ = yycheck_init();
  private static final byte[] yycheck_init()
  {
    return new byte[]
    {
      29,    13,    74,     4,    20,     3,    78,     3,     9,    38,
      39,    40,    23,    24,    25,    26,    27,    28,    29,    35,
       0,    50,    38,     6,     7,    54,    55,    56,    57,    58,
      59,    60,    61,    62,    63,    64,    65,    66,    36,     3,
       3,     4,     5,    72,    20,     8,     9,    32,    11,    12,
      13,    14,    15,    38,   126,   127,    32,    10,    11,    71,
      32,    24,    38,     3,     4,     5,    36,    37,    97,    98,
      99,   100,    35,    33,    14,    15,    39,    15,    16,   108,
       3,     4,     5,    10,    24,    27,    28,    29,    15,    16,
      21,    14,    15,    34,   123,    35,   125,     3,     3,    39,
       3,    24,    22,    25,    26,    27,    28,    29,     3,    35,
      35,     3,    35,    36,    33,    33,    39,    16,    17,    18,
      19,    35,    21,    22,    23,    24,    25,    26,    27,    28,
      29,    35,    34,     3,    16,    17,    18,    19,    37,    21,
      22,    23,    24,    25,    26,    27,    28,    29,    36,     3,
      16,    17,    18,    19,    36,    21,    22,    23,    24,    25,
      26,    27,    28,    29,    36,    34,    32,    16,    17,    18,
      19,    36,    21,    22,    23,    24,    25,    26,    27,    28,
      29,    33,    33,    32,    16,    17,    18,    19,    34,    21,
      22,    23,    24,    25,    26,    27,    28,    29,    34,   100,
      32,    16,    17,    18,    19,    -1,    21,    22,    23,    24,
      25,    26,    27,    28,    29,   108,    -1,    32,    16,    17,
      18,    19,    -1,    21,    22,    23,    24,    25,    26,    27,
      28,    29,    -1,    -1,    32,    16,    17,    18,    19,    -1,
      21,    22,    23,    24,    25,    26,    27,    28,    29,    -1,
      -1,    32,    16,    17,    18,    19,    -1,    21,    22,    23,
      24,    25,    26,    27,    28,    29,    -1,    -1,    32,    16,
      17,    18,    19,    -1,    21,    22,    23,    24,    25,    26,
      27,    28,    29
    };
  }

/* YYSTOS[STATE-NUM] -- The symbol kind of the accessing symbol of
   state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     6,     7,    41,    42,     3,     3,     0,    41,    32,
      33,    41,    10,    11,    43,    44,    49,    21,    46,    46,
      34,    43,    43,     3,     3,     3,    22,    35,    32,    38,
       3,    36,    45,     3,     4,     5,    14,    15,    24,    35,
      39,    52,    53,    54,    55,    56,     3,    33,    36,    37,
      35,    52,    52,    52,    16,    17,    18,    19,    21,    22,
      23,    24,    25,    26,    27,    28,    29,    32,     3,     8,
       9,    12,    13,    47,    48,    49,    50,    52,    33,     3,
      36,    52,    57,    36,    52,    52,    52,    52,    52,    52,
      52,    52,    52,    52,    52,    52,    52,    20,    38,    35,
      35,    46,    52,    34,    47,    32,    47,     3,    37,    36,
      52,    52,    51,    52,    51,     3,    32,    34,    57,    32,
      32,    36,    36,    20,    32,    38,    33,    33,    52,    52,
      47,    47,    32,    32,    34,    34
    };
  }

/* YYR1[RULE-NUM] -- Symbol kind of the left-hand side of rule RULE-NUM.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    40,    41,    41,    41,    42,    43,    43,    43,    44,
      44,    45,    45,    46,    46,    47,    47,    48,    48,    48,
      48,    48,    48,    48,    48,    49,    49,    50,    50,    50,
      51,    52,    52,    52,    52,    53,    53,    53,    53,    53,
      53,    53,    53,    53,    53,    53,    53,    53,    54,    54,
      54,    55,    55,    55,    55,    55,    56,    56,    57,    57
    };
  }

/* YYR2[RULE-NUM] -- Number of symbols on the right-hand side of rule RULE-NUM.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     4,     2,     0,     5,     2,     2,     0,     9,
       8,     4,     2,     3,     0,     2,     0,     2,     7,     7,
       1,     1,     4,     4,     3,     4,     6,     4,     6,     6,
       1,     1,     1,     1,     1,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     3,     2,
       2,     1,     1,     1,     1,     1,     4,     3,     3,     1
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
       2,     2,     2,    39,     2,     2,     2,     2,    27,     2,
      35,    36,    25,    23,    37,    24,     2,    26,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,    32,
      21,    38,    22,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,    29,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    33,    28,    34,     2,     2,     2,     2,
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
      15,    16,    17,    18,    19,    20,    30,    31
    };
  }


  private static final int YYLAST_ = 282;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 7;
  private static final int YYNTOKENS_ = 40;

/* Unqualified %code blocks.  */
/* "./src/main/resources/UCricketParser.y":57  */

    @Getter
    private static Program program;

/* "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java":1599  */

}
/* "./src/main/resources/UCricketParser.y":175  */
