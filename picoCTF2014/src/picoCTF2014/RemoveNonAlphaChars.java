package picoCTF2014;

public class RemoveNonAlphaChars {
	public static void main(String[] args) {
		String entireFlag = ""
				+ "'f', 'l', 'a', 'g', ' ', 'i', 's', ':', ' '"
				+ ", "
				+ "'w', "
            + "'h', 'a', 't', '_', 'd', 'o', 'e', 's', '_', 't', "
            + "'h', 'e',"
            + "'_', 'l', 'o', 'g', 'c', 'a', 't', '_', "
            + "'s', 'a', 'y'";
		
		String noApos = entireFlag.replaceAll("'", "");
		String noCom = noApos.replaceAll(",", "");
		String flag = noCom.substring(noCom.indexOf(":") + 1, noCom.length());
		String noSpace = flag.replaceAll(" ", "");
		
		System.out.println(noSpace);
	}
}