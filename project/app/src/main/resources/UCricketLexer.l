package pl.polsl.student.maciwal866.ucricket;

%%
%unicode
%standalone
%public
%class UCricketLexer
%implements UCricketParser.Lexer
%line
%column

%{
    @Override
    public void yyerror(String msg){
        System.err.printf("%d:%d: %s\n%s\n", yyline + 1, yycolumn, yytext(), msg);
        System.exit(-1);
    }

    @Override
    public String getLVal(){
        return yytext();
    }
%}

COMMENT = \/\/.*
WHITESPACE = \ +|\n+|\r+|\t+
IDENTIFIER = [a-zA-z][a-zA-Z0-9]*(:?[a-zA-Z0-9]+)?
INTEGER = \d+
FLOAT = \d*\.\d+d

%%
"+" {return '+';}
"-" {return '-';}
"*" {return '*';}
"/" {return '/';}
"=" {return '=';}
"%" {return '%';}
"&" {return '&';}
"|" {return '|';}
"^" {return '^';}
"~" {return '~';}
"!" {return '!';}
"(" {return '(';}
")" {return ')';}
"<" {return '<';}
">" {return '>';}
"{" {return '{';}
"}" {return '}';}
"[" {return '[';}
"]" {return ']';}
"." {return '.';}
"," {return ',';}
":" {return ':';}
";" {return ';';}
"\'" {return '\'';}
"\"" {return '\"';}

"==" {return UCricketParser.Lexer.EQUAL_EQUAL;}
"!=" {return UCricketParser.Lexer.BANG_EQUAL;}
"<=" {return UCricketParser.Lexer.LESS_EQUAL;} 
">=" {return UCricketParser.Lexer.GREATER_EQUAL;}

import {return UCricketParser.Lexer.IMPORT;}
scope {return UCricketParser.Lexer.SCOPE;}
func {return UCricketParser.Lexer.FUNC;}
if {return UCricketParser.Lexer.IF;}
while {return UCricketParser.Lexer.WHILE;}
var {return UCricketParser.Lexer.VAR;}
return {return UCricketParser.Lexer.RETURN;}
true {return UCricketParser.Lexer.TRUE;}
false {return UCricketParser.Lexer.FALSE;}

{IDENTIFIER} {
    return UCricketParser.Lexer.IDENTIFIER;
}

{INTEGER} {
    return UCricketParser.Lexer.INTEGER;
}

{FLOAT} {
    return UCricketParser.Lexer.FLOAT;
}

{COMMENT} {}
{WHITESPACE} {}