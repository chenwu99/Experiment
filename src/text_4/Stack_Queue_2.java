package text_4;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

public class Stack_Queue_2 {
	private Node head;
	private Node tail;
	int size;
	public Stack_Queue_2(){
		head=new Node();
		tail = null;
		size = 0;
	}
	
	/*
	 * 入队（在链表尾部插入节点）
	 */
	public void addTail(Node node){
//		if(head.getNext()==null){
//			head.setNext(node);
//			node.setNext(head);
//			tail=node;
//		}else{
//			node.setNext(head.getNext());
//			head.setNext(node);
//		}
		if(tail==null){
			node.setNext(node);
			head.setNext(node);
			tail=node;
			size++;
		}
		else{
			node.setNext(tail.getNext());
			tail.setNext(node);
			tail=node;
			size++;
		}
	}
	
	/*
	 * 打印链表
	 */
	public void printList(){
		Node p;
		if(head.getNext()==null){
			System.out.println("空表");
		}else{
			tail.setNext(null);
			p=head.getNext();
			while(p.getNext()!=null){
				System.out.print(p.getData()+"->");
				p=p.getNext();
			}
			System.out.print(p.getData());
			System.out.println();
		}
	}
	/*
	 * 置队空，将尾结点的next域为空，头节点的next域设为空
	 */
	public void Empty(){
		tail.setNext(null);
		head.setNext(null);
	}
	/*
	 * 出队
	 */
	public void Pop(){
//		System.out.println(head.getNext().getNext().getData());
		if(head.getNext().getNext()==head){//头结点后面只有一个结点
			head.setNext(null);
			tail=null;
		}else{
			Node temp=head.getNext().getNext();
			head.setNext(temp);
		}
	}
	public static void main(String[] args) {
		int n,flag=0;
		Stack_Queue_2 link=new Stack_Queue_2();
//		link.Pop();
//		System.out.println(link.head.getNext().getData());
//		link.printList();
		while(true){
			System.out.println("1.入队   2.出队  3.置队空");
			Scanner scanner=new Scanner(System.in);
			n=scanner.nextInt();
			if(n==1){
				System.out.print("输入入队结点:");
				link.addTail(new Node(scanner.nextInt()));
				link.printList();
			}
			if(n==2){
				link.Pop();
				link.printList();
			}
			if(n==3){
				link.Empty();
				link.printList();				
			}
		}
		
	}
}