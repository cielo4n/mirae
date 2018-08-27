package health.database;

import java.io.Serializable;
import java.util.Date;
import java.util.StringTokenizer;

//회원 정보가 담겨져있는 DTO(Data Transfer Object)클래스
public class MemberDto implements Serializable{

	private int mem_no;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	private Date mem_birth;
	private String mem_gender;
	private float mem_height;
	private float mem_weight;
	private String mem_shape;
	private int trainer_no;
	private String gym_id;
	private String trainer_name; // 테이블에는 없지만 추가
	private int birth_year;
	private int birth_month;
	private int birth_day;
	//birth_year, birth_month, birth_day는 변경시 mem_birth와 동기화 필요하다

	public MemberDto() {
	}
	
	//새 회원 등록에서 사용하는 생성자
	public MemberDto(String gym_id, String mem_name, String mem_tel, String mem_addr,
			int birth_year, int birth_month, int birth_day, String mem_gender, double mem_height,
			double mem_weight, String mem_shape, String trainer_num_name) {
		this.gym_id = gym_id;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_addr = mem_addr;
		this.mem_birth = new Date(birth_year-1900, birth_month-1, birth_day);
		this.mem_gender = mem_gender;
		this.mem_height = (float) mem_height;
		this.mem_weight = (float) mem_weight;
		this.mem_shape = mem_shape;
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
		
		StringTokenizer st = new StringTokenizer(trainer_num_name, "　");
		this.trainer_no = Integer.parseInt(st.nextToken());
		this.trainer_name = st.nextToken();
	}
	
	//수정할 때 사용하는 생성자
	public MemberDto(String gym_id, int mem_no, String mem_name, String mem_tel, String mem_addr,
			int birth_year, int birth_month, int birth_day, String mem_gender, double mem_height,
			double mem_weight, String mem_shape, String trainer_num_name) {
		this.gym_id = gym_id;
		this.mem_no = mem_no;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_addr = mem_addr;
		this.mem_birth = new Date(birth_year-1900, birth_month-1, birth_day);
		this.mem_gender = mem_gender;
		this.mem_height = (float) mem_height;
		this.mem_weight = (float) mem_weight;
		this.mem_shape = mem_shape;
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
		
		StringTokenizer st = new StringTokenizer(trainer_num_name, "　");
		this.trainer_no = Integer.parseInt(st.nextToken());
		this.trainer_name = st.nextToken();
	}
	
	//birth_year, birth_month, birth_day는 변경시 mem_birth와 동기화 필요하다
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

	public MemberDto(int mem_no) {
		this.mem_no = mem_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public String getMem_name() {
		return mem_name;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public Date getMem_birth() {
		return mem_birth;
	}

	public String getMem_gender() {
		return mem_gender;
	}

	public float getMem_height() {
		return mem_height;
	}

	public float getMem_weight() {
		return mem_weight;
	}

	public String getMem_shape() {
		return mem_shape;
	}

	public int getTrainer_no() {
		return trainer_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}

	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}

	public void setMem_height(float mem_height) {
		this.mem_height = mem_height;
	}

	public void setMem_weight(float mem_weight) {
		this.mem_weight = mem_weight;
	}

	public void setMem_shape(String mem_shape) {
		this.mem_shape = mem_shape;
	}

	public void setTrainer_no(int trainer_no) {
		this.trainer_no = trainer_no;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	
	public String getGym_id() {
		return gym_id;
	}

	public void setGym_id(String gym_id) {
		this.gym_id = gym_id;
	}

	@Override
	public String toString(){
		String str="";
		
		str += "mem_no : "+mem_no+"\n";
		str += "mem_name : "+mem_name+"\n";
		str += "mem_tel : "+mem_tel+"\n";
		str += "mem_addr : "+mem_addr+"\n";
		str += "mem_birth : "+mem_birth+"\n";
		str += "birth_year : "+birth_year+"\n";
		str += "birth_month : "+birth_month+"\n";
		str += "birth_day : "+birth_day+"\n";
		str += "mem_gender : "+mem_gender+"\n";
		str += "mem_height : "+mem_height+"\n";
		str += "mem_weight : "+mem_weight+"\n";
		str += "mem_shape : "+mem_shape+"\n";
		str += "trainer_no : "+trainer_no+"\n";
		str += "gym_id : "+gym_id+"\n";
		str += "trainer_name : "+trainer_name+"\n";
		
		return str;
	}
}
