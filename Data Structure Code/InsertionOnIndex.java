package org.abhi.exercise.datastructure;
import java.util.*;
public class InsertionOnIndex {

	public void insertAtIndexPosition(int[] array_as_para, int index_position, int data_to_insert) {
		for(int index = (array_as_para.length - 2); index >= index_position; index=index-1) {
			
			System.out.println("element at index number is"+index+"i.e. "+ array_as_para[index]+"  shifted to the "+ (index+1));
			
			array_as_para[index+1] = array_as_para[index];
			if(index == index_position) {
				array_as_para[index_position] = data_to_insert;
			}
		}
		
		System.out.println("after shifting, the array looks alike");
		
		for(int index = 0; index< array_as_para.length; index++) {
			
			System.out.println("element at " + index + " is "+array_as_para[index]);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the size of the array ");
		int array_length = sc.nextInt();
		int []array =new int[array_length];
		
		System.out.println("enter "+ (array_length-1)+"  elements to insert in array");
		
		for(int index = 0; index < array.length-1; index++ ) {
			array[index] = sc.nextInt();
		}
		
		System.out.println("array elements before any operation");
		
		for(int index = 0; index<array.length; index++) {
			System.out.print(array[index]+"  ");
		}
		System.out.println();
		System.out.println("enter the index postion where you want to enter the data"
				+ "  index position must be less than "+ array.length);
		int index_pos_to_insert = sc.nextInt();
		
		System.out.println("enter the data that you want to insert at "+ index_pos_to_insert);
		int data_to_insert = sc.nextInt();
		
		InsertionOnIndex ioi = new InsertionOnIndex();
		ioi.insertAtIndexPosition(array, index_pos_to_insert, data_to_insert);
		
		

	}

}
