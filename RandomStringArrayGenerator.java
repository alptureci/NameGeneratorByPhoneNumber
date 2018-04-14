package utilities;

import java.util.Arrays;
import java.util.Random;

public class RandomStringArrayGenerator {
	
	char[] alphabet = {'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z'};
	
	private String[] string_arr;
	
	public String[] getRandomString(){
		return string_arr;
	}
	
	public void generateRandomStringArray(int sizeOfEachWord, int arraySize){
		string_arr = new String[arraySize];
		
		Random r =  new Random();
		
		for (int i = 0; i < arraySize; i++){
			String s = "";
			for (int j = 0; j < sizeOfEachWord; j++){
				s = s + alphabet[r.nextInt(26)];
			}
			string_arr[i] = s;
		}
	}
	
	public void sort(){
		if (string_arr != null && string_arr.length > 0){
			Arrays.sort(string_arr);
		}		
	}
	
	public void addControl_word(String control_world){
		if (string_arr != null && string_arr.length > 0){
			string_arr[string_arr.length - 1] = control_world;
		}
	}
	
	public static void test(int sizeOfEachWord, int arraySize){
		RandomStringArrayGenerator r = new RandomStringArrayGenerator();
		r.generateRandomStringArray(sizeOfEachWord, arraySize);
		
		System.out.println("Unsorted Version");
		for (String s : r.getRandomString()){
			System.out.print("'"+s+"' - ");
		}
		System.out.println("");
		
		r.sort();
		
		System.out.println("Sorted Version");
		for (String s : r.getRandomString()){
			System.out.print("'"+s+"' - ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args){
		test(3,5);
		test(3,5);
		test(5,5);
		test(3,10);
		test(3,10);
		
	}

}
