package com.guozz.designpattern.birdge.common;

/**
 * ���ػ���
 * @author Administrator
 *
 */
public abstract class AbstractSwitch {

	//�򿪿���
	public abstract void turnOn();
	
	//����
	public abstract void light();
	
	//�رտ���
	public abstract void turnOff();
	
	//��������
	public final void makeLight(){
		this.turnOn();
		this.light();
		this.turnOff();
	}
	
}
