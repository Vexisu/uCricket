%language "Java"

%code imports {
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

import lombok.Getter;
}

%define api.package {pl.polsl.student.maciwal866.ucricket}
%define api.prefix {UCricket}
%define api.parser.class {UCricketParser}
%define api.parser.public
%define parse.error verbose
%verbose

%token IDENTIFIER INTEGER FLOAT IMPORT SCOPE IF WHILE FUNC VAR RETURN TRUE FALSE EQUAL_EQUAL BANG_EQUAL LESS_EQUAL GREATER_EQUAL

%nterm <ValueType> returnedType
%nterm <StatementChain> statements
%nterm <Statement> statement
%nterm <VariableStatement> variableStatement
%nterm <Expression> expression binary unary primary functionCall condition
%nterm <ArgumentsExpression> arguments
%nterm <Scope> scope
%nterm <Function> function
%nterm <Scope.ScopeContent> scopeContent
%nterm <Function.ArgumentChain> argumentChain

%start program
%left "==" "!=" "<=" ">=" "<" ">" 
%left '+' '-'
%left '*' '/'
%right ARITHM_NEGATION LOGICAL_NEGATION

%code {
    @Getter
    private static Program program;
}

%code init {
    program = new Program();
}

%%
program:
        program IMPORT IDENTIFIER ';'
    |   program scope { program.addScope($2); }
    |   
;

scope:
        SCOPE IDENTIFIER '{' scopeContent '}' { $$ = new Scope($<String>2, $4); }
;

scopeContent:
        scopeContent function { $$ = new Scope.ScopeContent<Function>($2, $1); }
    |   scopeContent variableStatement { $$ = new Scope.ScopeContent<VariableStatement>($2, $1); }
    |   { $$ = null; }
;

function:
        FUNC returnedType IDENTIFIER '(' argumentChain ')' '{' statements '}' { $$ = new Function($2, $<String>3, $5, $8); }
    |   FUNC returnedType IDENTIFIER '(' ')' '{' statements '}' { $$ = new Function($2, $<String>3, null, $7); }
;

argumentChain:
        argumentChain ',' IDENTIFIER IDENTIFIER { $$ = new Function.ArgumentChain(ValueType.parse($<String>3), $<String>4, $1); }
    |   IDENTIFIER IDENTIFIER { $$ = new Function.ArgumentChain(ValueType.parse($<String>1), $<String>2, null); }
;

returnedType:
        '<' IDENTIFIER '>' { $$ = ValueType.parse($<String>2); }
    |   { $$ = null; }
;

statements:
        statements statement { $$ = new StatementChain($2, $1); }
    |   { $$ = null; }
;

statement: 
        expression ';' {$$ = new ExpressionStatement($1); }
    |   IF '(' condition ')' '{' statements '}' { $$ = new IfStatement($3, $6); }
    |   WHILE '(' condition ')' '{' statements '}' { $$ = new WhileStatement($3, $6); }
    |   variableStatement { $$ = $1; }
    |   IDENTIFIER '=' expression ';' { $$ = new AssignmentStatement($<String>1, $3); }
    |   RETURN expression ';' { $$ = new ReturnStatement($2); }
;

variableStatement:
        VAR returnedType IDENTIFIER ';' { $$ = new VariableStatement($2, $<String>3, null); }
    |   VAR returnedType IDENTIFIER '=' expression ';' { $$ = new VariableStatement($2, $<String>3, $5); }
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
        expression EQUAL_EQUAL expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.EQUAL, $3); }
    |   expression BANG_EQUAL expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.NOT_EQUAL, $3); }
    |   expression '<' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.LESS, $3); }
    |   expression '>' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.GREATER, $3); }
    |   expression LESS_EQUAL expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.LESS_EQUAL, $3); }
    |   expression GREATER_EQUAL expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.GREATER_EQUAL, $3); }
    |   expression '+' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.ADD, $3); }
    |   expression '-' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.SUBTRACT, $3); }
    |   expression '*' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.MULTIPLY, $3); }
    |   expression '/' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.DIVIDE, $3); }
;

unary:
        '(' expression ')' { $$ = new UnaryExpression($2, UnaryExpression.Type.PARENTHESIS); }
    |   '!' expression %prec LOGICAL_NEGATION { $$ = new UnaryExpression($2, UnaryExpression.Type.LOGICAL_NEGATION); }
    |   '-' expression %prec ARITHM_NEGATION { $$ = new UnaryExpression($2, UnaryExpression.Type.ARITHMETICAL_NEGATION); }
;

primary:
        INTEGER { $$ = new ValueExpression($<String>1, ValueType.INTEGER); }
    |   FLOAT { $$ = new ValueExpression($<String>1, ValueType.FLOAT); }
    |   TRUE { $$ = new ValueExpression($<String>1, ValueType.BOOLEAN); }
    |   FALSE { $$ = new ValueExpression($<String>1, ValueType.BOOLEAN); }
    |   IDENTIFIER { $$ = new VariableExpression($<String>1); }
;

functionCall:
        IDENTIFIER '(' arguments ')' { $$ = new FunctionCallExpression($<String>1, $3); }
    |   IDENTIFIER '(' ')' { $$ = new FunctionCallExpression($<String>1, null); }
;

arguments: 
        arguments ',' expression { $$ = new ArgumentsExpression($3, $1); }
    |   expression { $$ = new ArgumentsExpression($1, null); }
;
%%