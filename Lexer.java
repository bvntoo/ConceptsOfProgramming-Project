import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.Scanner;
import java.util.File;

public class Lexer {
    private StringBuilder input = new StringBuilder();
    private Token token;
    private String lexema;
    private boolean exausthed = false;
    private String errorMessage = "";
    private Set<Character> blankChars = new HashSet<Character>();

    public Lexer(String[] filePath) {
        try
    {
        Scanner file = new Scanner(new File(filePath));
        List<String> fileContent = new ArrayList<String>();
        String line = "";

        while(file.hasNextLine()!=false)
        {
            line = file.nextLine();
            fileContent.add(line);
        }
        file.close();
        //The lexar method needs to be able to return a lexical breakdown of the given file. Refer to the parser report document for the format
        String[] returnArray = fileContent.toArray(new String[0]);
        return returnArray;

    }
    catch (FileNotFoundException e)
    {
        System.out.println("Please input a valid filepath");
        String[] returnArray = {"foo"}; // This is really only needed for the writeToFile method in Parser.java
        //e.printStackTrace();
        return returnArray;
    }

        fileContent.add('\r');
        fileContent.add('\n');
        fileContent.add((char) 8);
        fileContent.add((char) 9);
        fileContent.add((char) 11);
        fileContent.add((char) 12);
        fileContent.add((char) 32);

        moveAhead();
    }

    public void moveAhead() {
        if (exausthed) {
            return;
        }

        if (input.length() == 0) {
            exausthed = true;
            return;
        }

        ignoreWhiteSpaces();

        if (findNextToken()) {
            return;
        }

        exausthed = true;

        if (input.length() > 0) {
            errorMessage = "Unexpected symbol: '" + input.charAt(0) + "'";
        }
    }

    private void ignoreWhiteSpaces() {
        int charsToDelete = 0;

        while (blankChars.contains(input.charAt(charsToDelete))) {
            charsToDelete++;
        }

        if (charsToDelete > 0) {
            input.delete(0, charsToDelete);
        }
    }

    private boolean findNextToken() {
        for (Token t : Token.values()) {
            int end = t.endOfMatch(input.toString());

            if (end != -1) {
                token = t;
                lexema = input.substring(0, end);
                input.delete(0, end);
                return true;
            }
        }

        return false;
    }

    public Token currentToken() {
        return token;
    }

    public String currentLexema() {
        return lexema;
    }

    public boolean isSuccessful() {
        return errorMessage.isEmpty();
    }

    public String errorMessage() {
        // Error message needs to be able to print the line the error occured on and explain it
        return errorMessage;
    }

    public boolean isExausthed() {
        return exausthed;
    }
}
