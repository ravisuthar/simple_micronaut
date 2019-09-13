package com.github.ravisuthar.circulardependency;


public class A {
	
	private B b;
	

	public A(B b){
		this.b=b;
	}


	public B getB() {
		return b;
	}


	public void setB(B b) {
		this.b = b;
	}


	@Override
	public String toString() {
		return "A";
	}
	
	
}
