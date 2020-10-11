package com.jzw.pojo;

import java.util.Random;
import java.util.Scanner;

public class Pet_Dog 
{
	//定义常量
	public static int MAX_NAME_LEN = 16;
	public static int L_COMSUMPTION = 10; 
	public static int M_COMSUMPTION = 7;
	public static int S_COMSUMPTION = 4;
	
	public int L_VOLUME = 160;
	public int M_VOLUME = 160;
	public int S_VOLUME = 160;
	
	public enum BodyFormType{SMALL,MEDIUM,LARGE}
	
	//名字
	private String name ;
	//体型
	private BodyFormType bodyFormType;
	//消耗单位量
	private int consumption;
	//饱和度
	private int health;
	//食物剩余
	private int foodRemain;
	//食物容量
	private int foodVolume;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	@Override
	public String toString() {
		return "Pet_Dog [L_VOLUME=" + L_VOLUME + ", M_VOLUME=" + M_VOLUME + ", S_VOLUME=" + S_VOLUME + ", name=" + name
				+ ", bodyFormType=" + bodyFormType + ", consumption=" + consumption + ", health=" + health
				+ ", foodRemain=" + foodRemain + ", foodVolume=" + foodVolume + "]";
	}
	//默认构造方法
	public Pet_Dog()
	{
		this.bodyFormType=BodyFormType.SMALL;
		this.setName("UNNAMED");
		this.consumption = S_COMSUMPTION;
		this.health = (int) (80 + Math.random() % 20);
		this.foodRemain = 0;
		this.foodVolume = 100;			
	}
	//特定构造方法
	public Pet_Dog(String name ,BodyFormType bodyForm)
	{
		super();
		this.bodyFormType = bodyForm;
		this.name = name;
		int comsption = 0;
		int fvolume = 0;
		
		switch(bodyForm)
		{
			case SMALL:
				comsption = S_COMSUMPTION;
				fvolume = S_VOLUME;
				break;
			case MEDIUM:
				comsption = M_COMSUMPTION;
				fvolume = M_VOLUME;
				break;
			case LARGE:
				comsption = L_COMSUMPTION;
				fvolume = L_VOLUME;
				break;
		
		}
		this.consumption=comsption;
		this.health = (int) (80 + Math.random() % 20);
		
		this.foodRemain = 0;
		this.foodVolume = fvolume;
		
		return;
		
		
	}
	//显示
	public void show(Pet_Dog dog)
	{
		System.out.println(dog.toString());
	}
	//喂食方法
	public void feed(Pet_Dog dog)
	{
		int food = 0;
		System.out.println(dog.name + " : please input a number"); 
		Scanner in=new Scanner(System.in);
		food += in.nextInt();
		if(food > 0)
		{
			dog.foodRemain += food;
			if(dog.foodRemain > dog.foodVolume)
			{
				dog.foodRemain = dog.foodVolume;
			}			
		}
		else
		{
			System.out.println( dog.name + ": let's eat shit");
		}
		
	}
	//狗吃
	public void eat(Pet_Dog dog)
	{
		if(dog.health == 100)
		{
			System.out.println(dog.name + " : I am full");
		}
		else
		{
			int foodshouldeat = 100 - dog.health;
			//三目运算
			foodshouldeat = (foodshouldeat <= dog.foodRemain ? foodshouldeat : dog.foodRemain);
			//效果等同于下面的代码
//			if(foodshouldeat <= dog.foodRemain)
//			{
//				
//			}
//			else
//			{
//				foodshouldeat = dog.foodRemain;
//			}
			if(foodshouldeat != 0)
			{
				dog.health += foodshouldeat;
				dog.foodRemain -=foodshouldeat;
				System.out.println(dog.name + " : eat eat eat");
			}
			else
			{
				System.out.println(dog.name + " : let's eat shit");
			}
			//while语句实现？
			
		}
	}
	
	//Live 方法
	public int live(Pet_Dog dog)
	{
		int day = 0;
		while(dog.health > 0)
		{
			System.out.println("today is " + day );
			show(dog);
			System.out.println(dog.name + " i am hungry");
			feed(dog);
			System.out.println("\n");
			eat(dog);
			play(dog);
			dog.health -= dog.consumption;
			if(dog.health < 0)
			{
				dog.health = 0;
			}
			day++;
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		System.out.println(dog.name + " death");
		return 0;
	}
	
	private static void play(Pet_Dog dog) {
		if(dog.health >= 60)
		{
			System.out.println(dog.name + " : play");
		}
		else
		{
			System.out.println(dog.name + " : says no");
		}
	}
	public static void main(String[] args) {
		Pet_Dog AAA = new Pet_Dog("A",BodyFormType.SMALL);		
		AAA.live(AAA);
			
		System.out.println(AAA.name);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
