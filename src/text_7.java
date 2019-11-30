import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class text_7 {
//	private boolean visited[]={false};//��·���Ƿ񱻷��ʹ���
	private boolean[] visited=new boolean[100];//��·���Ƿ񱻷��ʹ���
	private Queue<Character> queue = new LinkedList();
	private Stack<Character> stack=new Stack<>();
	private char[] push=new char[100];
	private int rear=0;
	private Scanner scanner=new Scanner(System.in);
	public int LocateV(ALGraph alGraph,char v){
		int flag=0,i=0;
		for(i=0;i<alGraph.getVexnum();i++){
			if(alGraph.getVertices()[i].getData()==v){
				flag=1;
				break;
			}
		}
		if(flag==1)
			return i;
		else
			return 000;
		
	}
	public int LocateVex(AMGraph amGraph,char v){
		int flag=0,i=0;
		for(i=0;i<amGraph.getVexnum();i++){
			if(amGraph.getVexs()[i]==v){
				flag=1;
				break;
			}
		}
		if(flag==1)
			return i;
		else
			return 000;
		
	}
	public void CreateUDN(AMGraph amGraph) throws IOException{
		System.out.println("�����������Ϣ:");
		for(int i=0;i<amGraph.getVexnum();i++){
			char c = scanner.next().charAt(0);
			amGraph.getVexs()[i]=c;
		}
		
		//��ʼ���ڽӾ��󣬱ߵ�Ȩֵ����Ϊ����ֵMvmax;
		for(int i=0;i<amGraph.getVexnum();i++){
			for(int j=0;j<amGraph.getVexnum();j++){
				amGraph.getArcs()[i][j]=0;
			}
		}
		//�����ڽӾ���
		
		for(int k=0;k<amGraph.getArcnum();++k){
			System.out.println("����һ���������Ķ���");
			char v1 = scanner.next().charAt(0); 
			char v2 = scanner.next().charAt(0); 
//			int w=scanner.nextInt();
			int i=LocateVex(amGraph, v1);
			int j=LocateVex(amGraph, v2);
			amGraph.getArcs()[i][j]=1;
			amGraph.getArcs()[j][i]=amGraph.getArcs()[i][j];
		}
		
	}
	public void CreateUDG(ALGraph alGraph){
		System.out.println("�����������Ϣ:");
		//��������㣬�����ͷ����
		for(int i=0;i<alGraph.getVexnum();i++){
			char c = scanner.next().charAt(0);
			alGraph.getVertices()[i].data=c;
			alGraph.getVertices()[i].setFirstarc(null);
		}
		//�����ڽӱ�;
		for(int k=0;k<alGraph.getArcnum();k++){
			System.out.println("����һ���������Ķ���");
			char v1 = scanner.next().charAt(0); 
			char v2 = scanner.next().charAt(0);
			int i=LocateV(alGraph, v1);//0
			int j=LocateV(alGraph, v2);//1
			ArcNode p1=new ArcNode();
			p1.setAdjvex(j);//����ָ��Ķ���λ�á�
			p1.setNextArc(alGraph.getVertices()[i].getFirstarc());
			alGraph.getVertices()[i].setFirstarc(p1);
			ArcNode p2=new ArcNode();
			p2.setAdjvex(i);
			p2.setNextArc(alGraph.getVertices()[j].getFirstarc());
			alGraph.getVertices()[j].setFirstarc(p2);
		}
	}
	
//	public void text1(ALGraph alGraph){
//		for(int i=0;i<alGraph.getVexnum();i++){
//			VexNode p=alGraph.getVertices()[i];
//			System.out.print(p.getData()+" ");
//			while(p!=null){
//				p=p
//			}
//		}
//		
//	}
	public void text(AMGraph amGraph){
		for(int i=0;i<amGraph.getVexnum();i++){
			for(int j=0;j<amGraph.getVexnum();j++){
				System.out.print(amGraph.getArcs()[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void DFS(AMGraph amGraph){
		int w;
		for(int i=0;i<100;i++)
			visited[i]=false;
		System.out.println("���붥��u,v");
		char u = scanner.next().charAt(0); 
		char v = scanner.next().charAt(0);
		int i=LocateVex(amGraph, u);
		int j=LocateVex(amGraph, v);
		stack.push(u);
		push[rear]=u;
		rear++;
		visited[i]=true;
		while( (!stack.empty()) && (!visited[j]) ){
		      int k = LocateVex(amGraph, stack.peek());//ջ��Ԫ������λ��
		      for(w = 1; w <= amGraph.getVexnum(); w++)
		          if((amGraph.getArcs()[k][w] == 1) && (!visited[w])){//��·��û�����ʹ�
		               visited[w] = true;
		               stack.push(amGraph.getVexs()[w]);//ѹ��ջ
		               push[rear] = amGraph.getVexs()[w];//�Ŷ�����
		               rear++;
		               break;
		          }
		      if(w == (amGraph.getVexnum()+1)){//û��·����
		        stack.pop();
		        rear--;
		      }
		 }
		
	}
	public void output()
	{
	   for(int i = 0; i < rear-1; i++)
		   System.out.print(push[i]+"->");
	   System.out.println(push[rear-1]);
	}
	
	public static void main(String[] args) throws IOException  {
		Scanner scanner=new Scanner(System.in);
		System.out.println("�����ܶ�����,�ܱ���;");
		AMGraph amGraph=new AMGraph(scanner.nextInt(),scanner.nextInt());
		text_7 text_7=new text_7();
		text_7.CreateUDN(amGraph);
		text_7.text(amGraph);
//		text_7.DFS(amGraph);
		text_7.output();
//		
		
	}

}
