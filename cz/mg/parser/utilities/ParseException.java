package cz.mg.parser.utilities;


public class ParseException extends TraceableException {
    public ParseException(Substring element, String message) {
        super(element, message);
    }
}
