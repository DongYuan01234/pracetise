package com.guozz.designpattern.builder;

import com.guozz.designpattern.builder.director.MobileDirector;
import com.guozz.designpattern.builder.itf.IMobileBuilder;
import com.guozz.designpattern.builder.itf.MobileBuilderImp1;
import com.guozz.designpattern.builder.itf.MobileBuilderImp2;
import com.guozz.designpattern.builder.model.MobilePackage;

public class MainAPP {

	public static void main(String[] args) {
		//����ָ����
		MobileDirector mobileDirector = new MobileDirector();
		
		//�ײ�1
		IMobileBuilder iMobileBuilder1 = new MobileBuilderImp1();
		
		//�ײ�2
		IMobileBuilder iMobileBuilder2 = new MobileBuilderImp2();
		
		printMassege(mobileDirector.createMobilePackage(iMobileBuilder1));	
		
		printMassege(mobileDirector.createMobilePackage(iMobileBuilder2));	
		
	}

	/**
	 * ��ӡ����ײ���Ϣ
	 * @param createMobilePackage
	 */
	private static void printMassege(MobilePackage 	mobilePackage) {
		System.out.println("---����"+mobilePackage.getMoney() +"\t---����"+mobilePackage.getShortInfo()+"\t---����:"+mobilePackage.getMusic());		
	}
}
