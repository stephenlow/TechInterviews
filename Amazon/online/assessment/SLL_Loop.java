package online.assessment;

/*
 *  A singly liked list. Can have a loop. Detect it and find the size of list.
*/ 

public class SLL_Loop {

	
	public static boolean hasLoop(Node first){
		
		if(first == null) //List doesnt exist
			return false;
		
		Node slow, fast;
		
		slow = fast = first;
		
		while(true){
			slow = slow.next;
			try{
				if(fast != null)
					fast = fast.next.next;
				else
					return false;
				
				if(fast == null || slow == null)
					return false;
				
				if(slow == fast)
					return true;
			}
			catch(Exception e){
				return false;
			}
		}
	}
	
	public static void main(String[] ars){
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.next = node2;
		Node node3 = new Node(3);
		node2.next = node3;
		Node node4 = new Node(4);
		node3.next = node4;
		Node node5 = new Node(5);
		node4.next = node5;
		node5.next = node3;
		
		System.out.print(hasLoop(node1));
		 
		
	}

}

class Node{
	int value;
	Node next;
	
	public Node(int val){
		this.value = val;
	}
}

