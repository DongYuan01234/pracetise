package com.guozz.designpattern.prototypepattern;

import com.guozz.designpattern.prototypepattern.factory.ILifeFactory;
import com.guozz.designpattern.prototypepattern.factory.LifeFactoryImp;
import com.guozz.designpattern.prototypepattern.pojo.DayLife;

public class MainApp {

	public static void main(String[] args) {
		ILifeFactory lifeFactory = new LifeFactoryImp();
		//��ӡ��Ĭ������
		lifeFactory.getNewInstance().print();
		
		//�ٴλ��DayLife,�޸�getUp���������
		System.out.println("--------------------");
		DayLife dayLife = lifeFactory.getNewInstance();
		dayLife.setGetUp("����������8�����");
		dayLife.print();
		
		//�ٴλ��DayLife,�޸�getUp���������
		System.out.println("--------------------");
		DayLife dayLife2 = lifeFactory.getNewInstance();
		dayLife2.setGetUp("����������9�����");
		dayLife2.print();
	}
}
