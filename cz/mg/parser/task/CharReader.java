package cz.mg.parser.task;

import cz.mg.parser.utilities.Substring;


public class CharReader {
    private final Substring text;
    private int position = 0;
    private int begin = 0;
    private int end = 0;

    public CharReader(Substring text) {
        this.text = text;
    }

    public char take(){
        char ch = text.get(position);
        position++;
        return ch;
    }

    public boolean canTake(){
        return position >= 0 && position < text.count();
    }

    public void skip(int n){
        position += n;
    }

    public void setBegin(){
        this.begin = position;
    }

    public void setEnd(){
        this.end = position;
    }

    public void setBegin(int delta){
        this.begin = position + delta;
    }

    public void setEnd(int delta){
        this.end = position + delta;
    }

    public Substring getSubstring(){
        return new Substring(text, begin, end);
    }

    public int getColumn(){
        return position;
    }

    public void backOff(){
        position--;
    }
}
