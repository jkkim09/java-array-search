package search.list;

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
		lss.printBST();
		System.out.println(lss.exists(5));
	}
}
