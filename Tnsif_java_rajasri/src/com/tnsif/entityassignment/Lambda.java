package com.tnsif.entityassignment;

public class Lambda {
	public interface Find_Factorial4{
		int factorial(int num);
	}
	public static void main(String[] args) {
		Find_Factorial4 fact=(num) ->
		{
			int i, f=1;
			for(i=1; i<=num; i++) {
				f=f*i;
			}
			return f;
		};
		System.out.println("Factorial is: " +fact.factorial(5));
	}

}
