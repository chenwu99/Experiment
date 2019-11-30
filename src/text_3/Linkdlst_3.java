package text_3;

import java.io.IOException;
import java.util.Scanner;

public class Linkdlst_3 {
	private Node_double head=new Node_double();//这是一个空的节点。
//	private Node_double head=null;
	private int size=0;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	/*
	 * 查询元素
	 */
	public void LOCATE(){
		int seach;
		Node_double p=head;
		int flag=0,freg;
		System.out.print("输入所要查询的元素:");
		Scanner sacnne =new Scanner(System.in);
		seach=sacnne.nextInt();
		while(p!=head.getPrior()){
			p=p.getNext();
			freg=p.getFreg();
			if(p.getDate()!=seach){
				flag=0;
			}else{
				freg++;
				p.setFreg(freg);
				flag=1;
				break;
			}
		}
//		System.out.println(p.getFreg());
		if(flag==0){
			System.out.println("没有找到此元素!!!!");
		}
//		sacnne.close();
		
	}
	/*
	 * 冒泡排序;
	 */
	public void Print_sort(){
		Node_double p=head.getNext(),tail=head;
		while(p.getNext()!= tail){
			
			while(p.getNext()!= tail){
				
	            if(p.getFreg()<=p.getNext().getFreg()){
	            	int p_date= p.getDate(),p_next_date=p.getNext().getDate();
	            	int p_ferg= p.getFreg(),p_next_ferg=p.getNext().getFreg();
	                p.setDate(p_next_date);
	                p.getNext().setDate(p_date);	              
	                p.setFreg(p_next_ferg);
	                p.getNext().setFreg(p_ferg);
	            
	            }
	            
	            p = p.getNext(); //P恰好为最后一个节点 
			}
			
	       tail = p;
	       p = head.getNext();    //遍历起始结点重置为头结点    
		}
	}
//	public void Print_sort(){
//		Node_double p=head,temp,pr,t;
//		while(p!=head.getPrior()){
//			p=p.getNext();
//				if(temp.getFreg()>= pr.getFreg()){
//					temp.getPrior().setNext(temp.getNext());
//					temp.getNext().setPrior(temp.getPrior());
//					head.setNext(temp);
//					temp.setNext(p);
//					temp.setPrior(head);
//				}
//				pr=pr.getNext();
//			}			
//		}
//	}
	/*
	 * 在链表头部添加元素
	 */
	public void AddTail(Node_double node){
//		if(size==0){
		if(head.getNext()==null){
			head.setPrior(node);
			head.setNext(node);
			node.setNext(head);
			node.setPrior(head);
			size++;
		}else{			
			node.setPrior(head);
			node.setNext(head.getNext());
			head.setNext(node);
			size++;
		}
	}
	/*
	 * 打印链表
	 */
	public void PrintList(){
		Node_double p=head;
		System.out.print("链表元素为:");
		while(p!=head.getPrior()){
			p=p.getNext();
			System.out.print(p.getDate()+" ");
//			System.out.print(p.getFreg()+" ");
			
		}
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		int n;
		Linkdlst_3 link=new Linkdlst_3();
		link.AddTail(new Node_double(1));
		link.AddTail(new Node_double(2));
		link.AddTail(new Node_double(3));
		link.AddTail(new Node_double(4));
		link.AddTail(new Node_double(5));
		link.PrintList();
		System.out.println("是否继续查询");
		char c=(char)System.in.read(); 
		while(c!='#'){
			link.LOCATE();
			link.Print_sort();
			link.PrintList();
			System.out.println("是否继续查询");
			c=(char)System.in.read(); 
		}
		
//		link.LOCATE();
//		link.LOCATE();
		
//		while(true){
//			Scanner scanner=new Scanner(System.in);			
//			System.out.println("是否继续查询元素:1.是,2.否 ");
//			n=scanner.nextInt();
//			if(n==1){
//								
//			}if(n==2){
//				break;
//			}
////			scanner.close();
//		}
		
	}
}
