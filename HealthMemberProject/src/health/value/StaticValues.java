package health.value;

import health.database.GymDto;
import health.database.MemberDto;
import health.database.TrainerDto;

//Ŭ���� ���� ��ü�� �����ϱ� ���� static ������ �����س��� Ŭ����
//Ŭ���� �̸����� ������ �����ϰ� ���α׷��� ����� �� ���� ����ִ�
public class StaticValues {
	private static String svAdmin_id = null;
	private static String svGym_id = null;
	private static GymDto svGymDto = null;
	private static MemberDto svMemDto = null;
	private static TrainerDto svTrainerDto = null;
	
	public static String getSvAdmin_id() {
		return svAdmin_id;
	}
	public static String getSvGym_id() {
		return svGym_id;
	}
	public static void setSvAdmin_id(String svAdmin_id) {
		StaticValues.svAdmin_id = svAdmin_id;
	}
	public static void setSvGym_id(String svGym_id) {
		StaticValues.svGym_id = svGym_id;
	}
	public static GymDto getSvGymDto() {
		return svGymDto;
	}
	public static void setSvGymDto(GymDto svGymDto) {
		StaticValues.svGymDto = svGymDto;
	}
	public static MemberDto getSvMemDto() {
		return svMemDto;
	}
	public static void setSvMemDto(MemberDto svMemDto) {
		StaticValues.svMemDto = svMemDto;
	}
	public static TrainerDto getSvTrainerDto() {
		return svTrainerDto;
	}
	public static void setSvTrainerDto(TrainerDto svTrainerDto) {
		StaticValues.svTrainerDto = svTrainerDto;
	}
}
