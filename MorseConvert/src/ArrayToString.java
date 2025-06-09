public class ArrayToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"AYY", "LMAO"};
		StringBuffer swegToSweg = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			swegToSweg.append( a[i] );
		   //result.append( optional separator );
		}
		String mySwegString = swegToSweg.toString();
		System.out.println(mySwegString);
	}
}