package otherInterviewQuestions;

import java.util.*;
import utilities.BinarySearch4ArrayOfStrings;

public class NameGeneratorByPhoneNumber {
	
	HashMap<Character, char[]> directory = new HashMap<Character, char[]>();
	
	public NameGeneratorByPhoneNumber(){
		// Set the directory
		directory.put('2', new char[] {'a','b','c'});
		directory.put('3', new char[] {'d','e','f'});
		directory.put('4', new char[] {'g','h','i'});
		directory.put('5', new char[] {'j','k','l'});
		directory.put('6', new char[] {'m','n','o'});
		directory.put('7', new char[] {'p','q','r','s'});
		directory.put('8', new char[] {'t','u','v'});
		directory.put('9', new char[] {'w','x','y', 'z'});
	}
	
	
	public boolean isValidPhoneNumber(String number, boolean validate){
		
		//matches 10-digit numbers only
		String regexStr = "^[0-9]{10}$";
		
		if (validate && !number.matches(regexStr)){
			return false;
		}
		
		// if it contains '0' or '1'; it doesn't have conversion
		if (number.contains("0") || number.contains("1")){
			return false;
		}
		
		return true;
	}
	
	public ArrayList<String> generateName(String number, boolean validate){
		// get rid of dashes etc. 
		
		number = number.replaceAll("[\\s\\-()]", "");
		
		if (isValidPhoneNumber(number, validate) && validate){
			// trim the area code
			return generateName(number.substring(3).toCharArray());
		} else if (isValidPhoneNumber(number, validate) && !validate){
			// don't trim because, we know it's not an actual phone number, and just for test
			return generateName(number.toCharArray());
		} else return null;
	}
	
	public ArrayList<String> generateName(char[] number){
		// if there is no input == No output
		if (number.length == 0 || number[0] == ' '){
			return null;
		}
				
		// set the remainder for next recursion
		char[] remainder = Arrays.copyOfRange(number, 1, number.length);
		
		// recursively get alternates
		ArrayList<String> alternates = generateName(remainder);
		
		// possibilities: to be filled
		ArrayList<String> permutations = new ArrayList<String>();
		
		// combine the current chars with the ones from the previous recursion
		//current chars
		char[] chars = directory.get(number[0]);
		
		//combine with the previous ones
		if (alternates != null){
			for (int i = 0; i < alternates.size(); i++){
				for (char c : chars){
					permutations.add(c + alternates.get(i));
				}
			}
		}
		//if there is no earlier combination create your own
		else {
			for (char c : chars){
				permutations.add(c+"");
			}
		}		
		return permutations;
	}
	
	public static void test(String number, boolean validate){
		NameGeneratorByPhoneNumber gn = new NameGeneratorByPhoneNumber();
		
		ArrayList<String> available_names_list = gn.generateName(number, validate);
		
		
		System.out.println("\nPrinting available names for: " + number);
		
		if (available_names_list != null && available_names_list.size() != 0){
			String[] available_names = new String[available_names_list.size()];
			available_names = available_names_list.toArray(available_names);
			Arrays.sort(available_names);
			
			if (BinarySearch4ArrayOfStrings.binarySearch(available_names, "mdonald")){
				System.out.print("Param pam pam paaaaa!!");
			} else {
				System.out.println("\tgiven word is not found under possibilities");
			}
		} else {
			System.out.println("\t No Available Names");
		}	
	}
	
	public static void main(String[] args){
		
		String number1 = "78";
		String number2 = "6780";
		String number3 = "425-578-23-98";
		String number4 = "425-578-23-08";
		String number5 = "425-636-62-53";
		
		test(number1, false);
		test(number2, false);
		test(number3, true);
		test(number4, true);
		test(number5, true);
		
	}

}
