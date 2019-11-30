import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class text7_2 {
	public class QUEUE{
		int data;//顶点编号
		int parent;//前一个顶点的位置
	}
	private Scanner scanner=new Scanner(System.in);
	public int LocateV(ALGraph alGraph,char v){
		int flag=0,i=0;
		for(i=0;i<alGraph.vexnum;i++){
			if(alGraph.vertices[i].data==v){
				flag=1;
				break;
			}
		}
		if(flag==1)
			return i;
		else
			return 000;
		
	}
	public void CreateUDG(ALGraph alGraph){
		
		System.out.println("输入各顶点信息:");
		//输入各顶点，构造表头结点表
		for(int i=0;i<alGraph.vexnum;i++){
//			char c = scanner.next().charAt(0);
			alGraph.vertices[i]=new VexNode(scanner.next().charAt(0));
			alGraph.vertices[i].firstarc=null;
		}
		//构造邻接表;
		for(int k=0;k<alGraph.arcnum;k++){
//			System.out.println("输入一条边依附的顶点");
			char v1 = scanner.next().charAt(0); 
			char v2 = scanner.next().charAt(0);
			int i=LocateV(alGraph, v1);//0
			int j=LocateV(alGraph, v2);//1
			ArcNode p1=new ArcNode(j);
//			p1.adjvex=j;//边中指向的顶点位置。
			p1.nextArc=new ArcNode();
			p1.nextArc=alGraph.vertices[i].firstarc;
			alGraph.vertices[i].firstarc=p1;
			ArcNode p2=new ArcNode(i);
//			p2.adjvex=i;
			p2.nextArc=new ArcNode();
			p2.nextArc=alGraph.vertices[j].firstarc;
			alGraph.vertices[j].firstarc=p2;
		}
		System.out.println("输入结束");
	}
	public void OutPut(ALGraph alGraph){
		for(int i=0;i<alGraph.vexnum;i++){
			System.out.print(alGraph.vertices[i].data+" ");
			ArcNode  arc=alGraph.vertices[i].firstarc;
			while(arc!=null){
                System.out.print("-->"+arc.adjvex);
                arc=arc.nextArc;
            }
            System.out.println();
		}
	}
	public int NextAdjVex(ALGraph G,int u,int w)
	{
	    ArcNode p=G.vertices[u].firstarc;
	    while(p!=null)
		{
	        if(p.adjvex==w)
			{
	            p=p.nextArc;
	            break;
	        }
	        p=p.nextArc;
	    }
	    if(p==null)
	        return -1;
	    return p.adjvex;
	}
	public void ShortPath(ALGraph G){
		System.out.println("输入顶点u,v");
		char u = scanner.next().charAt(0); 
		char v = scanner.next().charAt(0);
		int k=LocateV(G, u);
		int j=LocateV(G, v);
		//输出从顶点u到顶点v的最短逆路径
		ArcNode p=new ArcNode();
		int  w,i;
		QUEUE[] qu=new QUEUE[100];
		for(int m=0;m<100;m++){
			qu[m]=new QUEUE();
		}
		int front=-1,rear=-1;//队列头尾指针
		int[] visited=new int[100];
		for(i=0;i<100;i++)//访问标志设置初值0
			visited[i]=0;
		rear++;
		qu[rear].data=k;//顶点u进队
		qu[rear].parent=-1;
		visited[k]=1;
		while(front<=rear)//队列不为空时循环
		{
			front++;
			w=qu[front].data;//出队顶点w
			if(w==j)//找到v时输出路径之逆并退出
			{
				i=front;//通过队列输出逆路径
				while(qu[i].parent!=-1){
					System.out.println(qu[i].data);
					i=qu[i].parent;
				}
				System.out.println(qu[i].data);
				break;
			}
			p=G.vertices[w].firstarc;//找到w的第一邻接点
			while(p!=null){
				if(visited[p.adjvex]==0){
					visited[p.adjvex]=1;
					rear++;//将w的未访问过的邻接点进队
					qu[rear].data=p.adjvex;
					qu[rear].parent=front;
				}
				p=p.nextArc;
			}
		}
	}
	public static void main(String[] args) {
		text7_2 text_2=new text7_2();
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入总顶点数,总边数;");
		ALGraph alGraph=new ALGraph(scanner.nextInt(),scanner.nextInt());
		text_2.CreateUDG(alGraph);
		text_2.OutPut(alGraph);
		text_2.ShortPath(alGraph);
		
	}
	
}
