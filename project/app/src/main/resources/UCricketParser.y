%language "Java"

%{
package pl.polsl.student.maciwal866.ucricket;
%}

%define api.prefix {UCricket}
%define api.parser.class {UCricketParser}
%define api.parser.public
%define parse.error verbose

%token IDENTIFIER INTEGER FLOAT IMPORT SCOPE FUNC VAR RETURN

%start program
%left "+" "-"
%left "*" "/"
%precedence PAREN
%precedence PRIMARY

%%
program:
        program statement
    |   statement 
;

statement: 
        expression ";"
;

expression:
        expression "+" expression
    |   expression "-" expression
    |   expression "*" expression
    |   expression "/" expression
    |   "(" expression ")" %prec PAREN
    |   primary %prec PRIMARY
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