package test_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

//ʵ��һ����̬����
public class DynamicArray {
	//����һ������,��ʼ������100
	int[] Original;
	private int startLength=5;
	int len=0;//��ǰ����
	
	//��������ĳ�ʼ���ȣ�ʹ��Ĭ�ϵĳ�ʼ����
	public DynamicArray(){
		Original=new int[startLength];
	}
	
	//������ʼ���鳤��
	public DynamicArray(int startLength){
		this.startLength=startLength;
	}
	
	//������ݵķ���
	public void add(int o) {
		//��ǰ���ó��Ⱥ�������ó������,�Ѿ��ݲ�������Ԫ��ʱ��
		if(len==Original.length) {
			int[] newArray= new int[Original.length*2];//������ĳ�����չһ��
			//����ԭ����ֵ
			for(int i=0;i<len;i++)
				newArray[i]=Original[i];
			newArray[len]=o;
			len++;
			//��ԭ��������ָ��ı�������λ��
			Original=newArray;
		}else {
			Original[len]=o;
			//��ǰԪ�ظ�������1
			len++;
			}
	}
	
	//��������ĳ���
	public int size() {
		return len;
	}
	
	//��ȡ���ݵķ���
	public int get(int index) {
		return Original[index];
	}
	
	//�������ݵķ���
	public void insert(int o,int position) {
		len++;
		if(len>Original.length) {
			int[] newArray= new int[Original.length*2];
			for(int i=0;i<position;i++)
				newArray[i]=Original[i];
			for(int i=position+1;i<len;i++)
				newArray[i]=Original[i-1];
			newArray[position]=o;
			Original=newArray;//��ԭ��������ָ��ı�������λ��
		}
		else {
			for(int i=len-1;i>position;i--){//����Ųһλ;
				Original[i]=Original[i-1];
			}
			Original[position]=o;
		}
	}
	/*
	 * �������Ԫ�ز��жϲ����λ�á�
	 */
	public void scanner(DynamicArray test){
		int position=1000,inser;
		System.out.print("����������Ԫ��: " );
		Scanner scanner=new Scanner(System.in);
		inser=scanner.nextInt();
		for(int i=0;i<test.size();i++){//�жϲ���λ�á�
			if(test.get(i)>=inser){
				position=i;
				break;
			}
		}
		if(position==1000){
			position=test.size();
		}
		System.out.println("����λ��:"+position);
		test.insert(inser, position);
	}
	
	public void print(DynamicArray test){
		System.out.print("˳����е�Ԫ��Ϊ:");
		for(int i=0;i<test.size();i++){
			System.out.print(test.get(i)+" ");			
		}
		System.out.println();
	}
	/*
	 * ˳���ѭ������
	 */
	public void RotateRight(){
		int rem,i,j;
		Scanner scanner=new Scanner(System.in);
		System.out.print("������ѭ�����Ƶ�λ��:");	
		int bit=scanner.nextInt();
//		scanner.close();
		for(j=0;j<bit;j++){
			rem=Original[len-1];
			for(i=len-1;i>0;i--){
			    Original[i]=Original[i-1];
			}
			//ѭ�����ƽ�������ʱ����w���������һλ
			Original[0]=rem;
		}
		System.out.println("˳�����ѭ�����Ƶ�Ԫ��Ϊ:");
		for(int k=0;k<len;k++){			 
			System.out.print(Original[k]+" ");
		}
		System.out.println();
	}
	/*
	 * ˳���ʵ������
	 */
	public void Inversion(){
		int temp,i,j=len;
		for(i=0;i<j;i++){
			temp=Original[i];
			Original[i]=Original[j-1];
			Original[j-1]=temp;
			j--;
		}
		System.out.println("˳������ú�Ԫ��Ϊ");
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
			System.out.println("������ʵ�����:");
			Scanner scanne=new Scanner(System.in);
			int n=scanne.nextInt();
//			scanne.close();
			test.print(test);//���˳���
			if(n==1){
				test.scanner(test);//�������Ԫ�أ����жϲ���λ��
				test.print(test);
				
			}
			if(n==2){
				test.RotateRight();				
			}
			if(n==3){
				test.Inversion();
			}
				
			if(n==4){
				System.out.println("�����˳��˲˵���");
				break;
			}
//			scanner.close();
		}
		  		
	}
	
}