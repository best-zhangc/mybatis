package org.tarena.entity;

/**
 * 卡车实体类  封装卡车相关字段
 * @author zhangchao
 *
 */
public class Truck extends Vehicle{
	private int boxsize;

	public int getBoxsize() {
		return boxsize;
	}

	public void setBoxsize(int boxsize) {
		this.boxsize = boxsize;
	}

	@Override
	public String toString() {
		return "Truck [boxsize=" + boxsize + "]";
	}

}
