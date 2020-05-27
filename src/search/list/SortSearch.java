package search.list;

public interface SortSearch {
	/**
	 * �Է¹��� �ش� ����  ���� ����
	 * 
	 * @param n		ã������ ��
	 * @return		���� ����
	 */
	public boolean exists(int n);
	
	/**
	 * min ���� max ���� �����ϴ� ���̰� ���� (�ߺ��� ���� ��� ����)
	 * 
	 * @param min	ã�°� �ּҰ�
	 * @param max	ã�°� �ִ밪
	 * @return		ã�� �� list
	 */
	public int[] range(int min, int max);
	
	/**
	 * �־��� ���� ���� ����
	 * 
	 * @param list	ã�°��� ����Ʈ
	 * @return		ã�°� ���� ����Ʈ
	 */
	public int[] count(int[] list);
	
	/**
	 * �ִ밪 n�� ���� (�ߺ��� �������� �����ؼ� �� n��)
	 * 
	 * @param n		�ִ밪 n��
	 * @return		�ִ밪 list
	 */
	public int[] take(int n);
	
	/**
	 * ���Խ� ���� �ش��ϴ� ���� ��ȯ
	 * 
	 * @param asterisk	ã�� ����
	 * @return			ã���� list
	 */
	public int[] filter(String asterisk);
}
