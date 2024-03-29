package health.ui;

import health.database.RegDao;
import health.database.RegDto;
import health.value.StaticValues;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

//헬스기간 등록 다이얼로그
public class HSTermJoinDialog extends JDialog implements ActionListener{

	private JPanel contentPanel = new JPanel();
	private JTextField tf_reg_year;
	private JComboBox cb_reg_month;
	private JComboBox cb_reg_day;
	private JComboBox cb_term_month;
	private JButton btn_term_ok;
	private JButton btn_term_cancel;
	
	public HSTermJoinDialog() {
		setResizable(false);
		setModal(true);
		setTitle("헬스기간 등록");
		setBounds(100, 100, 410, 280);
		setLocationRelativeTo(null); //창 가운데 위치시킴
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
		{
			JLabel lb_health_term_rg = new JLabel("등록일");
			lb_health_term_rg.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_health_term_rg.setBounds(41, 62, 47, 23);
			getContentPane().add(lb_health_term_rg);
		}
		{
			JLabel lb_health_term_rg2 = new JLabel("등록기간");
			lb_health_term_rg2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_health_term_rg2.setBounds(41, 132, 58, 30);
			getContentPane().add(lb_health_term_rg2);
		}
		{
			tf_reg_year = new JTextField();
			tf_reg_year.setBounds(100, 62, 65, 25);
			getContentPane().add(tf_reg_year);
			tf_reg_year.setColumns(10);
		}
		{ //등록일에서 월 콤보박스
			cb_reg_month = new JComboBox();
			cb_reg_month.setModel(new DefaultComboBoxModel(new Object[] {1,2,3,4,5,6,7,8,9,10,11,12}));
			cb_reg_month.setBounds(188, 62, 65, 25);
			getContentPane().add(cb_reg_month);
		}
		{ //등록일에서 일 콤보박스
			cb_reg_day = new JComboBox();
			cb_reg_day.setModel(new DefaultComboBoxModel(new Object[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
			cb_reg_day.setBounds(278, 62, 65, 25);
			getContentPane().add(cb_reg_day);
		}
		{
			JLabel lb_term_year = new JLabel("년");
			lb_term_year.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb_term_year.setBounds(166, 57, 25, 30);
			getContentPane().add(lb_term_year);
		}
		{ //등록기간 콤보박스
			cb_term_month = new JComboBox();
			cb_term_month.setModel(new DefaultComboBoxModel(new Object[] {1, 3, 6, 12}));
			cb_term_month.setBounds(100, 137, 80, 23);
			getContentPane().add(cb_term_month);
		}
		{
			JLabel lb_term_m = new JLabel("개월");
			lb_term_m.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb_term_m.setBounds(190, 137, 80, 23);
			getContentPane().add(lb_term_m);
		}
		{
			JLabel lb_term_month = new JLabel("월");
			lb_term_month.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb_term_month.setBounds(258, 57, 25, 30);
			getContentPane().add(lb_term_month);
		}
		{
			JLabel lb_term_day = new JLabel("일");
			lb_term_day.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			lb_term_day.setBounds(347, 57, 25, 30);
			getContentPane().add(lb_term_day);
		}
		{
			btn_term_ok = new JButton("확 인");
			btn_term_ok.addActionListener(this);
			btn_term_ok.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btn_term_ok.setBounds(84, 200, 97, 23);
			getContentPane().add(btn_term_ok);
		}
		{
			btn_term_cancel = new JButton("취 소");
			btn_term_cancel.addActionListener(this);
			btn_term_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			btn_term_cancel.setBounds(229, 200, 97, 23);
			getContentPane().add(btn_term_cancel);
		}
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_term_cancel){ //취소 누르면
			dispose(); //창 닫힘
		}
		else if(obj == btn_term_ok){ //확인 누르면
			//확인버튼누르면 회원의헬스기간이등록되는이벤트
			int year;
			int chkday;

			try{ //등록일의 연도를 모두 숫자로 받는지 확인
				year = Integer.parseInt(tf_reg_year.getText());
			} catch(Exception ie){ //숫자가 아니면 예외처리
				WarningMessage.inputRegYearFailure();
				return;
			}
			
			//콤보박스에 있는 등록일의 월, 일, 기간을 입력받음
			int month = (Integer)cb_reg_month.getSelectedItem();
			int day = (Integer)cb_reg_day.getSelectedItem();
			int term = (Integer)cb_term_month.getSelectedItem();

			//날짜가 잘 입력되었나 확인
			chkday = WarningMessage.checkDay(year, month, day);
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
			
			//등록 객체 만듦
			RegDto rd = new RegDto(year, month, day, term);
			//헬스기간 등록 추가
			if(RegDao.getInstance().insertReg(StaticValues.getSvGym_id(), StaticValues.getSvMemDto().getMem_no(), rd)){	
				WarningMessage.healthRegister(); //등록추가했다고 알려줌
				dispose(); //창 닫음
			}
		}
	}
}
