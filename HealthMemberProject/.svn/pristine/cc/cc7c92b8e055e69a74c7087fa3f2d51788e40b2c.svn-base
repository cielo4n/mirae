package health.database;

import java.sql.*;

/*
 * 데이터 베이스 클래스는 싱글톤 패턴으로 생성한다.
 * 싱글톤 패턴은 인스턴스를 하나로 제한을 두는 것으로 
 * 객체 생성은 한번만 가능하고 그 객체에 접근하는 식으로 사용한다
 * 
 * 싱글톤 패턴 사용 방법
 * 1. 생성자의 접근제한자는 다른 클래스에서 생성할 수 없도록 private로 한다
 * 2. 자기자신의 객체를 static 변수로 선언한다.
 * 3. 위의 객체를 가져오기 위한 메소드를 만든다.
 * (관례적으로 변수명은 instance, 메소드명은 getInstance로 한다)
 */

//관리자 로그인 데이터베이스에 접근하는 DAO(Data Access Object)클래스
public class AdminDao {
	
	//유일하게 자기 자신을 참조할 수 있는 변수
	private static AdminDao instance; 
	
	//데이터베이스 정보
	private static final String DBName="healthdb"; //데이터베이스이름은 이거로 한다
	private static final String DBUser = "root";
	private static final String DBPassword = "123456";
	
	private String url= "jdbc:mysql://localhost/"+DBName;
	private String jdbc_driver = "com.mysql.jdbc.Driver";
	
	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static String sql = null;
	
	//private 생성자에서 드라이버 로드, Connection 연결
	private AdminDao(){
		try{
			Class.forName(jdbc_driver); //드라이버 로드
			conn = DriverManager.getConnection(url, DBUser, DBPassword); //Connection 연결
		} catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다");
		} catch(SQLException e) {
			System.out.println("Connection 연결 실패");
		} 
	}
	
	//public 자기 반환하는 메소드
	public static AdminDao getInstance() { //자기자신을 참조하는 변수 리턴
		if(instance == null) //참조변수가 null일 때는 생성함
			instance = new AdminDao();
		return instance;
	}
	
	//연결 종료
	private void disConnect(){
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close(); 연결을 계속 끊었다가 했다가 하면 에러남
		} catch(SQLException e) {
			System.out.println("종료 안됨");
			e.printStackTrace();
		}
	}
	
	//관리자 아이디, 비밀번호 조회해서 비교하는 기능
	public boolean compareAdmin(String admin_id, String admin_pw){
		try{
			stmt = conn.createStatement();
			sql = "SELECT * FROM login_admin";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				//아이디 패스워드 비교 필요
				if(rs.getString("admin_id").equals(admin_id)){
						if(rs.getString("admin_pw").equals(admin_pw))
						{
							return true;
						}
				}
			}
			return false;
		} catch(SQLException e){
			System.out.println("compareAdmin 실패");
			e.printStackTrace();
		} finally{
			disConnect();
		}
		return false;
	}
	
	//관리자 등록하는 부분
	public boolean insertAdmin(String admin_id, String admin_pw){
		try{
			sql = "INSERT INTO login_admin VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql); //미리 쿼리 보냄
			pstmt.setString(1, admin_id); //물음표는 1부터 시작, 동적으로 값 넣음
			pstmt.setString(2, admin_pw);
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e){
			System.out.println("insertLoginAdmin 실패");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}

	//관리자 아이디 중복검사, 같은 아이디가 있나 확인
	public boolean differentAdmin_id(String admin_id){
		try{
			stmt = conn.createStatement();
			sql = "SELECT admin_id FROM login_admin WHERE admin_id='"+admin_id+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				return false;
			}
			return true;
		} catch(SQLException e){
			System.out.println("differentAdmin_id 실패");
			return false;
		} finally{
			disConnect();
		} 
	}
}
