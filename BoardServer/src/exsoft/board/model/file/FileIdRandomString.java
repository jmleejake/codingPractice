package exsoft.board.model.file;

import java.util.Random;

public class FileIdRandomString {
	public String getRandomString(int length){
		StringBuffer buf = new StringBuffer();
		Random random =  new Random();
		
		String[] str = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0,-".split(",");
		
		for (int i = 0; i < length; i++) {
			buf.append(str[random.nextInt(str.length)]);
		}
		
		return buf.toString();
	}
}
