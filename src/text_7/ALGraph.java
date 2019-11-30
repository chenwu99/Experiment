package text_7;

public class ALGraph {
	VexNode[] vertices=new VexNode[100]; 
	int vexnum,arcnum;
	public ALGraph(int vexnum, int arcnum) {
		this.vexnum = vexnum;
		this.arcnum = arcnum;
		vertices = new VexNode[vexnum];
	}
	public ALGraph() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ALGraph(VexNode[] vertices, int vexnum, int arcnum) {
		super();
		this.vertices = vertices;
		this.vexnum = vexnum;
		this.arcnum = arcnum;
	}
	public VexNode[] getVertices() {
		return vertices;
	}
	public void setVertices(VexNode[] vertices) {
		this.vertices = vertices;
	}
	public int getVexnum() {
		return vexnum;
	}
	public void setVexnum(int vexnum) {
		this.vexnum = vexnum;
	}
	public int getArcnum() {
		return arcnum;
	}
	public void setArcnum(int arcnum) {
		this.arcnum = arcnum;
	}
	
}
