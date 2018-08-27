package com.nmom.soap;

public class S {
	
	// 게시판 번호
	public final static int BOARD_NOTICE =1;
	public final static int BOARD_EVENT =2;
	public final static int BOARD_FAQ =3;
	public final static int BOARD_QNA =4;
	public final static int BOARD_REVIEW =5;
	
	// 성별
	public final static int GENDER_MALE =1;
	public final static int GENDER_FEMALE =2;
	
	// 회원등급
	public final static int LEVEL_ADMIN = 10;
	public final static int LEVEL_MEMBER = 1;
	public final static int LEVEL_BLACKLIST = 2;
	public final static int LEVEL_NONMEMBER = 3;
	public final static int DROP_TRUE = 1;
	public final static int DROP_FALSE = 0;
	
	// [소라] 수정, 삭제 시 실행 결과 값
	public final static int PROCESS_SUCCESS = 1;
	public final static int PROCESS_ERROR = -1;
	public final static int PROCESS_NO_RESULT = 0;
	
	// [소라] 정렬 값
	public final static boolean ASC = true;
	public final static boolean DESC = false;
	
	// [소라] 진열, 판매, 삭제 상태 수정 시 true, false 값
	public final static int STATE_TRUE = 1;
	public final static int STATE_FALSE = 0;
	
	// 게시판 한 페이지에 나오는 글 개수
	public final static int PAGE_LIMIT = 10;
	
	
	// Session Attribute Name
	public final static String SESSION_LOGIN ="loggedin";
	public final static String SESSION_ADMIN ="admin";
	
	// [수진] Session Temp Order
	public final static String SESSION_TEMP_ORDER = "tempOrder";
	
	// [수진] 프로세스 번호
	public final static int DELIVERY_PREPARE = 11; //배송준비중
	public final static int DELIVERY_WAITING = 12; //배송대기
	public final static int DELIVER = 13; 			//배송중
	public final static int DELIVERY_COMPLETE = 14; //배송완료
	public final static int BUY_DECISION = 21; 	//구매확정
	public final static int REFUND_PROCESS = 31; 	//환불요청
	public final static int REFUND_COMPLETE = 32; 	//환불완료
}
