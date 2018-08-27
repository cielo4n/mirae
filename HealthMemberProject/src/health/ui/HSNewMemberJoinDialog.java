package health.ui;

import health.database.MemberDao;
import health.database.MemberDto;
import health.database.RegDto;
import health.database.TrainerDao;
import health.value.StaticValues;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//�� ȸ�� ��� ���̾�α�
public class HSNewMemberJoinDialog extends JDialog implements ActionListener {
	
	private JTextField tf_health_memberjoin_name;
	private JTextField tf_health_memberjoin_phone;
	private JTextField tf_health_memberjoin_address;
	private JTextField tf_health_memberjoin_birth_year;
	private JTextField tf_health_memberjoin_weight;
	private JTextField tf_health_memberjoin_height;
	private JTextField tf_health_join_year;

	private JComboBox cb_health_memberjoin_gender;
	private JComboBox cb_health_memberjoin_pc;
	private JComboBox cb_health_memberjoin_trainer;
	private JComboBox cb_health_join_term;
	private JComboBox cb_memberjoin_birth_month;
	private JComboBox cb_memberjoin_birth_day;
	private JComboBox cb_health_join_month;
	private JComboBox cb_health_join_day;
	private JButton btn_health_memberjoinCancel;
	private JButton btn_health_memberjoinOK;

	public HSNewMemberJoinDialog(HealthScreen owner) { 
		super(owner);
		setResizable(false);
		setModal(true);

		setTitle("�� ȸ�� ���");

		setBounds(100, 100, 460, 543);
		setLocationRelativeTo(null);

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		JLabel lb_health_memberjoin_name = new JLabel("�̸�");
		lb_health_memberjoin_name.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_name.setBounds(12, 27, 48, 18);
		layeredPane.add(lb_health_memberjoin_name);

		JLabel lb_health_memberjoin_phone = new JLabel("����ó");
		lb_health_memberjoin_phone.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_phone.setBounds(12, 62, 48, 18);
		layeredPane.add(lb_health_memberjoin_phone);

		JLabel lb_health_memberjoin_address = new JLabel("�ּ�");
		lb_health_memberjoin_address.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_address.setBounds(12, 98, 41, 15);
		layeredPane.add(lb_health_memberjoin_address);

		JLabel lb_health_memberjoin_birth = new JLabel("�������");
		lb_health_memberjoin_birth.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_birth.setBounds(12, 127, 68, 24);
		layeredPane.add(lb_health_memberjoin_birth);

		JLabel lb_health_memberjoin_pc = new JLabel("ü��");
		lb_health_memberjoin_pc.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_pc.setBounds(12, 265, 48, 18);
		layeredPane.add(lb_health_memberjoin_pc);

		JLabel lb_health_memberjoin_height = new JLabel("Ű");
		lb_health_memberjoin_height.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_height.setBounds(12, 200, 57, 15);
		layeredPane.add(lb_health_memberjoin_height);

		JLabel lb_health_memberjoin_weight = new JLabel("������");
		lb_health_memberjoin_weight.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_weight.setBounds(12, 234, 57, 15);
		layeredPane.add(lb_health_memberjoin_weight);

		JLabel lb_health_memberjoin_gender = new JLabel("����");
		lb_health_memberjoin_gender.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_gender.setBounds(12, 165, 48, 18);
		layeredPane.add(lb_health_memberjoin_gender);

		JLabel lb_health_memberjoin_join = new JLabel("�����");
		lb_health_memberjoin_join.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_join.setBounds(12, 377, 57, 15);
		layeredPane.add(lb_health_memberjoin_join);

		tf_health_memberjoin_name = new JTextField();
		tf_health_memberjoin_name.setColumns(10);
		tf_health_memberjoin_name.setBounds(107, 25, 50, 24);
		layeredPane.add(tf_health_memberjoin_name);

		tf_health_memberjoin_phone = new JTextField();
		tf_health_memberjoin_phone.setColumns(10);
		tf_health_memberjoin_phone.setBounds(107, 59, 151, 24);
		layeredPane.add(tf_health_memberjoin_phone);

		tf_health_memberjoin_address = new JTextField();
		tf_health_memberjoin_address.setColumns(10);
		tf_health_memberjoin_address.setBounds(107, 94, 306, 24);
		layeredPane.add(tf_health_memberjoin_address);

		tf_health_memberjoin_birth_year = new JTextField();
		tf_health_memberjoin_birth_year.setColumns(10);
		tf_health_memberjoin_birth_year.setBounds(107, 129, 57, 24);
		layeredPane.add(tf_health_memberjoin_birth_year);

		tf_health_memberjoin_weight = new JTextField();
		tf_health_memberjoin_weight.setColumns(10);
		tf_health_memberjoin_weight.setBounds(107, 197, 100, 24);
		layeredPane.add(tf_health_memberjoin_weight);

		//���� �޺��ڽ�
		cb_health_memberjoin_gender = new JComboBox();
		cb_health_memberjoin_gender.setModel(new DefaultComboBoxModel(
				new Object[] { "����", "����" }));
		cb_health_memberjoin_gender.setBounds(107, 163, 68, 24);
		layeredPane.add(cb_health_memberjoin_gender);

		//ü�� �޺��ڽ�
		cb_health_memberjoin_pc = new JComboBox();
		cb_health_memberjoin_pc.setModel(new DefaultComboBoxModel(
				new Object[] {"���迱", "�߹迱", "�ܹ迱" }));
		cb_health_memberjoin_pc.setBounds(107, 265, 93, 21);
		layeredPane.add(cb_health_memberjoin_pc);

		JLabel lb_health_memberjoin_month = new JLabel("��ϱⰣ");
		lb_health_memberjoin_month.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_month.setBounds(12, 419, 57, 15);
		layeredPane.add(lb_health_memberjoin_month);

		JLabel lb_health_memberjoin_trainer = new JLabel("���Ʈ���̳�");
		lb_health_memberjoin_trainer.setFont(new Font("���� ����", Font.BOLD, 12));
		lb_health_memberjoin_trainer.setBounds(12, 292, 83, 26);
		layeredPane.add(lb_health_memberjoin_trainer);

		btn_health_memberjoinCancel = new JButton("�� ��");
		btn_health_memberjoinCancel.addActionListener(this);

		btn_health_memberjoinCancel.setBounds(242, 456, 93, 36);
		layeredPane.add(btn_health_memberjoinCancel);

		tf_health_memberjoin_height = new JTextField();
		tf_health_memberjoin_height.setColumns(10);
		tf_health_memberjoin_height.setBounds(107, 231, 100, 24);
		layeredPane.add(tf_health_memberjoin_height);

		cb_health_memberjoin_trainer = new JComboBox();
		cb_health_memberjoin_trainer.setBounds(107, 296, 93, 21);
		//�ｺ�忡 �����ִ� Ʈ���̳ʵ��� �޺��ڽ��� ������
		cb_health_memberjoin_trainer.setModel(TrainerDao.getInstance().trainerCombo(StaticValues.getSvGym_id()));
		layeredPane.add(cb_health_memberjoin_trainer);

		tf_health_join_year = new JTextField();
		tf_health_join_year.setColumns(10);
		tf_health_join_year.setBounds(88, 374, 48, 24);
		layeredPane.add(tf_health_join_year);

		JLabel lb_health_memberjoin_main = new JLabel("�ｺ �Ⱓ ���");
		lb_health_memberjoin_main.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_memberjoin_main.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_memberjoin_main.setBounds(151, 339, 126, 24);
		layeredPane.add(lb_health_memberjoin_main);

		JLabel lb_health_memberjoin_year = new JLabel("��");
		lb_health_memberjoin_year.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_memberjoin_year.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_memberjoin_year.setBounds(129, 374, 35, 24);
		layeredPane.add(lb_health_memberjoin_year);

		JLabel lb_health_memberjoin_m = new JLabel("��");
		lb_health_memberjoin_m.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_memberjoin_m.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_memberjoin_m.setBounds(212, 374, 35, 24);
		layeredPane.add(lb_health_memberjoin_m);

		JLabel lb_health_memberjoin_day = new JLabel("��");
		lb_health_memberjoin_day.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_memberjoin_day.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_memberjoin_day.setBounds(287, 374, 48, 24);
		layeredPane.add(lb_health_memberjoin_day);

		//��ϱⰣ(�� ����) �޺��ڽ�
		cb_health_join_term = new JComboBox();
		cb_health_join_term.setModel(new DefaultComboBoxModel(new Object[] {
				1, 3, 6, 12 }));
		cb_health_join_term.setBounds(89, 417, 50, 21);
		layeredPane.add(cb_health_join_term);

		JLabel lb_health_memberjoin_rm = new JLabel("����");
		lb_health_memberjoin_rm.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_memberjoin_rm.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_memberjoin_rm.setBounds(110, 415, 93, 21);
		layeredPane.add(lb_health_memberjoin_rm);
		
		btn_health_memberjoinOK = new JButton("Ȯ ��");
		btn_health_memberjoinOK.setBounds(114, 456, 93, 36);
		layeredPane.add(btn_health_memberjoinOK);
		btn_health_memberjoinOK.addActionListener(this);

		//������� �� �� �޺��ڽ�
		cb_memberjoin_birth_month = new JComboBox();
		cb_memberjoin_birth_month.setModel(new DefaultComboBoxModel(
				new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9,
						10, 11, 12 }));
		cb_memberjoin_birth_month.setBounds(206, 128, 41, 24);
		layeredPane.add(cb_memberjoin_birth_month);

		JLabel lb_memberjoin_year = new JLabel("��");
		lb_memberjoin_year.setHorizontalAlignment(SwingConstants.CENTER);
		lb_memberjoin_year.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_memberjoin_year.setBounds(172, 129, 35, 24);
		layeredPane.add(lb_memberjoin_year);

		//������� �� �� �޺��ڽ�
		cb_memberjoin_birth_day = new JComboBox();
		cb_memberjoin_birth_day.setModel(new DefaultComboBoxModel(new Object[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
				23, 24, 25, 26, 27, 28, 29, 30, 31 }));
		cb_memberjoin_birth_day.setBounds(274, 128, 48, 24);
		layeredPane.add(cb_memberjoin_birth_day);

		JLabel label = new JLabel("\uC6D4");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("���� ����", Font.BOLD, 15));
		label.setBounds(242, 129, 35, 24);
		layeredPane.add(label);

		JLabel label_1 = new JLabel("\uC77C");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("���� ����", Font.BOLD, 15));
		label_1.setBounds(312, 129, 48, 24);
		layeredPane.add(label_1);

		//����� �� �� �޺��ڽ�
		cb_health_join_month = new JComboBox();
		cb_health_join_month.setModel(new DefaultComboBoxModel(new Object[] {
						1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		cb_health_join_month.setBounds(166, 373, 48, 24);
		layeredPane.add(cb_health_join_month);

		//����� �� �� �޺��ڽ� 
		cb_health_join_day = new JComboBox();
		cb_health_join_day.setModel(new DefaultComboBoxModel(new Object[] {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
				23, 24, 25, 26, 27, 28, 29, 30, 31 }));
		cb_health_join_day.setBounds(249, 374, 48, 24);
		layeredPane.add(cb_health_join_day);
		
		setVisible(true); // ���� �����ٰ� �־� ��
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		if (obj == btn_health_memberjoinOK) { // Ȯ�ι�ư
			// Ȯ�� ������ ��ȸ���� ��ϵǴ��̺�Ʈ
			int birth_year;
			double height;
			double weight;
			int reg_year;
			int chkday;
			
			String name = tf_health_memberjoin_name.getText();
			String tel = tf_health_memberjoin_phone.getText();
			String addr = tf_health_memberjoin_address.getText();

			try{ //������� �� ���� �Է½� ��� ���ڷ� �޴��� Ȯ��
				birth_year = Integer.parseInt(tf_health_memberjoin_birth_year.getText());
			} catch(Exception e){ 
				//���ڰ� �ƴϸ� ����ó��
				WarningMessage.inputYearFailure();
				return;
			}
			
			//�޺��ڽ��� ���õ� ��, ��, ���� �׸��� �о��
			int birth_month = (Integer)cb_memberjoin_birth_month.getSelectedItem();
			int birth_day = (Integer)cb_memberjoin_birth_day.getSelectedItem();
			String gender = (String)cb_health_memberjoin_gender.getSelectedItem();

			//��¥�� �� �ԷµǾ��� Ȯ��
			chkday = WarningMessage.checkDay(birth_year, birth_month, birth_day);
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
					
			try{ //Ű�� ��� ���ڷ� �޴��� Ȯ��
				height = Double.parseDouble(tf_health_memberjoin_height.getText());
			} catch(Exception e){
				//���ڰ� �ƴϸ� ����ó��
				WarningMessage.inputHeightFailure();
				return;
			}
			
			try{ //�����Ը� ��� ���ڷ� �޴��� Ȯ��
				weight = Double.parseDouble(tf_health_memberjoin_weight.getText());
			} catch(Exception e){
				//���ڰ� �ƴϸ� ����ó��
				WarningMessage.inputWeightFailure();
				return;
			}
			
			//�޺��ڽ��� ���õ� ü��, ���Ʈ���̳� �׸��� �о��
			String shape = (String)cb_health_memberjoin_pc.getSelectedItem();
			String trainer = (String)cb_health_memberjoin_trainer.getSelectedItem();
			
			try{ //��Ͽ����� ��� ���ڷ� �޴��� Ȯ��
				reg_year = Integer.parseInt(tf_health_join_year.getText());
			} catch(Exception e){ 
				//���ڰ� �ƴϸ� ����ó��
				WarningMessage.inputRegYearFailure();
				return;
			}
			//�޺��ڽ��� ���õ� ��Ͽ�, �����, ��ϱⰣ�� �о��
			int reg_month = (Integer)cb_health_join_month.getSelectedItem();
			int reg_day = (Integer)cb_health_join_day.getSelectedItem();
			int reg_term = (Integer)cb_health_join_term.getSelectedItem();
			
			//��¥�� �� �ԷµǾ��� Ȯ��
			chkday = WarningMessage.checkDay(reg_year, reg_month, reg_day);
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
			
			//�о�Դ� �����͸� ��ü�� ����
			MemberDto mt = new MemberDto(StaticValues.getSvGym_id(), name, tel, addr, birth_year, birth_month, birth_day, gender, height, weight, shape, trainer);
			RegDto rt = new RegDto(reg_year, reg_month, reg_day, reg_term);
			
			//ȸ�� ���̺��� ����, ��� ���̺��� ����
			MemberDao.getInstance().insertNewMember(mt, rt);
			WarningMessage.memberJoin(); //�� ȸ�� ��� �˷���
			dispose(); //â ����
		}

		// ��ҹ�ư ����
		if (obj == btn_health_memberjoinCancel) {
			dispose(); // â������ �̺�Ʈ
		}
	}
}