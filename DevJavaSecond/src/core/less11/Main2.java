package core.less11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
	
	private static final Pattern P = Pattern.compile("[0-9]+");

	public static void main(String[] args) {
		String s = "";
		String s1 = "as";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			Matcher m = P.matcher(s1);
			if(m.matches()){
				s+=s1;
			}
		}
		System.out.println("Escape exception: "+(System.currentTimeMillis()-start)/1000);
		System.out.println(s);
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			try{
				int s3 = Integer.valueOf(s1);
				s+=s3;
			}catch(NumberFormatException e){
			}
		}
		System.out.println("With exception: "+(System.currentTimeMillis()-start)/1000);
		System.out.println(s);
	}

}
