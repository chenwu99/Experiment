package text_7;
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
	private boolean[] visit;
	private AMGraph amGraph;
	public text_7(AMGraph amGraph,boolean[] visit){
		this.amGraph=amGraph;
		this.visit=visit;
	}
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
//			System.out.println("����һ���������Ķ���");
			char v1 = scanner.next().charAt(0); 
			char v2 = scanner.next().charAt(0); 
//			int w=scanner.nextInt();
			int i=LocateVex(amGraph, v1);
			int j=LocateVex(amGraph, v2);
			amGraph.getArcs()[i][j]=1;
			amGraph.getArcs()[j][i]=amGraph.getArcs()[i][j];
		}
		
	}
	public void DFS(int v){
		System.out.println(v);
		this.visit[v]=true;
		for(int w=0;w<amGraph.getVexnum();w++){
			if(amGraph.getArcs()[v][w]==1 && visit[w]==false){
				DFS(w);
			}
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
	public void DFS(){
		int w;
		for(int i=0;i<100;i++)
			visited[i]=false;
		System.out.println("���붥��u,v");
		char u = scanner.next().charAt(0); 
		char v = scanner.next().charAt(0);
		int i=LocateVex(this.amGraph, u);
		int j=LocateVex(this.amGraph, v);
		stack.push(u);
		push[rear]=u;
		rear++;
		visited[i]=true;
		while( (!stack.empty()) && (!visited[j]) ){
		      int k = LocateVex(this.amGraph, stack.peek());//ջ��Ԫ������λ��
		      for(w = 1; w <= this.amGraph.getVexnum(); w++)
		          if((this.amGraph.getArcs()[k][w] == 1) && (!visited[w])){//��·��û�����ʹ�
		               visited[w] = true;
		               stack.push(this.amGraph.getVexs()[w]);//ѹ��ջ
		               push[rear] = this.amGraph.getVexs()[w];//�Ŷ�����
		               rear++;
		               break;
		          }
		      if(w == (this.amGraph.getVexnum()+1)){//û��·����
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
//	public void DFS(AMGraph amGraph,char u,char v,char[] path,int length,int visit[]){
//		int s;
//		for(int i=0;i<amGraph.getVexnum();i++){
//			if(amGraph)
//		}
//	}
//	public void FindAllPath(AMGraph amGraph,char u,char v){
//		if(u==v)
//			System.out.println("��������ͬ");
//		else{
//			int[] visit=new int[100];
//			for(int i=0;i<100;i++)
//				visit[i]=0;
//			char[] path=new char[100];
//			DFS(amGraph,u,v,0,visit);
//			
//		}
//	}
	public static void main(String[] args) throws IOException  {
		Scanner scanner=new Scanner(System.in);
		System.out.println("�����ܶ�����,�ܱ���;");
		int vex=scanner.nextInt();
		int arc=scanner.nextInt();
		AMGraph amGraph=new AMGraph(vex,arc);
		boolean[] visit=new boolean[vex];
		for(int i=0;i<vex;i++){
			visit[i]=false;
		}
		text_7 text_7=new text_7(amGraph,visit);
		text_7.CreateUDN(amGraph);
		text_7.text(amGraph);
		text_7.DFS();
		text_7.output();
//		
		
	}

}
