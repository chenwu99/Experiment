package text_3;

import java.util.Scanner;

public class Linkedlst {
	private Node head;
	private Node tail;
	int size;
	public Linkedlst(){
		tail = head = null;
		size = 0;
	}
	/*
	 * 在链表尾部插入节点
	 */
	public void addTail(Node t1){
//		if(size==0){
		if(tail==null){
			t1.setNext(t1);
			tail=t1;
			size++;
		}
		else{
			t1.setNext(tail.getNext());
			tail.setNext(t1);
			tail=t1;
			size++;
		}
	}
	public int text(Node node){
		Node p=tail.getNext();
		int flag=0;
		while(p!=tail){
			if(p.getData()==node.getData()){
				flag=1;
				break;
			}
			p=p.getNext();
		}
		if(p.getData()==node.getData()){
			flag=1;
		}
//		System.out.println(flag);
		return flag;
	}
	public void Delet(Node node){
		Node p = new Node();
		Node temp = new Node();
		Node t=null;
		p = tail.getNext();
		
		if(p.getData()!=node.getData()){
			while(p.getData()!=node.getData()){
				temp=p;
				p=p.getNext();
			}
			p = tail.getNext();
			while(p.getData()!=temp.getData()){
				t=p;
				p=p.getNext();
			}
			t.setNext(temp.getNext());
		}
		if(p.getData()==node.getData()){
			if(size>1){
				while(p.getNext()!=tail){
					p = p.getNext();
				}
				p.setNext(tail.getNext());
				tail=p;
				size--;
			}
			else if(size==1){//就一个尾结点
				tail = null;
				size--;
			}
		}
//		if(p==tail.getNext()){
//			if(tail.getData()==node.getData()){
//				if(size>1){
//					while(p.getNext()!=tail){
//						p = p.getNext();
//					}
//					p.setNext(tail.getNext());
//					size--;
//				}
//				else if(size==1){//就一个尾结点
//					tail = null;
//					size--;
//				}	
//			}
//		}
	}
	/*
	 * 删除节点
	 */
	public void Delete(Node node){
		Node p = new Node();
		Node temp = new Node();
		p = tail.getNext();
		if(node.getData()!=tail.getNext().getData()){
			while(p.getNext().getData()!=node.getData()){				
				p = p.getNext();
			}
			p.setNext(p.getNext().getNext());
			size--;
		}
		else if(node.getData()==tail.getNext().getData()){
			if(size>1){
				while(p.getNext()!=tail){
					p = p.getNext();
				}
				p.setNext(tail.getNext());
				tail=p;
				size--;
			}
			else if(size==1){//就一个尾结点
				tail = null;
				size--;
			}	
		}
	}
	/*
	 * 打印链表
	 */
	public void printList(){
		Node p=new Node();
		p=tail.getNext();
		try{
			while(p!=tail){
				System.out.print(p.getData());
				System.out.print("->");
				p=p.getNext();
			}
			System.out.print(p.getData());
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int n,flag=0;
		Linkedlst link=new Linkedlst();
		link.addTail(new Node(1));
		link.addTail(new Node(2));
		link.addTail(new Node(3));
		link.addTail(new Node(4));
		link.addTail(new Node(5));
		System.out.println("打印链表:");
		link.printList();
		Scanner sacnner=new Scanner(System.in);
		System.out.println("输入删除的元素");
		n=sacnner.nextInt();
		flag=link.text( new Node(n));
		if(flag==1){
			link.Delet(new Node(n));
			System.out.println("打印链表:");
			link.printList();
		}
		else{
			System.out.println("没有这个元素！！！！");
		}
	}
	 
}