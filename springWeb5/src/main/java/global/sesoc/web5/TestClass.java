package global.sesoc.web5;

import java.util.UUID;

public class TestClass {

	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			String id = "M" + String.format("%019d", i); 
			System.out.println(id);
			System.out.println(id.length());
		}
		String uu = UUID.randomUUID().toString();
		System.out.println(uu);
		System.out.println(uu.length());
	}

}
