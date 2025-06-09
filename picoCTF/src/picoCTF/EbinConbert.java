package picoCTF;

import java.math.BigInteger;

public class EbinConbert {
	public static String toHex(String yeah) {
	    return String.format("%040x", new BigInteger(1, yeah.getBytes()));
	}
	
	public static double toDouble(String swig) {
		double sweg = Double.parseDouble(swig);
		return sweg;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String swag = "123";
		double swagdub = toDouble(swag);
		double ayy = Math.pow(swagdub, 16);
		String see = "" + ayy % 16;
		
		System.out.println(toHex(swag));
		
	    //self.request.send(hex(pow(int(m.encode("hex"), 16),3,n)))
		//hex((pow(x,y)) % z)
	}
}