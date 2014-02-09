package online.assessment;

import java.util.PriorityQueue;
import java.util.TreeMap;


/*
 * Given set of n points (Xi, Yi), 
 * write a function to find k nearest points from origin.
 */

public class ClosestPointsToOrigin {
	
	//TreeMap<Key, Value> - emulates red black tree which is essentially a binary
	//search tree with one extra bit of storage (the colour - red or black)
	//Self-Balancing Binary Search Tree
	public static Point[] closestk(Point[] myList, int k){
		
		TreeMap<Double, Point> redBlackTree = new TreeMap<Double, Point>();
		Point[] closestPoints = new Point[k];
		int count = 0;
		
		for(int i = 0; i < myList.length; i++){
			double distance = findOriginDistance(myList[i]);
			redBlackTree.put(distance, myList[i]);
		}
		
		for(double key : redBlackTree.keySet()){
			
			if(count < k){
				closestPoints[count] = redBlackTree.get(key);
			}
			
			count++;
		}
		
		return closestPoints;
		
	}
	
	//Priority Queue<E> - emulates Min Heap
	public static Double[] closestkVer2(Point[] myList, int k){
		
		PriorityQueue<Double> heap = new PriorityQueue<Double>();
		Double[] closestPoints = new Double[k];
		int count = 0;
		
		for(int i = 0; i < myList.length; i++){
			double distance = findOriginDistance(myList[i]);
			heap.add(distance);
		}
		
		for(double key : heap){
			if(count < k){
				closestPoints[count] = key;
			}
			count++;
		}
		
		return closestPoints;
		
		
		
	}
	
	public static double findOriginDistance(Point point){
		return Math.sqrt(Math.pow(point.x - 0.0, 2) + Math.pow(point.y - 0.0, 2));
	}
	
	public static void main(String[] args){
		Point[] myList = new Point[5];
		Point one = new Point(2, 3);
		Point two = new Point(1, 1);
		Point three = new Point(5, 10);
		Point four = new Point(3, 3);
		Point five = new Point(6, 8);
		
		myList[0] = one;
		myList[1] = two;
		myList[2] = three;
		myList[3] = four;
		myList[4] = five;
		
		Point[] closest = new Point[3];
		Double[] closest2 = new Double[3];
		closest = closestk(myList, 3);
		closest2 = closestkVer2(myList, 3);
		
		for(int i = 0; i < 3; i++){
			System.out.println("(" + closest[i].x + " " + closest[i].y + ")");
			System.out.println(closest2[i]);
		}
	}
	
	

}

class Point{
	
	double x;
	double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
}
