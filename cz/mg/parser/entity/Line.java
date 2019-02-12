package cz.mg.parser.entity;

import cz.mg.collections.tree.TreeNode;
import cz.mg.parser.utilities.Substring;


public class Line extends TreeNode<Line, Token> {
    private final int indentation;
    private final Substring content;

    public Line(int indentation, Substring content) {
        this.indentation = indentation;
        this.content = content;
    }

    public int getIndentation() {
        return indentation;
    }

    public Substring getContent() {
        return content;
    }
}
