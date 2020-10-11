package com.jzw.pojo;

import com.jzw.pojo.Pet_Dog.BodyFormType;

public class PeopleSin {		
	public static void main(String[] args) {		
		Pet_Dog AAA = new Pet_Dog("A",BodyFormType.SMALL);		
		AAA.live(AAA);
		AAA.feed(AAA);		
		
	}

}
