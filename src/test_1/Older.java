package test_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Older {
	
	public void insert(int date){
		int rem=100,i;
		List<Integer> list=new ArrayList<Integer>();
		
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(8);
		for(i=0;i<list.size();i++){
			if(list.get(i)>date){
				rem=i;
				list.add(rem,date);
				break;
			}
		}
		System.out.println(i);
		if(rem==100){
			list.add(date);
		}
		
		System.out.println(list);
		
	}
	public static void main(String []args){
//		Older older=new Older();
//		int inser;
//		System.out.println("请输入插入的整数:");
//		Scanner n=new Scanner(System.in);
//		inser=n.nextInt();
//		n.close();
//		System.out.println("shazime");
//		older.insert(inser);
		for(int i=0;i<10;i++){
			if(i%2==0){
				i++;
//				System.err.println(" " +i);
			}
			System.err.println("go");
		}
//		
	
	}
	
}
