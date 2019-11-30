package text_4;

public class Node_char {
	private char date;
	private Node_char next;
	
	public Node_char(char date) {
		super();
		this.date = date;
		this.next=null;
	}
	public char getDate() {
		return date;
	}
	
	public Node_char() {
		super();
		this.next=null;
	}

	public void setDate(char date) {
		this.date = date;
	}
	
	public Node_char getNext() {
		return next;
	}
	
	public void setNext(Node_char next) {
		this.next = next;
	}
}
