package text_7;

import java.util.Scanner;

public class GraphSchool {

    private int maxValue = 100000;
    public Scenery[] vexs; // 顶点名及其信息
    public int[][] arcs; //邻接矩阵(存储两边间距离)
    public int vexNum, arcNum; //点数和边数
    private String[] names = {"a", "b", "c", "d"};
    private String[] introduction = {"a", "b", "c", "d"};

    public GraphSchool() {
        this(false);
    }

    public GraphSchool(boolean isDirection) {
        vexNum = names.length; //点数
        arcNum = 4; //边数
        vexs = new Scenery[vexNum];
        arcs = new int[vexNum][vexNum];
        //录入顶点
        for(int i=0 ; i<vexNum ; i++) {
            vexs[i] = new Scenery(names[i], introduction[i]);
        }
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<vexNum ; i++) {
            for(int j=0; j<vexNum ; j++) {
                //初始化记录权值的二维数组(默认为无穷远)
                arcs[i][j] = maxValue;
            }
        }
        //录入边及边权
        for(int i=0 ; i<arcNum ; i++) {
            //录入起始点和终点，以及边权
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
     * @params start, end (起始点和结束点位置)
     * @return path[] (起始点到其他点的最短路径)
     */
    public int[] shortestPath_DIJ(String startStr, String endStr) {
        int start = locateVex(startStr);
        int end = locateVex(endStr);
        //记录当前点是否已经求出最短路径
        boolean inSet[] = new boolean[vexNum];
        //记录路径
        int path[] = new int[vexNum];
        //记录距起始点距离
        int[] distanceStart = new int[vexNum];
        //初始化distanceStart数组
        for(int i=0 ; i<vexNum ; i++) {
            distanceStart[i] = arcs[start][i];
        }
        //初始化path数组
        for(int i=0 ; i<vexNum ; i++) {
            if(distanceStart[i] == maxValue) {
                path[i] = -1;
            }else {
                path[i] = start;
            }
        }
        //将start设置为已求出最短路径
        inSet[start] = true;
        //设置远点距自己为0
        distanceStart[start] = 0;

        for(int i=1 ; i<vexNum ; i++) { //求剩余n-1个的最短路径
            int min = maxValue;
            int v = -1;

            //找到所有没计算过最短路径的点中离start最近的点
            for(int w=0 ; w<vexNum ; w++) {
                if(!inSet[w] && distanceStart[w] < min) {
                    v = w;
                    min = distanceStart[w];
                }
            }

            inSet[v] = true; //将找到的离start最近的点设置为以及算过最短路径
            distanceStart[v] = min; //设置其距start的距离

            //若有更近的路径则改变path中保存的路径
            for(int w=0 ; w<vexNum ; w++) {
                //若找到中间有中介的更短的边,改变路径
                if(!inSet[w] && distanceStart[v] + arcs[v][w] < distanceStart[w]) {
                    distanceStart[w] = distanceStart[v] + arcs[v][w];
                    path[w] = v;
                }
            }

            //找到路径，返回path
            if(inSet[end])  return path;
        }

        //未找到路径，返回null
        return null;
    }

    public int[] shortestPath_Floyd(String startStr, String endStr) {
        int start = locateVex(startStr);
        int end = locateVex(endStr);
        //记录路径
        int[][] path = new int[vexNum][vexNum];
        int[][] distanceStart = new int[vexNum][vexNum];

        //初始化path数组和distanceStart数组
        for(int i=0 ; i<vexNum ; i++) {
            for(int j=0 ; j<vexNum ; j++) {
                //初始化的distanceStart数组和边的邻接矩阵一样
                distanceStart[i][j] = arcs[i][j];
                if(i == j)  distanceStart[i][j] = maxValue;
                //为无穷远或者距离自己都设置为没有上一个(-1)
                if(distanceStart[i][j] == maxValue || i == j)  path[i][j] = -1;
                else  path[i][j] = i;
            }
        }

        for(int k=0 ; k<vexNum ; k++) {
            for(int i=0 ; i<vexNum ; i++) {
                for(int j=0 ; j<vexNum ; j++) {
                    if(i == j)  continue;
                    //如果找到i经过k到j的路径比i到j的短
                    if(distanceStart[i][k] + distanceStart[k][j] < distanceStart[i][j]) {
                        //改变距离
                        distanceStart[i][j] = distanceStart[i][k] + distanceStart[k][j];
                        //改变路径，设置j的前驱为k
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        //找到路径，返回start到其他点的最短路径
        if(path[start][end] != -1)  return path[start];
        //未找到路径，返回
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

