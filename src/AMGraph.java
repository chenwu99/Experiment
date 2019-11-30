
public class AMGraph {
	private static int MVNum=100;
	private int vexnum;//��ǰ����
	private int arcnum;//��ǰ����
	private char[] vexs;//�����
	private int[][] arcs;//�ڽӾ���
	
	public AMGraph(int vexnum,int arcnum) {
		this.vexnum = vexnum;
		this.arcnum=arcnum;
		this.vexs = new char[vexnum];
		this.arcs = new int[vexnum][vexnum];
	}
	 
	public static int getMVNum() {
		return MVNum;
	}

	public static void setMVNum(int mVNum) {
		MVNum = mVNum;
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
	public char[] getVexs() {
		return vexs;
	}
	public void setVexs(char[] vexs) {
		this.vexs = vexs;
	}
	public int[][] getArcs() {
		return arcs;
	}
	public void setArcs(int[][] arcs) {
		this.arcs = arcs;
	}
	

}
