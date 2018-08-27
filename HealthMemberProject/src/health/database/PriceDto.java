package health.database;

import java.io.Serializable;

//비용 정보가 담겨져있는 DTO(Data Transfer Object)클래스
public class PriceDto implements Serializable{
	private int year;
	private int month;
	private int reg_term;
	private int price_total;
	
	public PriceDto(){}
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getReg_term() {
		return reg_term;
	}
	public int getPrice_total() {
		return price_total;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setReg_term(int reg_term) {
		this.reg_term = reg_term;
	}
	public void setPrice_total(int price_total) {
		this.price_total = price_total; 
	}

	@Override
	public String toString(){
		String str = "";
		str += "year : "+year+"\n";
		str += "month : "+month+"\n";
		str += "reg_term : "+reg_term+"\n";
		str += "price_total : "+price_total+"\n";
		
		return str;
	}
	
}
