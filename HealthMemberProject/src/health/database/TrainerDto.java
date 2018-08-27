package health.database;

import java.io.Serializable;
import java.util.Date;

//트레이너 정보가 담겨져있는 DTO(Data Transfer Object)클래스
public class TrainerDto implements Serializable{
	private int trainer_no;
	private String trainer_name;
	private String trainer_tel;
	private String trainer_addr;
	private Date trainer_birth;
	private String trainer_gender;
	private int trainer_career;
	private String gym_id;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	//birth_year, birth_month, birth_day는 변경시 trinaer_birth와 동기화 필요하다

	public TrainerDto(){
	}

	public TrainerDto(String trainer_name, String trainer_tel,
			String trainer_addr, int birth_year, int birth_month, int birth_day, String trainer_gender,
			int trainer_career, String gym_id) { //트레이너번호는 입력 안받음
		this.trainer_name = trainer_name;
		this.trainer_tel = trainer_tel;
		this.trainer_addr = trainer_addr;
		this.trainer_gender = trainer_gender;
		this.trainer_career = trainer_career;
		this.gym_id = gym_id;
		this.trainer_birth = new Date(birth_year-1900, birth_month-1, birth_day);
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
	
	}
	//수정 할때사용
	public TrainerDto(String gym_id, int trainer_no, String trainer_name, String trainer_tel, String trainer_addr,
		int birth_year, int birth_month, int birth_day, String trainer_gender, int trainer_career){
		this.gym_id = gym_id;
		this.trainer_no = trainer_no;
		this.trainer_name = trainer_name;
		this.trainer_tel = trainer_tel;
		this.trainer_addr = trainer_addr;
		this.trainer_gender = trainer_gender;
		this.trainer_birth = new Date(birth_year-1900, birth_month-1, birth_day);
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
		this.trainer_career = trainer_career;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public int getBirth_month() {
		return birth_month;
	}

	public int getBirth_day() {
		return birth_day;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public void setBirth_month(int birth_month) {
		this.birth_month = birth_month;
	}

	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}

	public String getGym_id() {
		return gym_id;
	}

	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}

	public void setGym_id(String gym_id) {
		this.gym_id = gym_id;
	}

	public int getTrainer_no() {
		return trainer_no;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public String getTrainer_tel() {
		return trainer_tel;
	}

	public String getTrainer_addr() {
		return trainer_addr;
	}

	public Date getTrainer_birth() {
		return trainer_birth;
	}

	public String getTrainer_gender() {
		return trainer_gender;
	}

	public int getTrainer_career() {
		return trainer_career;
	}
	
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public void setTrainer_tel(String trainer_tel) {
		this.trainer_tel = trainer_tel;
	}

	public void setTrainer_addr(String trainer_addr) {
		this.trainer_addr = trainer_addr;
	}

	public void setTrainer_birth(Date trainer_birth) {
		this.trainer_birth = trainer_birth;
	}

	public void setTrainer_gender(String trainer_gender) {
		this.trainer_gender = trainer_gender;
	}

	public void setTrainer_career(int trainer_career) {
		this.trainer_career = trainer_career;
	}
	
	@Override
	public String toString(){
		String str = "";
		str+= "trainer_no : "+trainer_no+"\n";
		str+= "trainer_name : "+trainer_name+"\n";
		str+= "trainer_tel : "+trainer_tel+"\n";
		str+= "trainer_addr : "+trainer_addr+"\n";
		str+= "trainer_birth : "+trainer_birth+"\n";
		str+= "trainer_gender : "+trainer_gender+"\n";
		str+= "trainer_career : "+trainer_career+"\n";
		str+= "gym_id : "+gym_id+"\n";
		str+= "birth_year : "+birth_year+"\n";
		str+= "birth_month : "+birth_month+"\n";
		str+= "birth_day : "+birth_day+"\n";
		
		return str;
	}
}
