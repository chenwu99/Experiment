package text_4;

public class Node {
	
	private int data;
	private Node next;
	public Node(int i, Node nt){
		data = i;
		next = nt;
	}
	
	public Node(int i){
		this(i,null);
	}
	
	public Node(){
		this(0,null);
	}
	
	public void setData(int i){
		data = i;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNext(Node nt){
		next = nt;
	}
	
	public Node getNext(){
		return next;
	}
}