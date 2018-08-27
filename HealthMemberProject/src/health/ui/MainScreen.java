package health.ui;

import health.database.AdminDao;
import health.database.GymDao;
import health.value.StaticValues;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

//ó�� ���۽� ���� ȭ��
public class MainScreen extends JFrame implements ActionListener {

	BufferedImage img = null;
	JTextField loginTextField = null;
	JPasswordField passwordField = null;
	JButton bt, bt2, bt3, bt4;
	JRadioButton CB = null;
	JRadioButton CB1 = null;

	int frm = 400, frm1 = 300;
	int screen_width, screen_height;

	// ������
	public MainScreen() {
		setResizable(false);
		setTitle("The Future Fitness Club");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// ���̾ƿ� ����
		getContentPane().setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 794, 572);
		layeredPane.setLayout(null);
		setLocationRelativeTo(null); //â�� ����� ��ġ

		// �г�1
		// �̹��� �޾ƿ���
		try {
			img = ImageIO.read(new File("img/main.jpg"));
		} catch (IOException e) {
			System.out.println("�̹��� �ҷ����� ����");
			System.exit(0);
		}

		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 800, 600);

		// �α��� �ʵ�
		loginTextField = new JTextField(15);
		loginTextField.setFont(new Font("���� ����", Font.BOLD, 15));
		loginTextField.setBounds(264, 242, 270, 24);
		layeredPane.add(loginTextField);
		loginTextField.setOpaque(false);
		loginTextField.setForeground(Color.BLACK);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		// �н�����
		passwordField = new JPasswordField(15);
		passwordField.setFont(new Font("���� ����", Font.BOLD, 15));
		passwordField.setBounds(264, 313, 270, 24);
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);

		// �α��ι�ư �߰�
		bt = new JButton(new ImageIcon("img/login_n.png"));

		//���콺 ������ �׸��� �ٲ�
		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bt.setIcon((new ImageIcon("img/login_p.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				bt.setIcon((new ImageIcon("img/login_n.png")));
			}
		});
		bt.setBounds(264, 431, 130, 40);

		bt2 = new JButton(new ImageIcon("img/join_n.png"));

		//���콺 ������ �׸��� �ٲ�
		bt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bt2.setIcon((new ImageIcon("img/join_p.png")));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				bt2.setIcon((new ImageIcon("img/join_n.png")));
			}
		});
		bt2.setBounds(404, 431, 130, 40);

		bt3 = new JButton(new ImageIcon("img/check_n.png"));
		bt3.setBounds(289, 384, 12, 12);

		bt4 = new JButton(new ImageIcon("img/check_n.png"));
		bt4.setBounds(419, 384, 12, 12);

		// ��ư ����ó��
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
        bt.setContentAreaFilled(false);

		bt2.setBorderPainted(false);
		bt2.setFocusPainted(false);
		bt2.setContentAreaFilled(false);

		bt3.setBorderPainted(false);
		bt3.setFocusPainted(false);
		bt3.setContentAreaFilled(false);

		bt4.setBorderPainted(false);
		bt4.setFocusPainted(false);
		bt4.setContentAreaFilled(false);

		layeredPane.add(bt);
		layeredPane.add(bt2);
		layeredPane.add(bt3);
		layeredPane.add(bt4);

		// ������ �߰���
		layeredPane.add(panel);
		getContentPane().add(layeredPane);

		CheckboxGroup gb = new CheckboxGroup();
		ButtonGroup bg = new ButtonGroup();

		CB = new JRadioButton(new ImageIcon("img/check_n.png"));

		CB.addItemListener(new ItemListener() { 
			// üũ�ڽ��� üũ���Ǹ� üũ��ư�� üũ���Ǵ� �̺�Ʈ
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					bt3.setIcon((new ImageIcon("img/check_p.png")));
				else
					bt3.setIcon((new ImageIcon("img/check_n.png")));
			}
		});
		CB.setBounds(289, 384, 90, 30);
		layeredPane.add(CB);
		CB.setBorderPainted(false);
		CB.setFocusPainted(false);
		CB.setContentAreaFilled(false);

		CB1 = new JRadioButton(new ImageIcon("img/check_n.png"));
		CB1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// üũ�ڽ��� üũ���Ǹ� üũ��ư�� üũ���Ǵ� �̺�Ʈ
				if (e.getStateChange() == ItemEvent.SELECTED)
					bt4.setIcon((new ImageIcon("img/check_p.png")));
				else
					bt4.setIcon((new ImageIcon("img/check_n.png")));

			}
		});
		CB1.setBounds(419, 384, 90, 30);
		layeredPane.add(CB1);
		CB1.setBorderPainted(false);
		CB1.setFocusPainted(false);
		CB1.setContentAreaFilled(false);

		bg.add(CB);
		bg.add(CB1);

		bt.addActionListener(this);
		bt2.addActionListener(this);
		
		setVisible(true);
	} // end ������

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		// �����ڵ�� ��ư ������ ���̾�α� ������ �̺�Ʈ
		if (obj == bt2) {
			new MSAdminJoinDialog(MainScreen.this);
		}
		
		// �α��� ������ �����ڿ�üũ�ƴ��� �ｺ�忡 üũ�ƴ��� Ȯ���� �α������ִ��̺�Ʈ
		else if (obj == bt) {
			String id = loginTextField.getText();
			String pw = new String(passwordField.getPassword());

			if (id.equals("") || pw.equals("")) { // ������ ���
				WarningMessage.mainScreenLoginBlankWarning();
				return;
			}

			// üũ�ڽ��� ������ ���õǾ��� ����
			//�ƹ��͵� ������ �ȵǾ����� ���â
			if (CB.isSelected() == false && CB1.isSelected() == false) {
				WarningMessage.mainScreenLoginCheck();
				return;
			}

			// ������ ���õǰ� �α���
			if (CB.isSelected() == true) {
				// ���̵��ϰ� ��й�ȣ �ȸ����� ���â
				if (AdminDao.getInstance().compareAdmin(id, pw) == false) {
					WarningMessage.mainScreenLoginWarning();
					return;
				} 
				 // ���̵��ϰ� ��й�ȣ ������
				StaticValues.setSvAdmin_id(id);
				setVisible(false);
				new AdminScreen(); // ������ ȭ������ ��
			}

			// �ｺ�� ���õǰ� �α���
			else if (CB1.isSelected() == true) {
				// ���̵��ϰ� ��й�ȣ �ȸ����� ���â
				if (GymDao.getInstance().compareGym(id, pw) == false) {
					WarningMessage.mainScreenLoginWarning();
					return;
				}
				// ���̵��ϰ� ��й�ȣ ������
				StaticValues.setSvAdmin_id(GymDao.getInstance().gym_idToAdmin_id(id));
				StaticValues.setSvGym_id(id);
				setVisible(false);
				new HealthScreen(); // �ｺ�� ȭ������ ��
			}	
		}
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

	// ����
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		//����� ����
		
		MainScreen frame = new MainScreen();

	}
}