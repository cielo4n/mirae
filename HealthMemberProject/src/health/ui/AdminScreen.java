package health.ui;

import health.database.GymDao;
import health.value.StaticValues;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//관리자 로그인 시 나오는 관리자메인화면
public class AdminScreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tb_adminscreen;
	private JButton btn_adminscreen_view;
	private JButton btn_adminscreen_sales;
	private JButton btn_adminscreen_join;
	private JButton btn_admin_logout;

	public AdminScreen() {
		setResizable(false);
		setTitle("관리자 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lb_health_list = new JLabel("헬스장 목록");
		lb_health_list.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lb_health_list.setHorizontalAlignment(SwingConstants.CENTER);
		lb_health_list.setBounds(45, 49, 117, 38);
		layeredPane.add(lb_health_list);

		btn_admin_logout = new JButton("로그아웃");
		btn_admin_logout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_admin_logout.setBounds(650, 20, 110, 30);
		layeredPane.add(btn_admin_logout);

		btn_adminscreen_view = new JButton("헬스장 상세보기");
		btn_adminscreen_view.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_adminscreen_view.setBounds(90, 442, 140, 45);
		layeredPane.add(btn_adminscreen_view);

		btn_adminscreen_sales = new JButton("헬스장 매출보기");
		btn_adminscreen_sales.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_adminscreen_sales.setBounds(292, 442, 140, 45);
		layeredPane.add(btn_adminscreen_sales);

		btn_adminscreen_join = new JButton("헬스장 등록");
		btn_adminscreen_join.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btn_adminscreen_join.setBounds(503, 442, 140, 45);
		layeredPane.add(btn_adminscreen_join);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 132, 666, 249);
		layeredPane.add(scrollPane);
		tb_adminscreen = new JTable();
		tb_adminscreen.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		tb_adminscreen.setFillsViewportHeight(true);
		// 테이블에서 하나의 행만 선택 가능
		tb_adminscreen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		tb_adminscreen.setModel(GymDao.getInstance().selectGymAll(
				StaticValues.getSvAdmin_id()));
		scrollPane.setViewportView(tb_adminscreen);

		btn_adminscreen_view.addActionListener(this);
		btn_adminscreen_sales.addActionListener(this);
		btn_adminscreen_join.addActionListener(this);
		btn_admin_logout.addActionListener(this);
		setVisible(true);
	} // 생성자 끝

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		if (obj == btn_admin_logout) { // 로그아웃하면 메인화면으로 간다
			setVisible(false);
			new MainScreen();
		} else if (obj != btn_adminscreen_join) {
			// 테이블에서 행을 선택해서 아이디를 뽑아내는 부분
			int row = tb_adminscreen.getSelectedRow(); // 선택된 행을 반환
			if (row == -1)
				return; // 아무것도 선택 안되었으면 리턴
			String gym_id = (String) tb_adminscreen.getValueAt(row, 0); 
			// (행, 열)값 반환.  행의 0번째열 값 반환
			StaticValues.setSvGym_id(gym_id); // 선택한 헬스장 아이디 저장

			if (obj == btn_adminscreen_view) { // 누르면 헬스장을 상세히볼수잇는버튼
				new ASHealthViewDialog();
				tb_adminscreen.setModel(GymDao.getInstance().selectGymAll(
						StaticValues.getSvAdmin_id()));

			} else if (obj == btn_adminscreen_sales) { // 헬스장 매출보여주는 이벤트
				new PriceViewDialog();
			}

		} else if (obj == btn_adminscreen_join) { // 새로운 헬스장 등록해주는 이벤트
			new ASHealthJoinDialog(AdminScreen.this);
			tb_adminscreen.setModel(GymDao.getInstance().selectGymAll(
					StaticValues.getSvAdmin_id()));
		}
	}
}
