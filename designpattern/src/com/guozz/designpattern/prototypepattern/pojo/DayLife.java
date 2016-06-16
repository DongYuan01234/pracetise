package com.guozz.designpattern.prototypepattern.pojo;

/**
 * �ճ�������
 * @author Administrator
 *
 */
public class DayLife implements Cloneable {

	//��
	private String getUp;
	
	//������
	private String byBus;
	
	//�³��������
	private String getFood;
	
	//����С�
	private String noon;
	
	//���翪ʼ����
	private String afternoonWork;
	
	//�°�ؼ�
	private String goHome;
	
	//������Ϣ
	private String night;

	public String getGetUp() {
		return getUp;
	}

	public void setGetUp(String getUp) {
		this.getUp = getUp;
	}

	public String getByBus() {
		return byBus;
	}

	public void setByBus(String byBus) {
		this.byBus = byBus;
	}

	public String getGetFood() {
		return getFood;
	}

	public void setGetFood(String getFood) {
		this.getFood = getFood;
	}

	public String getNoon() {
		return noon;
	}

	public void setNoon(String noon) {
		this.noon = noon;
	}

	public String getAfternoonWork() {
		return afternoonWork;
	}

	public void setAfternoonWork(String afternoonWork) {
		this.afternoonWork = afternoonWork;
	}

	public String getGoHome() {
		return goHome;
	}

	public void setGoHome(String goHome) {
		this.goHome = goHome;
	}

	public String getNight() {
		return night;
	}

	public void setNight(String night) {
		this.night = night;
	}
	
	public void print(){
		System.out.println(this.getGetUp());
		System.out.println(this.getByBus());
		System.out.println(this.getGetFood());
		System.out.println(this.getNoon());
		System.out.println(this.getAfternoonWork());
		System.out.println(this.getGoHome());
		System.out.println(this.getNight());
	}

	@Override
	public DayLife clone() {
	
		try {
			return (DayLife) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
