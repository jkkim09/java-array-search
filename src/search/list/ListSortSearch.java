package search.list;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class ListSortSearch implements SortSearch{
	private Node root = null;
	int descCount = 0;
	int maxCount = 0;
	int[] descList;
	
	ArrayList<Integer> patterList;
	
	public ListSortSearch(int number) {
		for (int a=0; a<number; a++) {
			int negativeCheck = (int)(Math.random() * 2);
			int randomInt = (int)(Math.random() * number);
			int n = negativeCheck == 0 ? randomInt * -1 : randomInt;
			insertValue(n);
		}
	}
	
    public void insertValue(int value){
        root = insertNode(root, value);
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
    
    public void getDescList(Node root){
        if(root != null){
        	getDescList(root.right);
        	
        	if (descCount < maxCount) {
        		descList[descCount] = root.data;
        		descCount++;
        	} else {
        		return;
        	}
        	
        	getDescList(root.left);
        }
    }
    
    public void getPatternList (Node root, String asterisk) {
    	if(root != null){
    		getPatternList(root.left, asterisk);
    
        	if (patternCheck(asterisk, root.toString())) {
        		patterList.add(root.data);
        	}
    		
    		getPatternList(root.right, asterisk);
        }
    }
    
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
    
    ////////////// 임시 /////////////////////
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
    ////////////// 임시 /////////////////////
    
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
	
	
	public static void main(String[] args) {
		ListSortSearch lss = new ListSortSearch(100);
//		lss.printBST();
		ArrayList<Integer> aa = lss.filter("3*");	
		for (int a : aa) { 
			System.out.println(a);
		}
	}
}
