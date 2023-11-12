%language "Java"

%{
package pl.polsl.student.maciwal866.ucricket;

import pl.polsl.student.maciwal866.ucricket.ast.ASTNode;
%}

%define api.prefix {UCricket}
%define api.parser.class {UCricketParser}
%define api.parser.public
%define parse.error verbose
%verbose

%token IDENTIFIER INTEGER FLOAT IMPORT SCOPE IF WHILE FUNC VAR RETURN

%start program
%left "==" "!=" "<=" ">=" "<" ">" 
%left "+" "-"
%left "*" "/"
%precedence ARITHM_NEGATION
%precedence LOGICAL_NEGATION

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
        FUNC returnedType IDENTIFIER "(" ")" "{" statements "}"
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
    |   RETURN expression ";"
;

condition:
        expression
;

expression:
        expression "==" expression
    |   expression "!=" expression
    |   expression "<" expression
    |   expression ">" expression
    |   expression "<=" expression
    |   expression ">=" expression
    |   expression "+" expression
    |   expression "-" expression
    |   expression "*" expression
    |   expression "/" expression
    |   "(" expression ")"
    |   "!" expression %prec LOGICAL_NEGATION
    |   "-" expression %prec ARITHM_NEGATION
    |   primary
;

primary:
        INTEGER 
    |   FLOAT
    |   IDENTIFIER
    |   functionCall
;

functionCall:
        IDENTIFIER "(" arguments ")"
    |   IDENTIFIER "(" ")"
;

arguments: 
        arguments "," expression
    |   expression
;
%%