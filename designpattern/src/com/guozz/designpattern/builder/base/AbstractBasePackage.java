package com.guozz.designpattern.builder.base;

import com.guozz.designpattern.builder.model.MobilePackage;

public abstract class AbstractBasePackage {

	//�ֻ��ײ�ʵ������
	protected MobilePackage mobilePackage;
	
	public AbstractBasePackage(){
		this.mobilePackage=new MobilePackage();
	}
	
}
