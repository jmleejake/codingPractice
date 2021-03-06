package jyp;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class uuidTest {
	public static void main(String[] args) {
		System.out.println("\t\t"+UUID.randomUUID().toString()); 
		
//		String strText = "aaa한글 테스트aaa";
//
//		if(strText.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
//
//			System.out.println("한글포함");
//
//		}
		
		Pattern pattern = Pattern.compile("[1|2|?].*"); //1,2,? 로 시작하는 모든 문자열
		
		Pattern p1 = Pattern.compile("11");
		Pattern p2 = Pattern.compile("22");
		
		
		String inputs[] = {"?", "22", "12", "1?2", "??1", "1??1", "1???1", "1???2"};
		
		for(int i=0; i<inputs.length; i++){
			Matcher matcher = pattern.matcher(inputs[i]);
			
			Matcher m1 = p1.matcher(inputs[i]);
			Matcher m2 = p2.matcher(inputs[i]);
			
			if(m1.matches() || m2.matches()){
				System.out.println(inputs[i]+": "+"wrong word");
			} else {
				System.out.println(inputs[i]+": "+"right word");
			}
			
			//System.out.println(inputs[i]+": "+matcher.matches());
		}
	}
}
