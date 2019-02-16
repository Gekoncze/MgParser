package test;

import cz.mg.parser.entity.Book;
import cz.mg.parser.entity.Line;
import cz.mg.parser.entity.Page;
import cz.mg.parser.entity.Token;
import cz.mg.parser.task.Parser;

import java.io.*;


public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Parser parser = new Parser();
        Book book = parser.parse(readText(new FileInputStream("/home/me/DATA/Dev/Java/MgParser/src/test/DefaultDesigner")));
        Page page = book.getChildren().getFirst();
        System.out.println("### PAGE");
        for(Line line : page){
            System.out.println("    ## LINE");
            for(Token token : line){
                System.out.println("        # TOKEN " + token.getType().name() + ": " + token.getContent());
            }
        }
    }

    private static String readText(InputStream stream){
        StringBuilder text = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream))){
            String line;
            while((line = reader.readLine()) != null){
                text.append(line);
                text.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return text.toString();
    }
}
