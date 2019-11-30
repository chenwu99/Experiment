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
	 * 递归创建二叉树，进入方法之后在申请空间
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
	 * 计算二叉树的深度
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
	 * 先申请root空间
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
	 * 前序递归 ，遍历数
	 */
	public void  preOrderTraverse(Node node){
		if(node==null) return;
		System.out.println("    ");
		System.out.println("       "+node.getData());
		preOrderTraverse(node.getLeft_next());
		preOrderTraverse(node.getRight_next());
	}
	/*
	 * 前序非递归，输出树
	 */
	public void preOrderByStack(){
		System.out.print("前序非递归遍历:");
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
	 * 中序非递归
	 */
	public void inOrderByStack(){
		System.out.print("中序非递归遍历:");
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
	 * 后序非递归
	 */
	public void postOrderByStack() {
		System.out.print("后序非递归遍历:");
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
		System.out.print("输入树的结点:");
		tree.root=tree.Createtree();
		
		while(true){
			System.out.println("1.计算深度 2.非递归遍历树 3.退出");
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			if(n==1){
				System.out.println("树的深度为:"+tree.Depth(tree.GetRoot()));			
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
