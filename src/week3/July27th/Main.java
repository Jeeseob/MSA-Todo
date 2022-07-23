package week3.July25th;

import java.io.*;
import java.util.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/21
 * @Problem : 수 이어가기 : https://www.acmicpc.net/problem/2635
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> maxNumbers = new ArrayList<>();
        int maxCount = 0;

        for (int i = N; i >= N/2; i--) {
            ArrayList<Integer> tempNumbers = new ArrayList<>();
            tempNumbers.add(N);
            tempNumbers.add(i);

            while (true) {
                int temp = tempNumbers.get(tempNumbers.size()-2) - tempNumbers.get(tempNumbers.size()-1);
                if (temp < 0) break;
                tempNumbers.add(temp);
            }

            if (maxCount < tempNumbers.size()) {
                maxCount = tempNumbers.size();
                maxNumbers = tempNumbers;
            }
        }

        System.out.println(maxCount);
        maxNumbers.forEach(i -> System.out.print(i + " "));
    }
}
