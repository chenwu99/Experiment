package text_7;

public class VexNode {//∂•µ„–≈œ¢;
	char data;
	ArcNode firstarc;

	public VexNode(char data){
		super();
		this.data = data;
		this.firstarc = new ArcNode();
	}
	public VexNode(char data, ArcNode firstarc) {
		super();
		this.data = data;
		this.firstarc = firstarc;
	}
	public VexNode() {
		super();
		this.firstarc = new ArcNode();
		// TODO Auto-generated constructor stub
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public ArcNode getFirstarc() {
		return firstarc;
	}
	public void setFirstarc(ArcNode firstarc) {
		this.firstarc = firstarc;
	}
	
}
