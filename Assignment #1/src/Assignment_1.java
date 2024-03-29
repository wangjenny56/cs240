
public class Assignment_1 {

	public static String decToTwoBin (int value) {
		
		int decimalValue = Math.abs(value);
		int decimal = Math.abs(value);
		String TwoBin = "";
		String msBit = "";
		String zeros = "";
		
		while (decimalValue != 0) {
			decimalValue = decimalValue / 2;
			String bit = String.valueOf(decimal % 2);
			TwoBin = bit + TwoBin;
			decimal = decimalValue;
		}
		
		if(TwoBin.length() != 8) {
			int zeroCount = 7 - TwoBin.length();
			for (int i = 0; i < zeroCount; i++) {
				zeros = zeros + "0";
			}
		}
		
		if ((zeros + TwoBin).length() > 7) {
			//System.out.println(zeros);
			//System.out.println(TwoBin);
			return "Cannot be expressed with 8 binary digits";
		}
		
		if(value < 0){
			//System.out.println("negative");
			
			String TrueMag = zeros + TwoBin;
			return '1' + (flipAdd(TrueMag));
		}
		
		if(value >= 0) {
			msBit = "0";
			return msBit + zeros + TwoBin;
		}
		

		return msBit + zeros + TwoBin;
		
	}
	
	public static int bintoDec (String value) {
		int decimal = 0;
		char[] ch = value.toCharArray();
		//System.out.println("value is " + ch[0]);
		
		if (ch[0] == '1') {
			decimal = -1 * dec(flipAdd(value));
		}else {
			decimal = dec(value);
		}

		/*for (int i = value.length()-1; i > 0; i--) {
			//System.out.println(ch[i] + " this is i " + ((value.length()-1) - i));

			if (ch[i] == '1') {
				decimal = (int) (decimal + Math.pow(2, ((value.length()-1) - i)));
				//System.out.println("this is i " + i);
			}
		}*/
		return decimal;
	
	}
	
	
	public static int dec (String value) {
		int decimal = 0;
		char[] ch = value.toCharArray();
		for (int i = value.length()-1; i > 0; i--) {
			//System.out.println(ch[i] + " this is i " + ((value.length()-1) - i));

			if (ch[i] == '1') {
				decimal = (int) (decimal + Math.pow(2, ((value.length()-1) - i)));
				//System.out.println("this is i " + i);
			}
		}
		return decimal;
	}
	
	public static String flipAdd (String value) {
		char[] ch = value.toCharArray();
		String newValue = "";
		boolean carryBit = false;
	
		for (int i = 0; i < value.length(); i++) {
			if (ch[i] == '0') {
				ch[i] = '1';
			}else {
				ch[i] = '0';
			}
		}
		
		if(ch[value.length() - 1] == '1') {
			carryBit = true;
			newValue = '0' + newValue; 
			//System.out.println(carryBit);
		}else {
			newValue = '1' + newValue;
		}
		
		for (int i = value.length() - 2; i >= 0; i--) {
			//System.out.println(ch[i]);
			if(carryBit == true && ch[i] == '1') {
				carryBit = true;
				newValue = '0' + newValue; 
			}else if(carryBit == true && ch[i] == '0'){
				newValue = '1' + newValue; 
				carryBit = false;
			}else {
				newValue = ch[i] + newValue;
			}
		}
		
		return new String(newValue);
	}
	
	public static void main(String[] args) {
		
		System.out.println("this is decimal to Two's complement");
		System.out.println(decToTwoBin (-128));
		System.out.println(decToTwoBin (127));
		System.out.println(decToTwoBin (500));
		System.out.println(decToTwoBin (-130));
		System.out.println(decToTwoBin (49));
		System.out.println(decToTwoBin (119));
		System.out.println(decToTwoBin (-119));
		System.out.println(decToTwoBin (0));
		System.out.println(decToTwoBin (-1));
		
		System.out.println("this is binary to decimal");
		System.out.println(bintoDec("11001101"));
		System.out.println(bintoDec("11111111"));
		System.out.println(bintoDec("00000000"));
		System.out.println(bintoDec("01100110"));
		System.out.println(bintoDec("11100110"));
		System.out.println(bintoDec("10100110"));
		
		
		
		
		
	}

}
