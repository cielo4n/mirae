package com.nmom.soap.data.model.sales.stat;

import java.util.List;

public class AgeGroupStatList 
{
	List<AgeGroupStat> data;
	String title;
	
	public AgeGroupStatList() {}

	public AgeGroupStatList(List<AgeGroupStat> data, String title) 
	{
		this.data = data;
		this.title = title;
	}

	public List<AgeGroupStat> getData() {
		return data;
	}

	public void setData(List<AgeGroupStat> data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
