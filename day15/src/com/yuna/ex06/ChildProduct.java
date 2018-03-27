package com.yuna.ex06;

public class ChildProduct<T, M, C> extends Procuct<T, M>{
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
}
