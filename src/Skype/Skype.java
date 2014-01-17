package Skype;

import java.util.*;

public class Skype {
	
	/*
	 * Given two lists, print the elements that are in one but not in the other
	 */

	public static void uniqueElementsBruteForce(int[] a, int[] b){
		
		for(int i = 0; i < a.length; i++){
			
			for(int j = 0; j < b.length; j++){
				
				if(a[i] == b[j]){
					break;
				}
				else{
					if(j == b.length - 1){
						System.out.print(a[i] + " ");
					}
				}

			}
		}
		
		for(int i = 0; i < b.length; i++){
			
			for(int j = 0; j < a.length; j++){
				
				if(b[i] == a[j]){
					break;
				}
				else{
					if(j == a.length - 1){
						System.out.print(b[i] + " ");
					}
				}

			}
		}
	}
	
	public static void uniqueElementsOptimized(int[] a, int[] b){
		
		HashMap<Integer, Boolean> myMap = new HashMap<Integer, Boolean>();
		HashMap<Integer, Boolean> myMap2 = new HashMap<Integer, Boolean>();
		
		for(int i = 0; i < b.length; i++){			
			myMap2.put(b[i], true);
		}
		
		for(int j = 0; j < a.length; j++){
			if(myMap2.get(a[j]) == null){
				System.out.print(a[j] + " ");
			}
		}
		
		for(int i = 0; i < a.length; i++){			
			myMap.put(a[i], true);
		}
		
		for(int j = 0; j < b.length; j++){
			if(myMap.get(b[j]) == null){
				System.out.print(b[j] + " ");
			}
		}
	}
	
	
	public static void main (String[] args){
		
		int[] a = {1, 2, 3, 4, 5, 6};
		int[] b = {2, 4, 6, 7};
		
		//uniqueElementsBruteForce(a, b);
		uniqueElementsOptimized(a, b);
		
		
	}
}
