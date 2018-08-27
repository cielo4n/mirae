package health.database;

import java.sql.*;

/*
 * ������ ���̽� Ŭ������ �̱��� �������� �����Ѵ�.
 * �̱��� ������ �ν��Ͻ��� �ϳ��� ������ �δ� ������ 
 * ��ü ������ �ѹ��� �����ϰ� �� ��ü�� �����ϴ� ������ ����Ѵ�
 * 
 * �̱��� ���� ��� ���
 * 1. �������� ���������ڴ� �ٸ� Ŭ�������� ������ �� ������ private�� �Ѵ�
 * 2. �ڱ��ڽ��� ��ü�� static ������ �����Ѵ�.
 * 3. ���� ��ü�� �������� ���� �޼ҵ带 �����.
 * (���������� �������� instance, �޼ҵ���� getInstance�� �Ѵ�)
 */

//������ �α��� �����ͺ��̽��� �����ϴ� DAO(Data Access Object)Ŭ����
public class AdminDao {
	
	//�����ϰ� �ڱ� �ڽ��� ������ �� �ִ� ����
	private static AdminDao instance; 
	
	//�����ͺ��̽� ����
	private static final String DBName="healthdb"; //�����ͺ��̽��̸��� �̰ŷ� �Ѵ�
	private static final String DBUser = "root";
	private static final String DBPassword = "123456";
	
	private String url= "jdbc:mysql://localhost/"+DBName;
	private String jdbc_driver = "com.mysql.jdbc.Driver";
	
	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	private static String sql = null;
	
	//private �����ڿ��� ����̹� �ε�, Connection ����
	private AdminDao(){
		try{
			Class.forName(jdbc_driver); //����̹� �ε�
			conn = DriverManager.getConnection(url, DBUser, DBPassword); //Connection ����
		} catch(ClassNotFoundException e){
			System.out.println("����̹��� ã�� �� �����ϴ�");
		} catch(SQLException e) {
			System.out.println("Connection ���� ����");
		} 
	}
	
	//public �ڱ� ��ȯ�ϴ� �޼ҵ�
	public static AdminDao getInstance() { //�ڱ��ڽ��� �����ϴ� ���� ����
		if(instance == null) //���������� null�� ���� ������
			instance = new AdminDao();
		return instance;
	}
	
	//���� ����
	private void disConnect(){
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close(); ������ ��� �����ٰ� �ߴٰ� �ϸ� ������
		} catch(SQLException e) {
			System.out.println("���� �ȵ�");
			e.printStackTrace();
		}
	}
	
	//������ ���̵�, ��й�ȣ ��ȸ�ؼ� ���ϴ� ���
	public boolean compareAdmin(String admin_id, String admin_pw){
		try{
			stmt = conn.createStatement();
			sql = "SELECT * FROM login_admin";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				//���̵� �н����� �� �ʿ�
				if(rs.getString("admin_id").equals(admin_id)){
						if(rs.getString("admin_pw").equals(admin_pw))
						{
							return true;
						}
				}
			}
			return false;
		} catch(SQLException e){
			System.out.println("compareAdmin ����");
			e.printStackTrace();
		} finally{
			disConnect();
		}
		return false;
	}
	
	//������ ����ϴ� �κ�
	public boolean insertAdmin(String admin_id, String admin_pw){
		try{
			sql = "INSERT INTO login_admin VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql); //�̸� ���� ����
			pstmt.setString(1, admin_id); //����ǥ�� 1���� ����, �������� �� ����
			pstmt.setString(2, admin_pw);
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException e){
			System.out.println("insertLoginAdmin ����");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}

	//������ ���̵� �ߺ��˻�, ���� ���̵� �ֳ� Ȯ��
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
			System.out.println("differentAdmin_id ����");
			return false;
		} finally{
			disConnect();
		} 
	}
}