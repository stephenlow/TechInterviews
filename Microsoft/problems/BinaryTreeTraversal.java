package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Depth First Search Algorithm & Bredth First Search algorithm.
 */

public class BinaryTreeTraversal {
	
	public static int dfsFindNode(Node root, int val){
		
		if(root == null)
			return -1;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node curr = stack.pop();
			
			if(curr.value == val)
				return val;
			
			if(curr.left == null && curr.right == null)
				return -1;
			
			if(curr.left != null){
				int x = dfsFindNode(curr.left, val);
				if(x == val)
					return val;
				
			}
			
			if(curr.right != null){
				int y = dfsFindNode(curr.right, val);
				if(y == val)
					return val;
				
			}	
			
		}
		
		return -1; //value never found
	}
	
	public static int bfsNodeSearch(Node root, int val){
		
		if(root == null)
			return -1;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			
			Node curr = q.poll();
			
			if(curr.value == val)
				return curr.value;
			
			if(root.left != null)
				q.add(curr.left);
			if(root.right != null)
				q.add(curr.right);
			
		}
		
		
		return -1;
	}
	
	public static void main(String[] args){
		
		/*
		 * 				10
		 * 			   /   \
		 * 			8	     12
		 *		  /   \     /   \ 
		 *      3      9   11     15
		 */
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(12);
		
		root.left.left = new Node(3);
		root.left.right = new Node(9);
		
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		
		System.out.println(dfsFindNode(root, 12));
		System.out.println(bfsNodeSearch(root, 15));
	}

}

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int value){
		this.value = value;
	}
	
	public String toString(){
		return this.value + "";
	}
	
}
