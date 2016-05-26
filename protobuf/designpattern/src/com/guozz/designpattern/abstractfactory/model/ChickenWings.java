package com.guozz.designpattern.abstractfactory.model;

public class ChickenWings extends AbstractBaseFood implements IFood {

	@Override
	public void printMessage() {
		System.out.println("--"+this.kind+"风味鸡翅,\t 单价:" +this.price+",\t 数量:  "+this.num+", \t 合计:" + this.totalPrice());

	}

}
