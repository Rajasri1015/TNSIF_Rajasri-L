package com.tnsif.entityassignment;

public class ProductDemo {
	public static void main(String[] args) {
		Product p1=new Product();
		p1.setPid(101);
		p1.setPname("TV");
		p1.setQuantity(6);
		System.out.println(p1);
		Product p2=new Product();
		p2.setPid(101);
		p2.setPname("Fan");
		p2.setQuantity(7);
		System.out.println(p2);
		
	}

}
