package com.guozz.designpattern.birdge.switchs;

import com.guozz.designpattern.birdge.lights.ILight;

/**
 * ң�ؿ��أ��̳�BaseSwitch��չ����
 * @author Administrator
 *
 */
public class RemoteControlSwitch extends BaseSwitch {

	//���췽��
	public RemoteControlSwitch(ILight light) {
		super(light);
	}
	
	/**
	 * ʹ��ң�ؿ��ؿ��Ƶ��
	 * @param operColor
	 */
	public final void makeRemoteLight(int operColor){
		//�򿪿��ؽ�ͨ����
		this.light.electricConnected();
		//����
		this.light.light();
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
		System.out.println("������ "+color+" ! ");
		//�رտ��أ��Ͽ�����
		this.light.electricClosed();
	}
	
	

}
