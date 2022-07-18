package week2.July19th;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/19
 * @Problem : 보물 : https://www.acmicpc.net/problem/1026
 */

public class Main {
    // ArrayA, B를 모두 정렬할 수 있다면, 더 쉽게 풀 수 있음.
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrayA = getArray(br, N);
        int[] arrayB =  getArray(br, N);

        Arrays.sort(arrayA);
        int[] indexArray = new int[N];
        int[] checkArray = arrayB.clone();

        // 인덱스를 기반으로하는 Array를 추가하여, 이를 정렬하는 방식으로 해결
        for (int i = 0; i < N; i++) {
            int tempMaxIndex = 0;
            for (int j = 0; j < N; j++) {
                tempMaxIndex = checkArray[tempMaxIndex] > checkArray[j]? tempMaxIndex : j;
            }
            checkArray[tempMaxIndex] = -1;
            indexArray[i] = tempMaxIndex;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += arrayB[indexArray[i]] * arrayA[i];
        }

        System.out.println(answer);
    }

    private static int[] getArray(BufferedReader br, int N) throws IOException {
        int[] array = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        return array;
    }
}
