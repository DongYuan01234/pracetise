package com.guozz.designpattern.birdge.lights;

/**
 * �׳��ʵ��
 * @author Administrator
 *
 */
public class IncandescentLight implements ILight {

	@Override
	public void electricConnected() {
		System.out.println("�׳�ƴ�");
	}

	@Override
	public void light() {
		System.out.println("�׳������");
	}

	@Override
	public void electricClosed() {
		System.out.println("�׳�ƹر�");
	}

}
