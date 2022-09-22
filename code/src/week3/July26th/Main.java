package week3.July26th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/24
 * @Problem : 덩치 : https://www.acmicpc.net/problem/7568
 */

public class Main {

    private static char[][] inputBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(stringTokenizer.nextToken());
            height[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (height[i] < height[j] && weight[i] < weight[j]) {
                    rank[i]++;
                }
            }
        }
        Arrays.stream(rank).forEach(i-> System.out.print(i + " "));
    }
}