package health.database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

//등록 데이터베이스에 접근하는 DAO(Data Access Object)클래스
public class RegDao {
		//유일하게 자기 자신을 참조할 수 있는 변수
		private static RegDao instance; 
		
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
		private RegDao(){
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
		public static RegDao getInstance() { //자기자신을 참조하는 변수 리턴
			if(instance == null) //참조변수가 null일 때는 생성함
				instance = new RegDao();
			return instance;
		}
		
		//연결 종료
		private void disConnect(){
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
//				if(conn != null) conn.close();
			} catch(SQLException e) {
				System.out.println("종료 안됨");
				e.printStackTrace();
			}
		}
		
		//헬스 기간 등록 부분
		public boolean insertReg(String gym_id, int mem_no, RegDto g){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try{
				sql = "INSERT INTO reg VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql); //미리 쿼리 보냄
				pstmt.setString(1, sdf.format(g.getReg_date()));
				pstmt.setString(2, sdf.format(g.getEnd_date()));
				pstmt.setInt(3, g.getYear());
				pstmt.setInt(4, g.getMonth());
				pstmt.setInt(5, mem_no);
				pstmt.setString(6, gym_id);
				pstmt.setInt(7, g.getReg_term());
				int result = pstmt.executeUpdate();
				
				if(result == 1) {
					return true;
				} else {
					return false;
				}
				
			} catch(SQLException e){
				System.out.println("insertReg 실패");
				e.printStackTrace();
				return false;
			} finally{
				disConnect();
			}
		}

		//회원 조회(전부), 테이블에 연결하게 DefaultTableModel을 반환 (Vector와 ArrrayList 이용)
		//헬스장에 해당하는 회원 조회
		public DefaultTableModel selectRegAll(String gym_id){
			String colNames[] = {"등록번호", "회원이름", "등록일", "마감일", "등록개월"};
			String mem_name;
			ArrayList <Vector> arrlist = new ArrayList<Vector>();
			
			DefaultTableModel model = new DefaultTableModel(colNames, 0){
				 public boolean isCellEditable(int row, int column) //무명클래스(자식)을 오버라이딩
		         {
		            return false; //테이블을 수정불가능하게 변경함
		         }
			};
			
			try{
				stmt = conn.createStatement();
				sql = "SELECT reg.reg_no, member.mem_name, reg.reg_date, reg.end_date, reg.reg_term FROM reg LEFT JOIN member ON reg.mem_no=member.mem_no WHERE reg.gym_id='"+gym_id+"'";
				rs = stmt.executeQuery(sql);
				
				//테이블모델에 저장하기 위해 벡터로 데이터베이스를 저장하는 방법
				while(rs.next()){
					//1) 벡터에 행 하나를 저장한다
					Vector<Object> vt = new Vector<Object>();
					vt.add(rs.getInt("reg.reg_no"));
					mem_name = rs.getString("member.mem_name");
					
					if(mem_name == null)
						vt.add("삭제된 회원");
					else
						vt.add(mem_name);
					
					vt.add(rs.getDate("reg.reg_date"));
					vt.add(rs.getString("reg.end_date"));
					vt.add(rs.getString("reg.reg_term"));
					
					//2) 그 행을 어레이리스트에 저장해서 2차원배열처럼 만든다
					arrlist.add(vt);
				}
				
				//3) 어레이리스트의 길이만큼의 행(vector)을 테이블모델에 저장한다.
				for(int i=0; i<arrlist.size(); i++){
					model.addRow(arrlist.get(i));
				}
				
				return model;
			} catch(SQLException e){
				System.out.println("selectRegAll 실패");
				e.printStackTrace();
				return null;
			}
	 		finally{
				disConnect();
			}
		}

		//등록 조회(이름 검색)
		//헬스장에 해당하는 회원 조회
		public DefaultTableModel selectRegSearch(String gym_id, String mem_name){
			String colNames[] = {"등록번호", "회원이름", "등록일", "마감일", "등록개월"};
			DefaultTableModel model = new DefaultTableModel(colNames, 0){
				 public boolean isCellEditable(int row, int column) //무명클래스(자식)을 오버라이딩
		         {
		            return false; //수정불가
		         }
			};
			
			try{
				stmt = conn.createStatement();
				sql = "SELECT reg.reg_no, member.mem_name, reg.reg_date, reg.end_date, reg.reg_term FROM reg LEFT JOIN member ON reg.mem_no=member.mem_no WHERE reg.gym_id = '"+gym_id+"' AND member.mem_name LIKE '"+mem_name+"%'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					model.addRow(new Object[]{
							rs.getInt("reg.reg_no"), rs.getString("member.mem_name"), rs.getDate("reg.reg_date"), 
							rs.getString("reg.end_date"), rs.getString("reg.reg_term")
					});
				}
				return model;
			} catch(SQLException e){
				System.out.println("selectRegSearch 실패");
				e.printStackTrace();
				return null;
			} finally {
				disConnect();
			}
		}
}
