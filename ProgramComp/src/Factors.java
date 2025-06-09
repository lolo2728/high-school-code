/* Find int factors of number */
public class Factors {
	public static int getFactor(int numFac) {
		int factorCount = 0;
		for(int i = 1; i < numFac; i++) {  
		    if(numFac % i == 0) {
		       factorCount++;
		    }
		}
		return factorCount;
	}
	
	public static int setFactorArray(int findfact) {
		int i = 1;
		int j = 0;
		int factors = getFactor(findfact);
		int[] sweg = new int[factors];
		
		while(i < findfact) {
			if(findfact % i == 0) {
				sweg[j] = i;
				j++;
				}
			i++;
			}
		return(sweg[sweg.length-1]); //get last num in array

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(setFactorArray(120));
		}
}