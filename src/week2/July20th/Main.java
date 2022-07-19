package week2.July20th;

import java.io.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/15
 * @Problem : 쉬운 계단  : https://www.acmicpc.net/problem/10844
 */

public class Main {
    private static final int MAX = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][12];

        for (int i = 1; i < 10; i++)
        {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++)
        {
            for (int j = 1; j <= 10 ; j++)
            {
                // 직전 DP 기준 양 옆의 값을 가져올 수 있다.
                // 양끝에 위치한 값은 각각 한쪽에서만 가져올 수 있는데, 어처피 0이라 무시됨
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]);
                dp[i][j] %= MAX;
            }
        }

        // 답 구하기
        int answer = 0;
        for (int i = 1; i <= 10; i++) {
            answer += dp[N - 1][i];
            answer %= MAX;
        }
        System.out.println(answer);
    }
}
