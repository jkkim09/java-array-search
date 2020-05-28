package search.list;

public class Node {
    private int data;
    private int count = 1;
    private Node left;
    private Node right;
    
	public Node(){
        this.left = null;
        this.right = null;
    }
    
	public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getCount() {
		return this.count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
    public void plusCount() {
    	this.count++;
    }
    
    public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
    public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
    public String toString() {
    	return Integer.toString(this.data);
    }
}
