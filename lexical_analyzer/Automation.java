
package lexical_analyzer;

public class Automation 
{

	public void identifyCharacter(String line, int lineNumber){
		if(!line.equals("")){
			if(isNumber(line.charAt(0))){
				numberIdentifier(line, lineNumber);
			}else{
				switch(line.charAt(0)){
					case '_': underlineIdentifier1(line, lineNumber); break;
					case '-': numberIdentifier(line, lineNumber); break;
					case '+': numberIdentifier(line, lineNumber); break;
					case '/': commentIdentifier(line, lineNumber); break;
					case 'i': integerIdentifier(line, lineNumber); break;
					case 'f': floatIdentifier(line, lineNumber); break;
					case 'd': doubleIdentifier(line, lineNumber); break;
					case 'c': charIdentifier(line, lineNumber); break;
					case 'b': booleanIdentifier(line, lineNumber); break;
					case 'r': realIdentifier(line, lineNumber); break;
					default: Error.addError(lineNumber);
				}


				

				System.out.println();

				Output.print();

			}
		}else{
			Error.addError(lineNumber);
			Error.print();
		}
	}
	
	private void integerIdentifier(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		if(length <= 3){
			for(int i = 1; i< length; i++){
				switch(i){
					case 1 : error = (line.charAt(i) == 'n' ? false : true); break;
					case 2 : error = (line.charAt(i) == 't' ? false : true); break;
					default: error = true;
				}
				if(error){
					Error.addError(lineNumber);
					break;
				}
			}
		}else{
			error = true;
			Error.addError(lineNumber);
		}
		if(error == false){
			Output.setInt(lineNumber);
		}
	}
	
	private void floatIdentifier(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		if(length <= 5){
			for(int i = 1; i< length; i++){
				switch(i){
					case 1 : error = (line.charAt(i) == 'l' ? false : true); break;
					case 2 : error = (line.charAt(i) == 'o' ? false : true); break;
					case 3 : error = (line.charAt(i) == 'a' ? false : true); break;
					case 4 : error = (line.charAt(i) == 't' ? false : true); break;
					default: error = true;
				}
				if(error){
					Error.addError(lineNumber);
					break;
				}
			}
		}else{
			error = true;
			Error.addError(lineNumber);
		}
		if(error == false){
			Output.setFloat(lineNumber);
		}
	}
	
	private void realIdentifier(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		if(length <= 4){
			for(int i = 1; i< length; i++){
				switch(i){
					case 1 : error = (line.charAt(i) == 'e' ? false : true); break;
					case 2 : error = (line.charAt(i) == 'a' ? false : true); break;
					case 3 : error = (line.charAt(i) == 'l' ? false : true); break;
					default : error = true;
				}
				if(error){
					Error.addError(lineNumber);
					break;
				}
			}
		}else{
			error = true;
			Error.addError(lineNumber);
		}
		if(error == false){
			Output.setReal(lineNumber);
		}
	}
	
	private void doubleIdentifier(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		if(length <= 6){
			for(int i = 1; i< length; i++){
				switch(i){
					case 1 : error = (line.charAt(i) == 'o' ? false : true); break;
					case 2 : error = (line.charAt(i) == 'u' ? false : true); break;
					case 3 : error = (line.charAt(i) == 'b' ? false : true); break;
					case 4 : error = (line.charAt(i) == 'l' ? false : true); break;
					case 5 : error = (line.charAt(i) == 'e' ? false : true); break;
				}
				if(error){
					Error.addError(lineNumber);
					break;
				}
			}
		}else{
			error = true;
			Error.addError(lineNumber);
		}
		if(error == false){
			Output.setDouble(lineNumber);
		}
	}
	
	private void charIdentifier(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		if(length <= 4){
			for(int i = 1; i< length; i++){
				switch(i){
					case 1 : error = (line.charAt(i) == 'h' ? false : true); break;
					case 2 : error = (line.charAt(i) == 'a' ? false : true); break;
					case 3 : error = (line.charAt(i) == 'r' ? false : true); break;
					default : error = true;
				}
				if(error){
					Error.addError(lineNumber);
					break;
				}
			}
		}else{
			error = true;
			Error.addError(lineNumber);
		}
		if(error == false){
			Output.setChar(lineNumber);
		}
	}
	
	private void booleanIdentifier(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		if(length <= 7){
			for(int i = 1; i< length; i++){
				switch(i){
					case 1 : error = (line.charAt(i) == 'o' ? false : true); break;
					case 2 : error = (line.charAt(i) == 'o' ? false : true); break;
					case 3 : error = (line.charAt(i) == 'l' ? false : true); break;
					case 4 : error = (line.charAt(i) == 'e' ? false : true); break;
					case 5 : error = (line.charAt(i) == 'a' ? false : true); break;
					case 6 : error = (line.charAt(i) == 'n' ? false : true); break;
					default : error = true;
				}
				if(error){
					Error.addError(lineNumber);
					break;
				}
			}
		}else{
			error = true;
			Error.addError(lineNumber);
		}
		if(error == false){
			Output.setBoolean(lineNumber);
		}
	}
	
	private void commentIdentifier(String line, int lineNumber){
		int length = line.length();
		if(line.charAt(1) == '/'){
				if(line.charAt(length - 2) != '*'){
					Error.addError(lineNumber);
				}else{
					if(line.charAt(length -1) != '/'){
						Error.addError(lineNumber);
					}
					else{
						Output.setCommentIdentifier(lineNumber, line);
					}
			}
		}else{
			Error.addError(lineNumber);
		}
	}
	
	private void numberIdentifier(String line, int lineNumber){
		if(isNumber(line.charAt(1))){
			if(line.length() == 2){
				Output.setIntegerIdentifier(lineNumber, line);
				Symbol.addSymbol(line);
			}else{
				numberIdentifier2(line, lineNumber);
			}
		}
		else{
			Error.addError(lineNumber);
		}
	}
	
	private void numberIdentifier2(String line, int lineNumber){
		boolean isFloat = false;
		int length = line.length();
		boolean error = false;
		for(int i = 2; i < length; i++){
			if(!isNumber(line.charAt(i))){
				if(line.charAt(i) != '.'){
					Error.addError(lineNumber);
					error = true;
					break;
				}
				else{
					if(length < (i + 2)){
						Error.addError(lineNumber);
						error = true;
						break;
					}else{
						if(!isNumber(line.charAt(i + 1))){
							Error.addError(lineNumber);
							error = true;
							break;
						}
						isFloat = true;
					}
				}
			}
		}
		if(error == false){
			Symbol.addSymbol(line);
			if(isFloat){
				Output.setFloatIdentifier(lineNumber, line);
			}else{
				Output.setIntegerIdentifier(lineNumber, line);
			}
		}
	}
	
	private void underlineIdentifier1(String line, int lineNumber){
		if(isCharacter(line.charAt(1)) || isNumber(line.charAt(1))){
			if(line.length() == 2){
				Output.setIdentifier(lineNumber, line);
				Symbol.addSymbol(line);
			}else{
				underlineIdentifier2(line, lineNumber);
			}
		}
	}
	
	private void underlineIdentifier2(String line, int lineNumber){
		int length = line.length();
		boolean error = false;
		for(int i = 2; i < length; i++){
			if(!isCharacter(line.charAt(i)) && !isNumber(line.charAt(i))){
				Error.addError(lineNumber);
				error = true;
				break;
			}
		}
		if(error == false){
			Symbol.addSymbol(line);
			Output.setIdentifier(lineNumber, line);
		}
	}
	
	private boolean isCharacter(char c){
		return Character.isLetter(c);
	}
	
	
	private boolean isNumber(char c){
		return Character.isDigit(c);
	} 

    
}
