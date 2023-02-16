package org.abhi.exercise.datastructure;

import java.util.*;

public class WorkWithLinkedList {
	
	Node head_of_Linked_List;
	
	class Node{
		int data_of_node;
		Node next;
		
		public Node(int data_for_node) {
			data_of_node = data_for_node;
			next = null;
		}
	}
	
	public void pushData(int data_to_push) {
		Node create_new_node  = new Node(data_to_push);
		create_new_node.next = head_of_Linked_List;
		head_of_Linked_List = create_new_node;
		System.out.println("data has pushed without any husstle");
	}
	
	public void printList() {
		Node traverse_list = head_of_Linked_List;
		while(traverse_list != null ) {
			System.out.println("data that are present in the list are "+traverse_list.data_of_node);
			traverse_list = traverse_list.next;
		}
	}
	
	public void pushAtTheEnd(int data_to_push) {
		Node new_node = new Node(data_to_push);
		
		if( head_of_Linked_List == null ) {
			//head_of_Linked_List = new Node(data_to_push);
			head_of_Linked_List = new_node;
		}
		new_node.next = null;
		Node last = head_of_Linked_List;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		
		
	}
	
	public static void main(String []args) {
		WorkWithLinkedList wwll = new WorkWithLinkedList();
	System.out.println("this program contains the insertion of a new node "
			+ " at the head of the linked list");

	System.out.println("enter the data that you want to add in the linked list");
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the number of nodes that you want to insert into linked list");
	int number_of_nodes = sc.nextInt();
	for(int add_nodes=0; add_nodes<number_of_nodes; add_nodes++) {
		wwll.pushData(sc.nextInt());	
	}
	
	wwll.printList();
	System.out.println("enter the value thayt you want to add in the end of the linked list");
	wwll.pushAtTheEnd(sc.nextInt());
	
	wwll.printList();
	}
	
	
	
	}
