package com.example.qwertj.activity;

public class Itembean {

	private String tv;
	/**
	 * ��ʶ�Ƿ����ɾ��
	 */
	private boolean canRemove = true;

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public boolean isCanRemove() {
		return canRemove;
	}

	public void setCanRemove(boolean canRemove) {
		this.canRemove = canRemove;
	}

	public Itembean(String title, boolean canRemove) {
		this.tv = title;
		this.canRemove = canRemove;
	}

	public Itembean() {

	}
}
