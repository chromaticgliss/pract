class CgStringPract {

	public static boolean hasUniqueChars(String str) {
		for( i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}

		return true;
	}

	public static boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;

		String sorted1 = new String(java.util.Arrays.sort(str1.toCharArray()));
		String sorted2 = new String(java.util.Arrays.sort(str2.toCharArray()));
		
		return sorted1.equals(sorted2);
	}

	public static String spaceReplace(char[] string, length) {
		int numSpace = 0;
		for (int i = 0; i < length; i++) {
			if (c == ' ') numSpace++;
		}

		int newLength = length + (numSpace * 2);
		string[newLength] = '\0';


		
		for (int j = length - 1; j >= 0; j--) {
			if( string[j] == ' ') {
				string[newLength - 3] = '%';
				string[newLength - 2] = '2';
				string[newLength - 1] = '0';
				newLength -= 3;
			} else {
				string[newLength - 1] = string[j];
				newLength--;
			}					
		}
				

		return new String(string);

	}

	public static String compressString(String str) {
		StringBuffer buf = new StringBuffer();	
		char current = str.charAt(0);
		char count = 0;

		for(int i = 0; i < str.length; i++) {			
			if (current == str.charAt(i)) {
				count += 1;
			} else {
				buf.append(current);
				buf.append(count);
				current = str.charAt(i);
				count = 1;
			}	
		}
		
		buf.append(current);
		buf.append(count);
		String newStr = buf.toString();
		if (newStr.length() >= str.length()) {
			return str;
		}
		
		return newStr;
	}

	public static int[][] rotateImage(int[][] image, int n){

		int temp;

		for(int offset = 0; offset < n/2; offset++) {
			for(int i = offset; i < n - offset; i++) {
				temp = image[offset][i];
				image[offset][i] = image[n-1-i][offset];
				image[n-1-i][offset] = image[n-offset][n-1-i];
				image[n-1-offset][n-1-i] = image[i][n-1-offset];
				image[i][n-1-offset] = temp;
			}
		}	
				
		return image;	
	}

	public static char[][] flipXsToOs(char [][] board, int m, int n) {
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];	
		java.util.Arrays.fill(rows,false);
		java.util.Arrays.fill(cols,false);
	
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if( board[i][j] == "O" ) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || cols[j]) {
					board[i][j] = 'O';
				}	
			}
		}
		
		return board;
	}


	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if(len = s2.length() && len > 0) {
			String check = s1 + s1;
			return s2.indexOf(check) != -1;
		}
	}

	public static void main(String args[]) {

	}

}
