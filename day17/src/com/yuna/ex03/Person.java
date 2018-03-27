package com.yuna.ex03;

public class Person implements Comparable<Person>{
	public String name;
	public int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		return o.age-age;
		
//		return (age-o.age)*-1;
		
/*		if(age<o.age)
			return 1;
		else if(age==o.age)
			return 0;
		else
			return -1;
*/
		
/*		if(age<o.age)
			return -1;
		else if(age==o.age)
			return 0;
		else
			return 1;
*/	
		
	}
}
/*package com.yuna.ex03;

public class Person implements Comparable<Person>{
	public String name;
	public int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		return o.age-age;
		
//		return (age-o.age)*-1;
		
				if(age<o.age)
			return 1;
		else if(age==o.age)
			return 0;
		else
			return -1;
		 
		
				if(age<o.age)
			return -1;
		else if(age==o.age)
			return 0;
		else
			return 1;
		 	
		
	}
}
*/