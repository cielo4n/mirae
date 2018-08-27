package com.nmom.soap.data.model.sales.stat;

public class AgeGroupStat
{
	private float y;
	private int amount;
	private String name;
	private String color;
	
	public AgeGroupStat() {}

	public AgeGroupStat(float y, int amount, String name, String color) 
	{
		this.y = y;
		this.amount = amount;
		this.name = name;
		this.color = color;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
