package com.guozz.designpattern.birdge.lights;

/**
 * �׳��ʵ��
 * @author Administrator
 *
 */
public class CrystalLight implements ILight {

	@Override
	public void electricConnected() {
		System.out.println("ˮ���ƴ�");
	}

	@Override
	public void light() {
		System.out.println("ˮ��������");
	}

	@Override
	public void electricClosed() {
		System.out.println("ˮ���ƹر�");
	}

}
