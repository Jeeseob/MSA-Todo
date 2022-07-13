package July13th.Baek15654;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/13
 * @Problem : N과 M(7) : https://www.acmicpc.net/problem/15655
 */

public class Main {
    private static int[] answer;
    private static int[] numbers;
    private static int N;
    private static int M;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        // 데이터 입력받아 정리
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 받은 데이터를 정렬하여 처리
        Arrays.sort(numbers);

        // 정답처리용 Array
        answer = new int[M];

        stringBuilder = new StringBuilder();
        dfs(0);
        System.out.println(stringBuilder.toString());
    }
    public static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int temp : answer) {
                stringBuilder.append(temp).append(" ");
            }
            stringBuilder.append('\n');
            return;
        }

        // 방문한적 없는 index 중 가장 먼저 처리
        for (int i = 0; i < N; i++) {
            answer[depth] = numbers[i];
            dfs(depth + 1);
        }
    }
}
