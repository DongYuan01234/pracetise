package com.guozz.designpattern.abstractfactory.custom;

import com.guozz.designpattern.abstractfactory.itf.IKfcFactory;
import com.guozz.designpattern.abstractfactory.model.Beverage;
import com.guozz.designpattern.abstractfactory.model.ChickenWings;
import com.guozz.designpattern.abstractfactory.model.FrenchFries;
import com.guozz.designpattern.abstractfactory.model.Humburg;

/**
 * �ͻ���
 * @author Administrator
 *
 */
public class Customer {

	/**
	 * ���󹤳�
	 */
	private IKfcFactory kfcFactory;
	
	public Customer (IKfcFactory kfcFactory){
		this.kfcFactory=kfcFactory;
	}
	
	/**
	 * ����ʳ��
	 */
	//�����������Ⱥ���
	public float orderHumburg(int num){
		//����������Ⱥ���
		Humburg humburg = kfcFactory.createHumburg(num);
		//���������Ϣ
		humburg.printMessage();
		//�����ܼ�
		return humburg.totalPrice();
	}
	
	
	//�����¶���������
	public float orderChickenWings(int num){
		//��ð¶���������
		ChickenWings chickenWings = kfcFactory.createChickenWing(num);
		//���������Ϣ
		chickenWings.printMessage();
		//�����ܼ�
		return chickenWings.totalPrice();
	}
	
	//��������
	public float orderFrenchFires(int num){
		//�������
		FrenchFries frenchFries = kfcFactory.createFrenchFires(num);
		//���������Ϣ
		frenchFries.printMessage();
		//�����ܼ�
		return frenchFries.totalPrice();
	}
	
	//��������
	public float orderBeverage(int num){
		//��ÿ���
		Beverage beverage = kfcFactory.createBeverage(num);
		//���������Ϣ
		beverage.printMessage();
		//�����ܼ�
		return beverage.totalPrice();
	}
	
	
}
