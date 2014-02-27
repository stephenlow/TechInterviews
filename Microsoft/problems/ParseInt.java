package problems;

public class ParseInt {
	
	public static int parseInt(String stringToConvert)
    {
        int i =0,num=0;
        int isNeg = 1;
        int length = stringToConvert.length();

        if(stringToConvert.charAt(0) =='-')
        {
            isNeg=-1;
            i=1;
        }

        while(i<length)
        {
            num*=10;
            num+=(stringToConvert.charAt(i++) - '0'); // or 48 ASCII value for 0
        }

        return num*isNeg;
    }
	
	public static void main(String[] args){
		
		String s = "15";
		
		System.out.print(parseInt(s));
	}

}
