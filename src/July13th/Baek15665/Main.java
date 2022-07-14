package July13th.Baek15665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/13
 * @Problem : N과 M(9) : https://www.acmicpc.net/problem/15663
 */

public class Main {
    private static LinkedHashSet<String> answer;
    private static int[] tempAnswer;
    private static int[] numbers;
    private static int N;
    private static int M;

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
        tempAnswer = new int[M];

        // 중복처리용 HashSet
        answer = new LinkedHashSet<>();

        dfs(0);
        answer.forEach(System.out::println);
    }

    public static void dfs(int depth) throws IOException {
        if (depth == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int temp : tempAnswer) {
                stringBuilder.append(temp).append(" ");
            }
            answer.add(stringBuilder.toString());
            return;
        }

        // 방문한적 없는 index 중 가장 먼저 처리
        for (int i = 0; i < N; i++) {
            tempAnswer[depth] = numbers[i];
            dfs(depth + 1);
        }
    }
}