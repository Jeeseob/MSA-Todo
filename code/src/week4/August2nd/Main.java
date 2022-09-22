package week4.August2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/03
 * @Problem : 섬의 개수 : https://www.acmicpc.net/problem/4963
 */

class Point {
    private int xPos;
    private int yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int height;
    private static int width;
    private static int[] xPlus = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    private static int[] yPlus = new int[]{1, -1, -1, 0, 1, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            if (width == 0 && height == 0) {
                break;
            }

            map = new int[height][width];
            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(island(height, width));
        }
    }

    private static int island(int height, int width) {
        int answer = 0;
        visited = new boolean[height][width];
        for (boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i,j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void bfs(int tempHeight, int tempWidth) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(tempHeight, tempWidth));

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            if(visited[temp.getxPos()][temp.getyPos()] || map[temp.getxPos()][temp.getyPos()] == 0) continue;
            visited[temp.getxPos()][temp.getyPos()] = true;

            for (int i = 0; i < 8; i++) {
                int nextXPos = temp.getxPos() + xPlus[i];
                int nextYPos = temp.getyPos() + yPlus[i];
                if (0 <= nextXPos && 0 <= nextYPos && nextXPos < height && nextYPos < width) {
                    queue.add(new Point(nextXPos, nextYPos));
                }
            }
        }
    }
}
