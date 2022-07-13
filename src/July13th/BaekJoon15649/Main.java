package July13th.BaekJoon15649;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/13
 * @Problem : N과 M(1) : https://www.acmicpc.net/problem/15651
 */

public class Main {
    private static boolean[] visited;
    private static int[] answer;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 정답처리용 Array
        answer = new int[M];

        // 방문체크용 Array 초기화
        visited = new boolean[N+1];
        Arrays.fill(visited,false);

        dfs(0);
    }
    public static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int temp : answer) {
                System.out.print(temp + " ");
            }
            System.out.println();
            return;
        }

        // 방문한적 없는 index 중 가장 먼저 처리
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                dfs(depth + 1);

                visited[i] = false; // 다음 연산을 위해 초기화
            }
        }
    }
}
