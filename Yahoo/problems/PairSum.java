package problems;

/*
 * Given an array, print all the pairs that sum to a particular value. You are not
 * given the value, find all possible values and print pairs for them.
 */

import java.util.*;
import java.util.Map.Entry;

public class PairSum {
	
	public static void printAllPairSum(int[] arr){
		
		HashSet<Integer> values = new HashSet<Integer>();
		
		for(int i = 0; i < arr.length; i++){
			
			for(int j = i+1; j < arr.length; j++){
				
				int sum = arr[i] + arr[j];				
				values.add(sum);
				
			}
		}
		
		Hashtable<Integer, Integer> arrValues = new Hashtable<Integer,Integer>();
		
		for(int i = 0; i < arr.length; i++){
			arrValues.put(i, arr[i]);
		}
		
		for(Integer i : values){
			
			for(Map.Entry<Integer, Integer> entry : arrValues.entrySet()){ 
				
				int num1 = entry.getValue();
				int num2 = i - num1;
				int num1Key = entry.getKey();
				int num2Key = findKey(arrValues.entrySet(), num2);
				
				if(arrValues.containsValue(num2) && (num1Key != num2Key))
					System.out.println("Value: " + i + "  <" + num1 + "," + num2 + ">");
			}
		}
	}
	
	public static int findKey(Set<Entry<Integer, Integer>> entrySet, int num){
		
		for(Map.Entry<Integer, Integer> entry : entrySet){
			if(num == entry.getValue())
				return entry.getKey();
		}
		return -1;
	}
	public static void main(String[] args){
		
		int[] arr1 = {1, 2, 3 , 4 , 5, 4};
		
		printAllPairSum(arr1);
	}

}
