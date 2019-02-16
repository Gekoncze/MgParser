package cz.mg.parser.task;

import cz.mg.collections.tree.TreeRoot;
import cz.mg.parser.entity.Book;
import cz.mg.parser.entity.Page;
import cz.mg.parser.utilities.Substring;


public class Parser extends TreeRoot<PageParser> {
    public Book parse(String... texts){
        Book book = new Book();
        for(String text : texts){
            Page page = new Page(new Substring(text));
            page.setParent(book);
            PageParser pageParser = new PageParser();
            pageParser.setParent(this);
            pageParser.parse(page);
        }
        return book;
    }
}
