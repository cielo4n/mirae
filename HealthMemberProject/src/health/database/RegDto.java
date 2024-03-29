package health.database;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

//등록 정보가 담겨져있는 DTO(Data Transfer Object)클래스
public class RegDto implements Serializable{
	private int reg_no; //자동증가
	private Date reg_date;
	private Date end_date;
	private int year;
	private int month;
	private int reg_term; //등록개월
	
	public RegDto(){}
	
	//헬스기간 등록에 사용되는 생성자
	public RegDto(int year, int month, int day, int reg_term){
		
		reg_date = new Date(year-1900, month-1, day); //년월일 저장
		
		//마지막 날짜를 저장하는 과정 
		//Date -> Calendar -> 계산 ->Calendar -> Date
		
		//Date -> Calendar
		Calendar cld = Calendar.getInstance();
		cld.setTime(reg_date); 
		//계산 : 등록 날짜에 등록개월을 더하고 1일을 뺀다
		cld.add(Calendar.MONTH, reg_term);
		cld.add(Calendar.DATE, -1);
		//Calendar -> Date
		end_date = new Date(cld.getTimeInMillis()); 
		//마지막 날짜를 저장하는 과정 끝
		
		this.year = year;
		this.month = month;
		this.reg_term = reg_term;
	}
	
	public int getReg_no() {
		return reg_no;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getReg_term() {
		return reg_term;
	}
	
	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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
	
	@Override
	public String toString(){
		String str = "";
		str += "reg_no : "+reg_no+"\n"	;
		str += "reg_date"+reg_date+"\n"	;
		str += "end_date : "+end_date+"\n"	;
		str += "year : "+year+"\n"	;
		str += "month : "+month+"\n"	;
		str += "reg_term : "+reg_term+"\n"	;

		return str;
	}
}
