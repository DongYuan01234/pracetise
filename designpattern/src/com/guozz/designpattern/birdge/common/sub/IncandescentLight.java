package com.guozz.designpattern.birdge.common.sub;

import com.guozz.designpattern.birdge.common.AbstractSwitch;

public class IncandescentLight extends AbstractSwitch {

	@Override
	public void turnOn() {
		System.out.println("�׳�ƿ���");
	}

	@Override
	public void light() {
		System.out.println("�׳������");
	}

	@Override
	public void turnOff() {
		System.out.println("�׳�ƹ���");
	}

}
