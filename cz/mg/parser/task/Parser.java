package cz.mg.parser.task;

import cz.mg.collections.tree.TreeRoot;
import cz.mg.parser.entity.Page;
import cz.mg.parser.utilities.Substring;


public class Parser extends TreeRoot<PageParser> {
    public Page parse(String text){
        Page page = new Page(new Substring(text));
        PageParser pageParser = new PageParser();
        pageParser.setParent(this);
        pageParser.parse(page);
        return page;
    }
}
