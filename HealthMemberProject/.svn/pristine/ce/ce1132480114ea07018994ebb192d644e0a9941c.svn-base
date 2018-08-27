package health.ui;

import health.database.GymDao;
import health.database.GymDto;
import health.value.StaticValues;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

//관리자 화면에서 헬스장 등록버튼 클릭시 나오는 다이얼로그
public class ASHealthJoinDialog extends JDialog implements ActionListener{
	
	private JPanel contentPane;
	private JTextField tf_admin_health_number;
	private JTextField tf_admin_health_name;
	private JTextField tf_admin_health_phone;
	private JTextField tf_admin_health_id;
	private JPasswordField tf_admin_health_pw;
	private JPasswordField tf_admin_health_rpw;
	private JTextField tf_admin_health_address;

	private JButton btn_healthregister_ok;
	private JButton btn_healthregister_cancel;
	
	public ASHealthJoinDialog(AdminScreen owner) {
		super(owner);
		setResizable(false);
		setModal(true);
		setTitle("헬스장 등록");
		setBounds(100, 100, 300, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lb_admin_health_id = new JLabel("아이디");
		lb_admin_health_id.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_id.setBounds(12, 29, 57, 15);
		layeredPane.add(lb_admin_health_id);

		JLabel lb_admin_health_pw = new JLabel("패스워드");
		lb_admin_health_pw.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_pw.setBounds(12, 54, 69, 15);
		layeredPane.add(lb_admin_health_pw);

		JLabel lb_admin_health_number = new JLabel("사업자 등록번호");
		lb_admin_health_number.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_number.setBounds(12, 113, 95, 22);
		layeredPane.add(lb_admin_health_number);

		JLabel lb_admin_health_name = new JLabel("헬스장 이름");
		lb_admin_health_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_name.setBounds(12, 151, 69, 15);
		layeredPane.add(lb_admin_health_name);

		JLabel lb_admin_health_address = new JLabel("주소");
		lb_admin_health_address.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_address.setBounds(12, 190, 57, 15);
		layeredPane.add(lb_admin_health_address);

		JLabel lb_admin_health_phone = new JLabel("전화번호");
		lb_admin_health_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_phone.setBounds(12, 225, 69, 15);
		layeredPane.add(lb_admin_health_phone);

		btn_healthregister_ok = new JButton("확인");
		btn_healthregister_ok.addActionListener(this);
				
		btn_healthregister_ok.setBounds(35, 321, 82, 34);
		layeredPane.add(btn_healthregister_ok);

		btn_healthregister_cancel = new JButton("취소");
		btn_healthregister_cancel.addActionListener(this);
		btn_healthregister_cancel.setBounds(156, 321, 82, 34);
		layeredPane.add(btn_healthregister_cancel);

		tf_admin_health_number = new JTextField();
		tf_admin_health_number.setBounds(122, 114, 150, 21);
		layeredPane.add(tf_admin_health_number);
		tf_admin_health_number.setColumns(10);

		tf_admin_health_name = new JTextField();
		tf_admin_health_name.setColumns(10);
		tf_admin_health_name.setBounds(122, 148, 150, 21);
		layeredPane.add(tf_admin_health_name);

		tf_admin_health_phone = new JTextField();
		tf_admin_health_phone.setColumns(10);
		tf_admin_health_phone.setBounds(103, 223, 169, 22);
		layeredPane.add(tf_admin_health_phone);

		tf_admin_health_id = new JTextField();
		tf_admin_health_id.setBounds(122, 26, 150, 21);
		layeredPane.add(tf_admin_health_id);
		tf_admin_health_id.setColumns(10);

		JLabel lb_admin_health_rpw = new JLabel("패스워드 재입력");
		lb_admin_health_rpw.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_rpw.setBounds(12, 79, 105, 15);
		layeredPane.add(lb_admin_health_rpw);

		tf_admin_health_pw = new JPasswordField();
		tf_admin_health_pw.setBounds(122, 51, 150, 22);
		layeredPane.add(tf_admin_health_pw);

		tf_admin_health_rpw = new JPasswordField();
		tf_admin_health_rpw.setBounds(122, 76, 150, 22);
		layeredPane.add(tf_admin_health_rpw);

		tf_admin_health_address = new JTextField();
		tf_admin_health_address.setBounds(52, 188, 220, 21);
		layeredPane.add(tf_admin_health_address);
		tf_admin_health_address.setColumns(10);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_healthregister_cancel){ //취소 누르면
			dispose(); //창 닫힘
		}
		else if(obj == btn_healthregister_ok){ 
			// 확인 누르면 헬스장이 등록되는이벤트
			String gym_id = tf_admin_health_id.getText();
			String gym_pw = new String(tf_admin_health_pw.getPassword());
			String gym_rpw = new String(tf_admin_health_rpw.getPassword());
			String business_no = tf_admin_health_number.getText();
			String gym_name = tf_admin_health_name.getText();
			String gym_tel = tf_admin_health_phone.getText();
			String gym_addr = tf_admin_health_address.getText();
			
			if(gym_id.equals("") || gym_pw.equals("") || gym_rpw.equals("") || business_no.equals("")
					|| gym_name.equals("") || gym_tel.equals("") || gym_addr.equals("")){
				WarningMessage.blankWarning(); //공백 검사
				
			} else if(gym_pw.equals(gym_rpw)==false){
				WarningMessage.notSamePassward(); //비밀번호 재입력이 비밀번호와 다름
				
			} else if(GymDao.getInstance().differentGym_id(gym_id)==false){
				WarningMessage.duplicationWarning(); //아이디 중복 검사
				
			} else {
				//헬스장 등록
				GymDto gd = new GymDto(gym_id, gym_pw, business_no, gym_name, gym_tel, gym_addr);
				GymDao.getInstance().insertGym(StaticValues.getSvAdmin_id(), gd);
				WarningMessage.healthJoin();
				dispose();
			}
		}
	}
}