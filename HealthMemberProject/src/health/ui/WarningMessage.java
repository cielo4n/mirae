
package health.ui;

import javax.swing.JOptionPane;

//���â�� ���� ���� JOptionPane�� ��Ƴ��� Ŭ����
public class WarningMessage {

//	public static void MainScreenLoginWarning()  // ���� ȭ�鿡�� �α��ν� ���� ������϶� 
//	{
//		JOptionPane.showMessageDialog(null, "��ϵ� ������� ������ �ƴմϴ�.", "�� ��� ����", JOptionPane.ERROR_MESSAGE);
//	}

	public static void notSamePassward()  // �н����尡 ����ġ�ҋ�
	{
		JOptionPane.showMessageDialog(null, "�н����尡 �������� Ȯ�����ּ���", "�н����� ����ġ", JOptionPane.WARNING_MESSAGE);
	}

	public static void mainScreenJoinSuccess() // ���� ȭ�鿡�� ������ ��Ͻ� ���������� ��� �Ϸ�Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� ��ϵǾ����ϴ�.", "������ ��� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void mainScreenJoinFailure() // ���� ȭ�鿡�� ������ ��Ͻ� ��Ͻ������� ��
	{
		JOptionPane.showMessageDialog(null, "����� �����߽��ϴ�.", "������ ��� ����", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mainScreenLoginWarning()  // ���� ȭ�鿡�� �α��ν� ���̵� ���ų�, ��й�ȣ�� �ȸ°ų� �� ��� 
	{
		JOptionPane.showMessageDialog(null, "���̵�� �н����带 Ȯ�����ּ���", "�α��� ����", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mainScreenLoginBlankWarning()  // ���� ȭ�鿡�� �α��ν� ���̵�� ��й�ȣ �Է� ����
	{
		JOptionPane.showMessageDialog(null, "���̵�� �н����带 �Է����ּ���", "�� �Է� ����", JOptionPane.WARNING_MESSAGE);
	}

	public static void blankWarning() // ȸ�����,Ʈ���̳ʵ�� ( ���Ӱ� ����Ҷ� ��ĭ�� ó������ �ʰ� �������)
	{
		JOptionPane.showMessageDialog(null, "��ĭ�� �������� �Է����ּ���.", "�� �Է� ����", JOptionPane.WARNING_MESSAGE);
	}

	public static void mainScreenLoginCheck() // ���������� �ｺ������ üũ�� �ȵǾ��ִ� ���
	{
		JOptionPane.showMessageDialog(null, "������ �Ǵ� �ｺ���� üũ���ּ���.", "�� üũ �׸�", JOptionPane.WARNING_MESSAGE);
	}

	public static void duplicationWarning() // ������, �ｺ�� ��Ͻ� ���̵� �ߺ��� ��
	{
		JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�", "��� ����", JOptionPane.ERROR_MESSAGE);
	}

	public static void healthJoin() // �ｺ�� ��Ͻ� ���������� ��ϿϷ�Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� ��ϵǾ����ϴ�.", "�ｺ�� ��ϿϷ�", JOptionPane.PLAIN_MESSAGE);
	}

	public static boolean healthDelete()  // �ｺ�� �����Ҷ� 
	{
		int abc;

		abc = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "�ｺ�� ����", JOptionPane.YES_NO_OPTION);
		if (abc == JOptionPane.YES_OPTION) {
			return true;
		} else if (abc == JOptionPane.NO_OPTION) {
			return false;
		} 
		return false;
	}

	public static void healthDeleteOK(){
		JOptionPane.showMessageDialog(null, "���� �Ϸ�Ǿ����ϴ�.", "�ｺ�� ���� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}
	public static void healthDeleteCancel(){
		JOptionPane.showMessageDialog(null, "�ｺ�� ������ ��ҵǾ����ϴ�.", "�ｺ�� ���� ���", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void healthUpdateSuccess()  // �ｺ�� �����Ҷ� ������ ���������� �Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� �����Ǿ����ϴ�.", "�ｺ�� �����Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}

	public static void trainerJoin()  // Ʈ���̳� ��Ͻ� ���������� ��ϿϷ�Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� ��ϵǾ����ϴ�.", "Ʈ���̳� ��ϿϷ�", JOptionPane.PLAIN_MESSAGE);
	}

	public static void inputYearFailure(){
		JOptionPane.showMessageDialog(null, "��������� ���ڷ� �Է��ؾ� �մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void inputHeightFailure(){
		JOptionPane.showMessageDialog(null, "Ű�� ���ڷ� �Է��ؾ� �մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);	

	}
	public static void inputWeightFailure(){
		JOptionPane.showMessageDialog(null, "�����Դ� ���ڷ� �Է��ؾ� �մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);	

	}
	public static void inputRegYearFailure(){
		JOptionPane.showMessageDialog(null, "������� ���ڷ� �Է��ؾ� �մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void inputCareerFailure(){
		JOptionPane.showMessageDialog(null, "����� ���ڷ� �Է��ؾ� �մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);	
	}
	
	public static void memberUpdate()  // ȸ�� ������ ���������� �����Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� �����Ǿ����ϴ�.", "ȸ�� �����Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}

	public static boolean memberDelete()  // ȸ�� �����Ҷ�
	{
		int abc;

		abc = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "ȸ�� ����", JOptionPane.YES_NO_OPTION);
		if(abc == JOptionPane.YES_OPTION) { 
			return true;
			
		} else if(abc == JOptionPane.NO_OPTION){
			return false;
		}
		return false;
	}	
	
	public static void memberDeleteOK(){
		JOptionPane.showMessageDialog(null, "���� �Ϸ�Ǿ����ϴ�.", "ȸ�� ���� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}
	public static void memberDeleteCancel(){
		JOptionPane.showMessageDialog(null, "ȸ�� ������ ��ҵǾ����ϴ�.", "ȸ�� ���� ���", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void healthRegister() // �ｺ �Ⱓ����Ҷ� ���������� ��ϿϷ� �޼���
	{
		JOptionPane.showMessageDialog(null, "�ｺ��� �Ϸ�Ǿ����ϴ�.", "�ｺ��� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}

	public static void memberJoin() // ȸ�� ��Ͻ� ���������� ��ϿϷ�Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� ��ϵǾ����ϴ�.", "ȸ����� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void trainerUpdateSuccess()  // Ʈ���̳� �����Ҷ� ���������� �����Ǿ�����
	{
		JOptionPane.showMessageDialog(null, "���������� �����Ǿ����ϴ�.", "Ʈ���̳� �����Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}

	public static void trainerDeleteOK(){
		JOptionPane.showMessageDialog(null, "���� �Ϸ�Ǿ����ϴ�.", "Ʈ���̳� ���� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
	}
	public static void trainerDeleteCancel(){
		JOptionPane.showMessageDialog(null, "ȸ�� ������ ��ҵǾ����ϴ�.", "Ʈ���̳� ���� ���", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean trainerDelete()  // Ʈ���̳� �����Ҷ�
	{
		int abc;

		abc = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "Ʈ���̳� ����", JOptionPane.YES_NO_OPTION);
		if (abc == JOptionPane.YES_OPTION) {
			return true;
		} else if (abc == JOptionPane.NO_OPTION) {
			return false;
		}
		return false;
	}
	
		
	//return 0 : �ߵ� ���
	//return 1 : 30�ϱ����� ��� ����
	//return 2 : ���� 2���� 29�ϱ��� ��� ����
	//return 3 : ������ �ƴ� 2���� 28�ϱ��� ��ϰ��� ����
	public static int checkDay(int year, int month, int day) {
	      int y = year;
	      int m = month;
	      int d = day;

	      //�������� Ȯ���ϴ� �κ�
	      if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0){
	    	  // �Է¹��� �⵵�� ���� ��������Ȯ���� 
	      
	    	  if (m == 2) { //�⵵���� �����̰� ���� ���� 2���϶� 
	    		  if (d <= 29) { // ��¥�� 29�� ���� �۰ų� ����  ���ϰ� Ʈ��
	    			  return 0;
	    		  } else { // 29�Ϻ��� �۰ų� ���� ������ ���ϰ� �޽�
	    			  return 2; //�����ε� �߸��Էµ�
	    		  }
	         }
	      }
	      
	      //2�� ����� �ԷµǾ��� Ȯ��
	      else if(m == 2){ // ������ �ƴҶ� ���ǰ��� 2���̸� 
	    	  if(d <= 28) // ��¥�� 28�Ϻ��� �۰ų� ������ Ʈ�簪�� ������
	    		  return 0;
	         else
	        	 return 3; //������ �ƴ� 2�� �߸� �Էµ�
	      }
	
	      //4, 6, 9, 11���� �ԷµǾ��� ��
	      else if ((m == 4) || (m == 6) || (m == 9) || (m == 11)) {
	    	  // �Է¹��� ���ǰ��� 4,6,9,11 �̸�
	         if (d <= 30) { // ��¥���� 30 ���� �۰ų� ������ ���� Ʈ��
	        	 return 0;
	         } else {
	            return 1; //30�ϱ����� �Ǿ�� �ϴµ� �߸� �Էµ�
	         }
	      }
	      
	      //1, 3, 5, 7, 8, 10, 12�� �� �ԷµǾ��� ��
	      else if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12)) {
	    	  if(d <= 31) {// ��¥���� 31���� �۰ų� ������ ���� Ʈ��
	    		  return 0;
	    	  }
	      }
	      return 0;
	} //checkDay �޼ҵ��� ��

	public static void inputYearNumFailure1(){
		JOptionPane.showMessageDialog(null, "�ش�⵵ �ش���� 30�ϱ����� ��ϰ����մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);   
	}
	public static void inputYearNumFailure2(){
		JOptionPane.showMessageDialog(null, "���� 2���� 29�ϱ��� ��ϰ����մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);   
	}
	public static void inputYearNumFailure3(){
		JOptionPane.showMessageDialog(null, "������ �ƴ� 2���� 28�ϱ��� ��ϰ����մϴ�.", "�߸��� �Է�", JOptionPane.ERROR_MESSAGE);   
	}
}
