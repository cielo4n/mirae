package health.database;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

//Ʈ���̳� �����ͺ��̽��� �����ϴ� DAO(Data Access Object)Ŭ����
public class TrainerDao {

	//�����ϰ� �ڱ� �ڽ��� ������ �� �ִ� ����
	private static TrainerDao instance; 
	
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
	private TrainerDao(){
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
	public static TrainerDao getInstance() {
		if(instance == null) //���������� null�� ���� ������ ȣ��
			instance = new TrainerDao();
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
	
	//Ʈ���̳� ��ȸ(����), ���̺��� �����ϰ� DefaultTableModel�� ��ȯ
	//�ｺ�忡 �ش��ϴ� Ʈ���̳� ��ȸ
	public DefaultTableModel selectTrainerAll(String gym_id){
		String colNames[] = {"Ʈ���̳ʹ�ȣ", "�̸�", "�������", "����ó", "�ּ�"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0){
			 public boolean isCellEditable(int row, int column) //����Ŭ����(�ڽ�)�� �������̵�
	         {
	            return false; //�����Ұ�
	         }
		};
		
		try{
			stmt = conn.createStatement();
			sql = "SELECT trainer_no, trainer_name, trainer_birth, trainer_tel, trainer_addr FROM trainer WHERE gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				model.addRow(new Object[]{
						rs.getInt("trainer_no"), rs.getString("trainer_name"), rs.getDate("trainer_birth"), 
						rs.getString("trainer_tel"), rs.getString("trainer_addr")
				});
			}
			return model;
		} catch(SQLException e){
			System.out.println("selectTrainer ����");
			e.printStackTrace();
			return null;
		}
 		finally{
			disConnect();
		}
	}

	//Ʈ���̳� ��ȸ(�̸� �˻�)
	//�ｺ�忡 �ش��ϴ� Ʈ���̳� ��ȸ
	public DefaultTableModel selectTrainerSearch(String gym_id, String trainer_name){
		String colNames[] = {"Ʈ���̳ʹ�ȣ", "�̸�", "�������", "����ó", "�ּ�"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0){
			 public boolean isCellEditable(int row, int column) //����Ŭ����(�ڽ�)�� �������̵�
	         {
	            return false; //�����Ұ�
	         }
		};
		
		try{
			stmt = conn.createStatement();
			sql = "SELECT trainer_no, trainer_name, trainer_birth, trainer_tel, trainer_addr FROM trainer WHERE trainer_name LIKE '"+trainer_name+"%' AND gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				model.addRow(new Object[]{
						rs.getInt("trainer_no"), rs.getString("trainer_name"), rs.getDate("trainer_birth"), 
						rs.getString("trainer_tel"), rs.getString("trainer_addr")
				});
			}
			return model;
		} catch(SQLException e){
			System.out.println("trainerMember ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//�޺��ڽ��� �� Ʈ���̳��̸� ��ȸ
	public DefaultComboBoxModel<String> trainerCombo(String gym_id){
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		try{   //Ʈ���̳� ��ȣ, Ʈ���̳� ��ȣ�� �޺��ڽ� ����
			stmt = conn.createStatement();
			sql = "SELECT trainer_no, trainer_name FROM trainer WHERE gym_id='"+gym_id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				model.addElement(rs.getString("trainer_no")+"��"+rs.getString("trainer_name"));
			}
			return model;
		} catch(SQLException e){
			System.out.println("trainerCombo ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//�ؽ�Ʈ�� �� Ʈ���̳��� ���ȸ�� �̸� ��ȸ
	public String selectTrainerMem(int trainer_no){
		String str="";
		int i=0;
		try{
			stmt = conn.createStatement();
			sql = "SELECT mem_no, mem_name FROM member WHERE trainer_no='"+trainer_no+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				if(i != 0) str+="\n"; 
				str += rs.getString("mem_no");
				str +="��";
				str += rs.getString("mem_name");
				i++;
			}
			return str;
		} catch(SQLException e){
			System.out.println("selectTrainerMem ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//Ʈ���̳� �󼼺���
	public TrainerDto selectTrainer(int trainer_no){
		TrainerDto td;
		
		try{
			stmt = conn.createStatement();
			sql = "SELECT trainer_no, trainer_name, trainer_tel, trainer_addr, trainer_birth, trainer_gender, trainer_career FROM trainer WHERE trainer_no='"+trainer_no+"'";
			rs = stmt.executeQuery(sql);
			
			td = new TrainerDto();
			while(rs.next()){
				td.setTrainer_no(rs.getInt("trainer_no"));
				td.setTrainer_name(rs.getString("trainer_name"));
				td.setTrainer_tel(rs.getString("trainer_tel"));
				td.setTrainer_addr(rs.getString("trainer_addr"));
				td.setTrainer_birth(rs.getDate("trainer_birth"));
				td.setTrainer_gender(rs.getString("trainer_gender"));
				td.setTrainer_career(rs.getInt("trainer_career"));	
			}
			return td;
		} catch(SQLException e){
			System.out.println("selectTrainer ����");
			e.printStackTrace();
			return null;
		} finally{
			disConnect();
		}
	}
	
	//Ʈ���̳� ���
	public boolean insertTrainer(TrainerDto td){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			sql = "INSERT INTO trainer VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, td.getTrainer_name());
			pstmt.setString(2, td.getTrainer_tel());
			pstmt.setString(3, td.getTrainer_addr());
			pstmt.setString(4, sdf.format(td.getTrainer_birth()));
			pstmt.setString(5, td.getTrainer_gender());
			pstmt.setInt(6, td.getTrainer_career());
			pstmt.setString(7, td.getGym_id());
			
			int result = pstmt.executeUpdate();
			
			if(result==1) 
				return true;
			else 
				return false;
			
		} catch(SQLException e){
			System.out.println("insertTrainer ����");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}
	
	//Ʈ���̳� ����
	public boolean updateTrainer(TrainerDto td){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try{
			sql = "UPDATE trainer SET trainer_name=?, trainer_tel=?, trainer_addr=?, trainer_birth=?, trainer_gender=?, trainer_career=? WHERE trainer_no=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, td.getTrainer_name());
			pstmt.setString(2, td.getTrainer_tel());
			pstmt.setString(3, td.getTrainer_addr());
			pstmt.setString(4, sdf.format(td.getTrainer_birth()));
			pstmt.setString(5, td.getTrainer_gender());
			pstmt.setInt(6, td.getTrainer_career());
			pstmt.setInt(7, td.getTrainer_no());
			
			int result = pstmt.executeUpdate();
			
			if(result==1) 
				return true;
			else 
				return false;
			
		} catch(SQLException e){
			System.out.println("updateTrainer ����");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}

	//Ʈ���̳� �����ϴ� �κ�
	public boolean deleteTrainer(int trainer_no){
		try{
			stmt = conn.createStatement();
			sql = "DELETE FROM trainer WHERE trainer_no="+trainer_no;
			
			int result = stmt.executeUpdate(sql);
			
			if(result == 1) return true;
			else return false;
		} catch(SQLException e){
			System.out.println("deleteTrainer ����");
			e.printStackTrace();
			return false;
		} finally{
			disConnect();
		}
	}
}