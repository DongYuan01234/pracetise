package com.guozz.designpattern.adapter.power;

/**
 * ��Դ����
 * @author Administrator
 *
 */
public abstract class AbsBasePower {

	//��ѹֵ
	private float power;
	
	//��λ
	private String unit = "V";
	
	public AbsBasePower	(float power){
		this.power=power;
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
