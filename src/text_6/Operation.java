package text_6;

import java.io.IOException;
import java.math.BigDecimal;

//import javax.print.attribute.standard.OrientationRequested;

public class Operation {
	private Queue queue;
	private Object[] Original;
	private int startLength=20;
	private int top;
	static int flag=0;
	public int Gettop(){
		return top;
	}
	/*
	 * 初始化所建立的对象的数组长度和top
	 */
	public Operation(){
		Original=new Object[startLength];
		this.top=0;
		this.queue=new Queue();
	}
	/*
	 * 入队
	 */
	public void EnQueue(Object object){
		Object[] original=queue.getOriginal();
		if(queue.getFront()==queue.getRear()){
			original[0]=object;
			queue.setRear(queue.getRear()+1);
		}else{
			original[queue.getRear()]=object;
			queue.setRear(queue.getRear()+1);		
		}
		
	}
	/*
	 * 出队
	 */
	public Object DeQueue(){
		Object[] original=queue.getOriginal();
		int front=queue.getFront();
		if(queue.getRear()==0){
			System.out.println("空队");
			return null;
		}else{
			
			queue.setFront(queue.getFront()+1);
			return original[front];
//			return object;
		}
	}
	public Object GetRear(){
		Object[] original=queue.getOriginal();
		if(queue.getRear()==0){
			System.out.println("空队");
			return null;
		}else{
			return original[queue.getRear()-1];
		}
	}
	/*
	 * 进栈，top上移
	 */
	public void Push(Object object){
		if(this.top==0){
			this.Original[0]=object;
			this.top++;
		}else{
			Original[this.top]=object;
			this.top++;
		}
	}
	/*
	 * 出栈，并且top的值下移
	 */
	public Object Pop(){
		if(this.top==0){
			System.out.println("次栈是空栈");
			return null;
		}else{
			Object object=Original[this.top-1];
			this.top--;
			return object;
		}
	}
	public Object getTop(){
		if(this.Gettop()==0){
			System.out.println("空栈");
			return null;
		}else{
			Object object=this.Original[this.top-1];
			return object;
		}
		
	}
	
	
	/*
	 * 判断并返回两个运算符之间的优先级
	 */
	public int  priority(char n,char m){
		int flag=1;
		char [][] compare=new char[7][7];
		
		return flag;
	}
	static public double Operator(double m,double n,char Char){
		double result;
		 
		if(Char=='+'||Char=='-'||Char=='*'||Char=='/'){
			switch(Char){
				case '*':
					result=m*n;
					BigDecimal  b   =   new   BigDecimal(result);  
					double   resultEnd1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					return resultEnd1;
				case '/':
					if(n==0){
						flag=1;
						System.out.println("除0错误操作");
						return 000;
					}
					result=m/n;
					BigDecimal   c   =   new   BigDecimal(result);  
					double   resultEnd2   =   c.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
					return resultEnd2;
				case '+':
					result=m+n;
					BigDecimal   d   =   new   BigDecimal(result);  
					double   resultEnd3   =   d.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
					return resultEnd3;
				case '-':
					result=m-n;
					BigDecimal   e   =   new   BigDecimal(result);  
					double   resultEnd4   =   e.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
					return resultEnd4;
				default:
					return 0;
			}
		}
		else{
			System.out.println("非法标志符");
			return 000;
		}
//		return Char;
	}
	/*
	 * 若s1优先则返回>,若s2优先则返回<,若s1,s2相同则返回=
	 */
	static public char Precede(char s1,char s2)
	{
		char f = 0;
		switch(s2)
		{
			case '+':
			case '-': 
				if(s1=='('|| s1=='#')
					f='<';
				else
					f='>';
				break;
			case '*':
			case '/': 
				if(s1=='*'||s1=='/'||s1==')')
					f='>';
				else
					f='<';
				break;
			case '(':
					f='<';
				break;
			case ')': 
					f='>';
				break;
			case '#':
				if(s1=='#')
					f='=';
				else
					f='>';
				break;
			default :
				break;
		}
		return f;
	} 
	public char[] InputChar() throws IOException{
		char[] in = new char [20];
		int i=0;//输入的字符数组的长度。
		System.out.println("请输入字符:");
		char ch=(char)System.in.read();
		while(ch!='#'){
			in[i]=ch;
			i++;  
			ch=(char)System.in.read();
		}
		return in;
	}
	/*
	 *中缀计算 
	 */
	public double during(char[] in){
		Operation operation=new Operation();
		Operation number=new Operation();
		operation.Push('#');
		number.Push('#');
		double x=0,y=0;
		double num;
		
		for(int j=0;j<in.length;j++){
			String keepnum="";
			if(in[j]>='0' && in[j]<='9'){
				while((in[j]>'0' && in[j]<'9' ) || in[j]=='.'){
					keepnum+=in[j];
					j++;
				}
				j--;
				num = Double.valueOf(keepnum.toString());
//				num=Integer.valueOf(keepnum).intValue();
				number.Push(num);System.out.println("           "+number.getTop());
			}else{
					char s1=(char)operation.getTop();
					switch(Precede(s1,in[j])){
					case '>':
						if(in[j]==')'){
							for(int i=operation.Gettop()-1;i>=0;i--){
								char c1=(char)operation.getTop();
								if(c1=='('){
									operation.Pop();
									break;
								}
								operation.Pop();
								x=(double)(number.Pop());
								y=(double)(number.Pop());
								number.Push(Operator(y,x,c1));System.out.println("             "+number.getTop());
							}
							
						}else{
							x=(double)(number.Pop());
							y=(double)(number.Pop());
							number.Push(Operator(y, x, s1));System.out.println("             "+number.getTop());
							operation.Pop();
							operation.Push(in[j]);
							
						}
						break;
					case '<':
						operation.Push(in[j]);
						break;
					case '=':
						//operation.Pop();
						break;
					default:
						break;
				}	
			}
		}
		for(int i=operation.Gettop();i>=0;i--){
			char c1=(char)operation.getTop();
			if(c1=='#'){
				break;
			}
			x=(double)(number.Pop());
			y=(double)(number.Pop());
			number.Push(Operator(y,x,c1));System.out.println("             "+number.getTop());
			operation.Pop();
		}
		return (double)number.Pop();
	}


	/*
	 * 中缀表达式转化成后缀表达式
	 */
	 public Operation Input(char[] in) throws IOException{
		Operation operation=new Operation();
		Operation number=new Operation();
		Operation End=new Operation();
		char[] post=new char[20];
		int z,i;
		double num;
		operation.Push('#');
		number.Push('#');
		for(int j=0;j<in.length;j++){
			String keepnum="";
//			char in[j]=in[j];
			if(in[j]>=48 && in[j]<=57){
				while((in[j]>='0' && in[j]<='9' ) || in[j]=='.'){
					keepnum+=in[j];
					j++;
				}
				j--;
				num = Double.valueOf(keepnum.toString());
//				num=Integer.valueOf(keepnum).intValue();
				System.out.println(num);
				End.EnQueue(num);
					
//				System.out.print(in[j]);
//				End.EnQueue(in[j]);
//				System.out.println();
//				
			}
			else{
				if(operation.Gettop()==0){
					operation.Push(in[j]);
				}else{
					char s1=(char)operation.getTop();
					switch(Precede(s1,in[j])){
					case '>':
						if(in[j]==')'){
							for(int k=operation.top-1;k>=0;k--){
								char c1=(char)operation.getTop();
								if(c1=='('){
									operation.Pop();
									break;
								}
								End.EnQueue(operation.getTop());
//								End.Push(operation.getTop());System.out.print("End  "+End.getTop());
								System.out.println(operation.Pop());
							}
						}else{
//								End.Push(operation.getTop());System.out.print("End  "+End.getTop());
								End.EnQueue(operation.getTop());
								System.out.println(operation.Pop());
								char c2=(char)operation.getTop();
								if(Precede(c2, in[j])=='>'){
//									End.Push(operation.getTop());System.out.print("End  "+End.getTop());
									End.EnQueue(operation.getTop());
									System.out.println(operation.Pop());
								}	
								operation.Push(in[j]);							
						}
						break;
					case '<':
						operation.Push(in[j]);
						break;
					}
				}	
			}
//			System.out.println("   "+j);
		}
		System.out.println("栈顶"+operation.Gettop());
		for(int j=operation.top-1;j>0;j--){
			System.out.println(operation.Original[j]);
			End.EnQueue(operation.Original[j]);
		}
		return End;
	}
	 /*
	  * 乘法计算
	  */
	 public int chengfa(int z){
		 int sum=1;
		 for(int i=1;i<z;i++){
			sum=sum*10;
		 }
		 return sum;
	 }
	 /*
	  * 后缀表达式计算；
	  */
	 public int back_count(){
			Operation back_CPush=new Operation();
			Object object=null;
			double x=0,y=0;
			for(int i=0;i<this.queue.getRear();i++){
				object=this.DeQueue();
				//如果obj是字符类型
					String str="";//把object转化为String类型
					str=object.toString();
//					str=String.valueOf(object);
					if(str=="*" || str=="-" || str=="+" || str=="/" || str=="%"){
						char c=str.charAt(0);
						x=(double)back_CPush.Pop();
						y=(double)back_CPush.Pop();
						back_CPush.Push(Operator(y, x, c));
						System.out.println(back_CPush.getTop());
					}else{
//						double num=Double.parseDouble(object.toString()); 
						Double num=Double.parseDouble(str);//String转化为double
						back_CPush.Push(num);
						System.out.println(back_CPush.getTop());
					}
					
//					char c = (char)object;//进行强制类型转换
//					if(c>='0' && c<='9'){
//						back_CPush.Push((int)c-48);
//						
//					}else{
//						x=(int)back_CPush.Pop();
//						y=(int)back_CPush.Pop();
//						back_CPush.Push(Operator(y, x, c));
//					}
					
				
			}
//			System.out.println("     "+back_CPush.Pop());
			return (int)back_CPush.Pop();
		}
	 
	 public void system_Queue(){
		 System.out.println("输出队中的元素");
		 for(int i=0;i<queue.getRear();i++){
			 System.out.println(this.DeQueue());
		 }
		 
	 }
	 
	 public void system_Push(Operation back_conut){
		 int i;
		 System.out.println("多少呀"+back_conut.Gettop());
		 for(i=0;i<back_conut.Gettop();i++){
			 System.out	.println(back_conut.getTop()+"  "+i);
			 back_conut.Pop();
		 }
		 System.out.println("   ghl"+i);
	 }
	public static void main(String[] args) throws IOException {
//        BigDecimal b = new BigDecimal("20").divide(new BigDecimal("3"), 3, BigDecimal.ROUND_UP);
//        System.out.println( b );
		Operation link=new Operation();
		Operation back_opereator=new Operation();
		
//		System.out.println(Operator(1.50, -2, '/'));
		char[] in=link.InputChar();
//		
		back_opereator=link.Input(in);//中缀到后缀		
//		System.out.println(back_opereator.back_count());//后缀计算
		System.out.println(link.during(in));//中缀计算
    }
//(1.3-1+2)*2.5+1-3#
}
