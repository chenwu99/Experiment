package text_5;


import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;
import java.util.Stack;

public class tree_2 {
	private int[] treeleft;
	private int deep;
	private int length;
	public tree_2(int deep){
		this.deep=deep;
//		length=(int) (Math.log(deep)/Math.log(2));
		length=deep;
		treeleft=new int[length];
	}
	/*
	 * 创建顺序表存储完全二叉树
	 */
	public void CreateTree(){
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<treeleft.length ;i++){
			int n=scanner.nextInt();
			if(n==0){
				scanner.close();
				break;
			}
			treeleft[i]=n;
		}
		
	}
	/*
	 * 先序非递归
	 */
	public void PreTravel2(int parentindex){
		int len=length;
		Stack<Integer> st=new Stack<Integer>();
		System.out.println("先序非递归:");
		while(!st.isEmpty() || parentindex<=len-1)
		{
			while(parentindex<=len-1){
				st.push(parentindex);
				System.out.print(treeleft[parentindex]+" ");
				parentindex=parentindex*2+1;
			}
			if(!st.isEmpty()){
				parentindex=st.peek();//parentindex=st.pop();parentindex=parentindx*2+2;
				parentindex=parentindex*2+2;
				st.pop();
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("输入结点个数:");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		tree_2 tree=new tree_2(n);
		tree.CreateTree();
		tree.PreTravel2(0);
		
	}
}//1 2 3 4 5 6 7 8 9
