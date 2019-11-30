import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class text7_2 {
	public class QUEUE{
		int data;//������
		int parent;//ǰһ�������λ��
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
		
		System.out.println("�����������Ϣ:");
		//��������㣬�����ͷ����
		for(int i=0;i<alGraph.vexnum;i++){
//			char c = scanner.next().charAt(0);
			alGraph.vertices[i]=new VexNode(scanner.next().charAt(0));
			alGraph.vertices[i].firstarc=null;
		}
		//�����ڽӱ�;
		for(int k=0;k<alGraph.arcnum;k++){
//			System.out.println("����һ���������Ķ���");
			char v1 = scanner.next().charAt(0); 
			char v2 = scanner.next().charAt(0);
			int i=LocateV(alGraph, v1);//0
			int j=LocateV(alGraph, v2);//1
			ArcNode p1=new ArcNode(j);
//			p1.adjvex=j;//����ָ��Ķ���λ�á�
			p1.nextArc=new ArcNode();
			p1.nextArc=alGraph.vertices[i].firstarc;
			alGraph.vertices[i].firstarc=p1;
			ArcNode p2=new ArcNode(i);
//			p2.adjvex=i;
			p2.nextArc=new ArcNode();
			p2.nextArc=alGraph.vertices[j].firstarc;
			alGraph.vertices[j].firstarc=p2;
		}
		System.out.println("�������");
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
		System.out.println("���붥��u,v");
		char u = scanner.next().charAt(0); 
		char v = scanner.next().charAt(0);
		int k=LocateV(G, u);
		int j=LocateV(G, v);
		//����Ӷ���u������v�������·��
		ArcNode p=new ArcNode();
		int  w,i;
		QUEUE[] qu=new QUEUE[100];
		for(int m=0;m<100;m++){
			qu[m]=new QUEUE();
		}
		int front=-1,rear=-1;//����ͷβָ��
		int[] visited=new int[100];
		for(i=0;i<100;i++)//���ʱ�־���ó�ֵ0
			visited[i]=0;
		rear++;
		qu[rear].data=k;//����u����
		qu[rear].parent=-1;
		visited[k]=1;
		while(front<=rear)//���в�Ϊ��ʱѭ��
		{
			front++;
			w=qu[front].data;//���Ӷ���w
			if(w==j)//�ҵ�vʱ���·��֮�沢�˳�
			{
				i=front;//ͨ�����������·��
				while(qu[i].parent!=-1){
					System.out.println(qu[i].data);
					i=qu[i].parent;
				}
				System.out.println(qu[i].data);
				break;
			}
			p=G.vertices[w].firstarc;//�ҵ�w�ĵ�һ�ڽӵ�
			while(p!=null){
				if(visited[p.adjvex]==0){
					visited[p.adjvex]=1;
					rear++;//��w��δ���ʹ����ڽӵ����
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
		System.out.println("�����ܶ�����,�ܱ���;");
		ALGraph alGraph=new ALGraph(scanner.nextInt(),scanner.nextInt());
		text_2.CreateUDG(alGraph);
		text_2.OutPut(alGraph);
		text_2.ShortPath(alGraph);
		
	}
	
}
