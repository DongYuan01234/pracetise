package com.guozz.designpattern.birdge.switchs;

import com.guozz.designpattern.birdge.lights.ILight;

/**
 * ���ض�����
 * @author Administrator
 *
 */
public class BaseSwitch {

	//ʹ����ϣ�����ILightΪ�ڲ�˽�����ԣ���Ϊ�Ž�
	protected ILight light;
	
	//���췽�����ⲿ��lightע�����
	public BaseSwitch(ILight light){
		this.light=light;
	}
	
	
	public final void makeLight(){
		//�򿪿��أ���ͨ����
		this.light.electricConnected();
		//����
		this.light.light();
		//�رտ��أ��Ͽ�����
		this.light.electricClosed();
	}
	
}
