%language "Java"

%{
package pl.polsl.student.maciwal866.ucricket;
%}

%define api.prefix {UCricket}
%define api.parser.class {UCricketParser}
%define api.parser.public
%define parse.error verbose

%token IDENTIFIER INTEGER FLOAT IMPORT SCOPE FUNC VAR RETURN
%%
program:
        program statement
    |   statement 
;

statement: 
        expression ";"
;

expression:
        term
;

term:
        term '+' factor
    |   term '-' factor
    |   factor
;

factor:
        factor '*' unary
    |   factor '/' unary
    |   unary
;

unary:
        primary
    |   "-" primary
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
        arguments expression
    |   expression
;

%%