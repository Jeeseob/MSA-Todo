package week3.July25th;

import java.io.*;
import java.util.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/24
 * @Problem : 체스판 다시 칠하기 : https://www.acmicpc.net/problem/1018
 */

public class Main {

    private static char[][] inputBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        inputBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                inputBoard[i][j] = row.charAt(j);
            }
        }

        int result = 64;
        for (int i = 0; i < N; i++) {
            if (!(N - i < 8)) {
                for (int j = 0; j < M; j++) {
                    if (!(M - j < 8)) {
                        int tmpMin = changeColor(i, j);
                        result = Math.min(tmpMin, result);
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static int changeColor(int row, int column) {
        char first = inputBoard[row][column];
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0) {
                    // 색깔이 같아야 하는 경우
                    if(inputBoard[i + row][j + column] != first) {
                        count++;
                    }
                } else {
                    // 색깔이 달라야 하는 경우
                    if(inputBoard[i + row][j + column] == first) {
                        count++;
                    }
                }
            }
        }
        count = Math.min(count, 64-count);
        return count;
    }
}