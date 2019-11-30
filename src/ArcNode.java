
public class ArcNode {//±ß½áµã£»
	int adjvex;
//	int info;
	ArcNode nextArc;
	public ArcNode(int adjvex, ArcNode nextArc) {
		super();
		this.adjvex = adjvex;
		this.nextArc = nextArc;
	}
	public ArcNode(int adjvex) {
		this.adjvex=adjvex;
//		this.info=info;
		nextArc=null;
		// TODO Auto-generated constructor stub
	}
	
	public ArcNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdjvex() {
		return adjvex;
	}
	public void setAdjvex(int adjvex) {
		this.adjvex = adjvex;
	}
	public ArcNode getNextArc() {
		return nextArc;
	}
	public void setNextArc(ArcNode nextArc) {
		this.nextArc = nextArc;
	}
	
}
