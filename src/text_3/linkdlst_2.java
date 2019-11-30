package text_3;

import java.io.IOException;

public class linkdlst_2 {
	private Node_char head;
	private Node_char tail;
	private int size=0;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public linkdlst_2() {
		super();
		this.head=this.tail=null;
		this.size=0;
	}
	/*
	 * 单链表插入链表,在尾节点
	 */
	public void Addtail(Node_char t){
		if(size==0){
			t.setNext(null);
			head=tail=t;
			size++;
		}
		else{
			tail.setNext(t);
			t.setNext(null);
			tail=t;
			size++;
		}	
	}
	/*
	 * 插入链表,在尾节点
	 */
	public void AddTail(Node_char t){
		if(size==0){
			t.setNext(t);
			head=tail=t;
			size++;
		}
		else{
			tail.setNext(t);
			t.setNext(head);
			tail=t;
			size++;
		}	
	}
	/*
	 * 打印链表
	 */
	public void PrintList(){
		Node_char p=new Node_char();
		p=head;
//			try{
		if(p==null){
			System.out.println("空表");
		}else{
			tail.setNext(null);
			while(p!=null){			
					if(p==tail){
						System.out.print(p.getDate());
					}else{
						System.out.print(p.getDate()+" ");
	//					System.out.print("->");
					}
					p=p.getNext();
				}
				System.out.println();
		}
				
//			}catch(Exception e){
//				e.printStackTrace();
//			}
		
	}
	public int  judge_null(){
		if(head==null){
			System.out.println("空表");
			return 0;
		}
		else{
			return 1;
		}
	}
	public static void main(String[] args)  throws IOException{	
		linkdlst_2 link_L=new linkdlst_2();
		linkdlst_2 link_h1=new linkdlst_2();
		linkdlst_2 link_h2=new linkdlst_2();
		linkdlst_2 link_h3=new linkdlst_2();
		System.out.println("输入链表节点：");
		char c=(char)System.in.read();
		while(c!='#'){
			link_L.Addtail(new Node_char(c));
			c=(char)System.in.read();			
		}
//		link_L.Addtail(new Node_char('1'));
//		link_L.Addtail(new Node_char('q'));
//		link_L.Addtail(new Node_char('8'));
//		link_L.Addtail(new Node_char('m'));
//		link_L.Addtail(new Node_char('&'));
//		link_L.Addtail(new Node_char('@'));
		System.out.println("输出链表结点:");
		link_L.PrintList();
		Node_char p=new Node_char();
		p=link_L.head;
//		link_L.tail.setNext(null);
		Node_char temp;
		while(p!=null){
			temp=p;
			p=p.getNext();
//			temp.setNext(null);//从单链表上面卸下来
			if((temp.getDate()>='A' && temp.getDate()<='Z')||(temp.getDate()>='a' && temp.getDate()<='z')){
				link_h1.AddTail(temp);
			}else if (temp.getDate()>='0' && temp.getDate()<='9'){
				link_h2.AddTail(temp);
			}else{
				link_h3.AddTail(temp);
			}
		}
//		set(link_L,link_h1, link_h2, link_h3);
		System.out.println("字母链表中的元素为");
		link_h1.PrintList();
		System.out.println("数字链表中的元素为");
		link_h2.PrintList();	
		System.out.println("字符链表中的元素为");
		link_h3.PrintList();
	}
	;
}
