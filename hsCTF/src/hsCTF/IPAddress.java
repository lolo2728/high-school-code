package hsCTF;

public class IPAddress {
	public static void main(String[] args) {
		String hexx = "abfefa1212cfafde65bcdfae";
		int len = hexx.length();
		char[] ip = hexx.toCharArray();
		char[] encrypted = new char[len];
		for(int i = 0; i < len; i++) {
		  if(!((48 <= ip[i] && ip[i] <= 57) || (97 <= ip[i] && ip[i] <= 102))) {
		     System.out.println("Not a valid IPv42 address.\n");
		    }
		  }
		 
		 for(int j = 0; j < len; j++) {
			   char d = ip[j];
			   int c = d ^ (d >> 4);
			   encrypted[j] = (char)(c);
		 }
	}
}

/*
 * 
 * 			   char d = ip[j];
			   int c = d ^ (d >> 4);
			   encrypted[j] = (char)(c);
			   
			   char to int a
			   a = d ^ (d >> 4);
			   
			   
			   
*/