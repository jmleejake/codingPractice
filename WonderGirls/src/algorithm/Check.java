package algorithm;

public class Check {
	public static void main(String[] args) {
		String str = "aaaabbbccc";
		String[] strarr = str.split("");
		int cnta = 0;
		int cntb = 0;
		int cntc = 0;
		
		for(String s1 : strarr) {
			if("a".equals(s1)) {
				cnta++;
			}
			if("b".equals(s1)) {
				cntb++;
			}
			if("c".equals(s1)) {
				cntc++;
			}
		}
		System.out.println(String.format("a=%d b=%d c=%d", cnta, cntb, cntc));
	}
}
