package picoCTF2014;

import java.math.BigInteger;
import java.util.ArrayList;

public class Test {
	static final int GAME_SIZE = 40; //Disk sizes go from 0->39
	
	public static ArrayList<BigInteger> getPrimes(int n) {
		ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
		BigInteger currentNumber = BigInteger.ONE.add(BigInteger.ONE);		
		while (primes.size() < n) {
			if (currentNumber.isProbablePrime(1000000)) {
				primes.add(currentNumber);
			}
			currentNumber = currentNumber.add(BigInteger.ONE);
		}
		return primes;
	}

	public static BigInteger createSavedPoleInformation(ArrayList<BigInteger> disk) {
		ArrayList<BigInteger> primes = getPrimes(GAME_SIZE);
		BigInteger poleValue = BigInteger.ONE; // Start with one
		for (BigInteger i : disk) {
			// If a disk is size n, multiply by the nth prime number
			poleValue = poleValue.multiply(primes.get(i.intValue()));
		}	
		return poleValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BigInteger> swags = getPrimes(GAME_SIZE-1);
        /*BigInteger bi1, bi2, bi3, bi4;
        bi1 = new BigInteger("123");
        bi2 = new BigInteger("1000");
        bi3 = new BigInteger("2000");
        bi4 = bi1.max(bi2.max(bi3));
        
        String str = "Maximum Value among " + bi1 + ", " + bi2 + ", and "+ bi3+" is "+ bi4;
        System.out.println(str);*/
		System.out.println(createSavedPoleInformation(swags));
        }
}