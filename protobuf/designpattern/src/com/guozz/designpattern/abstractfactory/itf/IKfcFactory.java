package com.guozz.designpattern.abstractfactory.itf;

import com.guozz.designpattern.abstractfactory.model.Beverage;
import com.guozz.designpattern.abstractfactory.model.ChickenWings;
import com.guozz.designpattern.abstractfactory.model.FrenchFries;
import com.guozz.designpattern.abstractfactory.model.Humburg;

/**
 * �ϵ»����󹤳�
 * @author Administrator
 *
 */
public interface IKfcFactory {

	//��������
	public Humburg createHumburg(int num);
	
	//��������
	public FrenchFries createFrenchFires(int num);
	
	//��������
	public ChickenWings createChickenWing(int num);
	
	//��������
	public Beverage createBeverage(int num);
	
	
	
}
