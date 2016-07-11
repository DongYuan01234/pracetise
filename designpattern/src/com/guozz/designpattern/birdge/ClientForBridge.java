package com.guozz.designpattern.birdge;

import com.guozz.designpattern.birdge.lights.CrystalLight;
import com.guozz.designpattern.birdge.lights.ILight;
import com.guozz.designpattern.birdge.lights.IncandescentLight;
import com.guozz.designpattern.birdge.switchs.BaseSwitch;
import com.guozz.designpattern.birdge.switchs.RemoteControlSwitch;

public class ClientForBridge {

	public static void main(String[] args) {
		//�׳��ʵ��
		ILight  incadescentLight=new IncandescentLight();
		//ˮ����ʵ��
		ILight  crystalLight=new CrystalLight();
		
		//һ�濪��
		 BaseSwitch baseSwitch = new BaseSwitch(incadescentLight);
		 baseSwitch.makeLight();
		 
		 //ң�ؿ���
		 RemoteControlSwitch remoteControlSwitch =new RemoteControlSwitch(crystalLight);
		 remoteControlSwitch.makeRemoteLight(1);
		
	}
}
