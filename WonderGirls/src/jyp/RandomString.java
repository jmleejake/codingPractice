package jyp;

import java.util.Random;
import java.util.StringTokenizer;

public class RandomString {
	private static String getRandomString(int length){
		StringBuffer buf = new StringBuffer();
		Random random =  new Random();
		
		String[] str = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0,-".split(",");
		
		for (int i = 0; i < length; i++) {
			buf.append(str[random.nextInt(str.length)]);
		}
		
		return buf.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomString(7));
		
		String fileTest = "testFile.xml";
		StringTokenizer sto = new StringTokenizer(fileTest,".");
		
		for (;sto.hasMoreTokens();) {
			System.out.println(sto.nextToken());
			System.out.println(sto.nextToken());
		}
	}
}
