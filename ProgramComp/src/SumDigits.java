public class SumDigits {
	public static int sumDigits(int digits) {
		int sum = 0;
		while (digits > 0) {
			sum += digits % 10;
			digits /= 10;
			}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sumDigits(16));
		}
	}