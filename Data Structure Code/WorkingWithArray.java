import java.util.*;
public class WorkingWithArray {
	
	
	public void findElementFromArray(int[] arr, int key_to_find) {
		int flag = 0;
		for(int index = 0; index < arr.length; index++) {
			if(arr[index] == key_to_find) {
				System.out.println("value  "+arr[index] +" is found at index number "+ index);
				flag = 1;
			}
			else {
				
				System.out.println("value is not present in the array");
				//flag = -1;
			}
			}
	}
	
	public static void main(String[] args) {
		
		int []search_array = new int[10];
		search_array[0] = 19;
		search_array[1] = 56;
		search_array[2] = 86;
		search_array[3] = 40;
		search_array[4] = 25;
		search_array[5] = 73;
		search_array[6] = 67;
		search_array[7] = 38;
		search_array[8] = 92;
		search_array[9] = 28;
		
		System.out.println("array before any operation");
		for(int array_element : search_array)
		System.out.println(array_element);
 		System.out.println("caling the method to find the element from array ");
 		
 		WorkingWithArray wwa = new WorkingWithArray();
 		Scanner sc= new Scanner(System.in);
 		
 		System.out.println("enter an integer value to find from array");
 		int value_to_find = sc.nextInt();
 		 wwa.findElementFromArray(search_array, value_to_find);
 		/*if(wwa.findElementFromArray(search_array, value_to_find) == -1)
 		{
 			System.out.println("value is not presented into the array");
 		
 		}
 		else
 		{
 			System.out.println("value " + search_array[wwa.findElementFromArray(search_array, value_to_find)]+"present at the "
 					+ "index number"+wwa.findElementFromArray(search_array, value_to_find));
 		}
		**/
	}

}
