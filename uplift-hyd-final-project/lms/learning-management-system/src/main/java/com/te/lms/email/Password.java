package com.te.lms.email;

import java.util.Random;

public class Password {
	
	public String passwordGenerator() {
		String upperChar = "QWERTYUIOPASDFGHJKLZXCVBNM";
		 String lowerChar = "qwertyuiopasdfghjklzxcvbnm";
		 String numbers = "123456789";
		 String specialChar = "!@#$%&*";
		 String Combination = upperChar+lowerChar+specialChar+numbers;
		 int length = 8;
		 char[] password = new char[length];
		 Random random = new Random();
		 for(int i = 0;i < length;i++) {
			 password[i] = Combination.charAt(random.nextInt(Combination.length()));
		 }
		 return  ""+password;
	}
}
