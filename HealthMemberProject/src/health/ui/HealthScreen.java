package health.ui;

import health.database.GymDao;
import health.database.MemberDao;
import health.database.RegDao;
import health.database.TrainerDao;
import health.value.StaticValues;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//�ｺ�� �α��� �� ������ ȭ��
public class HealthScreen extends JFrame {
	private JTextField tf_health_name;
	private JTextField tf_health_number;
	private JTextField tf_health_phone;
	private JTextField tf_health_address;
	
	private JTextField tf_health_member_name; //�ｺ����ο��� ��ȸ�� �̸�
	private JTextField tf_health_trainer_name; //Ʈ���̳ʿ��� ��ȸ�� �̸�
	private JTextField tf_healthmember_name; //�ｺ���Ȯ�ο��� ��ȸ�� �̸�
	
	private JTable tb_health_member; //ȸ���������� ���̺�
	private JTable tb_health_trainer; //Ʈ���̳ʰ������� ���̺�
	private JTable tb_healthmember_search; //�ｺ���Ȯ�ο��� ���̺�
	

	public HealthScreen() {
/////////////////////////////////////////////////////////////////////////////////////////
//�ｺ�� (����)ȭ�� ����
		
		setResizable(false);
		setTitle("�ｺ�� ȭ��");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 0, 784, 562);
		getContentPane().add(tabbedPane);
		
		JPanel pn_health_main = new JPanel();
		pn_health_main.setLayout(null);
		tabbedPane.addTab("\uD5EC\uC2A4\uC7A5 \uBA54\uC778", null, pn_health_main, null);

		JLabel lb_health_name = new JLabel("�ｺ�� �̸�");
		lb_health_name.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_name.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_name.setBounds(322, 28, 134, 38);
		pn_health_main.add(lb_health_name);

		JLabel lb_health_number = new JLabel("����� ��Ϲ�ȣ");
		lb_health_number.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_number.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_number.setBounds(322, 127, 134, 38);
		pn_health_main.add(lb_health_number);

		JLabel lb_health_phone = new JLabel("����ó");
		lb_health_phone.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_phone.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_phone.setBounds(322, 226, 134, 38);
		pn_health_main.add(lb_health_phone);

		JLabel lb_health_address = new JLabel("�� ��");
		lb_health_address.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_address.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_address.setBounds(322, 325, 134, 38);
		pn_health_main.add(lb_health_address);

		tf_health_name = new JTextField();
		tf_health_name.setEnabled(false);
		tf_health_name.setBounds(293, 76, 195, 41);
		tf_health_name.setFont(new Font("���� ����", Font.BOLD, 15));
		tf_health_name.setHorizontalAlignment(SwingConstants.CENTER);
		pn_health_main.add(tf_health_name);
		tf_health_name.setColumns(10);

		tf_health_number = new JTextField();
		tf_health_number.setEnabled(false);
		tf_health_number.setColumns(10);
		tf_health_number.setBounds(293, 175, 195, 41);
		tf_health_number.setFont(new Font("���� ����", Font.BOLD, 15));
		tf_health_number.setHorizontalAlignment(SwingConstants.CENTER);
		pn_health_main.add(tf_health_number);

		tf_health_phone = new JTextField();
		tf_health_phone.setEnabled(false);
		tf_health_phone.setColumns(10);
		tf_health_phone.setBounds(293, 274, 195, 41);
		tf_health_phone.setFont(new Font("���� ����", Font.BOLD, 15));
		tf_health_phone.setHorizontalAlignment(SwingConstants.CENTER);
		pn_health_main.add(tf_health_phone);

		tf_health_address = new JTextField();
		tf_health_address.setEnabled(false);
		tf_health_address.setColumns(10);
		tf_health_address.setBounds(241, 373, 296, 35);
		tf_health_address.setFont(new Font("���� ����", Font.BOLD, 15));
		tf_health_address.setHorizontalAlignment(SwingConstants.CENTER);
		pn_health_main.add(tf_health_address);
		
		JButton btn_health_logout = new JButton("�α׾ƿ�");
		btn_health_logout.setFont(new Font("���� ����", Font.BOLD, 13));
		btn_health_logout.setBounds(650, 20, 110, 30);
		pn_health_main.add(btn_health_logout);
		
		//�α׾ƿ� ��ư ������ ó�� ������ ����ȭ������ ���ư���
		btn_health_logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				setVisible(false);
				new MainScreen();
			}
		});

		JButton btn_health_update = new JButton("�ｺ�� ����");
		btn_health_update.setFont(new Font("���� ����", Font.BOLD, 13));
		btn_health_update.setBounds(224, 439, 120, 41);
		pn_health_main.add(btn_health_update);
		
		//�ｺ�� ���� ���� �� ����Ǵ� �κ�
		btn_health_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ｺ�� ���� ���̾�α� â ��
				new HSHealthUpdateDialog(HealthScreen.this);
				
				//�ｺ�� ���ο� �ִ� �ؽ�Ʈ �ʵ��� ���뵵 �ٲ�
				tf_health_name.setText(StaticValues.getSvGymDto().getGym_name());
				tf_health_number.setText(StaticValues.getSvGymDto().getBusiness_no());
				tf_health_phone.setText(StaticValues.getSvGymDto().getGym_tel());
				tf_health_address.setText(StaticValues.getSvGymDto().getGym_addr());
			}
		});

		JButton btn_health_salesview = new JButton("���⺸��");
		btn_health_salesview.setFont(new Font("���� ����", Font.BOLD, 13));
		
		//���⺸�� ���� �� ����Ǵ� �κ�
		btn_health_salesview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���⺸�� ���̾�α� â ��
				new PriceViewDialog();
			}
		});
		
		btn_health_salesview.setBounds(453, 439, 120, 41);
		pn_health_main.add(btn_health_salesview);
		
		//�ｺ����̵� �ش��ϴ� ������ �����ͺ��̽����� �ҷ���
		StaticValues.setSvGymDto(GymDao.getInstance().selectGym(StaticValues.getSvGym_id()));
		//�ҷ��� ������ �ｺ�� ���ο� �ִ� �ؽ�Ʈ�ʵ忡 ����
		tf_health_name.setText(StaticValues.getSvGymDto().getGym_name());
		tf_health_number.setText(StaticValues.getSvGymDto().getBusiness_no());
		tf_health_phone.setText(StaticValues.getSvGymDto().getGym_tel());
		tf_health_address.setText(StaticValues.getSvGymDto().getGym_addr());
		
///////////////////////////////////////////////////////////////////////////////////////////////////
//ȸ������ ȭ�� ����		
		
		JPanel pn_health_member = new JPanel();
		pn_health_member.setLayout(null);
		tabbedPane.addTab("\uD68C\uC6D0\uAD00\uB9AC", null, pn_health_member, null);

		JButton btn_health_member_search = new JButton("�� ȸ");
		
		//�̸� �ؽ�Ʈ�ʵ� ���� ��ȸ ��ư ���� �� �Ͼ�� �̺�Ʈ : �̸��� �ش��ϴ� ȸ���� ������ ��ȸ��
		btn_health_member_search.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { 
				 //�̸� �ؽ�Ʈ�ʵ忡 �ִ� ������ �о��
				 String sname = tf_health_member_name.getText(); 

				 //�̸� �ؽ�Ʈ�ʵ忡 ������ �ִ� ���
				 if(sname.equals("") == false){
					 //���� �ִ� �ｺ�忡�� �̸��� �ش��ϴ� ����� �ִ��� �˻��� �� ���̺��� ������
					 tb_health_member.setModel(MemberDao.getInstance().selectMemberSearch(StaticValues.getSvGym_id(), sname));
				 
				 } else { //�̸� �ؽ�Ʈ�ʵ忡 �ƹ��͵� ���� ���
					 //���� �ִ� �ｺ�忡 �����ִ� ��� ȸ���� �ҷ��ͼ� ���̺��� ������
					tb_health_member.setModel(MemberDao.getInstance().selectMemberAll(StaticValues.getSvGym_id()));
				 }
				 
				 //�̸� �ؽ�Ʈ�ʵ带 �������� �ٲ�
				 tf_health_member_name.setText("");
			 }
		 });
		
		/*
		 * ���� �߻�! (���� �����Ұ����� ����)
		 * 
		 * ó�� ����ȭ�鿡�� �α����� �� �� �κа� ��ġ�� �̺�Ʈ�� �ִ� �� ���δ�
		 * �ٸ� �κп����� ���� �ڵ�� �Ȱ��� �κ��� �� �Ǳ� ������ �� �׷��� �𸣰ڴ� 
		 * 
		 //�ؽ�Ʈ�ʵ忡�� ���� ������ �� ��ȸ�� ������ ���� �Ȱ��� �� �Ͼ
		 tf_health_member_name.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent ae) { 
				 // �̸� ��ȸ ������ ȸ���� ������ ��ȸ��
				 String sname = tf_health_member_name.getText();
				 if(sname.equals("") == false){
					 tb_health_member.setModel(MemberDao.getInstance().selectMemberSearch(StaticValues.getSvGym_id(), sname));
				 } else {
					tb_health_member.setModel(MemberDao.getInstance().selectMemberAll(StaticValues.getSvGym_id()));
				 }
				 tf_health_member_name.setText("");
			 }
		 });
		 */
		 
		btn_health_member_search.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_member_search.setBounds(620, 64, 97, 23);
		pn_health_member.add(btn_health_member_search);

		JLabel lb_health_member_name = new JLabel("�� ��");
		lb_health_member_name.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_member_name.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_member_name.setBounds(402, 68, 57, 19);
		pn_health_member.add(lb_health_member_name);

		tf_health_member_name = new JTextField();
		tf_health_member_name.setBounds(465, 59, 138, 38);
		pn_health_member.add(tf_health_member_name);
		tf_health_member_name.setColumns(10);

		JButton btn_health_memberview = new JButton("ȸ�� �󼼺���");
	
		//ȸ�� �󼼺��� ��ư ���� �� �Ͼ�� �̺�Ʈ
		btn_health_memberview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//���̺����� ���� �����ؼ� ���̵� �̾Ƴ��� �κ�
				int row = tb_health_member.getSelectedRow(); //���õ� ���� ��ȯ
				if(row == -1)  return; //�ƹ��͵� ���� �ȵǾ����� ����
				
				int smem_no = (int)tb_health_member.getValueAt(row, 0); 
				//(���õ� ��, 0��°��) ���� ��ȯ : ȸ����ȣ ��ȯ
				
				//ȸ����ȣ�� ������ ȸ�������� �˻��ؼ� Static������ ����
				StaticValues.setSvMemDto(MemberDao.getInstance().selectMember(smem_no)); //����
				
				//ȸ�� �󼼺��� ���̾�α� â ���
				new HSMemberViewDialog(); 
				
				//ȸ�� �󼼺��� ���̾�α׿��� �ｺ �Ⱓ ����� �� �� �ֱ� ������ �ｺ���Ȯ�� ���̺� ����
				tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id())); 
			}
		});
		btn_health_memberview.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_memberview.setBounds(98, 418, 145, 38);
		pn_health_member.add(btn_health_memberview);

		JButton btn_health_member_update = new JButton("ȸ������");
		
		//ȸ������ ��ư ������ �Ͼ�� �̺�Ʈ
		btn_health_member_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				//���̺����� ���� �����ؼ� ���̵� �̾Ƴ��� �κ�
				int row = tb_health_member.getSelectedRow(); //���õ� ���� ��ȯ
				if(row == -1)  return; //�ƹ��͵� ���� �ȵǾ����� ����
				
				int smem_no = (int)tb_health_member.getValueAt(row, 0); 
				//(���õ� ��, 0��°��) ���� ��ȯ : ȸ����ȣ ��ȯ
				
				//ȸ����ȣ�� ������ ȸ�������� �˻��ؼ� Static������ ����
				StaticValues.setSvMemDto(MemberDao.getInstance().selectMember(smem_no));
				
				//ȸ�� ���� ���̾�α� â ���
				new HSMemberUpdateDialog(HealthScreen.this);
				
				//ȸ�� ���� ���̺� ����
				tb_health_member.setModel(MemberDao.getInstance().selectMemberAll(StaticValues.getSvGym_id()));
				//ȸ�� ���� ���̾�α׿��� ȸ�� ������ �� �� �ֱ� ������ �ｺ���Ȯ�� ���̺� ����
				tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id()));
			}
		});
		
		btn_health_member_update.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_member_update.setBounds(321, 418, 145, 38);
		pn_health_member.add(btn_health_member_update);

		JButton btn_health_memberjoin = new JButton("�� ȸ�� ���");
		
		//�� ȸ�� ��� ��ư ���� �� �߻��ϴ� �̺�Ʈ
		btn_health_memberjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				//�� ȸ�� ��� ���̾�α� â ���
				new HSNewMemberJoinDialog(HealthScreen.this);
				
				//ȸ�� ���� ���̺� ����
				tb_health_member.setModel(MemberDao.getInstance().selectMemberAll(StaticValues.getSvGym_id()));
				//�� ȸ�� ��� ���̾�α׿��� �ｺ�Ⱓ����� �� �� �ֱ� ������ �ｺ���Ȯ�� ���̺� ����
				tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id()));
			}
		});
		
		btn_health_memberjoin.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_memberjoin.setBounds(542, 418, 145, 38);
		pn_health_member.add(btn_health_memberjoin);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 136, 672, 211);
		pn_health_member.add(scrollPane);

		tb_health_member = new JTable(); //ȸ������ ���̺�
		scrollPane.setViewportView(tb_health_member);
		tb_health_member.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //�� �ุ ���� ����
		
		//�ｺ�忡 �ش��ϴ� ȸ���� �ҷ��ͼ� ���̺��� ������
		tb_health_member.setModel(MemberDao.getInstance().selectMemberAll(StaticValues.getSvGym_id()));
		
		JLabel lb_member_main = new JLabel("ȸ�� ����");
		lb_member_main.setHorizontalAlignment(SwingConstants.CENTER);
		lb_member_main.setFont(new Font("���� ����", Font.BOLD, 20));
		lb_member_main.setBounds(61, 34, 97, 28);
		pn_health_member.add(lb_member_main);

/////////////////////////////////////////////////////////////////////////////////////////////////
//Ʈ���̳� ����ȭ�� ����
		
		JPanel pn_health_trainer = new JPanel();
		pn_health_trainer.setLayout(null);
		tabbedPane.addTab("\uD2B8\uB808\uC774\uB108 \uAD00\uB9AC", null, pn_health_trainer, null);

		JLabel lb_health_trainer_name = new JLabel("�� ��");
		lb_health_trainer_name.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_trainer_name.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_health_trainer_name.setBounds(402, 68, 57, 19);
		pn_health_trainer.add(lb_health_trainer_name);

		tf_health_trainer_name = new JTextField();
		tf_health_trainer_name.setColumns(10);
		tf_health_trainer_name.setBounds(465, 59, 138, 38);
		pn_health_trainer.add(tf_health_trainer_name);

		JButton btn_health_trainer_name = new JButton("�� ȸ");
		btn_health_trainer_name.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_trainer_name.setBounds(620, 64, 97, 23);
		pn_health_trainer.add(btn_health_trainer_name);
		
		//�̸� �ؽ�Ʈ�ʵ� ���� ��ȸ ��ư�� ���� �� �߻��Ǵ� �̺�Ʈ : �̸��� �ش��ϴ� Ʈ���̳� ������ ��ȸ��
		btn_health_trainer_name.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { 
				 //�̸� �ؽ�Ʈ�ʵ��� ������ �о��
				 String trainer_name = tf_health_trainer_name.getText();
				 
				 //�̸� �ؽ�Ʈ�ʵ忡 ������ �ִ� ��� 
				 if(trainer_name.equals("") == false){
					//���� �ִ� �ｺ�忡�� Ʈ���̳� �̸��� �ش��ϴ� ����� �ִ��� �˻��� �� ���̺��� ������
					tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerSearch(StaticValues.getSvGym_id(), trainer_name));
				
				 } else { //�̸� �ؽ�Ʈ�ʵ忡 �ƹ��͵� ���� ���
					//���� �ִ� �ｺ�忡 �����ִ� ��� Ʈ���̳ʸ� �ҷ��ͼ� ���̺��� ������
					tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerAll(StaticValues.getSvGym_id()));
				 }
				 //�̸� �ؽ�Ʈ�ʵ带 �������� �ٲ�
				 tf_health_trainer_name.setText("");
			 }
		 });
		//���� Ʈ���̳� �̸� �ؽ�Ʈ�ʵ忡�� ���͸� ģ�ٸ� �����ִ� �޼ҵ�� �Ȱ��� ������ �����
		tf_health_trainer_name.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { 
				 String trainer_name = tf_health_trainer_name.getText();
				 if(trainer_name.equals("") == false){
					 tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerSearch(StaticValues.getSvGym_id(), trainer_name));
				 } else {
						tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerAll(StaticValues.getSvGym_id()));
				 }
				 tf_health_trainer_name.setText("");
			 }
		 });
		
		JButton btn_health_trainerview = new JButton("Ʈ���̳� �󼼺���");

		//Ʈ���̳� �󼼺��� ��ư ������ �߻��Ǵ� �̺�Ʈ
		btn_health_trainerview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = tb_health_trainer.getSelectedRow(); //���õ� ���� ��ȯ
				if(row == -1)  return; //�ƹ��͵� ���� �ȵǾ����� ����
				int trainer_no = (int)tb_health_trainer.getValueAt(row, 0);
				//(���õ� ��, 0��°��) ���� ��ȯ :Ʈ���̳� ��ȣ ��ȯ
				
				//Ʈ���̳� ��ȣ�� ������ Ʈ���̳� ������ �˻��ؼ� Static������ ����
				StaticValues.setSvTrainerDto(TrainerDao.getInstance().selectTrainer(trainer_no)); 
				
				//Ʈ���̳� �󼼺��� ���̾�α� ���
				new HSTrainerViewDialog();
			}
		});

		btn_health_trainerview.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_trainerview.setBounds(98, 418, 163, 38);
		pn_health_trainer.add(btn_health_trainerview);

		JButton btn_health_trainerupdate = new JButton("Ʈ���̳� ����");
		
		//Ʈ���̳� ���� ��ư ������ �߻��Ǵ� �̺�Ʈ
		btn_health_trainerupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				//���̺����� ���� �����ؼ� ���̵� �̾Ƴ��� �κ�
				int row = tb_health_trainer.getSelectedRow(); //���õ� ���� ��ȯ
				if(row == -1)  return; //�ƹ��͵� ���� �ȵǾ����� ����
				int trainer_no = (int)tb_health_trainer.getValueAt(row, 0); 
				//(���õ� ��, 0��°��) ���� ��ȯ :Ʈ���̳� ��ȣ ��ȯ
				
				//Ʈ���̳� ��ȣ�� ������ Ʈ���̳� ������ �˻��ؼ� Static������ ����
				StaticValues.setSvTrainerDto(TrainerDao.getInstance().selectTrainer(trainer_no));
				
				//Ʈ���̳� ���� ���̾�α� ���
				new HSTrainerUpdateDialog(HealthScreen.this);
				
				//Ʈ���̳� ���� ���̺� ����
				tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerAll(StaticValues.getSvGym_id()));
				//�ｺ��� Ȯ�� ���̺� ����
				tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id()));
			}
		});
		btn_health_trainerupdate.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_trainerupdate.setBounds(321, 418, 145, 38);
		pn_health_trainer.add(btn_health_trainerupdate);

		JButton btn_health_trainerjoin = new JButton("Ʈ���̳� ���");
		
		//Ʈ���̳� ��� ��ư ���� �� �߻��Ǵ� �̺�Ʈ
		btn_health_trainerjoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//Ʈ���̳� ��� ���̾�α� ���
				new HSTrainerJoinDialog(HealthScreen.this);
				
				/*
				 * (���� ���� �Ұ����� ����) : Ʈ���̳� ����ϰ� ���� ���̺� ������ �ȵ�
				 * ���� �ڵ�� ���� ���� �ڵ�� �Ȱ����� �� ���⼭�� Ʈ���̳� ���̺� ������ �ȵǴ� ���� �𸣰���
				 */
				//Ʈ���̳� ���� ���̺� �����ϴ� �ڵ� ������ ������ �ȵ�
				tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerAll(StaticValues.getSvGym_id()));
			}
		});
		
		btn_health_trainerjoin.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_health_trainerjoin.setBounds(542, 418, 145, 38);
		pn_health_trainer.add(btn_health_trainerjoin);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 136, 674, 211);
		pn_health_trainer.add(scrollPane_1);

		tb_health_trainer = new JTable(); //Ʈ���̳� ���̺�
		scrollPane_1.setViewportView(tb_health_trainer);
		
		tb_health_trainer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //�� �ุ ���� ����

		//�ｺ�忡 �ش��ϴ� Ʈ���̳ʸ� �ҷ��ͼ� ���̺��� ������
		tb_health_trainer.setModel(TrainerDao.getInstance().selectTrainerAll(StaticValues.getSvGym_id()));
		
		JLabel lb_trainer_main = new JLabel("Ʈ���̳� ����");
		lb_trainer_main.setHorizontalAlignment(SwingConstants.CENTER);
		lb_trainer_main.setFont(new Font("���� ����", Font.BOLD, 20));
		lb_trainer_main.setBounds(61, 34, 145, 28);
		pn_health_trainer.add(lb_trainer_main);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//�ｺ ��� Ȯ�� ����		

		JPanel pn_health_join = new JPanel();
		pn_health_join.setLayout(null);
		tabbedPane.addTab("\uD5EC\uC2A4\uC7A5\uB4F1\uB85D \uD655\uC778", null, pn_health_join, null);

		JLabel lb_healthmember_name = new JLabel("ȸ�� �̸�");
		lb_healthmember_name.setHorizontalAlignment(SwingConstants.CENTER);
		lb_healthmember_name.setFont(new Font("���� ����", Font.BOLD, 15));
		lb_healthmember_name.setBounds(390, 68, 70, 19);
		pn_health_join.add(lb_healthmember_name);

		tf_healthmember_name = new JTextField();
		tf_healthmember_name.setColumns(10);
		tf_healthmember_name.setBounds(470, 61, 138, 38);
		pn_health_join.add(tf_healthmember_name);

		JButton btn_healthmember_ok = new JButton("�� ȸ");
		
		//ȸ���̸� �ؽ�Ʈ�ʵ� ���� ��ȸ��ư�� ������ �߻��ϴ� �̺�Ʈ : �̸��� �ش��ϴ� ȸ���� �ｺ���������������
		 btn_healthmember_ok.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { 
				 String mem_name = tf_healthmember_name.getText(); //ȸ���̸��� �о��

				 //ȸ���̸� �ؽ�Ʈ�ʵ忡 ������ �ִ� ���
				 if(mem_name.equals("") == false){
					//���� �ִ� �ｺ�忡�� �̸��� �ش��ϴ� ����� ��������� �ִ��� �˻��� �� ���̺��� ������
					 tb_healthmember_search.setModel(RegDao.getInstance().selectRegSearch(StaticValues.getSvGym_id(), mem_name));
				 
				 } else { //ȸ���̸� �ؽ�Ʈ�ʵ忡 �ƹ��͵� ���� ���
					 //���� �ִ� �ｺ�忡 �����ִ� ��� �ｺ��������� �ҷ��ͼ� ���̺��� ������
					tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id()));
				 }
				 //ȸ���̸� �ؽ�Ʈ�ʵ带 �������� �ٲ�
				 tf_healthmember_name.setText("");
			 }
		 });
		 //ȸ���̸� �ؽ�Ʈ�ʵ忡�� ���͸� ������ ���� �Ȱ��� ������ �����
		 tf_healthmember_name.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { 
				 String mem_name = tf_healthmember_name.getText();
				 if(mem_name.equals("") == false){
					 tb_healthmember_search.setModel(RegDao.getInstance().selectRegSearch(StaticValues.getSvGym_id(), mem_name));
				 } else {
					tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id()));
				 }
				 tf_healthmember_name.setText("");
			 }
		 });
		 
		btn_healthmember_ok.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_healthmember_ok.setBounds(620, 66, 97, 23);
		pn_health_join.add(btn_healthmember_ok);

		JLabel lb_health_main = new JLabel("�ｺ��� Ȯ��");
		lb_health_main.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_main.setFont(new Font("���� ����", Font.BOLD, 20));
		lb_health_main.setBounds(61, 34, 165, 28);
		pn_health_join.add(lb_health_main);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(62, 136, 674, 337);
		pn_health_join.add(scrollPane_2);

		tb_healthmember_search = new JTable(); //�ｺ�Ⱓ��� ���̺�
		scrollPane_2.setViewportView(tb_healthmember_search);
		tb_healthmember_search.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //�� �ุ ���� ����
		
		//�ｺ�忡 �ش��ϴ� �ｺ��� Ȯ�� ������ �ҷ��ͼ� ���̺��� ������
		tb_healthmember_search.setModel(RegDao.getInstance().selectRegAll(StaticValues.getSvGym_id()));

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null); //â�� ����� ���� ��
		setVisible(true);
	}
}