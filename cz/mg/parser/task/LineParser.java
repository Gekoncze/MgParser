package cz.mg.parser.task;

import cz.mg.parser.entity.Line;


public class LineParser {
    public void parse(Line line){
//        CharReader reader = new CharReader(getInput(), getOutput());
//        Line line = getOutput();
//
//        while(reader.hasNext()){
//            char ch = reader.moveNext();
//            reader.setMark();
//
//            if(ch == ' '){
//                if(reader.getPosition() == 0) throw new CompileException(reader.getSubstringLocation(), "Leading whitespace.");
//            } else if(ch == '#'){
//                parseComment(line, reader);
//            } else if(ch == '"' || ch == '\''){
//                parseLiteral(line, reader, ch);
//            } else if(isName(ch)){
//                parseWord(line, reader, ch);
//            } else if(ch == '(') {
//                new OpeningToken(line, reader.getSubstringLocation(), reader.getSubstring());
//            } else if(ch == ')'){
//                new ClosingToken(line, reader.getSubstringLocation(), reader.getSubstring());
//            } else {
//                parseOperator(line, reader);
//            }
//        }
    }

//    private static boolean isNumber(char ch){
//        return ch >= '0' && ch <= '9';
//    }
//
//    private static boolean isLowerCharacter(char ch){
//        return (ch >= 'a' && ch <= 'z');
//    }
//
//    private static boolean isUpperCharacter(char ch){
//        return (ch >= 'A' && ch <= 'Z');
//    }
//
//    private static boolean isName(char ch){
//        return isLowerCharacter(ch) || isUpperCharacter(ch) || isNumber(ch);
//    }
//
//    private static boolean isAllowedLiteralCharacter(char ch){
//        return (ch >= ' ' && ch <= '~');
//    }
//
//    private static boolean isAllowedCommentCharacter(char ch){
//        return (ch >= ' ' && ch <= '~');
//    }
//
//    private static boolean isEscapeCharacter(char ch){
//        return isAllowedLiteralCharacter(ch);
//    }
//
//    private static boolean isOperator(char ch){
//        OperatorToken.Operator operator = OperatorToken.Operator.fromString("" + ch);
//        return operator != null;
//    }
//
//    private static void parseOperator(Line parent, CharReader reader){
//        while(reader.hasNext()){
//            char ch = reader.moveNext();
//            if(!isOperator(ch)){
//                reader.movePrevious();
//                break;
//            }
//        }
//        String text = reader.getSubstring();
//        OperatorToken.Operator operator = OperatorToken.Operator.fromString(text);
//        if(operator == null) throw invalidCharacterException(reader, "");
//        new PlainOperatorToken(parent, reader.getSubstringLocation(), text, operator);
//    }
//
//    private static void parseWord(Line parent, CharReader reader, char ch){
//        boolean hasLeadingUpper = false;
//        boolean hasLowerCharacter = false;
//        boolean hasNumber = false;
//
//        int pointerCount = 0;
//        String text = null;
//        Location textLocation = null;
//
//        if(isUpperCharacter(ch)){
//            hasLeadingUpper = true;
//        } else if(isLowerCharacter(ch)){
//            hasLowerCharacter = true;
//        } else if(isNumber(ch)){
//            hasNumber = true;
//        }
//
//        while(reader.hasNext()){
//            ch = reader.moveNext();
//            if(isLowerCharacter(ch)){
//                hasLowerCharacter = true;
//            } else if(ch == '&') {
//                reader.movePrevious();
//                text = reader.getSubstring();
//                textLocation = reader.getSubstringLocation();
//                pointerCount = parsePointerCount(reader);
//                break;
//            } else if(isNumber(ch)){
//                hasNumber = true;
//            } else if(!isName(ch)) {
//                reader.movePrevious();
//                break;
//            }
//        }
//
//        if(text == null) text = reader.getSubstring();
//        if(textLocation == null) textLocation = reader.getSubstringLocation();
//
//        if(!hasNumber && !hasLowerCharacter){
//            parseKeyword(parent, text, textLocation, pointerCount);
//        } else if(hasLeadingUpper && hasLowerCharacter) {
//            parseTypename(parent, text, textLocation, pointerCount);
//        } else if(hasLowerCharacter) {
//            parseName(parent, text, textLocation, pointerCount);
//        } else {
//            throw new CompileException(reader.getSubstringLocation(), "Invalid word: " + text);
//        }
//    }
//
//    public static void parseKeyword(Line parent, String text, Location textLocation, int pointerCount){
//        KeywordToken.Keyword keyword = KeywordToken.Keyword.fromString(text);
//        if(keyword == null) throw new CompileException(textLocation, "Unknown keyword ", text, ".");
//
//        if(pointerCount > 0){
//            if(keyword == VOID){
//                new CombinedKeywordTypeToken(parent, textLocation, text, keyword, pointerCount);
//                return;
//            } else {
//                throw new CompileException(textLocation, "Invalid use of address for keyword.");
//            }
//        }
//
//        if(keyword == TRUE || keyword == FALSE || keyword == NULL){
//            new CombinedKeywordLiteralToken(parent, textLocation, text, keyword);
//            return;
//        }
//
//        OperatorToken.Operator operator = OperatorToken.Operator.fromString(text);
//        if(operator != null){
//            new CombinedKeywordOperatorToken(parent, textLocation, text, keyword, operator);
//            return;
//        } else {
//            new PlainKeywordToken(parent, textLocation, text, keyword);
//            return;
//        }
//    }
//
//    public static void parseTypename(Line parent, String text, Location textLocation, int pointerCount){
//        if(pointerCount > 0){
//            new PlainTypeToken(parent, textLocation, text, pointerCount);
//        } else {
//            new PlainTypenameToken(parent, textLocation, text);
//        }
//    }
//
//    public static void parseName(Line parent, String text, Location textLocation, int pointerCount){
//        if(pointerCount > 0) throw new CompileException(textLocation, "Invalid use of address for variable name.");
//        new PlainNameToken(parent, textLocation, text);
//    }
//
//    private static int parsePointerCount(CharReader reader){
//        int pointerCount = 0;
//        while(reader.hasNext('&')){
//            pointerCount++;
//            reader.moveNext();
//        }
//        return pointerCount;
//    }
//
//    private static void parseLiteral(Line parent, CharReader reader, char boundary){
//        while(reader.hasNext()){
//            char ch = reader.moveNext();
//            if(ch == '\\'){
//                parseEscapeSequence(reader);
//            } else if(ch == boundary){
//                new PlainLiteralToken(parent, reader.getSubstringLocation(), reader.getSubstring(1, -1));
//                return;
//            } else if(isAllowedLiteralCharacter(ch)) {
//                continue;
//            } else {
//                throw invalidCharacterException(reader, "for literal");
//            }
//        }
//        throw new CompileException(reader.getSubstringLocation(), "Unclosed literal.");
//    }
//
//    private static void parseEscapeSequence(CharReader reader){
//        if(!reader.hasNext()) throw new CompileException(reader.getSubstringLocation(), "Unclosed literal.");
//        char ch = reader.moveNext();
//        if(!isEscapeCharacter(ch)) throw invalidCharacterException(reader, "for escape sequence");
//    }
//
//    private static void parseComment(Line parent, CharReader reader){
//        while(reader.hasNext()){
//            char ch = reader.moveNext();
//            if(isAllowedCommentCharacter(ch)) continue;
//            else throw invalidCharacterException(reader, "for comment");
//        }
//        new CommentToken(parent, reader.getSubstringLocation(), reader.getSubstring());
//    }
//
//    private static CompileException invalidCharacterException(CharReader reader, String f){
//        reader.movePrevious();
//        reader.setMark();
//        reader.moveNext();
//        return new CompileException(reader.getSubstringLocation(), new Object[]{
//                "Invalid character '", reader.getCharSubstring(), "' (", "" + (int)reader.read(), ") ", f, "."
//        });
//    }
}