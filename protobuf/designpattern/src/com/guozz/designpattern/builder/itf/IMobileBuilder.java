package com.guozz.designpattern.builder.itf;

import com.guozz.designpattern.builder.model.MobilePackage;

/**
 * �ֻ��ײ�builder
 * @author Administrator
 *
 */
public interface IMobileBuilder {

	//�����ֻ��ײ͵Ļ���
	public 	void buildMoney();
	
	//�����ֻ��ײ͵Ķ���
	public void buildShortInfo();
	
	//�����ֻ��ײ͵Ĳ���
	public void buildMusic();
	
	//���ع�����ֻ��ײͶ���
	public MobilePackage getMobilePackage();
}
