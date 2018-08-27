
package health.ui;

import javax.swing.JOptionPane;

//경고창을 띄우기 위한 JOptionPane을 모아놓은 클래스
public class WarningMessage {

//	public static void MainScreenLoginWarning()  // 메인 화면에서 로그인시 없는 사용자일때 
//	{
//		JOptionPane.showMessageDialog(null, "등록된 사용자의 정보가 아닙니다.", "미 등록 정보", JOptionPane.ERROR_MESSAGE);
//	}

	public static void notSamePassward()  // 패스워드가 불일치할떄
	{
		JOptionPane.showMessageDialog(null, "패스워드가 동일한지 확인해주세요", "패스워드 불일치", JOptionPane.WARNING_MESSAGE);
	}

	public static void mainScreenJoinSuccess() // 메인 화면에서 관리자 등록시 성공적으로 등록 완료되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 등록되었습니다.", "관리자 등록 완료", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void mainScreenJoinFailure() // 메인 화면에서 관리자 등록시 등록실패했을 때
	{
		JOptionPane.showMessageDialog(null, "등록을 실패했습니다.", "관리자 등록 실패", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mainScreenLoginWarning()  // 메인 화면에서 로그인시 아이디가 없거나, 비밀번호가 안맞거나 할 경우 
	{
		JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mainScreenLoginBlankWarning()  // 메인 화면에서 로그인시 아이디와 비밀번호 입력 안함
	{
		JOptionPane.showMessageDialog(null, "아이디와 패스워드를 입력해주세요", "미 입력 내용", JOptionPane.WARNING_MESSAGE);
	}

	public static void blankWarning() // 회원등록,트레이너등록 ( 새롭게 등록할때 빈칸을 처리하지 않고 누른경우)
	{
		JOptionPane.showMessageDialog(null, "빈칸을 빠짐없이 입력해주세요.", "미 입력 내용", JOptionPane.WARNING_MESSAGE);
	}

	public static void mainScreenLoginCheck() // 관리자인지 헬스장인지 체크가 안되어있는 경우
	{
		JOptionPane.showMessageDialog(null, "관리자 또는 헬스장을 체크해주세요.", "미 체크 항목", JOptionPane.WARNING_MESSAGE);
	}

	public static void duplicationWarning() // 관리자, 헬스장 등록시 아이디 중복될 때
	{
		JOptionPane.showMessageDialog(null, "중복된 아이디 입니다", "등록 실패", JOptionPane.ERROR_MESSAGE);
	}

	public static void healthJoin() // 헬스장 등록시 성공적으로 등록완료되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 등록되었습니다.", "헬스장 등록완료", JOptionPane.PLAIN_MESSAGE);
	}

	public static boolean healthDelete()  // 헬스장 삭제할때 
	{
		int abc;

		abc = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "헬스장 삭제", JOptionPane.YES_NO_OPTION);
		if (abc == JOptionPane.YES_OPTION) {
			return true;
		} else if (abc == JOptionPane.NO_OPTION) {
			return false;
		} 
		return false;
	}

	public static void healthDeleteOK(){
		JOptionPane.showMessageDialog(null, "삭제 완료되었습니다.", "헬스장 삭제 완료", JOptionPane.PLAIN_MESSAGE);
	}
	public static void healthDeleteCancel(){
		JOptionPane.showMessageDialog(null, "헬스장 삭제가 취소되었습니다.", "헬스장 삭제 취소", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void healthUpdateSuccess()  // 헬스장 수정할때 수정이 성공적으로 되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다.", "헬스장 수정완료", JOptionPane.PLAIN_MESSAGE);
	}

	public static void trainerJoin()  // 트레이너 등록시 성공적으로 등록완료되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 등록되었습니다.", "트레이너 등록완료", JOptionPane.PLAIN_MESSAGE);
	}

	public static void inputYearFailure(){
		JOptionPane.showMessageDialog(null, "생년월일은 숫자로 입력해야 합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void inputHeightFailure(){
		JOptionPane.showMessageDialog(null, "키는 숫자로 입력해야 합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);	

	}
	public static void inputWeightFailure(){
		JOptionPane.showMessageDialog(null, "몸무게는 숫자로 입력해야 합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);	

	}
	public static void inputRegYearFailure(){
		JOptionPane.showMessageDialog(null, "등록일은 숫자로 입력해야 합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void inputCareerFailure(){
		JOptionPane.showMessageDialog(null, "경력은 숫자로 입력해야 합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void memberUpdate()  // 회원 수정시 성공적으로 수정되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다.", "회원 수정완료", JOptionPane.PLAIN_MESSAGE);
	}

	public static boolean memberDelete()  // 회원 삭제할때
	{
		int abc;

		abc = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "회원 삭제", JOptionPane.YES_NO_OPTION);
		if(abc == JOptionPane.YES_OPTION) { 
			return true;
			
		} else if(abc == JOptionPane.NO_OPTION){
			return false;
		}
		return false;
	}	
	
	public static void memberDeleteOK(){
		JOptionPane.showMessageDialog(null, "삭제 완료되었습니다.", "회원 삭제 완료", JOptionPane.PLAIN_MESSAGE);
	}
	public static void memberDeleteCancel(){
		JOptionPane.showMessageDialog(null, "회원 삭제가 취소되었습니다.", "회원 삭제 취소", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void healthRegister() // 헬스 기간등록할때 성공적으로 등록완료 메세지
	{
		JOptionPane.showMessageDialog(null, "헬스등록 완료되었습니다.", "헬스등록 완료", JOptionPane.PLAIN_MESSAGE);
	}

	public static void memberJoin() // 회원 등록시 성공적으로 등록완료되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 등록되었습니다.", "회원등록 완료", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void trainerUpdateSuccess()  // 트레이너 수정할때 성공적으로 수정되었을때
	{
		JOptionPane.showMessageDialog(null, "성공적으로 수정되었습니다.", "트레이너 수정완료", JOptionPane.PLAIN_MESSAGE);
	}

	public static void trainerDeleteOK(){
		JOptionPane.showMessageDialog(null, "삭제 완료되었습니다.", "트레이너 삭제 완료", JOptionPane.PLAIN_MESSAGE);
	}
	public static void trainerDeleteCancel(){
		JOptionPane.showMessageDialog(null, "회원 삭제가 취소되었습니다.", "트레이너 삭제 취소", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean trainerDelete()  // 트레이너 삭제할때
	{
		int abc;

		abc = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "트레이너 삭제", JOptionPane.YES_NO_OPTION);
		if (abc == JOptionPane.YES_OPTION) {
			return true;
		} else if (abc == JOptionPane.NO_OPTION) {
			return false;
		}
		return false;
	}
	
		
	//return 0 : 잘된 등록
	//return 1 : 30일까지만 등록 에러
	//return 2 : 윤년 2월은 29일까지 등록 에러
	//return 3 : 윤년이 아닌 2월은 28일까지 등록가능 에러
	public static int checkDay(int year, int month, int day) {
	      int y = year;
	      int m = month;
	      int d = day;

	      //윤년인지 확인하는 부분
	      if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0){
	    	  // 입력받은 년도의 값이 윤년인지확인함 
	      
	    	  if (m == 2) { //년도값이 윤년이고 월의 값이 2월일때 
	    		  if (d <= 29) { // 날짜는 29일 보다 작거나 같음  리턴값 트루
	    			  return 0;
	    		  } else { // 29일보다 작거나 같지 않으면 리턴값 펄스
	    			  return 2; //윤년인데 잘못입력됨
	    		  }
	         }
	      }
	      
	      //2월 제대로 입력되었나 확인
	      else if(m == 2){ // 윤년이 아닐때 월의값이 2월이면 
	    	  if(d <= 28) // 날짜가 28일보다 작거나 같으면 트루값을 리턴함
	    		  return 0;
	         else
	        	 return 3; //윤년이 아닌 2월 잘못 입력됨
	      }
	
	      //4, 6, 9, 11월달 입력되었을 때
	      else if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
	    	  // 입력받은 달의값이 4,6,9,11 이면
	         if (d <= 30) { // 날짜값이 30 보다 작거나 같으면 리턴 트루
	        	 return 0;
	         } else {
	            return 1; //30일까지만 되어야 하는데 잘못 입력됨
	         }
	      }
	      
	      //1, 3, 5, 7, 8, 10, 12월 달 입력되었을 때
	      else if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12)) {
	    	  if(d <= 31) {// 날짜값이 31보다 작거나 같으면 리턴 트루
	    		  return 0;
	    	  }
	      }
	      return 0;
	} //checkDay 메소드의 끝

	public static void inputYearNumFailure1(){
		JOptionPane.showMessageDialog(null, "해당년도 해당월은 30일까지만 등록가능합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);   
	}
	public static void inputYearNumFailure2(){
		JOptionPane.showMessageDialog(null, "윤년 2월은 29일까지 등록가능합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);   
	}
	public static void inputYearNumFailure3(){
		JOptionPane.showMessageDialog(null, "윤년이 아닌 2월은 28일까지 등록가능합니다.", "잘못된 입력", JOptionPane.ERROR_MESSAGE);   
	}
}

