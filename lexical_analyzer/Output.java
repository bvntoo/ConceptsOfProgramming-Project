package lexical_analyzer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Output {

	private static LinkedHashMap<Integer, String> output = new LinkedHashMap<Integer, String>();
	
	public static void setIdentifier(int line, String value){
		int index;
		if((index = Symbol.getIndexIfExists(value)) != 0){
			output.put(line, "IDENTIFIER "+ index);
		}else{
			output.put(line, "IDENTIFIER " + Symbol.getIndexOfIdentifier(value));
		}
	}

	public static void setInt(int line){
		output.put(line, "INT");
	}
	
	public static void setFloat(int line){
		output.put(line, "FLOAT");
	}
	
	public static void setChar(int line){
		output.put(line, "CHAR");
	}
	
	public static void setDouble(int line){
		output.put(line, "DOUBLE");
	}
	
	public static void setReal(int line){
		output.put(line, "REAL");
	}
	
	public static void setBoolean(int line){
		output.put(line, "BOOLEAN");
	}
	
	public static void setIntegerIdentifier(int line, String value){
		int index;
		if((index = Symbol.getIndexIfExists(value)) != 0){
			output.put(line, "INTEGER NUMBER" + index);
		}else{
			output.put(line, "INTEGER NUMBER" + Symbol.getIndexOfIdentifier(value));
		}
	}
	
	public static void setFloatIdentifier(int line, String value){
		int index;
		if((index = Symbol.getIndexIfExists(value)) != 0){
			output.put(line, "REAL NUMBER " + index);
		}else{
			output.put(line, "REAL NUMBER" + Symbol.getIndexOfIdentifier(value));
		}
	}
	
	public static void setCommentIdentifier(int line, String value){
		output.put(line, "COMMENTS");
	}
	
	public static LinkedHashMap<Integer, String> getOutput(){
		return output;
	}
	public static void print()
	{

		Integer [] key=  new Integer[output.size()];
		String [] value= new String[output.size()];
		
		int i=0;
		for(Map.Entry<Integer, String> entry: output.entrySet())
		{
			key[i]=entry.getKey();
			value[i++]=entry.getValue();

		}

		for(i=0;i<output.size();i++)
		{
			System.out.println( key[i] + "->" + value[i]);	
		}




	}
}