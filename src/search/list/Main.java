package search.list;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ListSortSearch lss = new ListSortSearch(200);
		
		System.out.println("start");
		ArrayList<Integer> aa = lss.filter("3*");
	}
}
