package com.guozz.designpattern.birdge.common;

import com.guozz.designpattern.birdge.common.sub.CrystalLight;
import com.guozz.designpattern.birdge.common.sub.IncandescentLight;

public class Client {

	public static void main(String[] args) {
		//�׳��
		AbstractSwitch light = new IncandescentLight();
		//ˮ����
		CrystalLight light2 = new CrystalLight();
		System.out.println("----һ�㿪��-----");
		light.makeLight();
		
		System.out.println("----ң�ؿ���----");
		light2.makeRemoteLight(1);
		
		
				
	}
}
