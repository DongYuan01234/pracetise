package com.guozz.designpattern.birdge.lights;

/**
 * ��ƽӿ�
 * @author Administrator
 *
 */
public interface ILight {

	/**
	 * ��ͨ����
	 */
	public void electricConnected();
	
	/**
	 * ����
	 */
	public void light();
	
	/**
	 * �Ͽ�����
	 */
	public void electricClosed();
}
