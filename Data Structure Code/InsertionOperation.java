package org.abhi.exercise.datastructure;
import java.util.*;

public class InsertionOperation {
	
	public void insertElement(int[] arr, int value_to_insert, int where_to_insert_index) {
		if(where_to_insert_index > arr.length) {
			
			System.out.println("insertion is not possible");
			
		}
		else {
			arr[where_to_insert_index] = value_to_insert;
			System.out.println("array elements after the insertion at the end of the array");
			
			for(int i : arr)
				System.out.println(i);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the size of array");
		
		int size_of_array = sc.nextInt();
		int element_for_array;
		int[] array = new int[size_of_array];
		for(int index = 0; index < (size_of_array-1); index++) {
			System.out.println("enter the element to insert in array");
			element_for_array = sc.nextInt();
			array[index] = element_for_array;
		}
		
		System.out.println("elements that are present in array");
		
		for(int index =0; index<size_of_array; index++) {
			System.out.println("array elements that are present in array" + array[index]);
			}
		
		System.out.println("enter the value to insert into the array");
		
		int element_to_insert = sc.nextInt();
		
		int insert_in_the_end = array.length-1;
		
		InsertionOperation io = new InsertionOperation();
		
		io.insertElement(array, element_to_insert, insert_in_the_end);

		
		

	}

}
