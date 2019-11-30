package test_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

//实现一个动态数组
public class DynamicArray {
	//申请一个数组,初始定长是100
	int[] Original;
	private int startLength=5;
	int len=0;//当前长度
	
	//不给数组的初始长度，使用默认的初始长度
	public DynamicArray(){
		Original=new int[startLength];
	}
	
	//给定初始数组长度
	public DynamicArray(int startLength){
		this.startLength=startLength;
	}
	
	//添加数据的方法
	public void add(int o) {
		//当前所用长度和数组可用长度相等,已经容不下数组元素时。
		if(len==Original.length) {
			int[] newArray= new int[Original.length*2];//将数组的长度扩展一倍
			//保存原来的值
			for(int i=0;i<len;i++)
				newArray[i]=Original[i];
			newArray[len]=o;
			len++;
			//把原来的数组指向改变后的数组位置
			Original=newArray;
		}else {
			Original[len]=o;
			//当前元素个数增加1
			len++;
			}
	}
	
	//返回数组的长度
	public int size() {
		return len;
	}
	
	//获取数据的方法
	public int get(int index) {
		return Original[index];
	}
	
	//插入数据的方法
	public void insert(int o,int position) {
		len++;
		if(len>Original.length) {
			int[] newArray= new int[Original.length*2];
			for(int i=0;i<position;i++)
				newArray[i]=Original[i];
			for(int i=position+1;i<len;i++)
				newArray[i]=Original[i-1];
			newArray[position]=o;
			Original=newArray;//把原来的数组指向改变后的数组位置
		}
		else {
			for(int i=len-1;i>position;i--){//往后挪一位;
				Original[i]=Original[i-1];
			}
			Original[position]=o;
		}
	}
	/*
	 * 输入插入元素并判断插入的位置。
	 */
	public void scanner(DynamicArray test){
		int position=1000,inser;
		System.out.print("请输入插入的元素: " );
		Scanner scanner=new Scanner(System.in);
		inser=scanner.nextInt();
		for(int i=0;i<test.size();i++){//判断插入位置。
			if(test.get(i)>=inser){
				position=i;
				break;
			}
		}
		if(position==1000){
			position=test.size();
		}
		System.out.println("插入位置:"+position);
		test.insert(inser, position);
	}
	
	public void print(DynamicArray test){
		System.out.print("顺序表中的元素为:");
		for(int i=0;i<test.size();i++){
			System.out.print(test.get(i)+" ");			
		}
		System.out.println();
	}
	/*
	 * 顺序表循环右移
	 */
	public void RotateRight(){
		int rem,i,j;
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入循环右移的位数:");	
		int bit=scanner.nextInt();
//		scanner.close();
		for(j=0;j<bit;j++){
			rem=Original[len-1];
			for(i=len-1;i>0;i--){
			    Original[i]=Original[i-1];
			}
			//循环右移结束后临时变量w存入数组第一位
			Original[0]=rem;
		}
		System.out.println("顺序表中循环右移的元素为:");
		for(int k=0;k<len;k++){			 
			System.out.print(Original[k]+" ");
		}
		System.out.println();
	}
	/*
	 * 顺序表实现逆置
	 */
	public void Inversion(){
		int temp,i,j=len;
		for(i=0;i<j;i++){
			temp=Original[i];
			Original[i]=Original[j-1];
			Original[j-1]=temp;
			j--;
		}
		System.out.println("顺序表逆置后元素为");
		for(int k=0;k<len;k++){
			System.out.print(Original[k]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		DynamicArray test=new DynamicArray();
		test.add(2);
		test.add(3);
		test.add(5);
		test.add(9);
		test.add(10);	   
		while(true){ 
			System.out.println();
			System.out.println("请输入实验序号:");
			Scanner scanne=new Scanner(System.in);
			int n=scanne.nextInt();
//			scanne.close();
			test.print(test);//输出顺序表
			if(n==1){
				test.scanner(test);//输入插入元素，并判断插入位置
				test.print(test);
				
			}
			if(n==2){
				test.RotateRight();				
			}
			if(n==3){
				test.Inversion();
			}
				
			if(n==4){
				System.out.println("您已退出此菜单！");
				break;
			}
//			scanner.close();
		}
		  		
	}
	
}