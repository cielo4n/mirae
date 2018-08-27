package health.ui;

import health.value.StaticValues;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

//회원 상세보기 다이얼로그
public class HSMemberViewDialog extends JDialog implements ActionListener{
	private JTextField tf_health_memberview_name; //회원번호
	private JTextField tf_health_memberview_phone;
	private JTextField tf_health_memberview_address;
	private JTextField tf_health_memberview_year;
	private JTextField tf_health_memberview_weight;
	private JTextField tf_health_memberview_height;
	private JTextField tf_member_number;
	private JTextField tf_health_memberview_trainer;
	private JTextField tf_health_memberview_month;
	private JTextField tf_health_memberview_day;
	private JTextField tf_health_memberview_gender;
	private JTextField tf_health_memberview_type; //체형
	private JButton btn_healthview_rg; //헬스기간등록 버튼
	private JButton btn_healthview_ok; //확인버튼

	public HSMemberViewDialog() {
		setResizable(false);
		setModal(true); //호출한 곳 클릭 못하게 함

		setTitle("회원 상세보기");

		setBounds(100, 100, 460, 520);
		setLocationRelativeTo(null); //가운데로 위치

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		JLabel lb_health_memberview_name = new JLabel("이름");
		lb_health_memberview_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_name.setBounds(12, 58, 48, 18);
		layeredPane.add(lb_health_memberview_name);

		JLabel lb_health_memberview_phone = new JLabel("연락처");
		lb_health_memberview_phone.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_phone.setBounds(12, 93, 48, 18);
		layeredPane.add(lb_health_memberview_phone);

		JLabel lb_health_memberview_address = new JLabel("주소");
		lb_health_memberview_address.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_address.setBounds(12, 136, 41, 15);
		layeredPane.add(lb_health_memberview_address);

		JLabel lb_health_memberview_birth = new JLabel("생년월일");
		lb_health_memberview_birth.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_birth.setBounds(12, 172, 68, 24);
		layeredPane.add(lb_health_memberview_birth);

		JLabel lb_health_memberview_pc = new JLabel("체형");
		lb_health_memberview_pc.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_pc.setBounds(12, 336, 48, 18);
		layeredPane.add(lb_health_memberview_pc);

		JLabel lb_health_memberview_height = new JLabel("키");
		lb_health_memberview_height.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_height.setBounds(12, 258, 57, 15);
		layeredPane.add(lb_health_memberview_height);

		JLabel lb_health_memberview_weight = new JLabel("몸무게");
		lb_health_memberview_weight.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_weight.setBounds(12, 299, 57, 15);
		layeredPane.add(lb_health_memberview_weight);

		JLabel lb_health_memberview_gender = new JLabel("성별");
		lb_health_memberview_gender.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_gender.setBounds(12, 218, 48, 18);
		layeredPane.add(lb_health_memberview_gender);

		tf_health_memberview_name = new JTextField();
		tf_health_memberview_name.setEnabled(false);
		tf_health_memberview_name.setColumns(10);
		tf_health_memberview_name.setBounds(107, 58, 116, 21);
		layeredPane.add(tf_health_memberview_name);

		tf_health_memberview_phone = new JTextField();
		tf_health_memberview_phone.setEnabled(false);
		tf_health_memberview_phone.setColumns(10);
		tf_health_memberview_phone.setBounds(107, 92, 151, 21);
		layeredPane.add(tf_health_memberview_phone);

		tf_health_memberview_address = new JTextField();
		tf_health_memberview_address.setEnabled(false);
		tf_health_memberview_address.setColumns(10);
		tf_health_memberview_address.setBounds(107, 131, 306, 25);
		layeredPane.add(tf_health_memberview_address);

		tf_health_memberview_year = new JTextField();
		tf_health_memberview_year.setEnabled(false);
		tf_health_memberview_year.setColumns(10);
		tf_health_memberview_year.setBounds(107, 173, 40, 24);
		layeredPane.add(tf_health_memberview_year);

		tf_health_memberview_weight = new JTextField();
		tf_health_memberview_weight.setEnabled(false);
		tf_health_memberview_weight.setColumns(10);
		tf_health_memberview_weight.setBounds(107, 296, 50, 24);
		layeredPane.add(tf_health_memberview_weight);

		JLabel lb_health_memberview_trainer = new JLabel("담당트레이너");
		lb_health_memberview_trainer.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_health_memberview_trainer.setBounds(12, 376, 83, 26);
		layeredPane.add(lb_health_memberview_trainer);

		tf_health_memberview_height = new JTextField();
		tf_health_memberview_height.setEnabled(false);
		tf_health_memberview_height.setColumns(10);
		tf_health_memberview_height.setBounds(107, 254, 50, 24);
		layeredPane.add(tf_health_memberview_height);

		JLabel lb_memberupdate_year = new JLabel("년");
		lb_memberupdate_year.setHorizontalAlignment(SwingConstants.CENTER);
		lb_memberupdate_year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_memberupdate_year.setBounds(140, 172, 35, 24);
		layeredPane.add(lb_memberupdate_year);

		btn_healthview_ok = new JButton("확 인");
		btn_healthview_ok.addActionListener(this);
		btn_healthview_ok.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_healthview_ok.setBounds(91, 426, 97, 23);
		layeredPane.add(btn_healthview_ok);

		btn_healthview_rg = new JButton("헬스기간 등록");
		btn_healthview_rg.addActionListener(this);
		btn_healthview_rg.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_healthview_rg.setBounds(227, 426, 127, 23);
		layeredPane.add(btn_healthview_rg);

		JLabel lb_memberview_number = new JLabel("회원번호");
		lb_memberview_number.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lb_memberview_number.setBounds(12, 23, 57, 15);
		layeredPane.add(lb_memberview_number);

		tf_member_number = new JTextField();
		tf_member_number.setEnabled(false);
		tf_member_number.setColumns(10);
		tf_member_number.setBounds(107, 20, 20, 21);
		layeredPane.add(tf_member_number);

		tf_health_memberview_trainer = new JTextField();
		tf_health_memberview_trainer.setEnabled(false);
		tf_health_memberview_trainer.setColumns(10);
		tf_health_memberview_trainer.setBounds(107, 378, 100, 24);
		layeredPane.add(tf_health_memberview_trainer);

		tf_health_memberview_month = new JTextField();
		tf_health_memberview_month.setEnabled(false);
		tf_health_memberview_month.setColumns(10);
		tf_health_memberview_month.setBounds(170, 174, 30, 24);
		layeredPane.add(tf_health_memberview_month);

		tf_health_memberview_day = new JTextField();
		tf_health_memberview_day.setEnabled(false);
		tf_health_memberview_day.setColumns(10);
		tf_health_memberview_day.setBounds(230, 174, 30, 24);
		layeredPane.add(tf_health_memberview_day);

		JLabel lb_healthview_month = new JLabel("월");
		lb_healthview_month.setHorizontalAlignment(SwingConstants.CENTER);
		lb_healthview_month.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_healthview_month.setBounds(195, 173, 35, 24);
		layeredPane.add(lb_healthview_month);

		JLabel lb_healthview_day = new JLabel("일");
		lb_healthview_day.setHorizontalAlignment(SwingConstants.CENTER);
		lb_healthview_day.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb_healthview_day.setBounds(260, 172, 35, 24);
		layeredPane.add(lb_healthview_day);

		tf_health_memberview_gender = new JTextField();
		tf_health_memberview_gender.setEnabled(false);
		tf_health_memberview_gender.setColumns(10);
		tf_health_memberview_gender.setBounds(107, 218, 57, 24);
		layeredPane.add(tf_health_memberview_gender);

		tf_health_memberview_type = new JTextField();
		tf_health_memberview_type.setEnabled(false);
		tf_health_memberview_type.setColumns(10);
		tf_health_memberview_type.setBounds(107, 336, 76, 24);
		layeredPane.add(tf_health_memberview_type);

		//Date에서 년월일 뽑기위해 씀
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		//있던 값 읽음
		tf_member_number.setText(String.valueOf(StaticValues.getSvMemDto().getMem_no()));
		tf_health_memberview_name.setText(StaticValues.getSvMemDto().getMem_name());
		tf_health_memberview_phone.setText(StaticValues.getSvMemDto().getMem_tel());
		tf_health_memberview_address.setText(StaticValues.getSvMemDto()	.getMem_addr());
		
		//Date에서 년월일 뽑음
		String mem_birth = sdf	.format(StaticValues.getSvMemDto().getMem_birth());
		String year = mem_birth.substring(0, 4);
		String month = mem_birth.substring(5, 7);
		String day = mem_birth.substring(8, 10);
		
		//뽑아진 년월일을 텍스트 필드에 뿌림
		tf_health_memberview_year.setText(year);
		tf_health_memberview_month.setText(month);
		tf_health_memberview_day.setText(day);
		
		//나머지도 텍스트필드에 넣음
		tf_health_memberview_gender.setText(StaticValues.getSvMemDto().getMem_gender());
		tf_health_memberview_height.setText(String.valueOf(StaticValues.getSvMemDto().getMem_height()));
		tf_health_memberview_weight.setText(String.valueOf(StaticValues.getSvMemDto().getMem_weight()));
		tf_health_memberview_trainer.setText(StaticValues.getSvMemDto().getTrainer_name());
		tf_health_memberview_type.setText(StaticValues.getSvMemDto().getMem_shape());
		
		setVisible(true); // 여기
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_healthview_ok){ //확인 버튼 누르면
			dispose(); //창닫힘
		}
		else if(obj == btn_healthview_rg){ //헬스기간등록 버튼 누르면
			// 헬스기간등록 다이어그램 띄움
			new HSTermJoinDialog();
		}
	}
}
