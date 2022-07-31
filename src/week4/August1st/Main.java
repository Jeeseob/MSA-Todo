package week4.August1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/01
 * @Problem : DFS와 BFS : https://www.acmicpc.net/problem/1260
 */

public class Main {

    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[][] arr;
    private static boolean[] visited;
    private static int node, line, start;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(str.nextToken());
            int node2 = Integer.parseInt(str.nextToken());
            arr[node1][node2] = 1;
            arr[node2][node1] = 1;
        }

        visited = new boolean[node + 1];

        Arrays.fill(visited, false);
        dfs(start);

        stringBuilder.append("\n");
        Arrays.fill(visited, false);
        bfs();

        System.out.println(stringBuilder);
    }

    public static void dfs(int temp) {
        if (visited[temp]) return;

        visited[temp] = true;
        stringBuilder.append(temp).append(" ");

        for (int i = 0; i <= node; i++) {
            if (arr[temp][i] == 1)
                dfs(i);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);
        queue.add(start);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (visited[temp]) continue;
            visited[temp] = true;
            stringBuilder.append(temp).append(" ");

            for (int i = 1; i <= node; i++) {
                if (arr[temp][i] == 1) {
                    queue.add(i);
                }
            }
        }
    }
}
