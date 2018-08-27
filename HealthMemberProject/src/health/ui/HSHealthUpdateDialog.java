package health.ui;

import health.database.GymDao;
import health.database.GymDto;
import health.value.StaticValues;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

//헬스장 정보를 수정하는 다이얼로그
public class HSHealthUpdateDialog extends JDialog implements ActionListener{

	private JTextField tf_healthupdate_id;
	private JTextField tf_healthupdate_name;
	private JTextField tf_healthupdate_number;
	private JTextField tf_healthupdate_phone;
	private JTextField tf_healthupdate_address;
	private JPasswordField tf_healthupdate_pw;
	private JButton btn_healthupdate_ok;
	private JButton btn_healthupdate_cancel;
	
	public HSHealthUpdateDialog(HealthScreen owner){
		super(owner);
		
		setModal(true);
		setResizable(false);
		setTitle("헬스장 정보수정");
		setBounds(100, 100, 400, 450);
		 setLocationRelativeTo(null); //창 가운데로
		getContentPane().setLayout(null);
		{
			JLabel lb_healthupdate_id = new JLabel("아이디");
			lb_healthupdate_id.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_healthupdate_id.setBounds(12, 50, 75, 22);
			getContentPane().add(lb_healthupdate_id);
		}
		{
			JLabel lb_healthupdate_pw = new JLabel("비밀번호");
			lb_healthupdate_pw.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_healthupdate_pw.setBounds(12, 99, 75, 22);
			getContentPane().add(lb_healthupdate_pw);
		}
		{
			JLabel lb_healthupdate_name = new JLabel("헬스장 이름");
			lb_healthupdate_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_healthupdate_name.setBounds(12, 167, 75, 22);
			getContentPane().add(lb_healthupdate_name);
		}
		{
			JLabel lb_healthupdate_number = new JLabel("사업자 등록번호");
			lb_healthupdate_number.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_healthupdate_number.setBounds(12, 211, 96, 22);
			getContentPane().add(lb_healthupdate_number);
		}
		{
			JLabel lb_healthupdate_phone = new JLabel("연락처");
			lb_healthupdate_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_healthupdate_phone.setBounds(12, 254, 75, 22);
			getContentPane().add(lb_healthupdate_phone);
		}
		{
			JLabel lb_healthupdate_address = new JLabel("주소");
			lb_healthupdate_address.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_healthupdate_address.setBounds(12, 297, 75, 22);
			getContentPane().add(lb_healthupdate_address);
		}
		{
			btn_healthupdate_ok = new JButton("확 인");
			btn_healthupdate_ok.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btn_healthupdate_ok.setBounds(76, 362, 97, 23);
			getContentPane().add(btn_healthupdate_ok);
		}
		{
			btn_healthupdate_cancel = new JButton("취 소");
			btn_healthupdate_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btn_healthupdate_cancel.setBounds(205, 362, 97, 23);
			getContentPane().add(btn_healthupdate_cancel);
		}
		{
			tf_healthupdate_id = new JTextField();
			tf_healthupdate_id.setEnabled(false);
			tf_healthupdate_id.setBounds(120, 52, 145, 22);
			getContentPane().add(tf_healthupdate_id);
			tf_healthupdate_id.setColumns(10);
		}
		{
			tf_healthupdate_name = new JTextField();
			tf_healthupdate_name.setColumns(10);
			tf_healthupdate_name.setBounds(120, 169, 145, 22);
			getContentPane().add(tf_healthupdate_name);
		}
		{
			tf_healthupdate_number = new JTextField();
			tf_healthupdate_number.setColumns(10);
			tf_healthupdate_number.setBounds(120, 213, 145, 22);
			getContentPane().add(tf_healthupdate_number);
		}
		{
			tf_healthupdate_phone = new JTextField();
			tf_healthupdate_phone.setColumns(10);
			tf_healthupdate_phone.setBounds(120, 256, 145, 22);
			getContentPane().add(tf_healthupdate_phone);
		}
		{
			tf_healthupdate_address = new JTextField();
			tf_healthupdate_address.setColumns(10);
			tf_healthupdate_address.setBounds(120, 299, 233, 22);
			getContentPane().add(tf_healthupdate_address);
		}
		
		tf_healthupdate_pw = new JPasswordField();
		tf_healthupdate_pw.setEnabled(false);
		tf_healthupdate_pw.setBounds(120, 101, 145, 23);
		getContentPane().add(tf_healthupdate_pw);
		
		btn_healthupdate_ok.addActionListener(this);
		btn_healthupdate_cancel.addActionListener(this);

		//StaticValues에 저장되어 있는 값 불러옴
		tf_healthupdate_id.setText(StaticValues.getSvGymDto().getGym_id());
		tf_healthupdate_name.setText(StaticValues.getSvGymDto().getGym_name());
		tf_healthupdate_number.setText(StaticValues.getSvGymDto().getBusiness_no());
		tf_healthupdate_phone.setText(StaticValues.getSvGymDto().getGym_tel());
		tf_healthupdate_address.setText(StaticValues.getSvGymDto().getGym_addr());
		tf_healthupdate_pw.setText(StaticValues.getSvGymDto().getGym_pw());
		
		setVisible(true); //마지막에 둬야 함
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		Object obj = ae.getSource();
		
		if(obj == btn_healthupdate_ok) { //확인버튼
			// 확인버튼누르면 변경된 헬스장정보가 저장됨
			
			//헬스장 객체 생성하고 정보 넣음
			GymDto gd = new GymDto();
			gd.setGym_id(tf_healthupdate_id.getText());
			gd.setGym_name(tf_healthupdate_name.getText());
			gd.setBusiness_no(tf_healthupdate_number.getText());
			gd.setGym_tel(tf_healthupdate_phone.getText());
			gd.setGym_addr(tf_healthupdate_address.getText());
			gd.setGym_pw(new String(tf_healthupdate_pw.getPassword()));
			
			//위에서 생성한 헬스장 객체를 넣어서 데이터베이스를 수정함
			GymDao.getInstance().updateGym(gd);
			StaticValues.setSvGymDto(gd); //현재 정적변수 값도 바꿈
			WarningMessage.healthUpdateSuccess(); //수정되었다고 알려줌
			dispose(); //창 닫음
			
		} else if(obj == btn_healthupdate_cancel) { //취소버튼
			dispose(); //창 닫음
		}
	}
}
