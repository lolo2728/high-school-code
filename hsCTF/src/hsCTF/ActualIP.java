package hsCTF;

public class ActualIP {

	public static void main(String[] args) {
		String enc = "2004e3bcbcgbdcc`2004`27:2004`27:bcgbdcc`";
		char[] encr = new char[enc.length()];
		char[] l = enc.toCharArray();
		
		for(int i = 0; i < enc.length(); i++) {
			//(char) (99 ^ (99 >> 4)))
			System.out.print((char) (((int) l[i]) ^ (((int) l[i]) >>4)));
			//System.out.print(((int) l[i]));
		}
	}
}