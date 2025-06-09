import java.util.Arrays;

public class DiverseArrays {
	public static int arraySum(int[] arr1) {
		int sum = 0;
		for(int i = 0; i < arr1.length; i++) {
			sum += arr1[i];
		}
		
		return sum;
	}
	
	public static int[] rowSums(int[][] arr2D) {
		int[] arr = new int[arr2D.length];
		for(int j = 0; j < arr2D.length; j++) {
			for(int k = 0; k < arr2D[0].length; k++) {
				arr[j] += arr2D[j][k];
			}
		}
		return arr;
	}
	
	public static boolean isDiverse(int[][] arr2D) {
		int[] arr1D = rowSums(arr2D);
		for(int m = 0; m < arr1D.length; m++) {
			for(int n = 1 + m; n < arr1D.length; n++) {
				if(arr1D[m] == arr1D[n]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] q1 = {1, 3, 2, 7, 3};
		int[][] q2 = {{1, 3, 2, 7, 3}, {10, 10, 4, 6, 2}, {5, 3, 5, 9, 6}, {7, 6, 4, 2, 1}};
		System.out.println(arraySum(q1));
		System.out.println(Arrays.toString(rowSums(q2)));
		System.out.println(isDiverse(q2));
	}
}