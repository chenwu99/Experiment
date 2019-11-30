package text_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTest {
	public class Tree{
		private int data;
		private Tree nextLeftTree;
		private Tree nextRightTree;
		public Tree(){
			data= 0;
			nextLeftTree=null;
			nextRightTree=null;
		}
		@Override
		public String toString() {
			return "Tree [data=" + data + ", nextLeftTree=" + nextLeftTree + ", nextRightTree=" + nextRightTree + "]";
		}
	}
	
	//�����������
	private Tree head;			//���ĸ��ڵ�
	private Scanner scanner = new Scanner(System.in);	//����Scanner������������System.in����
	public TreeTest(){
		head=new Tree();
	}
	public Tree gethead(){
		return head;
	}
	//���������������������
	private void ergodic (Tree tree){
		if(tree == null) return;
		System.out.println(tree.data);
		ergodic(tree.nextLeftTree);
		ergodic(tree.nextRightTree);
	}
	
	//��������洢������������
	private void creatTree(Tree tree){
		int num = scanner.nextInt();
		if(num == 0) return;
		tree.data = num;
		tree.nextLeftTree = new Tree();
		tree.nextRightTree = new Tree();
		creatTree(tree.nextLeftTree);
		creatTree(tree.nextRightTree);
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue=new LinkedList<>();
	}
}