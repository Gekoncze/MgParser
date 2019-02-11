package cz.mg.parser.entity;

import cz.mg.collections.tree.TreeNode;
import cz.mg.parser.utilities.Substring;


public class Page extends TreeNode<Book, Line> {
    private final Substring content;

    public Page(Substring content) {
        this.content = content;
    }

    public Substring getContent() {
        return content;
    }
}
