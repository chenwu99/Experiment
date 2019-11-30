package text_7;

import java.util.Scanner;

public class GraphSchool {

    private int maxValue = 100000;
    public Scenery[] vexs; // ������������Ϣ
    public int[][] arcs; //�ڽӾ���(�洢���߼����)
    public int vexNum, arcNum; //�����ͱ���
    private String[] names = {"a", "b", "c", "d"};
    private String[] introduction = {"a", "b", "c", "d"};

    public GraphSchool() {
        this(false);
    }

    public GraphSchool(boolean isDirection) {
        vexNum = names.length; //����
        arcNum = 4; //����
        vexs = new Scenery[vexNum];
        arcs = new int[vexNum][vexNum];
        //¼�붥��
        for(int i=0 ; i<vexNum ; i++) {
            vexs[i] = new Scenery(names[i], introduction[i]);
        }
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<vexNum ; i++) {
            for(int j=0; j<vexNum ; j++) {
                //��ʼ����¼Ȩֵ�Ķ�ά����(Ĭ��Ϊ����Զ)
                arcs[i][j] = maxValue;
            }
        }
        //¼��߼���Ȩ
        for(int i=0 ; i<arcNum ; i++) {
            //¼����ʼ����յ㣬�Լ���Ȩ
            int x = locateVex(s.next());
            int y = locateVex(s.next());
            int weight = s.nextInt();
            arcs[x][y] = weight;
            if(!isDirection) {
                arcs[y][x] = weight;
            }
        }
    }

    /**
     *
     * @params start, end (��ʼ��ͽ�����λ��)
     * @return path[] (��ʼ�㵽����������·��)
     */
    public int[] shortestPath_DIJ(String startStr, String endStr) {
        int start = locateVex(startStr);
        int end = locateVex(endStr);
        //��¼��ǰ���Ƿ��Ѿ�������·��
        boolean inSet[] = new boolean[vexNum];
        //��¼·��
        int path[] = new int[vexNum];
        //��¼����ʼ�����
        int[] distanceStart = new int[vexNum];
        //��ʼ��distanceStart����
        for(int i=0 ; i<vexNum ; i++) {
            distanceStart[i] = arcs[start][i];
        }
        //��ʼ��path����
        for(int i=0 ; i<vexNum ; i++) {
            if(distanceStart[i] == maxValue) {
                path[i] = -1;
            }else {
                path[i] = start;
            }
        }
        //��start����Ϊ��������·��
        inSet[start] = true;
        //����Զ����Լ�Ϊ0
        distanceStart[start] = 0;

        for(int i=1 ; i<vexNum ; i++) { //��ʣ��n-1�������·��
            int min = maxValue;
            int v = -1;

            //�ҵ�����û��������·���ĵ�����start����ĵ�
            for(int w=0 ; w<vexNum ; w++) {
                if(!inSet[w] && distanceStart[w] < min) {
                    v = w;
                    min = distanceStart[w];
                }
            }

            inSet[v] = true; //���ҵ�����start����ĵ�����Ϊ�Լ�������·��
            distanceStart[v] = min; //�������start�ľ���

            //���и�����·����ı�path�б����·��
            for(int w=0 ; w<vexNum ; w++) {
                //���ҵ��м����н�ĸ��̵ı�,�ı�·��
                if(!inSet[w] && distanceStart[v] + arcs[v][w] < distanceStart[w]) {
                    distanceStart[w] = distanceStart[v] + arcs[v][w];
                    path[w] = v;
                }
            }

            //�ҵ�·��������path
            if(inSet[end])  return path;
        }

        //δ�ҵ�·��������null
        return null;
    }

    public int[] shortestPath_Floyd(String startStr, String endStr) {
        int start = locateVex(startStr);
        int end = locateVex(endStr);
        //��¼·��
        int[][] path = new int[vexNum][vexNum];
        int[][] distanceStart = new int[vexNum][vexNum];

        //��ʼ��path�����distanceStart����
        for(int i=0 ; i<vexNum ; i++) {
            for(int j=0 ; j<vexNum ; j++) {
                //��ʼ����distanceStart����ͱߵ��ڽӾ���һ��
                distanceStart[i][j] = arcs[i][j];
                if(i == j)  distanceStart[i][j] = maxValue;
                //Ϊ����Զ���߾����Լ�������Ϊû����һ��(-1)
                if(distanceStart[i][j] == maxValue || i == j)  path[i][j] = -1;
                else  path[i][j] = i;
            }
        }

        for(int k=0 ; k<vexNum ; k++) {
            for(int i=0 ; i<vexNum ; i++) {
                for(int j=0 ; j<vexNum ; j++) {
                    if(i == j)  continue;
                    //����ҵ�i����k��j��·����i��j�Ķ�
                    if(distanceStart[i][k] + distanceStart[k][j] < distanceStart[i][j]) {
                        //�ı����
                        distanceStart[i][j] = distanceStart[i][k] + distanceStart[k][j];
                        //�ı�·��������j��ǰ��Ϊk
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        //�ҵ�·��������start������������·��
        if(path[start][end] != -1)  return path[start];
        //δ�ҵ�·��������
        return null;

    }

    public int locateVex(String v) {
        for(int i=0 ; i<vexs.length ; i++) {
            if(vexs[i].sceneryName.equals(v)) {
                return i;
            }
        }
        return -1;
    }

}

