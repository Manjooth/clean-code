package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		if(str.length() <= 1){
			return str;
		}

		int length = str.length();
		char lastChar = str.charAt(length - 1);
		char secondLastChar = str.charAt(length - 2);

		String restOfString = str.substring(0, length - 2);

		return restOfString + lastChar + secondLastChar;
	}

	public String truncateAInFirst2Positions(String str) {
		if(str.length() < 2){
			return str.replaceAll("A", "");
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			if(str.charAt(i) != 'A'){
				stringBuilder.append(str.charAt(i));
			}
		}
		stringBuilder.append(str.substring(2));

		return stringBuilder.toString();
	}
}
