package text_5;

import java.util.Stack;

public class Node {
	private int data;
	private Node leftnext;
	private Node rightnext;
	public Node(int i, Node rn,Node ln){
		data = i;
		leftnext = ln;
		rightnext =rn;
	}
	
	public Node(int i){
		this(i,null,null);
	}
	
	public Node(){
		this(0,null,null);
	}
	
	public void setData(int i){
		data = i;
	}
	
	public int getData(){
		return data;
	}

	public Node getLeft_next() {
		return leftnext;
	}

	public void setLeft_next(Node left_next) {
		this.leftnext = left_next;
	}

	public Node getRight_next() {
		return rightnext;
	}

	public void setRight_next(Node right_next) {
		this.rightnext = right_next;
	}
	public static void main(String[] args) {
		Node node=new Node(100);
		node.setRight_next(new Node(1));
		Stack<Node> stack=new Stack<Node>();
		stack.push(node);
		stack.push(node.getRight_next());
		System.out.println(stack.pop().getData());
		System.out.println(node.getRight_next().getData());
	}
}