package text_6;

public class Queue {
	private Object[] original;
	private int startLength=20;
	private int front;
	private int rear;
	
	public Queue() {
		original=new Object[startLength];
		this.front = 0;
		this.rear = 0;
	}
	public Object[] getOriginal() {
		return original;
	}
	public void setOriginal(Object[] original) {
		this.original = original;
	}
	public int getFront() {
		return front;
	}
	public void setFront(int front) {
		this.front = front;
	}
	public int getRear() {
		return rear;
	}
	public void setRear(int rear) {
		this.rear = rear;
	}
	
}
