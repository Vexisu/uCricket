%language "Java"

%code imports {
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
}

%define api.package {pl.polsl.student.maciwal866.ucricket}
%define api.prefix {UCricket}
%define api.parser.class {UCricketParser}
%define api.parser.public
%define parse.error verbose
%verbose

%token IDENTIFIER INTEGER FLOAT IMPORT SCOPE IF WHILE FUNC VAR PTR RETURN TRUE FALSE EQUAL_EQUAL BANG_EQUAL LESS_EQUAL GREATER_EQUAL ASSIGN_ADDRESS

%nterm <ValueType> returnedType
%nterm <StatementChain> statements
%nterm <Statement> statement
%nterm <VariableStatement> variableStatement
%nterm <PointerStatement> pointerStatement
%nterm <Expression> expression binary unary primary functionCall condition
%nterm <ArgumentsExpression> arguments
%nterm <Scope> scope
%nterm <Function> function
%nterm <Scope.ScopeContent> scopeContent
%nterm <Function.ArgumentChain> argumentChain

%start program
%left EQUAL_EQUAL BANG_EQUAL LESS_EQUAL GREATER_EQUAL '<' '>' 
%left '&' '|' '^'
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
        IMPORT IDENTIFIER ';' program
    |   scope program { program.addScope($1); }
    |   
;

scope:
        SCOPE IDENTIFIER '{' scopeContent '}' { $$ = new Scope($<String>2, $4); }
;

scopeContent:
        function scopeContent { $$ = new Scope.ScopeContent<Function>($1, $2); }
    |   variableStatement scopeContent { $$ = new Scope.ScopeContent<VariableStatement>($1, $2); }
    |   pointerStatement scopeContent { $$ = new Scope.ScopeContent<PointerStatement>($1, $2); }
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
    |   { $$ = ValueType.NONE; }
;

statements:
        statement statements { $$ = new StatementChain($1, $2); }
    |   { $$ = null; }
;

statement: 
        expression ';' {$$ = new ExpressionStatement($1); }
    |   IF '(' condition ')' '{' statements '}' { $$ = new IfStatement($3, $6); }
    |   WHILE '(' condition ')' '{' statements '}' { $$ = new WhileStatement($3, $6); }
    |   variableStatement { $$ = $1; }
    |   pointerStatement { $$ = $1; }
    |   IDENTIFIER '=' expression ';' { $$ = new AssignmentStatement(AssignmentType.VALUE, $<String>1, $3); }
    |   IDENTIFIER ASSIGN_ADDRESS expression ';' { $$ = new AssignmentStatement(AssignmentType.ADDRESS, $<String>1, $3); }
    |   RETURN expression ';' { $$ = new ReturnStatement($2); }
;

variableStatement:
        VAR returnedType IDENTIFIER ';' { $$ = new VariableStatement($2, $<String>3, null); }
    |   VAR returnedType IDENTIFIER '=' expression ';' { $$ = new VariableStatement($2, $<String>3, $5); }
;

pointerStatement:
        PTR returnedType IDENTIFIER ';' { $$ = new PointerStatement($2, $<String>3, AssignmentType.NONE, null); }
    |   PTR returnedType IDENTIFIER '=' expression ';' { $$ = new PointerStatement($2, $<String>3, AssignmentType.VALUE, $5); }
    |   PTR returnedType IDENTIFIER ASSIGN_ADDRESS expression ';' { $$ = new PointerStatement($2, $<String>3, AssignmentType.ADDRESS, $5); }
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
    |   expression '&' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.AND, $3); }
    |   expression '|' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.OR, $3); }
    |   expression '^' expression { $$ = new BinaryExpression($1, BinaryExpression.Operator.XOR, $3); }
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
        expression ',' arguments { $$ = new ArgumentsExpression($1, $3); }
    |   expression { $$ = new ArgumentsExpression($1, null); }
;
%%