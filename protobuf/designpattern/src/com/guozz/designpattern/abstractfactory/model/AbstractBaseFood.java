package com.guozz.designpattern.abstractfactory.model;

/**
 * ʳ�����
 * @author Administrator
 *
 */
public class AbstractBaseFood {

	//���
	protected String kind;
	
	
	//����
	protected int num;
	
	//�۸�
	protected float price;
	
	//�ϼ�
	public float totalPrice(){
		return this.num*this.price;
	}
	
	
}
