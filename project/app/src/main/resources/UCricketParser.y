%language "Java"

%{
package pl.polsl.student.maciwal866.ucricket;

import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
import pl.polsl.student.maciwal866.ucricket.ast.Expression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.BinaryExpression;
import pl.polsl.student.maciwal866.ucricket.ast.expression.UnaryExpression;
%}

%define api.prefix {UCricket}
%define api.parser.class {UCricketParser}
%define api.parser.public
%define parse.error verbose
%verbose

%token IDENTIFIER INTEGER FLOAT IMPORT SCOPE IF WHILE FUNC VAR RETURN

%nterm <Expression> expression binary unary primary functionCall

%start program
%left "==" "!=" "<=" ">=" "<" ">" 
%left "+" "-"
%left "*" "/"
%right ARITHM_NEGATION LOGICAL_NEGATION

%%
program:
        program IMPORT IDENTIFIER ";"
    |   program scope
    |   
;

scope:
        SCOPE IDENTIFIER "{" functions "}"
;

functions:
        functions function
    |   function
;

function:
        FUNC returnedType IDENTIFIER "(" argumentsDeclaration ")" "{" statements "}"
;

argumentsDeclaration:
        argumentsDeclaration "," IDENTIFIER IDENTIFIER
    |   IDENTIFIER IDENTIFIER
    |   
;

returnedType:
        "<" IDENTIFIER ">"
    |   
;

statements:
        statements statement 
    |   statement
;

statement: 
        expression ";"
    |   IF "(" condition ")" "{" statements "}" 
    |   WHILE "(" condition ")" "{" statements "}"
    |   VAR returnedType IDENTIFIER ";"
    |   VAR returnedType IDENTIFIER "=" expression ";"
    |   IDENTIFIER "=" expression ";"
    |   RETURN expression ";"
;

condition:
        expression
;

expression:
        binary
    |   unary
    |   primary
    |   functionCall
;

binary:
        expression "==" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.EQUAL, $3); }
    |   expression "!=" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.NOT_EQUAL, $3); }
    |   expression "<" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.LESS, $3); }
    |   expression ">" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.GREATER, $3); }
    |   expression "<=" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.LESS_EQUAL, $3); }
    |   expression ">=" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.GREATER_EQUAL, $3); }
    |   expression "+" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.ADD, $3); }
    |   expression "-" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.SUBTRACT, $3); }
    |   expression "*" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.MULTIPLY, $3); }
    |   expression "/" expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.DIVIDE, $3); }
;

unary:
        "(" expression ")" { $$ = new UnaryExpression($2, UnaryExpression.Type.PARENTHESIS); }
    |   "!" expression %prec LOGICAL_NEGATION { $$ = new UnaryExpression($2, UnaryExpression.Type.LOGICAL_NEGATION); }
    |   "-" expression %prec ARITHM_NEGATION { $$ = new UnaryExpression($2, UnaryExpression.Type.ARITHMETICAL_NEGATION); }
;

primary:
        INTEGER 
    |   FLOAT
    |   IDENTIFIER
;

functionCall:
        IDENTIFIER "(" arguments ")"
;

arguments: 
        arguments "," expression
    |   expression
    |
;
%%