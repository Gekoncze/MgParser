package cz.mg.parser.task;

import cz.mg.parser.utilities.ParseException;
import cz.mg.parser.entity.Line;
import cz.mg.parser.entity.Page;
import cz.mg.parser.utilities.Substring;


public class PageParser {
    public static final int INDENTATION_SIZE = 4;

    public PageParser() {
    }

    public void parse(Page page){
        Substring text = page.getContent();
        int begin = 0;
        for(int i = 0; i < text.count(); i++){
            char ch = text.get(i);
            if(ch == '\n'){
                addLine(page, new Substring(text, begin, i));
                begin = i + 1;
            } else if(!isValid(ch)){
                throw new ParseException("Error at line " + page.getChildren().count() + " column " + i + ": Unsupported character code " + (int)ch + ". Only ASCII codes from 32 to 126 are supported. Did you type in some fancy exotic characters?");
            }
        }
        addLine(page, new Substring(text, begin, text.count()));
    }

    private void addLine(Page page, Substring lineContent) {
        Line line = new Line(getIndentation(page, lineContent), lineContent);

        int lastIndentation = page.getChildren().getLast().getIndentation();
        if(isLastEmpty(page)){
            if(line.getIndentation() > lastIndentation) throw new ParseException("Error at line " + page.getChildren().count() + " column " + 0 + ": Invalid indentation. Current indentation " + line.getIndentation() + " cannot be greater than " + lastIndentation + ". Are you missing parent line or did you indent too much?");
        } else {
            if(line.getIndentation() > (lastIndentation + 1)) throw new ParseException("Error at line " + page.getChildren().count() + " column " + 0 + ": Invalid indentation. Current indentation " + line.getIndentation() + " cannot be greater than " + lastIndentation + " + 1. Are you missing parent line or did you indent too much?");
        }

        page.getChildren().addLast(line);
        LineParser lineParser = new LineParser();
        lineParser.parse(line, page.getChildren().count() - 1);
    }

    private int getLastIndentation(Page page){
        if(page.getChildren().count() <= 0){
            return 0;
        } else {
            return page.getChildren().getLast().getIndentation();
        }
    }

    private boolean isLastEmpty(Page page){
        if(page.getChildren().count() <= 0){
            return true;
        } else {
            return isEmpty(page.getChildren().getLast().getContent());
        }
    }

    private int getIndentation(Page page, Substring line){
        if(isEmpty(line)) return getLastIndentation(page);
        for(int i = 0; i < line.count(); i++){
            if(line.get(i) != ' '){
                if(i % INDENTATION_SIZE == 0){
                    return i / INDENTATION_SIZE;
                } else {
                    throw new ParseException("Error at line " + page.getChildren().count() + " column " + i + ": Invalid number of spaces for indentation. Expected multiple of " + INDENTATION_SIZE + ", given " + i + ".");
                }
            }
        }
        return 0;
    }

    private boolean isEmpty(Substring line){
        return line.toString().trim().length() <= 0;
    }

    private boolean isValid(char ch){
        return ch >= 32 && ch <= 126;
    }
}
