package text_3;

public class Node_double {
	private int date;
	private int freg;
	private Node_double next;
	private Node_double prior;
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getFreg() {
		return freg;
	}
	public void setFreg(int freg) {
		this.freg = freg;
	}
	public Node_double getNext() {
		return next;
	}
	public void setNext(Node_double next) {
		this.next = next;
	}
	public Node_double getPrior() {
		return prior;
	}
	public void setPrior(Node_double prior) {
		this.prior = prior;
	}
	public Node_double(int date) {
		super();
		this.date=date;
		this.freg=0;
		this.prior=null;
		this.next=null;
		// TODO Auto-generated constructor stub
	}
	public Node_double(int date, int freg, Node_double next, Node_double prior) {
		super();
		this.date = date;
		this.freg = freg;
		this.next = next;
		this.prior = prior;
	}
	public Node_double() {
		super();
		this.freg=0;
		this.prior=null;
		this.next=null;
		// TODO Auto-generated constructor stub
	}
	
	
}
