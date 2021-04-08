package lexical_analyzer;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

//import jdk.internal.org.jline.reader.Buffer;

public class Lexer{

    Automation automation= new Automation();    

   /* public Lexer(Reader fileContents) {
        String line = "";       

        try
         {

            BufferedReader br = new BufferedReader(fileContents);
            int linenumber=1;
            while((line=br.readLine())!=null)
            {
                automation.identifyCharacter(line, linenumber);
                linenumber++;
            }
        //The lexar method needs to be able to return a lexical breakdown of the given file. Refer to the parser report document for the format
        
        }
        catch (IOException e)
            {
                 e.printStackTrace();       
    
            }

    } */

    public Lexer(String[] fileContents) {

        String line = "";       

       /* try
         { */

            List<String> br = new ArrayList<String>();
            int counter=0;
            for(int x=0; x<fileContents.length; x++)
            {
                br.add(fileContents[x]);
                counter++;
            }

            int linenumber=1;

           /* while((line=((BufferedReader) br).readLine())!=null)
            {
                automation.identifyCharacter(line, linenumber);
                linenumber++;
            }*/
            
            for(int i = 0; i< counter; i++) {
                automation.identifyCharacter(br.get(i), linenumber);
                linenumber++;
            }



            
        //The lexar method needs to be able to return a lexical breakdown of the given file. Refer to the parser report document for the format
        
        /*}
        catch (IOException e)
            {
                 e.printStackTrace();       
    
            } */


    }

}   