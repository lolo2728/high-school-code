
public class HiddenWord {
	private String h_word;
	
	public HiddenWord(String w1) {
		h_word = w1;
	}
	
	public String getHint(String word) {
		String nWord = word;
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != h_word.charAt(i)) {
				if(h_word.replace(word.charAt(i) + "", "").length() == h_word.length()) {
					nWord.replace(word.charAt(i) + "", "*");
				} else {
					nWord.replace(word.charAt(i) + "", "+");
				}
			}
		}
		return nWord;
	}
}