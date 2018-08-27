package com.nmom.soap.data.model.sales.stat;

public class GenderGroupVo
{
	int mem_gender;
	int amount;
	float ratio;
	
	public GenderGroupVo() {}

	public GenderGroupVo(int mem_gender, int amount, float ratio)
	{
		this.mem_gender = mem_gender;
		this.amount = amount;
		this.ratio = ratio;
	}

	public int getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(int mem_gender) {
		this.mem_gender = mem_gender;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
}
