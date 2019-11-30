package test_2;

import java.util.Scanner;

public class Node{
	private int date;
	private Node next;
	public Node(){
		this.next=null;
		
	}
	public Node(int d){
		this.date=d;
		this.next=null;
	}
	/*
	 * ����Ԫ��
	 */
	static void AddNode(Node p,Node head){
		Node temp=null,tr=head;
		while(p.date>=tr.date && tr.next!=null){
			temp=tr;
			tr=tr.next;
		}
		if(tr.date>=p.date){
			if(tr==head.next){//��ͷ�ڵ����
				head.next=p;
				p.next=tr;
//				p.next=head;
//				head=p;
			}
			else{//  �ڱ��в��롣
				temp.next=p;
				p.next=tr;
			}
		}
		else{//  �ڱ�ĩ����
			tr.next=p;
			p.next=null;
		}
//		return head;
	}
	
	/*
	 * �������
	 */
	static void Display(Node head){
		Node pr=head.next;    
		while(pr!=null){
			System.out.print(pr.date+" ");
			pr=pr.next;
		}
		System.out.println();
	}
	/*
	 * ���÷�����ж��������ͷ���ĺ��档
	 */
	static void Inversion(Node head){
		Node p=null;
		Node pr = head.next;
		Node temp;
		while(pr.next!=null)
		{
			temp = head.next;
			head.next = pr.next;
			pr.next = head.next.next;
			head.next.next = temp;
		}
	}
/*
 * ��������ĵ�����ϲ���һ������ĵ�����;
 */
	static void Combine_Down(Node head1,Node head_1,Node head){
		Node A=head1.next,B=head_1.next,temp=null,C=head;
		
		while(A!=null && B!=null){
			if(A.date<B.date){
				temp=A;
				A=A.next;	
				temp.next=C.next;
				C.next=temp;
			}
			else if(A.date==B.date){
				temp=A;
				B=B.next;
				A=A.next;
				temp.next=C.next;
				C.next=temp;
			}
			else{
				temp=B;
				B=B.next;		
				temp.next=C.next;
				C.next=temp;
			}
		}
		
		if(B==null){
			while(A!=null){
				temp=A;
				A=A.next;
				temp.next=C.next;
				C.next=temp;
			
			}
		}
		if(A==null){
			
			while(B!=null){
				temp=B;
				B=B.next;
				temp.next=C.next;
				C.next=temp;
			}
		}
		
	}
	
	/*
	 * ��������ĵ�����ϲ���һ������ĵ�����
	 */
	static void Combine_Up(Node head1,Node head_1,Node head){
		Node A=head_1.next,B=head1.next,temp=null,C=head;
		while(A!=null && B!=null){//��סÿ��Ҫʵʱ��������C�Ľڵ�
			if(A.date<B.date){
				C.next=A;
				A=A.next;
				
			}
			else if(A.date==B.date){
				C.next=A;
				A=A.next;
				B=B.next;
				
			}
			else{
				C.next=B;
				B=B.next;
			}
			C=C.next;//ʹC�Ľڵ������µģ������Ǹ��ڵ㣩
		}
		//�ҵ�C�����Ľڵ�
		while(head!=null){
			temp=head;
			head=head.next;
		}
		if(A==null){
			temp.next=B;
		}
		if(B==null){
			temp.next=A;
		}
		
	}
	
	public static void main(String[] args) {
		int n;
		Node head=new Node();
		
		//����1
		Node head_1=new Node();
		Node node_1=new Node(22);
		Node node_2=new Node(9);
		Node node_3=new Node(4);
		//����2
		Node head1=new Node();
		Node node1=new Node(4);
		Node node2=new Node(6);
		Node node3=new Node(7);
		AddNode(node_1, head_1);//�������Ԫ�ء�
		AddNode(node_2,head_1);
		AddNode(node_3,head_1);
		AddNode(node1, head1);//�������Ԫ��
		AddNode(node2,head1);
		AddNode(node3,head1);
		while(true){
			System.out.println();
			System.out.println("������ʵ�����:");
			Scanner scanner=new Scanner(System.in);
			n=scanner.nextInt();
			if(n==1){
				System.out.println("�������1:");
				Display(head_1);
				System.out.println("���������Ľڵ�: ");
				Node node_4=new Node(scanner.nextInt());
				AddNode(node_4,head_1);
				System.out.println("����������Ϊ:");
				Display(head_1);
			}
			if(n==2){
				System.out.println("�������1:");
				Display(head_1);
				Inversion(head_1);
				System.out.println("���ú�ĵ�����Ϊ:");
				Display(head_1);
			}
			if(n==3){
				System.out.println("�������1:");
				Display(head_1);
				System.out.println("�������2:");
				Display(head1);
				Combine_Down(head1,head_1,head);
				System.out.println("����֮�������Ϊ: ");
				Display(head);
			}
			if(n==4){
				System.out.println("�����˳��˲˵�");
				break;				
			}
		}
//		Combine_Up(head1,head_1,head);
//		System.out.println("����֮�������Ϊ: ");
//		Display(head);
			
	}

}

































//public class Node {
//	private int date;
//	private Node next;//����������;
//	public Node(){
//		
//	}
//	public Node(int date)
//	{
//		this.date=date;
//	}
//	public void setDate(int date){this.date=date;}
//	public int getDate(){return date;}
//	public Node getNext(){return next;}
//	public void setNext(Node next){this.next=next;}
//	
//	public void printList(Node node)//�����󣬴�ӡ����
//	{
//		while(node!=null)
//		{
//			System.out.println(node.date);
//			node=node.next;
//		}
//	}
//	
//	
//	static Node addNode(Node p,Node head)//���������ڵ㣻
//	{
//		int d=p.date;
//		Node tr=null;
//		tr=head;
//		Node temp=null;
//			while(tr.date<d && tr.next!=null)
//			{
//				temp=tr;
//				tr=tr.next;
//			}
//			if(tr.date>=d)
//			{
//				if(tr==head)//��ͷ�ڵ�ǰ���룻
//				{
//					p.next=head;
//					head=p;
//				}
//				else//�м���룻
//				{
//					temp.next=p;
//					p.next=tr;
//				}
//			}
//			else//�ڱ�ĩ���룻
//			{
//				tr.next=p;
//				p.next=null;
//			}
//		return head;
//	}
//	public static void main(String[] args)
//	{
//		Node a1=new Node(22);
//		Node a2=new Node(6);
//		Node a3=new Node(9);
//		Node a4=new Node(4);
//		Node head;
//		head = addNode(a2,a1);
//		addNode(a3,head);
//		addNode(a4,head);
////		a4.printList(a1);
//		a1.printList(a4);
//	}
//}
