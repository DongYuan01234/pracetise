package com.guozz.designpattern.factory;

import com.guozz.designpattern.factory.itf.ISwordFactory;
import com.guozz.designpattern.factory.model.AbstractSword;

public class MainApp {

	public static void main(String[] args) {
		//����ܲ�ʵ�����󣬷�������ʹ�ýӿ�����
		//ISwordFactory swordFactory =new CaoCao();
		ISwordFactory swordFactory =new CaoCao2();
		//��ñ���ʾ�������Ǳ���
		AbstractSword sword= swordFactory.createSword();
		//��ɱ��׿
		System.out.println("�ܲ�ʹ��"+sword.getName()+"��ɱ��׿");
	}
}
