package health.ui;

import health.database.GymDao;
import health.database.GymDto;
import health.value.StaticValues;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

//������ ȭ�鿡�� �ｺ�� ��Ϲ�ư Ŭ���� ������ ���̾�α�
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
		setTitle("�ｺ�� ���");
		setBounds(100, 100, 300, 430);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lb_admin_health_id = new JLabel("���̵�");
		lb_admin_health_id.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_admin_health_id.setBounds(12, 29, 57, 15);
		layeredPane.add(lb_admin_health_id);

		JLabel lb_admin_health_pw = new JLabel("�н�����");
		lb_admin_health_pw.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_admin_health_pw.setBounds(12, 54, 69, 15);
		layeredPane.add(lb_admin_health_pw);

		JLabel lb_admin_health_number = new JLabel("����� ��Ϲ�ȣ");
		lb_admin_health_number.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_admin_health_number.setBounds(12, 113, 95, 22);
		layeredPane.add(lb_admin_health_number);

		JLabel lb_admin_health_name = new JLabel("�ｺ�� �̸�");
		lb_admin_health_name.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_admin_health_name.setBounds(12, 151, 69, 15);
		layeredPane.add(lb_admin_health_name);

		JLabel lb_admin_health_address = new JLabel("�ּ�");
		lb_admin_health_address.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_admin_health_address.setBounds(12, 190, 57, 15);
		layeredPane.add(lb_admin_health_address);

		JLabel lb_admin_health_phone = new JLabel("��ȭ��ȣ");
		lb_admin_health_phone.setFont(new Font("���� ���", Font.BOLD, 12));
		lb_admin_health_phone.setBounds(12, 225, 69, 15);
		layeredPane.add(lb_admin_health_phone);

		btn_healthregister_ok = new JButton("Ȯ��");
		btn_healthregister_ok.addActionListener(this);
				
		btn_healthregister_ok.setBounds(35, 321, 82, 34);
		layeredPane.add(btn_healthregister_ok);

		btn_healthregister_cancel = new JButton("���");
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

		JLabel lb_admin_health_rpw = new JLabel("�н����� ���Է�");
		lb_admin_health_rpw.setFont(new Font("���� ���", Font.BOLD, 12));
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
		
		if(obj == btn_healthregister_cancel){ //��� ������
			dispose(); //â ����
		}
		else if(obj == btn_healthregister_ok){ 
			// Ȯ�� ������ �ｺ���� ��ϵǴ��̺�Ʈ
			String gym_id = tf_admin_health_id.getText();
			String gym_pw = new String(tf_admin_health_pw.getPassword());
			String gym_rpw = new String(tf_admin_health_rpw.getPassword());
			String business_no = tf_admin_health_number.getText();
			String gym_name = tf_admin_health_name.getText();
			String gym_tel = tf_admin_health_phone.getText();
			String gym_addr = tf_admin_health_address.getText();
			
			if(gym_id.equals("") || gym_pw.equals("") || gym_rpw.equals("") || business_no.equals("")
					|| gym_name.equals("") || gym_tel.equals("") || gym_addr.equals("")){
				WarningMessage.blankWarning(); //���� �˻�
				
			} else if(gym_pw.equals(gym_rpw)==false){
				WarningMessage.notSamePassward(); //��й�ȣ ���Է��� ��й�ȣ�� �ٸ�
				
			} else if(GymDao.getInstance().differentGym_id(gym_id)==false){
				WarningMessage.duplicationWarning(); //���̵� �ߺ� �˻�
				
			} else {
				//�ｺ�� ���
				GymDto gd = new GymDto(gym_id, gym_pw, business_no, gym_name, gym_tel, gym_addr);
				GymDao.getInstance().insertGym(StaticValues.getSvAdmin_id(), gd);
				WarningMessage.healthJoin();
				dispose();
			}
		}
	}
}