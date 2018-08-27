package health.ui;

import health.database.AdminDao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//관리자를 등록하는 다이얼로그
public class MSAdminJoinDialog extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private final JTextField tf_admin_join_id = new JTextField();
	private JPasswordField tf_admin_join_pw;
	private JPasswordField tf_admin_join_rpw;
	private JButton btn_admin_join_cancel;
	private JButton btn_admin_join_ok;
	
	public MSAdminJoinDialog(MainScreen owner) {
		super(owner);
		setResizable(false);
		setModal(true);
		setTitle("관리자 등록");
		setBounds(100, 100, 300, 200);
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
		{
			JLabel lb_admin_join_id = new JLabel("아 이 디");
			lb_admin_join_id.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_admin_join_id.setHorizontalAlignment(SwingConstants.CENTER);
			lb_admin_join_id.setBounds(24, 24, 73, 21);
			getContentPane().add(lb_admin_join_id);
		}
		{
			JLabel lb_admin_join_pw = new JLabel("비 밀 번 호");
			lb_admin_join_pw.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_admin_join_pw.setHorizontalAlignment(SwingConstants.CENTER);
			lb_admin_join_pw.setBounds(24, 61, 73, 21);
			getContentPane().add(lb_admin_join_pw);
		}
		{
			JLabel lb_admin_join_rpw = new JLabel("비밀번호 재입력");
			lb_admin_join_rpw.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			lb_admin_join_rpw.setHorizontalAlignment(SwingConstants.CENTER);
			lb_admin_join_rpw.setBounds(12, 92, 102, 21);
			getContentPane().add(lb_admin_join_rpw);
		}
		tf_admin_join_id.setBounds(126, 24, 116, 21);
		getContentPane().add(tf_admin_join_id);
		tf_admin_join_id.setColumns(10);
		{
			btn_admin_join_ok = new JButton("확 인");
			btn_admin_join_ok.setBounds(24, 129, 97, 23);
			getContentPane().add(btn_admin_join_ok);
		}
		{
			btn_admin_join_cancel = new JButton("취 소");
			btn_admin_join_cancel.setBounds(153, 129, 97, 23);
			getContentPane().add(btn_admin_join_cancel);
		}
		{
			tf_admin_join_pw = new JPasswordField();
			tf_admin_join_pw.setBounds(126, 61, 116, 21);
			getContentPane().add(tf_admin_join_pw);
		}
		{
			tf_admin_join_rpw = new JPasswordField();
			tf_admin_join_rpw.setBounds(126, 92, 116, 21);
			getContentPane().add(tf_admin_join_rpw);
		}
		
		btn_admin_join_cancel.addActionListener(this); //리스너로 연결
		btn_admin_join_ok.addActionListener(this); //리스너로 연결
		
		setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_admin_join_ok){ //확인을 눌렀을 때
			// 확인누르면 관리자아이디가 등록되는이벤트
			String admin_id = tf_admin_join_id.getText();
			String admin_pw = new String(tf_admin_join_pw.getPassword());
			String admin_rpw = new String(tf_admin_join_rpw.getPassword());

			// 공백 확인
			if (admin_id.equals("") || admin_pw.equals("")
					|| admin_rpw.equals("")) {
				WarningMessage.blankWarning();
				return;
			}
			// 비밀번호와 비밀번호재입력이 맞는지 확인
			else if (admin_pw.equals(admin_rpw) == false) {
				WarningMessage.notSamePassward();
				return;
			}
			// 아이디 중복 확인
			else if (AdminDao.getInstance().differentAdmin_id(admin_id) == false) {
				WarningMessage.duplicationWarning();
				return;
			}
			// 입력 안됨
			else if (AdminDao.getInstance().insertAdmin(admin_id, admin_pw) == false) {
				WarningMessage.mainScreenJoinFailure();
				return;
			}
			// 입력잘된 경우
			else {
				WarningMessage.mainScreenJoinSuccess();
				dispose();
			}
		}
		else if(obj == btn_admin_join_cancel){ //취소를 눌렀을 때
			dispose(); // 취소버튼 누르면다이얼로그창 닫힘
		}
	}
}
