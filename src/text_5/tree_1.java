package text_5;

import java.util.Scanner;
import java.util.Stack;

public class tree_1 {
	
	private Scanner scanner=new Scanner(System.in);
	private Node root;
	private int[] SqBiTree;
	public Node GetRoot(){
		return this.root;
	}
	public void setRoot(Node root){
		this.root=root;
	}
	public tree_1(){
		root=new Node();
	}
	/*
	 * �ݹ鴴�������������뷽��֮��������ռ�
	 */
	public Node Createtree(){
		Node node;
		int n=scanner.nextInt();
		if(n==0){
			return null;
		}
		else{
			node=new Node();
			node.setData(n);
			node.setLeft_next(Createtree());
			node.setRight_next(Createtree());
		}
		return node;
	}
	/*
	 * ��������������
	 */
	public int Depth(Node node){
		if(node==null)
			return 0;
		int m=Depth(node.getLeft_next())+1;
		int n=Depth(node.getRight_next())+1;
        int deep=m>n?m:n;
        return deep;
	}
	/*
	 * ������root�ռ�
	 */
	public void Create_tree(Node node){
		int n=scanner.nextInt();
		if(n==0)  return;
		else{			
			node.setData(n);
			node.setLeft_next(new Node());
			node.setRight_next(new Node());
			Create_tree(node.getLeft_next());
			Create_tree(node.getRight_next());
		}
	}
	/*
	 * ǰ��ݹ� ��������
	 */
	public void  preOrderTraverse(Node node){
		if(node==null) return;
		System.out.println("    ");
		System.out.println("       "+node.getData());
		preOrderTraverse(node.getLeft_next());
		preOrderTraverse(node.getRight_next());
	}
	/*
	 * ǰ��ǵݹ飬�����
	 */
	public void preOrderByStack(){
		System.out.print("ǰ��ǵݹ����:");
		Stack<Node> stack=new Stack<Node>();
		Node current=root;
		while(current!=null || !stack.isEmpty()){
			while(current!=null){
				stack.push(current);
				System.out.print(current.getData()+" ");
				current=current.getLeft_next();				
			}
			if(!stack.isEmpty()){
				current=stack.pop();
				current=current.getRight_next();				
			}
		}
		System.out.println();     
	}
	/*
	 * ����ǵݹ�
	 */
	public void inOrderByStack(){
		System.out.print("����ǵݹ����:");
		Stack<Node> stack=new Stack<Node>();
		Node current=root;
		while(current!=null || !stack.isEmpty()){
			while(current!=null){
				stack.push(current);
				current=current.getLeft_next();				
			}
			if(!stack.isEmpty()){
				current=stack.pop();
				System.out.print(current.getData()+" ");
				current=current.getRight_next();				
			}
		}
		System.out.println();
	}
	/*
	 * ����ǵݹ�
	 */
	public void postOrderByStack() {
		System.out.print("����ǵݹ����:");
		Stack<Node> stack = new Stack<Node>();
		Node current = this.GetRoot();
		Node preNode = null;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.getLeft_next();
			}
			if (!stack.isEmpty()) {
				current = stack.peek().getRight_next();
				if (current == null || current == preNode) {
					current = stack.pop();
					System.out.print(current.getData()+" ");
					preNode = current;
					current = null;
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args){
		tree_1 tree=new tree_1();
		System.out.print("�������Ľ��:");
		tree.root=tree.Createtree();
		
		while(true){
			System.out.println("1.������� 2.�ǵݹ������ 3.�˳�");
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			if(n==1){
				System.out.println("�������Ϊ:"+tree.Depth(tree.GetRoot()));			
			}else if(n==2){
				tree.preOrderByStack();
				tree.inOrderByStack();
				tree.postOrderByStack();
			}else{
				break;
			}
		}
		
	}
}//1 2 5 4 0 0 8 0 0 9 0 0 4 0 0
