package com.jzw.pojo;

import com.jzw.pojo.Pet_Dog.BodyFormType;

public class PeopleMul {

	public static void main(String[] args)
	{
		Pet_Dog dog = new Pet_Dog("dog",BodyFormType.SMALL);
		dog.live(dog);
		int i = 0;
		while(dog.getHealth() >= 0 && i <10)
		{
			new Thread
			(
				new Runnable()
				{
						
					@Override
					public void run()
					{						
						dog.feed(dog);	
					}
				},"people one"		
			).run();
			i++;//如果一直新建线程会不会太消耗资源
		}

		
	}

}
