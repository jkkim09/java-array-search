package search.list;

public class ListSortSearch implements SortSearch{
	public int[] list;

	public ListSortSearch(int number) {
		list = new int[number];
		
		for (int a=0; a<number; a++) {
			int negativeCheck = (int)(Math.random() * 2);
			int randomInt = (int)(Math.random() * number);
			int n = negativeCheck == 0 ? randomInt * -1 : randomInt;
			list[a] = n;
		}
		
		for (int c : list) {
			System.out.println(c);
		}
	}
	

	@Override
	public boolean exists(int n) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] range(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] count(int[] list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] take(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] filter(String asterisk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		ListSortSearch lss = new ListSortSearch(10);
	}
}
