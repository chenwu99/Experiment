package text_4;

import java.io.IOException;
import java.util.Scanner;

public class Stack_Queue {
	private Node_char head=new Node_char();
	private Node_char top=new Node_char();
	private int size=0;
	
	public Node_char getTop() {
		return top;
	}
	public void setTop(Node_char top) {
		this.top = top;
	}
	public Node_char getHead() {
		return head;
	}
	public void setHead(Node_char head) {
		this.head = head;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Stack_Queue(){
//		this.head=null;
	}
	public void Print(){
		
	}
	
	/*
	 * 创建链栈（将栈顶设为链表的头结点）,链栈一般不设头结点。
	 */
	public void Push(Node_char node){
//		System.out.println(node.getDate());
		if(top.getNext()==null){
			top.setNext(node);
			node.setNext(null);
			size++;
		}else{
			node.setNext(top.getNext());
			top.setNext(node);
			size++;
		}
	}
	/*
	 * 出栈
	 */
	public void Pop(){
		if(top.getNext()==null){
			System.out.println("该链栈为空表");
//			return '*';
		}else{
			top.setNext(top.getNext().getNext());
			size--;
//			return date;
		}
	}
	/*
	 * 取出栈顶元素
	 */
	public char getTop_Next(){
		if(top.getNext()==null){
			System.out.println("此栈中没有元素值");
			return '0';
		}
		else{			
			return top.getNext().getDate();
		}
	}
	public String Empty(){
		if(this.top.getNext()==null){
			return null;
		}
		else{
			return   "ok";
		}
	}
	/*
	 * 在链表尾部插入节点
	 */
	public void AddTail(Node_char node){
		Node_char p=head;
		if(head.getNext()==null){
			p.setNext(node);
			size++;
		}else{
			while(p.getNext()!=null){
				p=p.getNext();	
			}
			p.setNext(node);
			size++;
		}
	}
	/*
	 * 在单链表的头部插入节点。
	 */
	public void AddHead(Node_char node){
		Node_char p=head;
		if(head.getNext()==null){
			p.setNext(node);
			size++;
		}else{
			node.setNext(head.getNext());
			head.setNext(node);
			size++;
		}
	}
	/*
	 * 打印链表
	 */
	public void Printlink(){
		Node_char p=head;
		System.out.println("输出链表:");
		while(p.getNext()!=null){
			p=p.getNext();
			System.out.print(p.getDate()+" ");
		}
		System.out.println();
	}
	public void judge_bracket() throws IOException {
		System.out.println("请输入字符括号:");
		char c=(char) System.in.read();
		int flag=0;
		while(c!='#'){
			switch (c){
				case '(':
					this.Push(new Node_char(c));
					break;
				case '[':				
					this.Push(new Node_char(c));
					break;
				case ']':
					if(this.Empty()!=null && this.getTop_Next()=='['){
						this.Pop();
					}else{
						flag=1;
					}
					break;
				case ')':
					if(this.Empty()!=null && this.getTop_Next()=='('){
						this.Pop();
					}else{
						flag=1;
					}
					break;
			}
			c=(char) System.in.read();
		}
		if(flag==0 && this.Empty()==null){
			System.out.println("匹配");
		}else{
			System.out.println("不匹配");
		}
	}
	/*
	 * 判断是不是回文串
	 */
	public void judge(Stack_Queue  stack){
//		System.out.println(this.size);
		int length=this.size/2,flag=1;
		Node_char p=this.getHead().getNext(),temp=null;
		for(int i=0;i<length;i++){
			temp=p;
			p=p.getNext();
			stack.Push(temp);
			System.out.print(stack.getTop_Next()+" ");
		}
		System.out.println();
		if(this.size%2==0){
			temp=p;
		}else{
			temp=p.getNext();
		}
		for(int i=0;i<length;i++){
			if(stack.getTop_Next()==temp.getDate()){
				flag=1;
				stack.Pop();
				temp=temp.getNext();
			}
			else{
				flag=0;
				break;
			}
		}
		if(flag==1){
			System.out.println("此字符串是回文串");
		}else{
			System.out.println("此字符串不是回文串");
		}
	}
	public static void main(String[] args)throws IOException {
		int n;
		Stack_Queue link =new Stack_Queue();
		Stack_Queue stack=new Stack_Queue();
		Stack_Queue stack_2=new Stack_Queue();//判断括号匹配
		while(true){
			System.out.println("输入:");
			Scanner scanner=new Scanner(System.in);
			n=scanner.nextInt();
			if(n==1){
				System.out.println("请输入字符串:");
				char c=(char)System.in.read(); 
				while(c!='#'){
					link.AddTail(new Node_char(c));
					c=(char)System.in.read(); 
				}
				link.Printlink();
				link.judge(stack);
				break;
			}
			if(n==2){
				stack_2.judge_bracket();
				break;
			}
			
		}
		

//		
		
		
//		int length=link.getSize()%2;
//		Node_char p=link.getHead().getNext();
//		while(p!=null){
//			temp=p;
//			p=p.getNext();
//			//temp.setNext(null);
//			stack.Push(new Node_char(temp.getDate()));			
//		}
//		System.out.println();
//		p=link.getHead().getNext();//重新使p指向头结点
//		for(int i=0;i<link.getSize();i++){
//			if(stack.getTop_Next()==p.getDate()){
//				flag=1;
//				p=p.getNext();
//				stack.Pop();
//			}
//			else{
//				flag=0;
//				break;
//			}
//		}
//		if(flag==1){
//			System.out.println("此字符串是回文串");
//		}else{
//			System.out.println("此字符串不是回文串");
//		}
	}
}
