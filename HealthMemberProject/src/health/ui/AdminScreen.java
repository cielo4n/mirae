package health.ui;

import health.database.GymDao;
import health.value.StaticValues;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//������ �α��� �� ������ �����ڸ���ȭ��
public class AdminScreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tb_adminscreen;
	private JButton btn_adminscreen_view;
	private JButton btn_adminscreen_sales;
	private JButton btn_adminscreen_join;
	private JButton btn_admin_logout;

	public AdminScreen() {
		setResizable(false);
		setTitle("������ ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lb_health_list = new JLabel("�ｺ�� ���");
		lb_health_list.setFont(new Font("���� ����", Font.BOLD, 20));
		lb_health_list.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_list.setBounds(45, 49, 117, 38);
		layeredPane.add(lb_health_list);

		btn_admin_logout = new JButton("�α׾ƿ�");
		btn_admin_logout.setFont(new Font("���� ����", Font.BOLD, 13));
		btn_admin_logout.setBounds(650, 20, 110, 30);
		layeredPane.add(btn_admin_logout);

		btn_adminscreen_view = new JButton("�ｺ�� �󼼺���");
		btn_adminscreen_view.setFont(new Font("���� ����", Font.BOLD, 13));
		btn_adminscreen_view.setBounds(90, 442, 140, 45);
		layeredPane.add(btn_adminscreen_view);

		btn_adminscreen_sales = new JButton("�ｺ�� ���⺸��");
		btn_adminscreen_sales.setFont(new Font("���� ����", Font.BOLD, 13));
		btn_adminscreen_sales.setBounds(292, 442, 140, 45);
		layeredPane.add(btn_adminscreen_sales);

		btn_adminscreen_join = new JButton("�ｺ�� ���");
		btn_adminscreen_join.setFont(new Font("���� ����", Font.BOLD, 13));
		btn_adminscreen_join.setBounds(503, 442, 140, 45);
		layeredPane.add(btn_adminscreen_join);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 132, 666, 249);
		layeredPane.add(scrollPane);
		tb_adminscreen = new JTable();
		tb_adminscreen.setFont(new Font("���� ����", Font.BOLD, 15));
		tb_adminscreen.setFillsViewportHeight(true);
		// ���̺����� �ϳ��� �ุ ���� ����
		tb_adminscreen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		tb_adminscreen.setModel(GymDao.getInstance().selectGymAll(
				StaticValues.getSvAdmin_id()));
		scrollPane.setViewportView(tb_adminscreen);

		btn_adminscreen_view.addActionListener(this);
		btn_adminscreen_sales.addActionListener(this);
		btn_adminscreen_join.addActionListener(this);
		btn_admin_logout.addActionListener(this);
		setVisible(true);
	} // ������ ��

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		if (obj == btn_admin_logout) { // �α׾ƿ��ϸ� ����ȭ������ ����
			setVisible(false);
			new MainScreen();
		} else if (obj != btn_adminscreen_join) {
			// ���̺����� ���� �����ؼ� ���̵� �̾Ƴ��� �κ�
			int row = tb_adminscreen.getSelectedRow(); // ���õ� ���� ��ȯ
			if (row == -1)
				return; // �ƹ��͵� ���� �ȵǾ����� ����
			String gym_id = (String) tb_adminscreen.getValueAt(row, 0); 
			// (��, ��)�� ��ȯ.  ���� 0��°�� �� ��ȯ
			StaticValues.setSvGym_id(gym_id); // ������ �ｺ�� ���̵� ����

			if (obj == btn_adminscreen_view) { // ������ �ｺ���� ���������մ¹�ư
				new ASHealthViewDialog();
				tb_adminscreen.setModel(GymDao.getInstance().selectGymAll(
						StaticValues.getSvAdmin_id()));

			} else if (obj == btn_adminscreen_sales) { // �ｺ�� ���⺸���ִ� �̺�Ʈ
				new PriceViewDialog();
			}

		} else if (obj == btn_adminscreen_join) { // ���ο� �ｺ�� ������ִ� �̺�Ʈ
			new ASHealthJoinDialog(AdminScreen.this);
			tb_adminscreen.setModel(GymDao.getInstance().selectGymAll(
					StaticValues.getSvAdmin_id()));
		}
	}
}