package health.database;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

//�ｺ�� �α���, �ｺ�� �����ͺ��̽��� �����ϴ� DAO(Data Access Object)Ŭ����
public class GymDao {

	//�����ϰ� �ڱ� �ڽ��� ������ �� �ִ� ����
	private static GymDao instance; 
	
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
	
	//private ������
	private GymDao(){
		try{
			Class.forName(jdbc_driver); //����̹� �ε�
			conn = DriverManager.getConnection(url, DBUser, DBPassword); //Connection ����
		} catch(ClassNotFoundException e){
			System.out.println("����̹��� ã�� �� �����ϴ�");
		} catch(SQLException e) {
			System.out.println("Connection ���� ����");
		} 
	}
	
	//public �ڱ��ڽ� ��ȯ
	public static GymDao getInstance() {
		if(instance == null) //���������� null�� ���� ������ ȣ��
			instance = new GymDao();
		return instance;
	}

	//���� ����
	private void disConnect(){
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close();
		} catch(SQLException e) {
			System.out.println("���� �ȵ�");
			e.printStackTrace();
		}
	}
	
	//�ｺ�� ����ϴ� �κ�
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
				System.out.println("login_gym�� ���� ����");
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
				System.out.println("gym�� ���� ����");
			}
		} catch(SQLException e){
			System.out.println("insertGym ����");
			e.printStackTrace();
		} finally{
			disConnect();
		}
	}
	
	//�ｺ�� ���̵�� �ｺ�� ��й�ȣ�� ���� �´°� �ִ��� ���ϴ� �޼ҵ�
	public boolean compareGym(String gym_id, String gym_pw){
		try{
			stmt = conn.createStatement();
			sql = "SELECT * FROM login_gym";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				//���̵� �н����� �� �ʿ�
				if(rs.getString("gym_id").equals(gym_id)){
						if(rs.getString("gym_pw").equals(gym_pw))
						{
							return true;
						}
				}
			}
			return false;
		} catch(SQLException e){
			System.out.println("compareGym ����");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}
	
	//�ｺ�� �����ϴ� �κ�
	public boolean deleteGym(String gym_id){ 
		try{
			stmt = conn.createStatement();
			sql = "DELETE FROM login_gym WHERE gym_id='"+gym_id+"'";
		
			int result = stmt.executeUpdate(sql);
			
			if(result == 1) {
				return true;  //���� ����
			} else {
				return false; //���� ����
			}
		} catch(SQLException e){
			System.out.println("deleteGym ����");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}
	
	//��� �ｺ�� ��ȸ�ϴ� �κ�. ���̺��� ������ �� �ְ� DefaultTableModel ��ȯ
	//(�ϳ��� �����ڿ� �ش��ϴ� �ｺ�� ��ȸ)
	public DefaultTableModel selectGymAll(String admin_id){
		String colNames[] = {"�ｺ�� ���̵�", "����� ��� ��ȣ", "�ｺ�� �̸�", "����ó", "�ּ�"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0){ //(���̸�, ����)
			 public boolean isCellEditable(int row, int column) //����Ŭ����(�ڽ�)�� �������̵�
	         {
	            return false; //�����Ұ�
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
			System.out.println("selectGym ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//�ｺ�� �󼼺���
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
			System.out.println("selectGym ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//�ｺ�� �����κ�
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
			System.out.println("updateGym ����");
			return false;
		} finally{
			disConnect();
		}
	}

	//�ｺ�� ���̵� �ش��ϴ� �����ھ��̵� ã�� �κ�
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
			System.out.println("gym_idToAdmin_id ����");
			return null;
		} finally{
			disConnect();
		}
	}
	
	//�ｺ�� ��ȣ������ �ｺ�� �̸� �̾Ƴ��� �κ�
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
			System.out.println("gym_idToGym_name ����");
			return null;
		} finally{
			disConnect();
		}
	}
	
	//�ｺ�� ���̵� �ߺ��˻�, ���� ���̵� �ֳ� Ȯ��
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
			System.out.println("differentGym_id ����");
			return false;
		} finally{
			disConnect();
		} 
	}
}