package com.github.ravisuthar.circulardependency;


public class B {
	
	private A a;
	
	
    public void setA(A a) {
        this.a = a;
    }


	public A getA() {
		return a;
	}


	@Override
	public String toString() {
		return "B";
	}
    
	
    
}

