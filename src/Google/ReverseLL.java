package Google;

public class ReverseLL {

	public static void reverseLL(Node head){
		if(head == null || head.next == null)
			return;
		
		 Node prev = head;
		 Node curr = prev.next;
		 Node next = curr.next;
		 
		 head.next = null;
		 
		 if (next == null){
			 curr.next = prev;
			 return;
		 }
		 
		 while(next.next != null){
			 curr.next = prev;
			 prev = curr;
			 curr = next;
			 next = next.next;
		 }
		 curr.next = prev;
		 next.next = curr;
	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.next = n2;
		//n2.next = null;
		n2.next = n3;
		//n3.next = null;
		n3.next = n4;
		n4.next = null;
		
		reverseLL(n1);
		
		if(n1.next == null)
			System.out.println("null");
		//System.out.println(n1.next.value);
		System.out.println(n2.next.value);
		System.out.println(n3.next.value);
		System.out.println(n4.next.value);
	}
}

class Node{
	int value;
	Node next;
	
	public Node(int value){
		this.value = value;
	}
}
