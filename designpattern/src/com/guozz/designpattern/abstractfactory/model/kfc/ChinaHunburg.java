package com.guozz.designpattern.abstractfactory.model.kfc;

import com.guozz.designpattern.abstractfactory.model.Humburg;

public class ChinaHunburg extends Humburg {

	
	public ChinaHunburg(int num){
		this.kind="����";
		this.num=num;
		this.price=14.0f;
	}
}
