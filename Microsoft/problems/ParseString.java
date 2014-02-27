package problems;

public class ParseString {
	
	public static boolean parseString(String s, String pattern){
		
		for(int i = 0; i < s.length(); i++){
			
			if(s.charAt(i) == pattern.charAt(0)){
				
				int j = 1;
				int k = i+1;
				int count = 1;
				
				while(j < pattern.length() && k < s.length()){
					
					if(s.charAt(k) != pattern.charAt(j))
						break;
					
					k++;
					j++;
					count++;
					
					if(count == pattern.length())
						return true;					
				}
				
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args){
		
		String s = "Steabcve";
		String pattern = "abc";
		
		System.out.print(parseString(s, pattern));
	}

}
