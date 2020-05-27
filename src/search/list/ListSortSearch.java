package search.list;

import java.util.Date;

public class ListSortSearch implements SortSearch{
	private Node root = null;
	
	public ListSortSearch(int number) {
		for (int a=0; a<number; a++) {
			int negativeCheck = (int)(Math.random() * 2);
			int randomInt = (int)(Math.random() * number);
			int n = negativeCheck == 0 ? randomInt * -1 : randomInt;
			insertValue(n);
		}
	}
	
    public Node insertNode(Node root, int value) {
        Node parentNode = root;
        Node newNode = new Node(value);
        
        if(parentNode==null){
            return newNode;
        }else if(parentNode.data>newNode.data){
            parentNode.left = insertNode(parentNode.left, value);
            return parentNode;
        }else if(parentNode.data<newNode.data){
            parentNode.right = insertNode(parentNode.right, value);
            return parentNode;
        }else{
        	parentNode.plusCount();
            return parentNode;
        }
    }
	
    public void insertValue(int value){
        root = insertNode(root, value);
    }
    
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    public void printBST(){
        inorder(root);
        System.out.println();
    }   
    
    public Node searchNodeData(int value){
    	Node parentNode = root;
        while(parentNode != null){
            if(value < parentNode.data) {
            	parentNode = parentNode.left;
            } else if(value > parentNode.data) {
            	parentNode = parentNode.right;
            } else {
            	return parentNode;
            }
        }
        return parentNode;
    }
    
	@Override
	public boolean exists(int n) {
		return searchNodeData(n) != null ? true : false ;
	}

	@Override
	public int[] range(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

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
		System.out.println(n);
		return null;
	}

	@Override
	public int[] filter(String asterisk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
//		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
//		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//		long secDiffTime = (afterTime - beforeTime)/1000;
//		System.out.println("시간 :" + beforeTime + "  -   " + afterTime + " = " + secDiffTime);
		
		ListSortSearch lss = new ListSortSearch(1000);
		lss.printBST();
		
        
		int[] s = {1 ,3 ,5};
		int[] list = lss.count(s);


		
		for (int a : list) {
			System.out.println(a);
		}
		
	}
}
