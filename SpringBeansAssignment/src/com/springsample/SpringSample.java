package com.springsample;

public class SpringSample {
	
    String name;
    String age;
    String company;
    
    public void printHello() {  
        System.out.println("Hello World in Spring sample from "+name+"\n age = "+age +"\n company = "+ company);  
    }  
  
    public String getName() {
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
    
}
