package health.ui;

import health.database.TrainerDao;
import health.database.TrainerDto;
import health.value.StaticValues;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

//트레이너 수정하는 다이얼로그
public class HSTrainerUpdateDialog extends JDialog implements ActionListener {
	private JTextField tf_trainerupdate_name;
	private JTextField tf_trainerupdate_phone;
	private JTextField tf_trainerupdate_address;
	private JTextField tf_trainerupdate_year;
	private JTextField tf_trainerupdate_career;
	private JTextField tf_trainerupdate_number;

	private JButton btn_trainerupdate_ok;
	private JButton btn_trainerupdate_cancel;
	private JButton btn_trainerupdate_delete;

	private JComboBox cb_trainerupdate_gender;
	private JComboBox cb_trainerupdate_month;
	private JComboBox cb_trainerupdate_day;

	public HSTrainerUpdateDialog(HealthScreen owner) { // 여기
		super(owner);
		setResizable(false);
		setModal(true);

		setTitle("트레이너 수정");

		setBounds(100, 100, 460, 410);
		setLocationRelativeTo(null);

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		JLabel lb_trainerupdate_name = new JLabel("이름");
		lb_trainerupdate_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_name.setBounds(12, 58, 48, 18);
		layeredPane.add(lb_trainerupdate_name);

		JLabel lb_trainerupdate_phone = new JLabel("연락처");
		lb_trainerupdate_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_phone.setBounds(12, 93, 48, 18);
		layeredPane.add(lb_trainerupdate_phone);

		JLabel lb_trainerupdate_address = new JLabel("주소");
		lb_trainerupdate_address.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_address.setBounds(12, 136, 41, 15);
		layeredPane.add(lb_trainerupdate_address);

		JLabel lb_trainerupdate_birth = new JLabel("생년월일");
		lb_trainerupdate_birth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_birth.setBounds(12, 172, 68, 24);
		layeredPane.add(lb_trainerupdate_birth);

		JLabel lb_trainerupdate_career = new JLabel("경 력");
		lb_trainerupdate_career.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_career.setBounds(12, 258, 57, 15);
		layeredPane.add(lb_trainerupdate_career);

		JLabel lb_trainerupdate_gender = new JLabel("성별");
		lb_trainerupdate_gender.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_gender.setBounds(12, 218, 48, 18);
		layeredPane.add(lb_trainerupdate_gender);

		tf_trainerupdate_name = new JTextField();
		tf_trainerupdate_name.setColumns(10);
		tf_trainerupdate_name.setBounds(107, 58, 50, 21);
		layeredPane.add(tf_trainerupdate_name);

		tf_trainerupdate_phone = new JTextField();
		tf_trainerupdate_phone.setColumns(10);
		tf_trainerupdate_phone.setBounds(107, 92, 100, 21);
		layeredPane.add(tf_trainerupdate_phone);

		tf_trainerupdate_address = new JTextField();
		tf_trainerupdate_address.setColumns(10);
		tf_trainerupdate_address.setBounds(107, 131, 306, 25);
		layeredPane.add(tf_trainerupdate_address);

		tf_trainerupdate_year = new JTextField();
		tf_trainerupdate_year.setColumns(10);
		tf_trainerupdate_year.setBounds(107, 173, 41, 24);
		layeredPane.add(tf_trainerupdate_year);

		tf_trainerupdate_career = new JTextField();
		tf_trainerupdate_career.setColumns(10);
		tf_trainerupdate_career.setBounds(107, 254, 25, 24);
		layeredPane.add(tf_trainerupdate_career);

		JButton btn_health_memberupdate = new JButton("취 소");
		btn_health_memberupdate.setBounds(242, 566, 93, 36);
		layeredPane.add(btn_health_memberupdate);

		JButton btn_health_member_update = new JButton("확 인");
		btn_health_memberupdate.setBounds(113, 566, 93, 36);
		layeredPane.add(btn_health_member_update);

		JLabel lb_trainerbirth_year = new JLabel("년");
		lb_trainerbirth_year.setHorizontalAlignment(SwingConstants.CENTER);
		lb_trainerbirth_year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_trainerbirth_year.setBounds(141, 173, 35, 24);
		layeredPane.add(lb_trainerbirth_year);

		JLabel lb_trainerbirth_month = new JLabel("월");
		lb_trainerbirth_month.setHorizontalAlignment(SwingConstants.CENTER);
		lb_trainerbirth_month.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_trainerbirth_month.setBounds(219, 173, 35, 24);
		layeredPane.add(lb_trainerbirth_month);

		JLabel lb_trainerbirth_day = new JLabel("일");
		lb_trainerbirth_day.setHorizontalAlignment(SwingConstants.CENTER);
		lb_trainerbirth_day.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_trainerbirth_day.setBounds(294, 173, 35, 24);
		layeredPane.add(lb_trainerbirth_day);

		btn_trainerupdate_ok = new JButton("확 인");
		btn_trainerupdate_ok.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_trainerupdate_ok.setBounds(37, 323, 97, 23);
		btn_trainerupdate_ok.addActionListener(this);
		layeredPane.add(btn_trainerupdate_ok);

		JLabel lb_trainerupdate_number = new JLabel("트레이너 번호");
		lb_trainerupdate_number.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerupdate_number.setBounds(12, 23, 83, 18);
		layeredPane.add(lb_trainerupdate_number);

		tf_trainerupdate_number = new JTextField();
		tf_trainerupdate_number.setEnabled(false);
		tf_trainerupdate_number.setColumns(10);
		tf_trainerupdate_number.setBounds(107, 20, 20, 21);
		layeredPane.add(tf_trainerupdate_number);

		btn_trainerupdate_cancel = new JButton("취소");
		btn_trainerupdate_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_trainerupdate_cancel.setBounds(172, 323, 97, 23);
		btn_trainerupdate_cancel.addActionListener(this);
		layeredPane.add(btn_trainerupdate_cancel);

		btn_trainerupdate_delete = new JButton("트레이너 삭제");
		btn_trainerupdate_delete.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_trainerupdate_delete.setBounds(301, 323, 131, 23);
		btn_trainerupdate_delete.addActionListener(this);
		layeredPane.add(btn_trainerupdate_delete);

		cb_trainerupdate_month = new JComboBox();
		cb_trainerupdate_month.setModel(new DefaultComboBoxModel(new Object[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		cb_trainerupdate_month.setBounds(172, 173, 50, 24);
		layeredPane.add(cb_trainerupdate_month);

		cb_trainerupdate_day = new JComboBox();
		cb_trainerupdate_day.setModel(new DefaultComboBoxModel(new Object[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }));
		cb_trainerupdate_day.setBounds(250, 173, 50, 24);
		layeredPane.add(cb_trainerupdate_day);

		cb_trainerupdate_gender = new JComboBox();
		cb_trainerupdate_gender.setModel(new DefaultComboBoxModel(new String[] {
				"남성", "여성" }));
		cb_trainerupdate_gender.setBounds(107, 216, 50, 24);
		layeredPane.add(cb_trainerupdate_gender);

		JLabel lb_trainerupdate_year1 = new JLabel("년");
		lb_trainerupdate_year1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_trainerupdate_year1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_trainerupdate_year1.setBounds(130, 252, 35, 24);
		layeredPane.add(lb_trainerupdate_year1);

		// 있던 값 읽음
		tf_trainerupdate_number.setText(String.valueOf(StaticValues
				.getSvTrainerDto().getTrainer_no()));
		tf_trainerupdate_name.setText(StaticValues.getSvTrainerDto()
				.getTrainer_name());
		tf_trainerupdate_phone.setText(StaticValues.getSvTrainerDto()
				.getTrainer_tel());
		tf_trainerupdate_address.setText(StaticValues.getSvTrainerDto()
				.getTrainer_addr());

		// Date에서 년월일 뽑음
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String Trainer_birth = sdf.format(StaticValues.getSvTrainerDto()
				.getTrainer_birth());
		String year = Trainer_birth.substring(0, 4);
		int month = Integer.parseInt(Trainer_birth.substring(5, 7));
		int day = Integer.parseInt(Trainer_birth.substring(8, 10));

		// 뽑아진 년월일을 텍스트 필드에 뿌림
		tf_trainerupdate_year.setText(year);
		cb_trainerupdate_month.setSelectedItem(month); // 콤보박스일
		cb_trainerupdate_day.setSelectedItem(day);

		// 나머지도 텍스트필드에 넣음
		cb_trainerupdate_gender.setSelectedItem(StaticValues.getSvTrainerDto()
				.getTrainer_gender());
		tf_trainerupdate_career.setText(String.valueOf(StaticValues
				.getSvTrainerDto().getTrainer_career()));
		setVisible(true); // 여기
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if (obj == btn_trainerupdate_ok) { //확인 버튼 누르면
			TrainerDto td;
			int trainer_year;
			int trainer_career; 
			int chkday;
			
			//입력된 회원정보를 가져옴
			String trainer_name = tf_trainerupdate_name.getText();
			String trainer_tel = tf_trainerupdate_phone.getText();
			String trainer_addr = tf_trainerupdate_address.getText();

			try { //생년월일의 연도가 숫자로 입력되었는지 유효성 검사
				trainer_year = Integer.parseInt(tf_trainerupdate_year.getText());
			} catch (Exception ie) { //숫자로 입력된 게 아닌 경우
				WarningMessage.inputYearFailure();
				return;
			}
			
			int trainer_month = (Integer) cb_trainerupdate_month.getSelectedItem();
			int trainer_day = (Integer) cb_trainerupdate_day.getSelectedItem();

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
			
			int trainer_no = Integer.parseInt(tf_trainerupdate_number.getText());
			String trainer_gender = (String) cb_trainerupdate_gender.getSelectedItem();
			
			try { //경력이 숫자로 입력되었는지 유효성검사
				trainer_career = Integer.parseInt(tf_trainerupdate_career	.getText());
			} catch (Exception ie) { //숫자로 입력된 게 아닌 경우
				WarningMessage.inputCareerFailure();
				return;
			}

			//입력된 정보를 트레이너 객체에 저장한다
			td = new TrainerDto(StaticValues.getSvGym_id(), trainer_no,
					trainer_name, trainer_tel, trainer_addr, trainer_year,
					trainer_month, trainer_day, trainer_gender, trainer_career);
	
			//트레이너 객체로 데이터 베이스 수정
			if (TrainerDao.getInstance().updateTrainer(td) == true)
				WarningMessage.trainerUpdateSuccess(); //수정 성공 알림
			
			dispose(); //창 닫음
		} 
		
		else if (obj == btn_trainerupdate_cancel) { //취소 버튼 누르면
			dispose(); //창 닫음
		} 
		
		else if (obj == btn_trainerupdate_delete) { //삭제 버튼 누르면
			//현재 보고있는 정보의 트레이너가 삭제됨

			//삭제할 거냐고 물어보는 JOptionPane다이얼로그 띄움
			if (WarningMessage.trainerDelete() == true) { //삭제한다고 하면
				
				//데이터베이스에서 트레이너 삭제
				TrainerDao.getInstance().deleteTrainer(
						StaticValues.getSvTrainerDto().getTrainer_no());
				
				WarningMessage.trainerDeleteOK(); //삭제됨 알림
				dispose(); //창 닫음
				
			} else { //삭제 안한다고 하면
				WarningMessage.trainerDeleteCancel(); //삭제취소됨 알림
			}
		}
	}
}
