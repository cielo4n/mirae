package health.ui;

import health.database.GymDao;
import health.value.StaticValues;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//관리자 화면에서 헬스장 상세보기 버튼 클릭시 나오는 다이얼로그
public class ASHealthViewDialog extends JDialog implements ActionListener{
	private JPanel contentPane;
	private JTextField tf_admin_health_number;
	private JTextField tf_admin_health_name;
	private JTextField tf_admin_health_phone;
	private JTextField tf_admin_health_id;
	private JPasswordField passwordField;
	private JTextField tf_admin_health_address;
	private JButton btn_healthview_ok;
	private JButton btn_healthview_delete;
	
	public ASHealthViewDialog() {
		setResizable(false);
		setModal(true);
		setTitle("헬스장 상세보기");
		setBounds(100, 100, 300, 374);
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
		lb_admin_health_address.setBounds(12, 176, 57, 15);
		layeredPane.add(lb_admin_health_address);

		JLabel lb_admin_health_phone = new JLabel("전화번호");
		lb_admin_health_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_admin_health_phone.setBounds(12, 206, 69, 15);
		layeredPane.add(lb_admin_health_phone);

		btn_healthview_ok = new JButton("확인");
		btn_healthview_ok.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_healthview_ok.addActionListener(this); //리스너로 연결
		btn_healthview_ok.setBounds(39, 272, 82, 34);
		layeredPane.add(btn_healthview_ok);

		tf_admin_health_number = new JTextField();
		tf_admin_health_number.setEnabled(false);
		tf_admin_health_number.setBounds(122, 114, 135, 21);
		layeredPane.add(tf_admin_health_number);
		tf_admin_health_number.setColumns(10);

		tf_admin_health_name = new JTextField();
		tf_admin_health_name.setEnabled(false);
		tf_admin_health_name.setColumns(10);
		tf_admin_health_name.setBounds(122, 148, 135, 21);
		layeredPane.add(tf_admin_health_name);

		tf_admin_health_phone = new JTextField();
		tf_admin_health_phone.setEnabled(false);
		tf_admin_health_phone.setColumns(10);
		tf_admin_health_phone.setBounds(103, 204, 154, 22);
		layeredPane.add(tf_admin_health_phone);

		tf_admin_health_id = new JTextField();
		tf_admin_health_id.setEnabled(false);
		tf_admin_health_id.setBounds(122, 26, 135, 21);
		layeredPane.add(tf_admin_health_id);
		tf_admin_health_id.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEnabled(false);
		passwordField.setBounds(122, 53, 135, 21);
		layeredPane.add(passwordField);

		btn_healthview_delete = new JButton("헬스장 삭제");
		btn_healthview_delete.addActionListener(this); //리스너로 연결
		btn_healthview_delete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_healthview_delete.setBounds(134, 272, 104, 34);
		layeredPane.add(btn_healthview_delete);

		tf_admin_health_address = new JTextField();
		tf_admin_health_address.setBounds(52, 176, 205, 21);
		layeredPane.add(tf_admin_health_address);
		tf_admin_health_address.setEnabled(false);
		tf_admin_health_address.setColumns(10);
		
		//헬스장 상세보기
		//헬스장아이디에 해당하는 정보를 저장
		StaticValues.setSvGymDto(GymDao.getInstance().selectGym(StaticValues.getSvGym_id()));
		
		tf_admin_health_id.setText(StaticValues.getSvGymDto().getGym_id());
		passwordField.setText(StaticValues.getSvGymDto().getGym_pw());;
		tf_admin_health_number.setText(StaticValues.getSvGymDto().getBusiness_no());
		tf_admin_health_name.setText(StaticValues.getSvGymDto().getGym_name());
		tf_admin_health_phone.setText(StaticValues.getSvGymDto().getGym_tel());
		tf_admin_health_address.setText(StaticValues.getSvGymDto().getGym_addr());
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_healthview_ok){ //확인
			//확인 누르면 닫힘
			dispose();
		}
		else if(obj == btn_healthview_delete){ //헬스장 삭제
			 // 누르면 헬스장삭제 코멘트가나오고 헬스장이 삭제되는이벤트
			 if(WarningMessage.healthDelete() == true){
				 GymDao.getInstance().deleteGym(StaticValues.getSvGymDto().getGym_id());
				 WarningMessage.healthDeleteOK();
				 dispose();
				 
			 } else {
				 WarningMessage.healthDeleteCancel();
			 }
		}
	}
}