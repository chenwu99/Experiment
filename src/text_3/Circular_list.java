package text_3;

import javax.sound.midi.SysexMessage;

public class Circular_list {
	private int date;
	public Circular_list next;
	public Circular_list(){
		this.next=null;
	}
	public Circular_list(int d){
		this.date=d;
		this.next=null;
	}
	/*
	 * 向链表中添加元素;
	 */
	static void Add(Circular_list node,Circular_list head){
		Circular_list p=head,temp=null;
		while(p.next!=head){
			p=p.next;
		}
		p.next=node;
		node.next=head;			
		System.out.println("请输出"+p.next.date);
	}
	/*
	 * 输出链表;
	 */
	static void Print(Circular_list head){
		Circular_list p=head;
		System.out.print(p.date+" ");
		while(p.next!=head){
			p=p.next;
			System.out.print(p.date+" ");
		}
		System.out.println();
	}
	static Circular_list Delete(int date,Circular_list head){
		Circular_list p=head,temp=null;
		while(p.next!=head){
			temp=p;
			p=p.next;
		}
		if(p.date==date){
			temp.next=p.next;
		}
		else{
			head=p.next;
		}
		return head;
	}
	public static void main(String[] args) {
		Circular_list head=null;
		Circular_list node_1=new Circular_list(1);
		Circular_list node_2=new Circular_list(2);
		Circular_list node_3=new Circular_list(3);
		Circular_list node_4=new Circular_list(4);
		Circular_list node_5=new Circular_list(5);
		head=node_1;
		head.next=head;
		Add(node_2,head);
		Add(node_3,head);		
		Add(node_4,head);		
		Add(node_5,head);		
		Print(head);	
		Print(Delete(2, head));
	}
	
}
