package cz.mg.parser.utilities;


public class TraceableException extends RuntimeException {
    private int row;
    private int begin;
    private int end;

    public TraceableException(Substring element, String message) {
        super(createMessage(element, message));
        this.row = findRow(element);
        this.begin = findColumn(element);
        this.end = this.begin + (element.getEnd() - element.getBegin());
    }

    private static String createMessage(Substring element, String message){
        int r = findRow(element);
        int c = findColumn(element);
        return "Error at line " + r + " column " + c + ": " + message;
    }

    private static int findRow(Substring element){
        int r = 0;
        int b = element.getBegin();
        for(int i = b; i >= 0; i--){
            char ch = element.getString().charAt(i);
            if(ch == '\n') r++;
        }
        return r + 1;
    }

    private static int findColumn(Substring element){
        int b = element.getBegin();
        for(int i = b; i >= 0; i--){
            char ch = element.getString().charAt(i);
            if(ch == '\n') return b-i-1+1;
        }
        return b+1;
    }

    public int getRow() {
        return row;
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }
}
