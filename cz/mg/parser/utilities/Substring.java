package cz.mg.parser.utilities;


public class Substring {
    private final String string;
    private final int begin;
    private final int end;

    public Substring(String string) {
        this.string = string;
        this.begin = 0;
        this.end = string.length();
    }

    public Substring(String string, int begin, int end) {
        check(begin, end, string.length());
        this.string = string;
        this.begin = begin;
        this.end = end;
    }

    public Substring(Substring substring, int begin, int end) {
        check(begin, end, substring.count());
        this.string = substring.string;
        this.begin = substring.begin + begin;
        this.end = substring.begin + end;
    }

    private static void check(int begin, int end, int count){
        if(begin < 0) throw new RuntimeException("Invalid begin index for substring: " + begin + " (must be >= 0)");
        if(end > count) throw new RuntimeException("Invalid end index for substring: " + end + " (must be <= " + count + ")");
        if(end < begin) throw new RuntimeException("Invalid end and begin index for substring: begin " + begin + " vs end " + end + " (begin must be <= end)");
    }

    public int count(){
        return end - begin;
    }

    public char get(int i){
        i = begin + i;
        if(i < begin) return 0;
        if(i >= end) return 0;
        return string.charAt(i);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Substring || o instanceof String) {
            return toString().equals(o.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        return string.substring(begin, end);
    }

    public static Substring union(Substring a, Substring b){
        if(a.string != b.string) throw new RuntimeException("Cannot union foreign substrings.");
        String string = a.string;
        int begin = Math.min(a.begin, b.begin);
        int end = Math.max(a.end, b.end);
        return new Substring(string, begin, end);
    }
}
