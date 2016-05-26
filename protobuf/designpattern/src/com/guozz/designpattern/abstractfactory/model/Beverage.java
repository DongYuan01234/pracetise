package com.guozz.designpattern.abstractfactory.model;

public class Beverage extends AbstractBaseFood implements IFood {

	@Override
	public void printMessage() {
		System.out.println("--"+this.kind+"����,\t ����:" +this.price+",\t ����:  "+this.num+", \t �ϼ�:" + this.totalPrice());

	}

}
