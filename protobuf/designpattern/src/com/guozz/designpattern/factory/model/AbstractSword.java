package com.guozz.designpattern.factory.model;
/**
 * 
 * @author Administrator
 * ������󱦵�
 */
public abstract class AbstractSword {

	//��������
	private String name;
	
	//������Ĺ��췽��
	public AbstractSword(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
