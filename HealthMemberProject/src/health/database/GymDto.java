package health.database;

import java.io.Serializable;

//데이터베이스에서 받은 데이터를 객체로 만들기 위해 작성
//헬스장 정보가 담겨져있는 DTO(Data Transfer Object)클래스
public class GymDto implements Serializable{

	private String gym_id;
	private String gym_pw;

	private String business_no;
	private String gym_name;
	private String gym_tel;
	private String gym_addr;

	public GymDto(){}
	
	// 헬스장 등록시 사용
	public GymDto(String gym_id, String gym_pw,
			String business_no, String gym_name, String gym_tel, String gym_addr) {
		this.gym_id = gym_id;
		this.gym_pw = gym_pw;
		this.business_no = business_no;
		this.gym_name = gym_name;
		this.gym_tel = gym_tel;
		this.gym_addr = gym_addr;
	}
	
	public String getGym_id() {
		return gym_id;
	}

	public String getGym_pw() {
		return gym_pw;
	}

	public String getBusiness_no() {
		return business_no;
	}

	public String getGym_name() {
		return gym_name;
	}

	public String getGym_tel() {
		return gym_tel;
	}

	public String getGym_addr() {
		return gym_addr;
	}

	public void setGym_id(String gym_id) {
		this.gym_id = gym_id;
	}

	public void setGym_pw(String gym_pw) {
		this.gym_pw = gym_pw;
	}

	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}

	public void setGym_name(String gym_name) {
		this.gym_name = gym_name;
	}

	public void setGym_tel(String gym_tel) {
		this.gym_tel = gym_tel;
	}

	public void setGym_addr(String gym_addr) {
		this.gym_addr = gym_addr;
	}

	@Override
	public String toString() {
		String str = "";
		str += "gym_id : "+gym_id+"\n";
		str += "gym_pw : "+gym_pw+"\n";
		str += "business_no : "+business_no+"\n";
		str += "gym_name : "+gym_name+"\n";
		str += "gym_tel : "+gym_tel+"\n";
		str += "gym_addr : "+gym_addr+"\n";
		return str;
	}
}
