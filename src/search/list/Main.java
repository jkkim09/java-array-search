package search.list;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * 정수형 난수가 -2147483648 ~ 2147483647 (21억) 이여서 개발 시 확인 하기 힘들어 설정을
		 * 추가하였습니다.
		 * true : 개발 모드
		 */
		ListSortSearch lss = new ListSortSearch(1000000, true);
		
		/**
		 * 주석을 풀면 정렬된 값을 볼 수 있습니다 
		 * 다만 정수 개수가 너무 크면 System.out.println가 동기 방식이기 때문에 시간이 오래 걸립니다.
		 */
//		lss.nodePringOut();
		
		/**
		 * 1. exists (n: Int) => Boolean : 해당 값이  존재 유무
		 */
		
		System.out.println(lss.exists(12));
		
		/**
		 * 2. range(-10, 100) : -10 ~ 100사이값 수집 (중복된 값도 모두 수집)
		 */
		
//		ArrayList<Integer> al = lss.range(-10, 10);
//		for (int a : al) {
//			System.out.println(a);
//		}
		
		/**
		 * 3. count([3, 90, -10, 20]) : [0, 10, 20, 0] 각 수어진 수의 갯수 수집
		 */
		
//		int[] list = {3, 90, -10, 20};
//		int[] al = lss.count(list);
//		for(int a : al) {
//			System.out.println(a);
//		}
		
		/**
		 * 4. take(10) : 최대 값 10개 수집 (중복시 다음값 수집해서 총 10개)
		 */
		
//		int[] al = lss.take(3);
//		for (int a : al) {
//			System.out.println(a);
//		}
		
		/**
		 * 5. filter("1*") : 10진수 n로 시작하는 수 수집 (1, 100, 1000, -1, -1000 등등)
		 * 6. filter("*3") : 10진수 n로 끝난는 수 수집 (3, 203, 33, -3, -4332320003 등등)
		 * 7. filter("5")  : 10진수 자릿수 수 수집 (10000, -20032, 98033, -43011, ...)
		 */
		
//		ArrayList<Integer> al = lss.filter("1*");
//		ArrayList<Integer> al = lss.filter("*3");
//		ArrayList<Integer> al = lss.filter("2");
//		for (int a : al) {
//			System.out.println(a);
//		}
	}
}
