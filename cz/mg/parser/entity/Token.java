package cz.mg.parser.entity;

import cz.mg.collections.tree.TreeLeaf;
import cz.mg.parser.utilities.Substring;


public class Token extends TreeLeaf<Line> {
    private Substring content;
    private Type type;

    public Token(Substring content, Type type) {
        this.content = content;
        this.type = type;
    }

    public enum Type {
        SPECIAL,
        COMMENT,
        LITERAL,
        KEYWORD,
        NAME
    }
}
