package com.guozz.designpattern.adapter;

import com.guozz.designpattern.adapter.v12.IPower12;
import com.guozz.designpattern.adapter.v12.Power12;
import com.guozz.designpattern.adapter.v220.Power220;

public class Client {

	public static void main(String[] args) {
		Power220 power220 = new Power220();
		power220.outPrint220V();
		
		Power12 power12 = new Power12();
		power12.output12v();
		
		//����������
		System.out.println("\n��Դ������ת����");
		IPower12 adapterPower12 = new AdapterPower12(power220);
		adapterPower12.output12v();
		System.out.println("\n��Դ������ת������");
		
	}
}
