package cz.mg.parser.task;

import cz.mg.parser.entity.Line;
import cz.mg.parser.entity.Token;
import cz.mg.parser.utilities.ParseException;
import cz.mg.parser.utilities.Substring;


public class LineParser {
    private int lineNumber = -1;

    public void parse(Line line, int lineNumber){
        this.lineNumber = lineNumber;
        CharReader reader = new CharReader(line.getContent());
        reader.skip(line.getIndentation()*PageParser.INDENTATION_SIZE);
        while(reader.canTake()){
            reader.setBegin();
            char ch = reader.take();
            Token token;
            switch(ch){
                case '#': token = parseComment(reader); break;
                case '"': token = parseLiteral(reader); break;
                default: token = isWordCharacter(ch) ? parseWord(reader) : parseSpecial(reader);
            }
            line.getChildren().addLast(token);
        }
    }

    private Token parseComment(CharReader reader){
        while(reader.canTake()) reader.take();
        reader.setEnd();
        return new Token(reader.getSubstring(), Token.Type.COMMENT);
    }

    private Token parseLiteral(CharReader reader){
        reader.setBegin();
        while(reader.canTake()){
            char ch = reader.take();
            if(ch == '"'){
                reader.setEnd(-1);
                return new Token(reader.getSubstring(), Token.Type.LITERAL);
            }
        }
        throw new ParseException("At line " + lineNumber + " column " + reader.getColumn() + ": Unclosed literal. Missing \".");
    }

    private Token parseWord(CharReader reader){
        while(reader.canTake()){
            char ch = reader.take();
            if(!isWordCharacter(ch)){
                reader.backOff();
                reader.setEnd();
            }
        }

        Substring s = reader.getSubstring();
        Token.Type t = isKeyword(s) ? Token.Type.KEYWORD : Token.Type.NAME;
        return new Token(s, t);
    }

    private Token parseSpecial(CharReader reader){
        reader.setEnd();
        return new Token(reader.getSubstring(), Token.Type.SPECIAL);
    }

    private boolean isNumberCharacter(char ch){
        return ch >= '0' && ch <= '9';
    }

    private boolean isLowerCharacter(char ch){
        return (ch >= 'a' && ch <= 'z');
    }

    private boolean isUpperCharacter(char ch){
        return (ch >= 'A' && ch <= 'Z');
    }

    private boolean isWordCharacter(char ch){
        return isLowerCharacter(ch) || isUpperCharacter(ch) || isNumberCharacter(ch);
    }

    private boolean isKeyword(Substring s){
        for(int i = 0; i < s.count(); i++) if(!isUpperCharacter(s.get(i))) return false;
        return true;
    }
}