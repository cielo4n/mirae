package health.ui;

import health.database.TrainerDao;
import health.value.StaticValues;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

//트레이너 상세보기 다이얼로그
public class HSTrainerViewDialog extends JDialog implements ActionListener{
	private JTextField tf_trainer_name;
	private JTextField tf_trainer_phone;
	private JTextField tf_trainer_address;
	private JTextField tf_trainer_year;
	private JTextField tf_trainer_career;
	private JTextField tf_trainer_number;
	private JTextField tf_trainer_month;
	private JTextField tf_trainer_day;
	private JTextField tf_trainer_gender;
	private JTextArea ta_trainer_memverview;
	private JButton btn_trainerview_ok;
	
	public HSTrainerViewDialog() {
		setModal(true);
		setTitle("트레이너 상세보기");

		setBounds(100, 100, 460, 499);
		setLocationRelativeTo(null); //창 가운데로

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		JLabel lb_trainerview_name = new JLabel("이름");
		lb_trainerview_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_name.setBounds(12, 58, 48, 18);
		layeredPane.add(lb_trainerview_name);

		JLabel lb_trainerview_phone = new JLabel("연락처");
		lb_trainerview_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_phone.setBounds(12, 93, 48, 18);
		layeredPane.add(lb_trainerview_phone);

		JLabel lb_trainerview_address = new JLabel("주소");
		lb_trainerview_address.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_address.setBounds(12, 136, 41, 15);
		layeredPane.add(lb_trainerview_address);

		JLabel lb_trainerview_birth = new JLabel("생년월일");
		lb_trainerview_birth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_birth.setBounds(12, 172, 68, 24);
		layeredPane.add(lb_trainerview_birth);

		JLabel lb_trainerview_career = new JLabel("경 력");
		lb_trainerview_career.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_career.setBounds(12, 258, 57, 15);
		layeredPane.add(lb_trainerview_career);

		JLabel lb_trainerview_gender = new JLabel("성별");
		lb_trainerview_gender.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_gender.setBounds(12, 218, 48, 18);
		layeredPane.add(lb_trainerview_gender);

		JLabel lb_trainercareer_year = new JLabel("년");
		lb_trainercareer_year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_trainercareer_year.setBounds(135, 251, 35, 24);
		layeredPane.add(lb_trainercareer_year);

		tf_trainer_name = new JTextField();
		tf_trainer_name.setEnabled(false);
		tf_trainer_name.setColumns(10);
		tf_trainer_name.setBounds(107, 58, 50, 21);
		layeredPane.add(tf_trainer_name);

		tf_trainer_phone = new JTextField();
		tf_trainer_phone.setEnabled(false);
		tf_trainer_phone.setColumns(10);
		tf_trainer_phone.setBounds(107, 92, 100, 21);
		layeredPane.add(tf_trainer_phone);

		tf_trainer_address = new JTextField();
		tf_trainer_address.setEnabled(false);
		tf_trainer_address.setColumns(10);
		tf_trainer_address.setBounds(107, 131, 306, 25);
		layeredPane.add(tf_trainer_address);

		tf_trainer_year = new JTextField();
		tf_trainer_year.setEnabled(false);
		tf_trainer_year.setColumns(10);
		tf_trainer_year.setBounds(107, 173, 30, 24);
		layeredPane.add(tf_trainer_year);

		tf_trainer_career = new JTextField();
		tf_trainer_career.setEnabled(false);
		tf_trainer_career.setColumns(10);
		tf_trainer_career.setBounds(107, 254, 25, 24);
		layeredPane.add(tf_trainer_career);

		JLabel lb_memberupdate_year = new JLabel("년");
		lb_memberupdate_year.setHorizontalAlignment(SwingConstants.CENTER);
		lb_memberupdate_year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_memberupdate_year.setBounds(130, 170, 35, 24);
		layeredPane.add(lb_memberupdate_year);

		btn_trainerview_ok = new JButton("확 인");
		btn_trainerview_ok.addActionListener(this);
		
		btn_trainerview_ok.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_trainerview_ok.setBounds(182, 416, 97, 23);
		layeredPane.add(btn_trainerview_ok);

		JLabel lb_trainerview_number = new JLabel("트레이너 번호");
		lb_trainerview_number.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainerview_number.setBounds(12, 23, 83, 18);
		layeredPane.add(lb_trainerview_number);

		tf_trainer_number = new JTextField();
		tf_trainer_number.setEnabled(false);
		tf_trainer_number.setColumns(10);
		tf_trainer_number.setBounds(107, 20, 20, 21);
		layeredPane.add(tf_trainer_number);

		tf_trainer_month = new JTextField();
		tf_trainer_month.setEnabled(false);
		tf_trainer_month.setColumns(10);
		tf_trainer_month.setBounds(160, 173, 25, 24);
		layeredPane.add(tf_trainer_month);

		tf_trainer_day = new JTextField();
		tf_trainer_day.setEnabled(false);
		tf_trainer_day.setColumns(10);
		tf_trainer_day.setBounds(210, 173, 30, 24);
		layeredPane.add(tf_trainer_day);

		JLabel lb_healthview_month = new JLabel("월");
		lb_healthview_month.setHorizontalAlignment(SwingConstants.CENTER);
		lb_healthview_month.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_healthview_month.setBounds(180, 170, 35, 24);
		layeredPane.add(lb_healthview_month);

		JLabel lb_healthview_day = new JLabel("일");
		lb_healthview_day.setHorizontalAlignment(SwingConstants.CENTER);
		lb_healthview_day.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_healthview_day.setBounds(235, 170, 35, 24);
		layeredPane.add(lb_healthview_day);

		tf_trainer_gender = new JTextField();
		tf_trainer_gender.setEnabled(false);
		tf_trainer_gender.setColumns(10);
		tf_trainer_gender.setBounds(107, 218, 40, 24);
		layeredPane.add(tf_trainer_gender);

		JLabel lb_trainer_member = new JLabel("담당 회원");
		lb_trainer_member.setHorizontalAlignment(SwingConstants.LEFT);
		lb_trainer_member.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_trainer_member.setBounds(12, 283, 68, 24);
		layeredPane.add(lb_trainer_member);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 288, 172, 92);
		layeredPane.add(scrollPane);

		ta_trainer_memverview = new JTextArea();
		ta_trainer_memverview.setEnabled(false);
		scrollPane.setViewportView(ta_trainer_memverview);
		// 있던 값 읽음
		tf_trainer_number.setText(String.valueOf(StaticValues.getSvTrainerDto()
				.getTrainer_no()));
		tf_trainer_name.setText(StaticValues.getSvTrainerDto()
				.getTrainer_name());
		tf_trainer_phone.setText(StaticValues.getSvTrainerDto()
				.getTrainer_tel());
		tf_trainer_address.setText(StaticValues.getSvTrainerDto()
				.getTrainer_addr());

		// Date에서 년월일 뽑음
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String Trainer_birth = sdf.format(StaticValues.getSvTrainerDto()
				.getTrainer_birth());
		String year = Trainer_birth.substring(0, 4);
		String month = Trainer_birth.substring(5, 7);
		String day = Trainer_birth.substring(8, 10);

		// 뽑아진 년월일을 텍스트 필드에 뿌림
		tf_trainer_year.setText(year);
		tf_trainer_month.setText(month);
		tf_trainer_day.setText(day);

		// 나머지도 텍스트필드에 넣음
		tf_trainer_gender.setText(StaticValues.getSvTrainerDto()
				.getTrainer_gender());
		tf_trainer_career.setText(String.valueOf(StaticValues.getSvTrainerDto()
				.getTrainer_career()));
		ta_trainer_memverview.append(TrainerDao.getInstance().selectTrainerMem(
				StaticValues.getSvTrainerDto().getTrainer_no()));

		setVisible(true); // 여기
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_trainerview_ok){ //확인 버튼 누르면
			setVisible(false); //창 닫힘
		}
	}
}
