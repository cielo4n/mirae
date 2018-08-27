package health.ui;

import health.database.GymDao;
import health.database.PriceDao;
import health.value.StaticValues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

//������, ������ ���� ���̾�α�
public class PriceViewDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tb_sales_health_year;
	private JTable tb_sales_health_month;
	private int selectYear;
	
	public PriceViewDialog() {
		setResizable(false);
		setModal(true);
		setTitle("���⺸��");
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
			JLabel lb_sales_year = new JLabel("���� ����");
			lb_sales_year.setFont(new Font("���� ����", Font.BOLD, 20));
			lb_sales_year.setBounds(105, 109, 100, 43);
			getContentPane().add(lb_sales_year);
		}
		{
			JLabel lb_sales_month = new JLabel("���� ����");
			lb_sales_month.setFont(new Font("���� ����", Font.BOLD, 20));
			lb_sales_month.setBounds(454, 109, 100, 43);
			getContentPane().add(lb_sales_month);
		}
		
		JLabel lb_sales_health = new JLabel("New label");
		lb_sales_health.setFont(new Font("���� ����", Font.BOLD, 25));
		lb_sales_health.setHorizontalAlignment(SwingConstants.CENTER);
		lb_sales_health.setBounds(105, 32, 449, 43);
		getContentPane().add(lb_sales_health);
		
		//�ｺ�� ��ȣ������ �̸��� �̾Ƴ��� �󺧷� ���
		lb_sales_health.setText(GymDao.getInstance().gym_idToGym_name(StaticValues.getSvGym_id()));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 184, 222, 214);
		getContentPane().add(scrollPane);
		
		//�������� ����
		tb_sales_health_year = new JTable();
		scrollPane.setViewportView(tb_sales_health_year);
		tb_sales_health_year.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		tb_sales_health_year.setModel(PriceDao.getInstance().selectYearPrice(StaticValues.getSvGym_id()));
		tb_sales_health_year.getColumnModel().getColumn(0).setPreferredWidth(30);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 184, 286, 214);
		getContentPane().add(scrollPane_1);

		
		//���⼭ ���� ���� ���õǾ����� Ȯ����
		tb_sales_health_year.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent event){
				int row = tb_sales_health_year.getSelectedRow(); //���õ� �� ��ȯ
				if(row == -1) return; //�ƹ��͵� ���� �ȵǾ����� ����
				selectYear = (Integer)tb_sales_health_year.getValueAt(row, 0); //���õ� ���� 0��° �� �� ��ȯ
				
				tb_sales_health_month.setModel(PriceDao.getInstance().selectMonthPrice(StaticValues.getSvGym_id(), selectYear));
	
			}
		});
		
		//�������� ����
		tb_sales_health_month = new JTable();
		scrollPane_1.setViewportView(tb_sales_health_month);
		tb_sales_health_month.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_sales_health_month.setModel(PriceDao.getInstance().selectMonthPrice(StaticValues.getSvGym_id(), selectYear));
		
		JButton btn_sales_OK = new JButton("Ȯ ��");
		btn_sales_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Ȯ�δ����� ���̾�α� ����
				setVisible(false);
			}
		});
		btn_sales_OK.setFont(new Font("���� ����", Font.BOLD, 20));
		btn_sales_OK.setBounds(269, 455, 117, 43);
		getContentPane().add(btn_sales_OK);
		tb_sales_health_month.getColumnModel().getColumn(0).setPreferredWidth(30);
		tb_sales_health_month.getColumnModel().getColumn(1).setPreferredWidth(30);
		
		setVisible(true);
	}
	
}