package search.list;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class ListSortSearch implements SearchInter{
	private Node root = null;
	int descCount = 0;
	int maxCount = 0;
	int[] descList;
	
	ArrayList<Integer> patterList;
	ArrayList<Integer> rangeList;
	
	@Override
	public int[] count(int[] list) {
		int listLengh = list.length;
		int[] countList = new int[listLengh];
		for (int i=0; i<listLengh; i++) {
			Node node = searchNodeData(list[i]);
			countList[i] = node != null ? node.getCount() : 0;
		}
		return countList;
	}

	@Override
	public int[] take(int n) {
		descList = new int[n];
		maxCount = n;
		getDescList(root);
		return descList;
	}
	
	@Override
	public ArrayList<Integer> filter(String asterisk) {
		patterList = new ArrayList<Integer>();
		getPatternList(root, asterisk);
		return patterList;
	}
	
	@Override
	public boolean exists(int n) {
		return searchNodeData(n) != null ? true : false ;
	}

	@Override
	public ArrayList<Integer> range(int min, int max) {
		rangeList = new ArrayList<Integer>();
    	rangeSearch(root, min, max);
    	return rangeList;
	}
	
	/**
	 * 설정한 number 수만큼 int list 가 생성하고 이진 트리를 만든다.
	 * 
	 * @param number	정수의 개수 설정
	 * @param dev		개발 환경 on/off
	 */
	public ListSortSearch(int number, boolean dev) {
		Random random = new Random();
		for (int a=0; a<number; a++) {
			int n;
			
			if (dev) {
				int negativeCheck = (int)(Math.random() * 2);
				int randomInt = (int)(Math.random() * number);
				n = negativeCheck == 0 ? randomInt * -1 : randomInt;
			} else {
				n = random.nextInt();
			}
			
			insertValue(n);
		}
	}
	
	/**
	 * 이진 탐색 트리 생성
	 * @param value
	 */
    public void insertValue(int value){
        root = insertNode(root, value);
    }
	
    /**
     * 값이 들어오면 부모 노드와 값을 비교하여 작으면 left, 크면 right node로 할당한다.
     * 
     * @param root		Node
     * @param value		Node 의 값
     * @return			Node
     */
    public Node insertNode(Node root, int value) {
        Node parentNode = root;
        Node newNode = new Node(value);
        
        if(parentNode == null){
            return newNode;
        }else if(parentNode.getData() > newNode.getData()){
            parentNode.setLeft(insertNode(parentNode.getLeft(), value));
            return parentNode;
        }else if(parentNode.getData() < newNode.getData()){
            parentNode.setRight(insertNode(parentNode.getRight(), value));
            return parentNode;
        }else{
        	parentNode.plusCount();
            return parentNode;
        }
    }
	
    /**
     * tree 에서 찾고자 하는 값이 있는 Node를 검색한다.
     * 
     * @param value		찾는값
     * @return			Node
     */
    public Node searchNodeData(int value){
    	Node parentNode = root;
        while(parentNode != null){
            if(value < parentNode.getData()) {
            	parentNode = parentNode.getLeft();
            } else if(value > parentNode.getData()) {
            	parentNode = parentNode.getRight();
            } else {
            	return parentNode;
            }
        }
        return parentNode;
    }
    
    /**
     * 외른쪽 아래 틑부터 순회하여 가장 큰 값 부터 검색한다.
     * @param root	Node
     */
    public void getDescList(Node root){
        if(root != null){
        	getDescList(root.getRight());
        	
        	if (descCount < maxCount) {
        		descList[descCount] = root.getData();
        		descCount++;
        	} else {
        		return;
        	}
        	
        	getDescList(root.getLeft());
        }
    }
    
    /**
     * 왼쪽 아래 끝부터 순회하여 문자를 비교한다.
     * 
     * @param root			Node 값
     * @param asterisk		비교할 문자형
     */
    public void getPatternList (Node root, String asterisk) {
    	if(root != null){
    		getPatternList(root.getLeft(), asterisk);
    
        	if (patternCheck(asterisk, root.toString())) {
        		patterList.add(root.getData());
        	}
    		
    		getPatternList(root.getRight(), asterisk);
        }
    }
    
    /**
     * 
     * @param asterisk		비교할 문자형
     * @param item			비교되는 값
     * @return				결과 값			
     */
    public boolean patternCheck (String asterisk, String item) {
		Pattern pattern;
		int asteriskIndex = asterisk.indexOf("*");
		String text = asterisk.replace("*", "");
		
		if (asteriskIndex == 0) {
			pattern = Pattern.compile(text + "$");
		} else if (asteriskIndex > 0) {
			pattern = Pattern.compile("^(-|)" + text);	
		} else {
			pattern = Pattern.compile("^(-|)\\d{"+ text +"}$");
		}
    	return pattern.matcher(item).find();
    }
    
    /**
     * @param node	Node 객체
     * @param min	검색 최고 값
     * @param max	검색 최대 값
     * @return		Node 객체
     */
    public Node rangeSearch(Node node, int min, int max) 
    { 
    	// 더이상 자식 노드가 없을경우
        if(node == null) {
        	return null ;         	
        }

        // min < x < max 일때
        if(node.getData() > min && node.getData() < max) {
        	rangeList.add(node.getData());
        	// 조건을 만족하므로 좌, 우로 검색을 시작함
        	this.rangeSearch(node.getLeft(), min, max);
        	this.rangeSearch(node.getRight(), min, max);
        	return node;         	
        } else if(node.getData() < min) {
        	// x < min 일때
        	return this.rangeSearch(node.getRight(), min, max);         	
        } else {
        	// x > min 일때
        	return this.rangeSearch(node.getLeft(), min, max);              	
        }
    } 
     

    /**
     * 왼쪽 끝 부분 부터 값을 보여준
     * @param root 	Node 객체
     */
    public void orderBy(Node root){
        if(root!=null){
        	orderBy(root.getLeft());
        	System.out.print(root.getData() + " ");
        	orderBy(root.getRight());
        }
    }
    
    /**
     * tree 주조를 order by 하여 보여준다.
     */
    public void nodePringOut(){
    	orderBy(root);
        System.out.println();
    }   
}
