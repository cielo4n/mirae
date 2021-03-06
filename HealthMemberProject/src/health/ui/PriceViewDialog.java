package health.ui;

import health.database.GymDao;
import health.database.PriceDao;
import health.value.StaticValues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//연매출, 월매출 보기 다이얼로그
public class PriceViewDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tb_sales_health_year;
	private JTable tb_sales_health_month;
	private int selectYear;
	
	public PriceViewDialog() {
		setResizable(false);
		setModal(true);
		setTitle("매출보기");
		setBounds(100, 100, 700,600);
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
			JLabel lb_sales_year = new JLabel("연간 매출");
			lb_sales_year.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lb_sales_year.setBounds(105, 109, 100, 43);
			getContentPane().add(lb_sales_year);
		}
		{
			JLabel lb_sales_month = new JLabel("월간 매출");
			lb_sales_month.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lb_sales_month.setBounds(454, 109, 100, 43);
			getContentPane().add(lb_sales_month);
		}
		
		JLabel lb_sales_health = new JLabel("New label");
		lb_sales_health.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lb_sales_health.setHorizontalAlignment(SwingConstants.CENTER);
		lb_sales_health.setBounds(105, 32, 449, 43);
		getContentPane().add(lb_sales_health);
		
		//헬스장 번호가지고 이름을 뽑아내서 라벨로 출력
		lb_sales_health.setText(GymDao.getInstance().gym_idToGym_name(StaticValues.getSvGym_id()));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 184, 222, 214);
		getContentPane().add(scrollPane);
		
		//연간매출 뽑음
		tb_sales_health_year = new JTable();
		scrollPane.setViewportView(tb_sales_health_year);
		tb_sales_health_year.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		tb_sales_health_year.setModel(PriceDao.getInstance().selectYearPrice(StaticValues.getSvGym_id()));
		tb_sales_health_year.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 184, 286, 214);
		getContentPane().add(scrollPane_1);

		
		//여기서 연도 뭐가 선택되었는지 확인함
		tb_sales_health_year.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent event){
				int row = tb_sales_health_year.getSelectedRow(); //선택된 행 반환
				if(row == -1) return; //아무것도 선택 안되었으면 리턴
				selectYear = (Integer)tb_sales_health_year.getValueAt(row, 0); //선택된 행의 0번째 열 값 반환
				
				tb_sales_health_month.setModel(PriceDao.getInstance().selectMonthPrice(StaticValues.getSvGym_id(), selectYear));
	
			}
		});
		
		//월간매출 뽑음
		tb_sales_health_month = new JTable();
		scrollPane_1.setViewportView(tb_sales_health_month);
		tb_sales_health_month.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_sales_health_month.setModel(PriceDao.getInstance().selectMonthPrice(StaticValues.getSvGym_id(), selectYear));
		
		JButton btn_sales_OK = new JButton("확 인");
		btn_sales_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //확인누르면 다이얼로그 닫힘
				setVisible(false);
			}
		});
		btn_sales_OK.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_sales_OK.setBounds(269, 455, 117, 43);
		getContentPane().add(btn_sales_OK);
		tb_sales_health_month.getColumnModel().getColumn(0).setPreferredWidth(30);
		tb_sales_health_month.getColumnModel().getColumn(1).setPreferredWidth(30);
		
		setVisible(true);
	}
	
}
