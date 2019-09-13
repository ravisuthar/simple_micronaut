package com.github.ravisuthar.circulardependency;

import io.micronaut.context.annotation.Bean;

import javax.inject.Singleton;

@io.micronaut.context.annotation.Factory
public class Factory {


	@Bean
	@Singleton
	public B getB(){
	 return new B();
	}
	
	@Bean
	@Singleton
	public A getA(){
		B b=getB();
		A a= new A(b);
		//b.setA(a); circular dependency
		return a;
	}
}
