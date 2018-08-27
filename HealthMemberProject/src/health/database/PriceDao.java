package health.database;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

//���, ��� �����ͺ��̽��� �����ϴ� DAO(Data Access Object)Ŭ����
public class PriceDao {

	//�����ϰ� �ڱ� �ڽ��� ������ �� �ִ� ����
	private static PriceDao instance; 
	
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
	private PriceDao(){
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
	public static PriceDao getInstance() {
		if(instance == null) //���������� null�� ���� ������ ȣ��
			instance = new PriceDao();
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
	
	//���⺸��(��������) ���̺��� ������ �� �ְ� DefaultTableModel�� ��ȯ
	public DefaultTableModel selectYearPrice(String gym_id){
		String colNames[] = {"����", "����"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0){
			 public boolean isCellEditable(int row, int column) //����Ŭ����(�ڽ�)�� �������̵�
	         {
	            return false; //�����Ұ�
	         }
		};
		
		try{
			stmt = conn.createStatement();
			sql = "SELECT reg.year, SUM(price.price_term) "
					+ "FROM reg LEFT JOIN price ON reg.reg_term=price.reg_term "
					+ "WHERE reg.gym_id='"+gym_id+"' "
					+ "GROUP BY reg.year "
					+ "ORDER BY reg.year ASC";
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				model.addRow(new Object[]{
						rs.getInt("year"), rs.getInt("SUM(price.price_term)")
				});	
			}
			return model;
		} catch(SQLException e) {
			System.out.println("selectYearPrice ����");
			e.printStackTrace();
			return null;
		}  finally{
			disConnect();
		}
	}
	
	//���⺸��(��������)
	public DefaultTableModel selectMonthPrice(String gym_id, int year){
		String colNames[] = {"��", "��", "����"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0){
			 public boolean isCellEditable(int row, int column) //����Ŭ����(�ڽ�)�� �������̵�
	         {
	            return false; //�����Ұ�
	         }
		};
		try{
			stmt = conn.createStatement();
			sql = "SELECT reg.year, reg.month, SUM(price.price_term) FROM reg LEFT JOIN price "
					+ "ON reg.reg_term=price.reg_term "
					+"WHERE reg.gym_id='"+gym_id+"'"
					+ "GROUP BY reg.month HAVING year="+year+
					 " ORDER BY reg.year, reg.month ASC";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				model.addRow(new Object[]{
						rs.getInt("year"), rs.getInt("month"), rs.getInt("SUM(price.price_term)")
				});	
			}
			return model;
			
		} catch(SQLException e) {
			System.out.println("selectMonthPrice ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
}