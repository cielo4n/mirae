package health.database;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

//헬스장 로그인, 헬스장 데이터베이스에 접근하는 DAO(Data Access Object)클래스
public class GymDao {

	//유일하게 자기 자신을 참조할 수 있는 변수
	private static GymDao instance; 
	
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
	
	//private 생성자
	private GymDao(){
		try{
			Class.forName(jdbc_driver); //드라이버 로드
			conn = DriverManager.getConnection(url, DBUser, DBPassword); //Connection 연결
		} catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다");
		} catch(SQLException e) {
			System.out.println("Connection 연결 실패");
		} 
	}
	
	//public 자기자신 반환
	public static GymDao getInstance() {
		if(instance == null) //참조변수가 null일 때는 생성자 호출
			instance = new GymDao();
		return instance;
	}

	//연결 종료
	private void disConnect(){
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close();
		} catch(SQLException e) {
			System.out.println("종료 안됨");
			e.printStackTrace();
		}
	}
	
	//헬스장 등록하는 부분
	public void insertGym(String admin_id, GymDto g){
		try{
			sql = "INSERT INTO login_gym VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getGym_id()); 
			pstmt.setString(2, g.getGym_pw());
			pstmt.setString(3, admin_id);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
			} else {
				System.out.println("login_gym에 삽입 실패");
			}
			
			sql = "INSERT INTO gym VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getGym_id());
			pstmt.setString(2, g.getBusiness_no());
			pstmt.setString(3, g.getGym_name());
			pstmt.setString(4, g.getGym_tel());
			pstmt.setString(5, g.getGym_addr());
			result = pstmt.executeUpdate();
			
			if(result == 1) {
			} else {
				System.out.println("gym에 삽입 실패");
			}
		} catch(SQLException e){
			System.out.println("insertGym 실패");
			e.printStackTrace();
		} finally{
			disConnect();
		}
	}
	
	//헬스장 아이디와 헬스장 비밀번호가 서로 맞는게 있는지 비교하는 메소드
	public boolean compareGym(String gym_id, String gym_pw){
		try{
			stmt = conn.createStatement();
			sql = "SELECT * FROM login_gym";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				//아이디 패스워드 비교 필요
				if(rs.getString("gym_id").equals(gym_id)){
						if(rs.getString("gym_pw").equals(gym_pw))
						{
							return true;
						}
				}
			}
			return false;
		} catch(SQLException e){
			System.out.println("compareGym 실패");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}
	
	//헬스장 삭제하는 부분
	public boolean deleteGym(String gym_id){ 
		try{
			stmt = conn.createStatement();
			sql = "DELETE FROM login_gym WHERE gym_id='"+gym_id+"'";
		
			int result = stmt.executeUpdate(sql);
			
			if(result == 1) {
				return true;  //삭제 성공
			} else {
				return false; //삭제 실패
			}
		} catch(SQLException e){
			System.out.println("deleteGym 실패");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}
	
	//모든 헬스장 조회하는 부분. 테이블에 연결할 수 있게 DefaultTableModel 반환
	//(하나의 관리자에 해당하는 헬스장 조회)
	public DefaultTableModel selectGymAll(String admin_id){
		String colNames[] = {"헬스장 아이디", "사업자 등록 번호", "헬스장 이름", "연락처", "주소"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0){ //(행이름, 열수)
			 public boolean isCellEditable(int row, int column) //무명클래스(자식)을 오버라이딩
	         {
	            return false; //수정불가
	         }
		};
	
		try{
			stmt = conn.createStatement();
			sql = "SELECT login_gym.admin_id, gym.gym_id, gym.business_no, gym.gym_name, gym.gym_tel, gym.gym_addr "
					+ "FROM gym LEFT JOIN login_gym "
					+ "ON login_gym.gym_id=gym.gym_id "
					+ "WHERE login_gym.admin_id='"+admin_id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				model.addRow(new Object[]{
						rs.getString("gym_id"), rs.getString("business_no"),
						rs.getString("gym_name"), rs.getString("gym_tel"),
						rs.getString("gym_addr")
				});
			}
			return model;
		} catch(Exception e) {
			System.out.println("selectGym 실패");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//헬스장 상세보기
	public GymDto selectGym(String gym_id){
		GymDto g = null;
		
		try{
			stmt = conn.createStatement();
			sql = "SELECT * FROM gym LEFT JOIN login_gym ON login_gym.gym_id=gym.gym_id WHERE gym.gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);

			g = new GymDto();

			while(rs.next()){
				g.setGym_id(rs.getString("gym.gym_id"));
				g.setGym_pw(rs.getString("login_gym.gym_pw"));
				g.setBusiness_no(rs.getString("business_no"));
				g.setGym_name(rs.getString("gym_name"));
				g.setGym_tel(rs.getString("gym_tel"));
				g.setGym_addr(rs.getString("gym_addr"));
			}
			return g;
		} catch(SQLException e){
			System.out.println("selectGym 실패");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//헬스장 수정부분
	public boolean updateGym(GymDto g){
		try{
			sql = "UPDATE gym SET gym_name=?, business_no=?, gym_tel=?, gym_addr=? WHERE gym_id='"+g.getGym_id()+"'";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getGym_name());
			pstmt.setString(2, g.getBusiness_no());
			pstmt.setString(3, g.getGym_tel());
			pstmt.setString(4, g.getGym_addr());
			
			int result = pstmt.executeUpdate();

			if(result ==1)
				return true;
			else
				return false;
		} catch(SQLException e){
			System.out.println("updateGym 실패");
			return false;
		} finally{
			disConnect();
		}
	}

	//헬스장 아이디에 해당하는 관리자아이디를 찾는 부분
	public String gym_idToAdmin_id(String gym_id){
		String admin_id = null;
		try{
			stmt = conn.createStatement();
			sql = "SELECT admin_id FROM login_gym WHERE gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				admin_id = rs.getString("admin_id");
			}
			return admin_id;
		}  catch(SQLException e){
			System.out.println("gym_idToAdmin_id 실패");
			return null;
		} finally{
			disConnect();
		}
	}
	
	//헬스장 번호가지고 헬스장 이름 뽑아내는 부분
	public String gym_idToGym_name(String gym_id){
		String gym_name = null;
		try{
			stmt = conn.createStatement();
			sql = "SELECT gym_name FROM gym WHERE gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				gym_name = rs.getString("gym_name");
			}
			return gym_name;
		} catch(SQLException e){
			System.out.println("gym_idToGym_name 실패");
			return null;
		} finally{
			disConnect();
		}
	}
	
	//헬스장 아이디 중복검사, 같은 아이디가 있나 확인
	public boolean differentGym_id(String gym_id){
		try{
			stmt = conn.createStatement();
			sql = "SELECT gym_id FROM gym WHERE gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				return false;
			}
			return true;
		} catch(SQLException e){
			System.out.println("differentGym_id 실패");
			return false;
		} finally{
			disConnect();
		} 
	}
}
