package health.ui;

import health.database.AdminDao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//�����ڸ� ����ϴ� ���̾�α�
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
		setTitle("������ ���");
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
			JLabel lb_admin_join_id = new JLabel("�� �� ��");
			lb_admin_join_id.setFont(new Font("���� ���", Font.BOLD, 12));
			lb_admin_join_id.setHorizontalAlignment(SwingConstants.CENTER);
			lb_admin_join_id.setBounds(24, 24, 73, 21);
			getContentPane().add(lb_admin_join_id);
		}
		{
			JLabel lb_admin_join_pw = new JLabel("�� �� �� ȣ");
			lb_admin_join_pw.setFont(new Font("���� ���", Font.BOLD, 12));
			lb_admin_join_pw.setHorizontalAlignment(SwingConstants.CENTER);
			lb_admin_join_pw.setBounds(24, 61, 73, 21);
			getContentPane().add(lb_admin_join_pw);
		}
		{
			JLabel lb_admin_join_rpw = new JLabel("��й�ȣ ���Է�");
			lb_admin_join_rpw.setFont(new Font("���� ���", Font.BOLD, 12));
			lb_admin_join_rpw.setHorizontalAlignment(SwingConstants.CENTER);
			lb_admin_join_rpw.setBounds(12, 92, 102, 21);
			getContentPane().add(lb_admin_join_rpw);
		}
		tf_admin_join_id.setBounds(126, 24, 116, 21);
		getContentPane().add(tf_admin_join_id);
		tf_admin_join_id.setColumns(10);
		{
			btn_admin_join_ok = new JButton("Ȯ ��");
			btn_admin_join_ok.setBounds(24, 129, 97, 23);
			getContentPane().add(btn_admin_join_ok);
		}
		{
			btn_admin_join_cancel = new JButton("�� ��");
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
		
		btn_admin_join_cancel.addActionListener(this); //�����ʷ� ����
		btn_admin_join_ok.addActionListener(this); //�����ʷ� ����
		
		setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == btn_admin_join_ok){ //Ȯ���� ������ ��
			// Ȯ�δ����� �����ھ��̵� ��ϵǴ��̺�Ʈ
			String admin_id = tf_admin_join_id.getText();
			String admin_pw = new String(tf_admin_join_pw.getPassword());
			String admin_rpw = new String(tf_admin_join_rpw.getPassword());

			// ���� Ȯ��
			if (admin_id.equals("") || admin_pw.equals("")
					|| admin_rpw.equals("")) {
				WarningMessage.blankWarning();
				return;
			}
			// ��й�ȣ�� ��й�ȣ���Է��� �´��� Ȯ��
			else if (admin_pw.equals(admin_rpw) == false) {
				WarningMessage.notSamePassward();
				return;
			}
			// ���̵� �ߺ� Ȯ��
			else if (AdminDao.getInstance().differentAdmin_id(admin_id) == false) {
				WarningMessage.duplicationWarning();
				return;
			}
			// �Է� �ȵ�
			else if (AdminDao.getInstance().insertAdmin(admin_id, admin_pw) == false) {
				WarningMessage.mainScreenJoinFailure();
				return;
			}
			// �Է��ߵ� ���
			else {
				WarningMessage.mainScreenJoinSuccess();
				dispose();
			}
		}
		else if(obj == btn_admin_join_cancel){ //��Ҹ� ������ ��
			dispose(); // ��ҹ�ư ��������̾�α�â ����
		}
	}
}
