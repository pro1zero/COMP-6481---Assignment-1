package part1;

public class question2 {

	public static void main(String[] args) {
		System.out.println(chars("gggN@@@@@KKeeeejjdsmmu"));
	}
	
	//Time: O(N), N is the total number of chars in the string. As we traverse the String only once.
	//Space: O(1)
	public static String chars(String s) {
		String result = "";
		if(s.isEmpty()) return result;
		int currentCount = 1;
		char previousChar = s.charAt(0);
		char currentChar = s.charAt(0);
		for(int i = 1; i < s.length(); i++) {
			currentChar = s.charAt(i);
			if(currentChar == previousChar) currentCount += 1;
			else {
				result += previousChar;
				if(currentCount > 1) result += Integer.toString(currentCount);
				currentCount = 1;
			}
			previousChar = currentChar;
		}
		return (currentCount > 1) ? result + currentChar + Integer.toString(currentCount) : result + currentChar;
	}
}
