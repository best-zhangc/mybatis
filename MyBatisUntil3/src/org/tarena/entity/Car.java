package org.tarena.entity;

/**
 * 小汽车实体类  封装小汽车相关字段
 * @author zhangchao
 *
 */
public class Car extends Vehicle{
	private int doorsize;

	public int getDoorsize() {
		return doorsize;
	}

	public void setDoorsize(int doorsize) {
		this.doorsize = doorsize;
	}

	@Override
	public String toString() {
		return "Car [doorsize=" + doorsize + "]";
	}
	

}
