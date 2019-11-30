package text_7;


import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Test {

public static void main(String[] args) throws IOException {

//	GraphSchool gs = new GraphSchool();
//	//int[] path = gs.shortestPath_DIJ("a", "d");
//	int[] path = gs.shortestPath_Floyd("a", "d");
//	Stack<Integer> stack = new Stack<Integer>();
//	int index = 3;
//	while(path[index] != -1) {
//	    stack.push(index);
//	    index = path[index];
//	}
//	stack.push(index);
//	while(!stack.isEmpty()) {
//	    System.out.print(gs.vexs[stack.pop()].sceneryName + "\t");
//	}
//	System.out.println();
//	
//	}
	System.out.println("输入总顶点数,总边数;");
	Scanner scanner=new Scanner(System.in);
	int vexnum=scanner.nextInt();
	int arcnum=scanner.nextInt();
	boolean[] visited=new boolean[vexnum];
	for(int i=0;i<visited.length;i++){
		visited[i]=false;
		
	}
		AMGraph amGraph=new AMGraph(vexnum, arcnum);
		text_7 text=new text_7(amGraph,visited);
		text.CreateUDN(amGraph);
		text.DFS(0);
	}
}
