package com.guozz.designpattern.adapter.v12;

import com.guozz.designpattern.adapter.power.AbsBasePower;

public class Power12 extends AbsBasePower implements IPower12 {

	public Power12() {
		super(12);
	}

	@Override
	public void output12v() {
		System.out.println("����["+this.getPower()+this.getUnit()+"]�ĵ�Դ");
	}

}
