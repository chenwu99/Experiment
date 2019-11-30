package test_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OlderRight {
	
	
/*
 * 顺序表循环右移
 */
	public void RotateRight(int[] move){
		int rem,i,j;
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入循环右移的位数:");	
		int bit=scanner.nextInt();
		scanner.close();
		 for(j=0;j<bit;j++){
	         rem=move[move.length-1];
	         
	         for(i=move.length-1;i>0;i--){
	             move[i]=move[i-1];
	          }
	            //循环右移结束后临时变量w存入数组第一位
	         move[0]=rem;
	     }
		 System.out.println("顺序表中循环右移的元素为:");
		 for(int k=0;k<move.length;k++){			 
			 System.out.print(move[k]+" ");
		 }
		System.out.println();
		
	}
/*
 * 顺序表实现逆置
 */
	public void Inversion(int[] move){
		int temp,i,j=move.length;
		for(i=0;i<j;i++){
			temp=move[i];
			move[i]=move[j-1];
			move[j-1]=temp;
			j--;
		}
		System.out.println("顺序表逆置后元素为");
		for(int k=0;k<move.length;k++){
			System.out.print(move[k]+" ");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		OlderRight olderright=new OlderRight();
//		List<Integer> list=new ArrayList<Integer>();
		DynamicArray  list=new DynamicArray ();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		int[] move=new int[list.size()];
		for(int i=0;i<list.size();i++){
			move[i]=list.get(i);
		}
		list.print(list);			
		olderright.RotateRight(move);//循环右移					
		olderright.Inversion(move);	//逆置
		
	}
}
