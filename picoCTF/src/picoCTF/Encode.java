/* 0x4859303659ce161a33bbeeb7a5d4b6144f21d887269be23ca63bc9b56695f1ec360e60dc935210feae4b3c01fe584640e147375845ab3af6843cbad4bce65
 * 7b201e0eb43134ead2e23efcd5c285ae09ae226d1810f682a2254c563e9e6f4aea3708ac39898d509de738757b8a4337da88df0f3ef2710f52323fa3b5b1d1aa817L
 * 
 * Its length is 66. Encryption length is 259
 */

package picoCTF;

import java.math.BigInteger;
import java.lang.Double;

public class Encode {
	public static String toHex(String arg) {
	    return String.format("%040x", new BigInteger(1, arg.getBytes()));
	}
	
	public static double toDouble(String swag) {
		double sweg = Double.parseDouble(swag);
		return sweg;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long swag = Long.parseLong("0x4859303659ce161a33bbeeb7a5d4b6144f21d887269be23ca63bc9b56695f1ec360e60dc935210feae4b3c01fe584640e147375845ab3af6843cbad4bce657b201e0eb43134ead2e23efcd5c285ae09ae226d1810f682a2254c563e9e6f4aea3708ac39898d509de738757b8a4337da88df0f3ef2710f52323fa3b5b1d1aa817L", 16);
		//System.out.println(toHexString(Math.pow(toDouble(toHex("Swag")), 16)));
		System.out.println(swag);
	}
}