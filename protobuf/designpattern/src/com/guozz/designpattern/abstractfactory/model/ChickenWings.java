package com.guozz.designpattern.abstractfactory.model;

public class ChickenWings extends AbstractBaseFood implements IFood {

	@Override
	public void printMessage() {
		System.out.println("--"+this.kind+"��ζ����,\t ����:" +this.price+",\t ����:  "+this.num+", \t �ϼ�:" + this.totalPrice());

	}

}
