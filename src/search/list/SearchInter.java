package search.list;

import java.util.ArrayList;

public interface SearchInter {
	/**
	 * 입력받은 해당 값이  존재 유무
	 * 
	 * @param n		찾으려는 값
	 * @return		존재 유무
	 */
	public boolean exists(int n);
	
	/**
	 * min 부터 max 까지 존재하는 사이값 수집 (중복된 값도 모두 수집)
	 * 
	 * @param min	찾는값 최소값
	 * @param max	찾는값 최대값
	 * @return		찾은 값 list
	 */
	public ArrayList<Integer> range(int min, int max);
	
	/**
	 * 주어진 수의 갯수 수집
	 * 
	 * @param list	찾는값들 리스트
	 * @return		찾는값 갯수 리스트
	 */
	public int[] count(int[] list);
	
	/**
	 * 최대값 n개 수집 (중복시 다음 값 수집해서 총 n개)
	 * 
	 * @param n		최대값 n개
	 * @return		최대값 list
	 */
	public int[] take(int n);
	
	/**
	 * 정규식 으로 해당하는 값들 반환
	 * 
	 * @param asterisk	찾는 조건
	 * @return			찾은값 list
	 */
	public ArrayList<Integer> filter(String asterisk);
}
