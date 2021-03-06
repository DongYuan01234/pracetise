package com.guozz.designpattern.abstractfactory.model;

/**
 * 食物基类
 * @author Administrator
 *
 */
public class AbstractBaseFood {

	//类别
	protected String kind;
	
	
	//数量
	protected int num;
	
	//价格
	protected float price;
	
	//合计
	public float totalPrice(){
		return this.num*this.price;
	}
	
	
}
