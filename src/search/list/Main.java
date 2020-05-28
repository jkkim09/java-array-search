package search.list;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ListSortSearch lss = new ListSortSearch(1000000);
		
		System.out.println("start");
//		lss.filter("3*");
//		lss.printBST();
		lss.range(-12, 15);
	}
}
