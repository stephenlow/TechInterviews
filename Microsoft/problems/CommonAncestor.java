package problems;

import java.util.Hashtable;

public class CommonAncestor {
	
	public static Node findCommonAncestor(Node root, Node a, Node b){
		
		if(root == null)
			return null;
		
		if(a == root || b == root)
			return root;
		
		Node left = findCommonAncestor(root.left, a, b);
		Node right = findCommonAncestor(root.right, a, b);
		
		//Exist on different branches
		if(left != null && right != null)
			return root;
		
		//a and b are on the same branch
		else if(left != null)
			return left;
		
		else
			return right;	
		
	}
	
	public static Node findCommonAncestorDFS(Node root, Node a, Node b){
		
		if(root == null)
			return null;
		
		if(a == root || b == root)
			return root;
		
		Hashtable<Node, Node> parent = new Hashtable<Node, Node>();
		Hashtable<Node, Integer> level = new Hashtable<Node, Integer>();
		
		level.put(root, 1);
		
		DFS(root, parent, level);
		int level_a = level.get(a);
		int level_b = level.get(b);
		
		while(level_a < level_b){
			b = parent.get(b);
			level_b--;
		}
		
		while(level_a > level_b){
			a = parent.get(a);
			level_a--;
		}
		
		//Same level but different branches
		while(a != b){
			a = parent.get(a);
			b = parent.get(b);
		}
		
		return a;		
		
	}
	
	public static void DFS(Node root, Hashtable<Node, Node> parent, Hashtable<Node, Integer> level){
		
		if(root.left != null){
			parent.put(root.left, root);
			level.put(root.left, level.get(root) + 1);
			DFS(root.left, parent, level);
		}
		
		if(root.right != null){
			parent.put(root.right, root);
			level.put(root.right, level.get(root) + 1);
			DFS(root.right, parent, level);
		}		
		
	}
	
	public static void main(String[] args){
		
		Node root = new Node(3);
		
		root.left = new Node(5);
		root.right = new Node(1);
		
		root.left.left = new Node(6);
		root.left.right = new Node (2);
		
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(4);
		
		root.right.left = new Node(0);
		root.right.right = new Node(8);
		
		int commonAncestor = findCommonAncestorDFS(root, root.left, root.left.right.right).value;
		
		System.out.print(commonAncestor);
		
	}

}
