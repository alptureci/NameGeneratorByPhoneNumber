package utilities;

public class BinarySearch4ArrayOfStrings{
	
	
	public static boolean binarySearch(String[] array, String target){
		
		return binarySearch(array, target, 0, array.length - 1);
		
	}
	
	public static boolean binarySearch(String[] array, String target, int low, int high){
		boolean res;
		if (low < high){			
			int mid = (low + high) /2;		
			
			String midElement = array[mid];
			
			if (midElement.equals(target)){
				res = true;
			} else if (midElement.compareTo(target) > 0){
				res = binarySearch(array, target, low, mid - 1);
			} else {
				res = binarySearch(array, target, mid + 1, high);
			}
		} else if (low == high){
			res = array[low].equals(target);
		} else {
			res = false;
		}
		return res;
	}
	
	public static void test(){
		// Below are all TESTs
		
				String[] arr1 = {"abc", "acb", "bac", "bca", "cab", "cba"};
				String val1 = "bac";
				System.out.println(binarySearch(arr1, val1) ? val1 + " found" : val1 + ": NOT AVAILABLE");
				
				
				String[] arr2 = {"mac", "mkb", "svg", "tqc", "xok"};
				String val2 = "mac";
				System.out.println(binarySearch(arr2, val2) ? val2 + " found" : val2 + ": NOT AVAILABLE");
				
				
				String[] arr3 = {"cyr", "mac", "qkl", "rsz", "xxx"};
				String val3 = "xxx";
				System.out.println(binarySearch(arr3, val3) ? val3 + " found" : val3 + ": NOT AVAILABLE");
				
				
				RandomStringArrayGenerator r = new RandomStringArrayGenerator();
				String control_world = "macaron";
				String[] arrayOfRandomStrings;
				
				for (int i = 0; i < 200; i++){
					//ADD CONTROL WORD
					r.generateRandomStringArray(3, 5);
					r.addControl_word(control_world);
					r.sort();
					arrayOfRandomStrings = r.getRandomString();
					if (!binarySearch(arrayOfRandomStrings, control_world)){
						// SOMETHING IS WRONG, CHECK
						for (String s : arrayOfRandomStrings){
							System.out.print("'"+s+"'-");
							break;
						}
					} else {
						// TRUE EVERYTHING IS OK!
						//System.out.println(binarySearch(arrayOfRandomStrings, control_world) ? control_world + " found" : control_world + ": NOT AVAILABLE");
					}
					
					// NO CONTROL WORD ADDED
					r.generateRandomStringArray(3, 5);
					r.sort();
					arrayOfRandomStrings = r.getRandomString();		
					System.out.println(binarySearch(arrayOfRandomStrings, control_world) ? control_world + " found" : control_world + ": NOT AVAILABLE");
				
				}
	}
	
	public static void main(String[] args){
		// run unit tests
		BinarySearch4ArrayOfStrings.test();		
	}
}
