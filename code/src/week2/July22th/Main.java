package week2.July22th;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/21
 * @Problem : 나이트의 이동 : https://www.acmicpc.net/problem/7562
 */


class Point {
    private int xPos;
    private int yPos;
    private int count;

    public Point(int xPos, int yPos, int count) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.count = count;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    private static int[] xPlus = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
    private static int[] yPlus = new int[]{1, -1, 1, -1, 2, -2, 2, -2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            Point startPoint = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), 0);
            stringTokenizer = new StringTokenizer(br.readLine());
            Point endPoint = new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), 0);



            Queue<Point> pointQueue = new LinkedList<>();
            pointQueue.add(startPoint);

            boolean[][] visited = new boolean[length][length];
            for (boolean[] visit : visited) {
                Arrays.fill(visit, false);
            }

            int answer = 0;
            while (!pointQueue.isEmpty()) {
                Point tempPoint = pointQueue.poll();
                int tempXPos = tempPoint.getxPos();
                int tempYPos = tempPoint.getyPos();

                if (visited[tempXPos][tempYPos]) {
                    continue;
                }
                visited[tempXPos][tempYPos] = true;

                if (tempXPos == endPoint.getxPos() && tempYPos == endPoint.getyPos()) {
                    answer = tempPoint.getCount();
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nextXPos = tempXPos + xPlus[j];
                    int nextYPos = tempYPos + yPlus[j];
                    if (0 <= nextXPos && nextXPos < length && 0 <= nextYPos && nextYPos < length) {
                        pointQueue.add(new Point(nextXPos, nextYPos, tempPoint.getCount() + 1));
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
