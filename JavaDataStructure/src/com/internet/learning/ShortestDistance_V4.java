package com.internet.learning;

//这个程序用来求得一个图的最短路径矩阵  
public class ShortestDistance_V4 {
	public static int dijkstra(int[][] W1, int start, int end) {
		boolean[] isLabel = new boolean[W1[0].length];// 是否标号
		int min = Integer.MAX_VALUE;
		int[] indexs = new int[W1[0].length];// 所有标号的点的下标集合
		int i_count = -1;
		int index = start;// 从初始点开始
		int presentShortest = 0;
		int[] distance = W1[start].clone();// v0到各点的最短距离的初始值
		indexs[++i_count] = index;// 把已经标号的下标存入下标集中
		isLabel[index] = true;
		while (true) {
			// 第一步：标号v0,即w[0][0]找到距离v0最近的点

			min = Integer.MAX_VALUE;
			for (int i = 0; i < distance.length; i++) {
				if (!isLabel[i] && distance[i] != -1 && i != index) {
					// 如果到这个点有边,并且没有被标号
					if (distance[i] < min) {
						min = distance[i];
						index = i;// 把下标改为当前下标
					}
				}
			}
			if (index == end) {
				break;
			}
			isLabel[index] = true;
			indexs[++i_count] = index;// 把已经标号的下标存入下标集中
			if (W1[indexs[i_count - 1]][index] == -1
					|| presentShortest + W1[indexs[i_count - 1]][index] > distance[index]) {
				presentShortest = distance[index];
			} else {
				presentShortest += W1[indexs[i_count - 1]][index];
			}

			// 第二步：奖distance中的距离加入vi
			for (int i = 0; i < distance.length; i++) {
				// 如果vi到那个点有边，则v0到后面点的距离加
				// 程序到这里是有问题滴！ 呵呵
				if (distance[i] == -1 && W1[index][i] != -1) {// 如果以前不可达，则现在可达了
					distance[i] = presentShortest + W1[index][i];
				} else if (W1[index][i] != -1
						&& presentShortest + W1[index][i] < distance[i]) {
					// 如果以前可达，但现在的路径比以前更短，则更换成更短的路径
					distance[i] = presentShortest + W1[index][i];
				}

			}
		}
		return distance[end] - distance[start];
	}

	public static int[][] getShortestPathMatrix(int[][] W) {
		int[][] SPM = new int[W.length][W.length];
		// 多次利用dijkstra算法
		for (int i = 0; i < W.length; i++) {
			for (int j = i + 1; j < W.length; j++) {
				SPM[i][j] = dijkstra(W, i, j);
				SPM[j][i] = SPM[i][j];
			}
		}
		return SPM;
	}

	public static void main(String[] args) {
		/* 顶点集：V={v1,v2,……，vn} */
		int[][] W = { { 0, 1, 3, 4 }, { 1, 0, 2, -1 }, { 3, 2, 0, 5 },
				{ 4, -1, 5, 0 } };
		int[][] W1 = { { 0, 1, 4, -1, -1, -1 }, { 1, 0, 2, 7, 5, -1 },
				{ 4, 2, 0, -1, 1, -1 }, { -1, 7, -1, 0, 3, 2 },
				{ -1, 5, 1, 3, 0, 6 }, { -1, -1, -1, 2, 6, 0 } };// 建立一个权值矩阵
		int[][] D = getShortestPathMatrix(W1);
		// 输出最后的结果
		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D[i].length; j++) {
				System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}
	}
}