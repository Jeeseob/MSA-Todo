package week2.July21th;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/15
 * @Problem : 상자넣기 : https://www.acmicpc.net/problem/1965
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] boxes = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] numbers = new int[N];
        Arrays.fill(numbers, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i] && numbers[j] >=  numbers[i]) {
                    numbers[i] = numbers[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(numbers).max().orElse(1));
    }
}
