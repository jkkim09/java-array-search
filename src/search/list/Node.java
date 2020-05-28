package search.list;

public class Node {
    int data;
    int count = 1;
    Node left;
    Node right;
    
    public Node(){
        this.left = null;
        this.right = null;
    }
    
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public void plusCount() {
    	this.count++;
    }
    
    public int getCount() {
    	return this.count;
    }
    
    @Override
    public String toString() {
    	return Integer.toString(this.data);
    }
}
