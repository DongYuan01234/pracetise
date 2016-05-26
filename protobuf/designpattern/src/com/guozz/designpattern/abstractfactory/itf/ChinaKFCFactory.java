package com.guozz.designpattern.abstractfactory.itf;

import com.guozz.designpattern.abstractfactory.model.Beverage;
import com.guozz.designpattern.abstractfactory.model.ChickenWings;
import com.guozz.designpattern.abstractfactory.model.FrenchFries;
import com.guozz.designpattern.abstractfactory.model.Humburg;
import com.guozz.designpattern.abstractfactory.model.kfc.ChinaBeverage;
import com.guozz.designpattern.abstractfactory.model.kfc.ChinaChickenWings;
import com.guozz.designpattern.abstractfactory.model.kfc.ChinaFrenchFires;
import com.guozz.designpattern.abstractfactory.model.kfc.ChinaHunburg;

public class ChinaKFCFactory implements IKfcFactory {

	/**
	 * ��������
	 */
	@Override
	public Humburg createHumburg(int num) {
		return new ChinaHunburg(num);
	}

	/**
	 * ��������
	 */
	@Override
	public FrenchFries createFrenchFires(int num) {
		return new ChinaFrenchFires(num);
	}
	/**
	 * ��������
	 */
	@Override
	public ChickenWings createChickenWing(int num) {
		return new ChinaChickenWings(num);
	}

	/**
	 * ��������
	 */
	@Override
	public Beverage createBeverage(int num) {
		return new ChinaBeverage(num);
	}

}
