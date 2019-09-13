package com.github.ravisuthar.circulardependency;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;

import javax.inject.Inject;

@Controller("/circular")
@Validated
public class CircularDependencyCotroller {

	@Inject
	private A a;

	@Inject
	private B b;

	@Get(value = "/a")
	public A a() {
		return this.a;
	}

	@Get(value = "/b")
	public B b() {
		this.b.setA(this.a);
		return this.b;
	}
}
