package com.tnsif.Dayfive.interfacedemo;


public class FunctionDemo {

	public static void main(String[] args) {
	
		//Lambda Expression
		GreetingDemo gd = () -> 
		System.out.println("Hello Everyone, Welcome to the Java Session");
		
		gd.greet();
		
		

	}

}