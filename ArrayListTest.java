import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file:\t");
        String filePath = scan.nextLine();
        String contents = readFile(filePath);
        String output = buildContents(contents);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(output);


    }

    public static String buildContents(String c)
    {
        ArrayList<String>  line = new ArrayList<String>();
        String curLine = "";
        String lexical = "";
        int index1;
        int index2;
        // Read c one line at a time
        String[] lines = c.split(System.getProperty("line.separator"));
        for (int i = 0; i < lines.length; i++)
        {
            System.out.println(lines[i]);
            curLine = lines[i];
            // Code to assign the contents to line[i] to the arrayList line
            index1 = 0;
            index2 = 0;
            String temp = "";
            for(int j = 0; j < curLine.length(); j++)
            {
                if (curLine.charAt(j) == ' ')
                {
                    index2 = j;
                    temp = curLine.substring(index1, index2);
                    line.add(temp);
                    index1 = j+1;
                }
            }
            lexical += readLine(line);
            line.clear();
        }

        return lexical;
    }

    public static String readLine(ArrayList<String> curLine)
    {
        String output = "";
        String temp = "";
        String left = "";
        String right = "";
        String value = "";
        String name = "";
        String lineNumber = curLine.get(0); // Records line number
        temp += "<block> -> <statement>\n";
        for (int i = 1; i < curLine.size(); i++)
        {
            switch (curLine.get(i))
            {
                case "+": // Handles the line if it is an addition equation
                    left = curLine.get(i-1);
                    right = curLine.get(i+1);
                    break;
                case "-": // Handles the line if it is a subtraction equation
                    left = curLine.get(i-1);
                    right = curLine.get(i+1);
                    break;
                case "*": // Handles the line if it is a multiplication equation
                    left = curLine.get(i-1);
                    right = curLine.get(i+1);
                    break;
                case "/": // Handles the line if it is a division equation
                    left = curLine.get(i-1);
                    right = curLine.get(i+1);
                    break;
                case "=": // Handles assignment opearations
                    output += "<statement> -> <assignment_statement>\n<assignment_statement> -> id <assignment_operator>\n<arithmetic_expression>\n<assignment_operator> -> <eq_operator>";
                    value = curLine.get(i-1);
                    switch (curLine.get(i+1))
                    {
                        case "int": // Handles int assignment
                            name = curLine.get(i+2);
                            output += "<arithmetic_expression> -> <literal_integer>\n"+ name + " -> id\n= -> <assignment_operator>\n" + value + " -> <literal_integer>\n";
                            output += "=" + name + value; //pre-fix
                            break;
                        case "String": // Handles String assignment
                            name = curLine.get(i+2);
                            output += "";
                            break;
                    }
                    break;

            }
            output += temp;
            temp = "";
        }
        return output;
    }

    public static String readFile(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }
}