package lexical_analyzer;

import java.util.ArrayList;

public class Error {

	private static ArrayList<Integer> errors = new ArrayList<Integer>();
	
	public static void addError(int line){
		errors.add(line);
	}
	
	public static ArrayList<Integer> getErros(){
		return errors;
	}

	public static void print()
	{

			for(int i=0; i<errors.size();i++)
			{
				System.out.println(errors.get(i));
			}
		
	}
}