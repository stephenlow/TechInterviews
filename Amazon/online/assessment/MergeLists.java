package online.assessment;

public class MergeLists {
	
	public static Node mergeSortedListIteration(Node nodeA, Node nodeB) {
	    Node mergedNode ;
	    Node tempNode ;      

	    if (nodeA == null) {
	        return nodeB;
	      } 
	      if (nodeB == null) {
	        return nodeA;
	      }     


	    if ( nodeA.value < nodeB.value)
	    {
	        mergedNode = nodeA;
	        nodeA = nodeA.next;
	    }
	    else
	    {
	        mergedNode = nodeB;
	        nodeB = nodeB.next;
	    }

	    tempNode = mergedNode; 

	    while (nodeA != null && nodeB != null)
	    {           

	        if ( nodeA.value < nodeB.value)
	        {               
	            mergedNode.next = nodeA;
	            nodeA = nodeA.next;
	        }
	        else
	        {
	            mergedNode.next = nodeB;
	            nodeB = nodeB.next;                
	        }       
	        mergedNode = mergedNode.next;
	    }

	    if (nodeA == null)
	    {
	        while(nodeB != null){
	        	mergedNode.next = nodeB;
	        	nodeB = nodeB.next;
	        	mergedNode = mergedNode.next;
	        }
	    }

	    if (nodeB == null)
	    {
	        while(nodeA != null){
	        	mergedNode.next = nodeA;
	        	nodeA = nodeA.next;
	        	mergedNode = mergedNode.next;
	        }
	    }
	    
	    while(tempNode != null){
	    	System.out.println(tempNode.value);
	    	tempNode = tempNode.next;
	    }
	    
	    return tempNode;
	}
	
	public static void main(String[] args){
		//1->2->3->4
		//1->3->5->7
		//1->1->2->3->3->4->5->7
		
		Node list1Node1 = new Node(1);
		Node list1Node2 = new Node(2);
		list1Node1.next = list1Node2;
		Node list1Node3 = new Node(3);
		list1Node2.next = list1Node3;
		Node list1Node4 = new Node(4);
		list1Node3.next = list1Node4;
		list1Node4.next = null;
		
		
		Node list2Node1 = new Node(1);
		Node list2Node2 = new Node(3);
		list2Node1.next = list2Node2;
		Node list2Node3 = new Node(5);
		list2Node2.next = list2Node3;
		Node list2Node4 = new Node(7);
		list2Node3.next = list2Node4;
		list2Node4.next = null;
		
		mergeSortedListIteration(list1Node1, list2Node1);
		
	}


}
