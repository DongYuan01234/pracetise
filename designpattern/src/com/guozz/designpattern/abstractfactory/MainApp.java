package com.guozz.designpattern.abstractfactory;

import com.guozz.designpattern.abstractfactory.custom.Customer;
import com.guozz.designpattern.abstractfactory.itf.ChinaKFCFactory;
import com.guozz.designpattern.abstractfactory.itf.IKfcFactory;

public class MainApp {

	public static void main(String[] args) {
		/**
		 * ����һ���ϵ»�����
		 */
		IKfcFactory kfcFactory = new ChinaKFCFactory();
		/**
		 * �ͻ�׼�����
		 */
		Customer customer = new Customer(kfcFactory);
		
		/**
		 * ��ʼ���
		 */
		//һ���������Ⱥ���
		float humberMoney = customer.orderHumburg(1);
		//�ĸ�������
		float chickenWingsMoney = customer.orderChickenWings(4);
		//һ������
		float frenchFriesMoney = customer.orderFrenchFires(1);
		//��������
		float beverageMoney = customer.orderBeverage(2);
		
		System.out.println("�ܹ�����"+(humberMoney+chickenWingsMoney+frenchFriesMoney+beverageMoney));
	}
}
