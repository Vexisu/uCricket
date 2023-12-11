package pl.polsl.student.maciwal866.ucricket.ast;

import pl.polsl.student.maciwal866.ucricket.ast.extension.Resolvable;

public interface ASTNode extends Resolvable{
    ASTNode solve();
}
