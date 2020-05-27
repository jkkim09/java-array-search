package search.list;

import java.util.Date;

public class ListSortSearch implements SortSearch{
	private Node root = null;
	
	public ListSortSearch(int number) {
		for (int a=0; a<number; a++) {
			int negativeCheck = (int)(Math.random() * 2);
			int randomInt = (int)(Math.random() * number);
			int n = negativeCheck == 0 ? randomInt * -1 : randomInt;
			if (a == 0) {
				System.out.println("root : " + n);
			} else {
				System.out.println("row : " + n);
			}
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
		Node parentNode = root;
		for (int e=0; e<5; e++) {
			if (parentNode.right != null) {
				System.out.println(parentNode.getNodeName());
				parentNode = parentNode.right;
			} else if (parentNode.left != null) {
				System.out.println();
			} else {
				System.out.println("  : " + parentNode.getNodeName());				
			}
		}
		return null;
	}

	@Override
	public int[] filter(String asterisk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
//		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
//		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
//		long secDiffTime = (afterTime - beforeTime)/1000;
//		System.out.println(beforeTime + "  -   " + afterTime + " = " + secDiffTime);
		
		ListSortSearch lss = new ListSortSearch(10);
		lss.printBST();
		lss.take(5);
       		
	}
}
