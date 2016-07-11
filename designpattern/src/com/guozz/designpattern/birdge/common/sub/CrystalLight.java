package com.guozz.designpattern.birdge.common.sub;

import com.guozz.designpattern.birdge.common.AbstractSwitch;

public class CrystalLight extends AbstractSwitch {

	@Override
	public void turnOn() {
		System.out.println("ˮ���ƿ���");
	}

	@Override
	public void light() {
		System.out.println("ˮ������");
	}

	@Override
	public void turnOff() {
		System.out.println("ˮ���ƹ���");
	}
	
	public final void makeRemoteLight(int operColor){
		//�򿪿���
		this.turnOn();
		//����
		this.light();
		String color="";
		switch (operColor) {
		case 1:
			color="ůɫ";
			break;
		case 2:
			color="��ɫ";
			break;
		case 3:
			color="��ɫ";
			break;

		default:
			color="��ɫ";
			break;
		}
		System.out.println("....������"+color+"! ");
		//�رտ��أ��Ͽ�����
		this.turnOff();
	}

}
