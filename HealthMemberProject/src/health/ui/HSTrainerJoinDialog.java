package health.ui;

import health.database.TrainerDao;
import health.database.TrainerDto;
import health.value.StaticValues;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

//트레이너 등록하는 다이얼로그
public class HSTrainerJoinDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_trainerjoin_name;
	private JTextField tf_trainerjoin_phone;
	private JTextField tf_trainerjoin_birth_year;
	private JTextField tf_trainerjoin_adress;
	private JTextField tf_trainerjoin_year; // 경력
	private JComboBox cb_trainerjoin_gender;
	private JComboBox cb_trainerjoin_month;
	private JComboBox cb_trainerjoin_day;

	private JButton btn_trainerjoin_ok;
	private JButton btn_trainerjoin_cancel;
	
	public HSTrainerJoinDialog(HealthScreen owner) {
		super(owner);
		setTitle("트레이너 등록");
		setBounds(100, 100, 380, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		JLabel lb_trainerjoin_name = new JLabel("이 름");
		lb_trainerjoin_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_name.setBounds(12, 37, 57, 15);
		getContentPane().add(lb_trainerjoin_name);

		JLabel lb_trainerjoin_phone = new JLabel("연락처");
		lb_trainerjoin_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_phone.setBounds(12, 86, 57, 15);
		getContentPane().add(lb_trainerjoin_phone);

		JLabel lb_trainerjoin_address = new JLabel("주 소");
		lb_trainerjoin_address.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_address.setBounds(12, 138, 57, 15);
		getContentPane().add(lb_trainerjoin_address);

		JLabel lb_trainerjoin_birth = new JLabel("생년월일");
		lb_trainerjoin_birth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_birth.setBounds(12, 201, 57, 15);
		getContentPane().add(lb_trainerjoin_birth);

		JLabel lb_trainerjoin_career = new JLabel("성 별");
		lb_trainerjoin_career.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_career.setBounds(12, 256, 57, 15);
		getContentPane().add(lb_trainerjoin_career);

		JLabel lb_trainerjoin_gender = new JLabel("경 력");
		lb_trainerjoin_gender.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_gender.setBounds(12, 308, 57, 15);
		getContentPane().add(lb_trainerjoin_gender);

		tf_trainerjoin_name = new JTextField();
		tf_trainerjoin_name.setBounds(81, 34, 50, 21);
		getContentPane().add(tf_trainerjoin_name);
		tf_trainerjoin_name.setColumns(10);

		tf_trainerjoin_phone = new JTextField();
		tf_trainerjoin_phone.setColumns(10);
		tf_trainerjoin_phone.setBounds(81, 83, 100, 21);
		getContentPane().add(tf_trainerjoin_phone);

		tf_trainerjoin_birth_year = new JTextField();
		tf_trainerjoin_birth_year.setColumns(10);
		tf_trainerjoin_birth_year.setBounds(81, 198, 42, 21);
		getContentPane().add(tf_trainerjoin_birth_year);

		tf_trainerjoin_adress = new JTextField();
		tf_trainerjoin_adress.setColumns(10);
		tf_trainerjoin_adress.setBounds(81, 135, 271, 21);
		getContentPane().add(tf_trainerjoin_adress);

		tf_trainerjoin_year = new JTextField();
		tf_trainerjoin_year.setColumns(10);
		tf_trainerjoin_year.setBounds(81, 305, 42, 21);
		getContentPane().add(tf_trainerjoin_year);

		JLabel lb_trainerjoin_careeryear = new JLabel("년");
		lb_trainerjoin_careeryear.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_careeryear.setBounds(126, 308, 26, 15);
		getContentPane().add(lb_trainerjoin_careeryear);

		cb_trainerjoin_gender = new JComboBox();
		cb_trainerjoin_gender.setModel(new DefaultComboBoxModel(new String[] {
				"\uB0A8\uC131", "\uC5EC\uC131" }));
		cb_trainerjoin_gender.setBounds(81, 253, 57, 21);
		getContentPane().add(cb_trainerjoin_gender);

		JLabel lb_trainerjoin_year = new JLabel("년");
		lb_trainerjoin_year.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_year.setBounds(126, 201, 26, 15);
		getContentPane().add(lb_trainerjoin_year);

		cb_trainerjoin_month = new JComboBox();
		cb_trainerjoin_month
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
						"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cb_trainerjoin_month.setBounds(151, 198, 46, 21);
		getContentPane().add(cb_trainerjoin_month);

		cb_trainerjoin_day = new JComboBox();
		cb_trainerjoin_day.setModel(new DefaultComboBoxModel(new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
				"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		cb_trainerjoin_day.setBounds(240, 198, 57, 21);
		getContentPane().add(cb_trainerjoin_day);

		JLabel lb_trainerjoin_month = new JLabel("월");
		lb_trainerjoin_month.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_month.setBounds(202, 201, 26, 15);
		getContentPane().add(lb_trainerjoin_month);

		JLabel lb_trainerjoin_day = new JLabel("일");
		lb_trainerjoin_day.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerjoin_day.setBounds(304, 201, 26, 15);
		getContentPane().add(lb_trainerjoin_day);

		btn_trainerjoin_ok = new JButton("확 인");
		btn_trainerjoin_ok.addActionListener(this);

		btn_trainerjoin_ok.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_trainerjoin_ok.setBounds(73, 401, 79, 35);
		getContentPane().add(btn_trainerjoin_ok);

		btn_trainerjoin_cancel = new JButton("취 소");
		btn_trainerjoin_cancel.addActionListener(this);
		btn_trainerjoin_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_trainerjoin_cancel.setBounds(202, 401, 79, 35);
		getContentPane().add(btn_trainerjoin_cancel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == btn_trainerjoin_cancel){ //취소버튼 누르면
			setVisible(false); //창 닫힘
		}
		else if(obj == btn_trainerjoin_ok){ //확인버튼 누르면
			int trainer_year = 0;
			int trainer_career = 0;
			int chkday;
			
			// 확인버튼누르면 새트레이너가 등록되는 이벤트
			// 공백확인하고 공백이면 알려줌
			if (tf_trainerjoin_name.getText().equals("") || tf_trainerjoin_phone.getText().equals("")
					|| tf_trainerjoin_adress.getText().equals("") || tf_trainerjoin_birth_year.getText().equals("")
					|| tf_trainerjoin_year.getText().equals("")) {
				WarningMessage.blankWarning();
				return;
			} 
			try { //트레이너 생년월일의 년이 숫자로 입력되었는지 확인
				trainer_year = Integer.parseInt(tf_trainerjoin_birth_year.getText());
			} catch (Exception e) { //숫자가 아니면 예외처리
				WarningMessage.inputYearFailure();
				return;
			}
			try { //트레이너 경력이 숫자로 입력되었는지 확인
				trainer_career = Integer.parseInt(tf_trainerjoin_year.getText());
			} catch (Exception e) { //숫자가 아니면 예외처리
				WarningMessage.inputCareerFailure();
				return;
			}

			String trainer_name = tf_trainerjoin_name.getText();
			String trainer_tel = tf_trainerjoin_phone.getText();
			String trainer_addr = tf_trainerjoin_adress.getText();

			//콤보박스에서 읽어옴
			String trainer_gender = (String) cb_trainerjoin_gender.getSelectedItem();
			int trainer_month = Integer.parseInt((String)cb_trainerjoin_month.getSelectedItem());
			int trainer_day = Integer.parseInt((String) cb_trainerjoin_day.getSelectedItem());

			//날짜가 잘 입력되었나 확인
			chkday = WarningMessage.checkDay(trainer_year, trainer_month, trainer_day);
			if(chkday == 1){
				WarningMessage.inputYearNumFailure1();
				return;
			} else if(chkday == 2){
				WarningMessage.inputYearNumFailure2();
				return;
			} else if(chkday == 3){
				WarningMessage.inputYearNumFailure3();
				return;
			}
			
			//읽어온 정보를 트레이너 객체에 저장
			TrainerDto td = new TrainerDto(trainer_name,	trainer_tel, trainer_addr, trainer_year,
					trainer_month, trainer_day, trainer_gender, trainer_career, StaticValues.getSvGym_id());
			WarningMessage.trainerJoin();
			
			//트레이너 객체를 데이터베이스에 삽입
			TrainerDao.getInstance().insertTrainer(td);
			dispose(); //창 닫음
		}
	}
}
