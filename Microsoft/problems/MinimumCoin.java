package problems;

public class MinimumCoin {
	
	public static void main(String args[]){
		int[] valueCoins = new int[]{1,3,5};
		int sum = 11;
		int[] minimum = new int[sum+1];
		int[][] coins = new int[sum+1][2];

		/* initializing the minimum of every sum to infinity */
		for(int i = 1; i < minimum.length; i++){
			minimum[i] = sum + 10000;
		}
		/* initializing that for minumum sum of zero, 0 coin is required */
		minimum[0] = 0;

		for(int i = 1; i <= sum; i++){
			for(int j = 0; j <valueCoins.length; j++){
				if(valueCoins[j] == i){
					minimum[i] = 1;
					coins[i][0] = i;
					coins[i][1] = 0;
				}
				else if((valueCoins[j] < i) && (((minimum[i-valueCoins[j]]) + 1) < minimum[i])){

					minimum[i] = (minimum[i-valueCoins[j]]) + 1;
					coins[i][0] = valueCoins[j];
					coins[i][1] = (i-valueCoins[j]);
				}
			}
		}

		for(int k = 1; k < minimum.length; k++){
			System.out.println( k + " " + minimum[k] + " " + coins[k][0] +"("+ coins[k][1] + ")");
		}

	}
}