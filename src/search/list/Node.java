package search.list;

public class Node {
    int data;
    int count = 0;
    String nodeName;
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
        this.count++;
        setNodeName(data);
    }
    
    public void setNodeName (int data) {
    	this.nodeName = data + " Node";
    }
    
    public String getNodeName () {
    	return this.nodeName;
    }
    
    public void plusCount() {
    	this.count++;
    }
    
    public int getCount() {
    	return this.count;
    }
}
