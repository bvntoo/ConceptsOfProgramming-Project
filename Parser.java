import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Parser {
                    //                  0       1     2   3   4   5   6   7   8
    public static String[] tokens = {"print","input","+","-","*","/",",","$","%"};

    public static List<String> numStorage = new ArrayList<String>();//stores ints
    public static List<String> stringStorage = new ArrayList<String>();//stores string variables
    public static List<String> lineStorage = new ArrayList<String>();//stores each line in the file

    public static void main(String[] args) {

        System.out.println("Please input the name of a file: ");
        Scanner input = new Scanner(System.in);
        String filepath = input.nextLine();
        //Path path = Paths.get(filepath);

        String[] fileContents = readFile(filepath);

        fileContents = tokenize(fileContents);

        for (String s : fileContents) {
            System.out.println(s);
        }

         writeToFile(fileContents);
    }

    public static String[] readFile(String input) {

        //reads in a given file using the path, line-by-line
        try {
            Scanner file = new Scanner(new File(input));
            List<String> fileContent = new ArrayList<String>();
            String line = "";

            while(file.hasNextLine()!=false) {
                line = file.nextLine();
                fileContent.add(line);
            }
            file.close();
            String[] returnArray = fileContent.toArray(new String[0]);
            return returnArray;

        }catch (FileNotFoundException e) {
            System.out.println("Please input a valid filepath");
            String[] returnArray = {"foo"};
            //e.printStackTrace();
            return returnArray;
        }
    }

    //converts the input into a tokenized output
    public static String[] tokenize(String[] input) {
        String line;
        String token;
        String tokenLine = "";
        String help = "";
        int lineCount = 1;
        int t = 0;

        if(input[0] == "foo") {
            return input;
        }

        for(int i = 0; i < input.length; i++) {
            line = input[i] + " ";
            token = "";
            t=0;
            while(t < line.length()) {

                //adds line count to the output array, once per line
                if(t==0) {
                    tokenLine += lineCount + " ";
                    lineCount++;
                }

                //handles parts in "", lumping them together into a big token, advancing t to the end of the "s
                if(line.charAt(t) == (char)34) {
                    int x = line.indexOf((char)34);
                    int y = line.indexOf((char)34, x+1);
                    tokenLine += "";
                    for(int u = t; u <= y; u++) {
                        tokenLine += line.charAt(u);
                    }
                    t = y;

                    //handles math symbols, as well as variable creation
                } else if(line.charAt(t) == (char)32 || line.length() == t) {
                    System.out.println(tokens[0]);

                    if(token.contains("$")) {
                        System.out.println("String Detected: ");
                        tokenLine = tokenLine + "String variable: " + token + " created ";
                        stringStorage.add(token);

                    } else if(token.contains("%")) {
                        System.out.println("Int detected: ");
                        tokenLine = tokenLine + "Int variable: " + token + " created ";
                        numStorage.add(token);
                        //handles the given token
                    } else if(token.equals(tokens[0])) {
                        tokenLine = tokenLine + "Print: ";
                    } else if(token.equals(tokens[1])) {
                        tokenLine = tokenLine + "Input: ";

                        //handles the given token if it contains a math sign, storing them
                    } else if(token.contains(tokens[2])) {
                        tokenLine += handleAdd(token);
                    } else if(token.contains(tokens[3])) {
                        tokenLine += handleSub(token);
                    } else if(token.contains(tokens[4])) {
                        tokenLine += handleMulti(token);
                    } else if(token.contains(tokens[5])) {
                        tokenLine += handleDiv(token);


                    } else
                    if(token.equals(tokens[6]))
                    {
                        tokenLine = tokenLine + ", assigning from input to: ";
                    }
                    else
                    {
                        if(!token.equals(""))
                        {
                            tokenLine += " Unrecognized token: " + token;
                        }
                    }
                    token = "";
                } else {
                    token += line.charAt(t);
                }
                System.out.println(token);
                t++;
            }
            input[i] = tokenLine;
            tokenLine = "";
        }
        return input;
    }
    public static String handleAdd(String input) {
        int x = 0, y = input.indexOf('+')+1;
        String left = "", right = "";

        while(x != input.indexOf('+')) {
            left = left + input.charAt(x);
            x++;
        }
        while(y != input.length()) {
            right = right + input.charAt(y);
            y++;
        }
        int leftInt = Integer.parseInt(left);
        int rightInt = Integer.parseInt(right);
        return left + " + " + right + " = " + (leftInt - rightInt);
    }

    public static String handleSub(String input) {
        int x = 0, y = input.indexOf('-')+1;
        String left = "", right = "";

        while(x != input.indexOf('-')) {
            left = left + input.charAt(x);
            x++;
            System.out.println(x);
        }
        while(y != input.length()) {
            right = right + input.charAt(y);
            y++;
        }
        int leftInt = Integer.parseInt(left);
        int rightInt = Integer.parseInt(right);
        return left + " - " + right + " = " + (leftInt - rightInt);
    }

    public static String handleMulti(String input) {
        int x = 0, y = input.indexOf('*')+1;
        String left = "", right = "";

        while(x != input.indexOf('*')) {
            left = left + input.charAt(x);
            x++;
            System.out.println(x);
        }
        while(y != input.length()) {
            right = right + input.charAt(y);
            y++;
        }
        int leftInt = Integer.parseInt(left);
        int rightInt = Integer.parseInt(right);
        return left + " * " + right + " = " + (leftInt * rightInt);
    }

    public static String handleDiv(String input) {
        int x = 0, y = input.indexOf('/')+1;
        String left = "", right = "";

        while(x != input.indexOf('/')) {
            left = left + input.charAt(x);
            x++;
            System.out.println(x);
        }
        while(y != input.length()) {
            right = right + input.charAt(y);
            y++;
        }
        int leftInt = Integer.parseInt(left);
        int rightInt = Integer.parseInt(right);
        return  left + " / " + right + " = " + (leftInt / rightInt);
    }


    public static void writeToFile(String[] input) { // This code doesn't need to be changes
        if(input[0] != "foo") {
            File outputFile = new File("output2.txt");
            try {
                if(outputFile.createNewFile()) {
                    System.out.println("File created at: " + outputFile.getAbsolutePath());
                } else {
                    System.out.println("File already exists at :" + outputFile.getAbsolutePath());
                }
                System.out.println("Writing to file");
                FileWriter x = new FileWriter(outputFile);
                for (String s : input) {
                    x.write(s + "\n");
                }
                x.close();
                System.out.println("Writing complete");
            } catch (IOException e) {
                System.out.println("Error creating new file");
                e.printStackTrace();
            }
        }
    }
}
