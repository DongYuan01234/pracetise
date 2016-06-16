package com.guozz.designpattern.prototypepattern.factory;

import com.guozz.designpattern.prototypepattern.pojo.DayLife;

public class LifeFactoryImp implements ILifeFactory {

	private static DayLife dayLife;
	
	/**
	 * �����null�Ļ����ֶ�����һ��
	 * �������null�Ļ���ʹ��clone������ֵһ�����󲢷���
	 */
	@Override
	public DayLife getNewInstance() {
		if(dayLife == null){
			dayLife= new DayLife();
			dayLife.setGetUp("7:00��");
			dayLife.setByBus("7:30��������");
			dayLife.setGetFood("8:00����˾ȥ�����");
			dayLife.setNoon("�ڹ�˾�����Է�������С�");
			dayLife.setAfternoonWork("13:30��ʼ����Ĺ���");
			dayLife.setGoHome("17:30�ؼ�");
			dayLife.setNight("������������");			
		}else{
			//�����Ϊnull����clone���������¶���
			System.out.println("clone DayLife");
			dayLife= dayLife.clone();
		}
		return dayLife;
	}

}
