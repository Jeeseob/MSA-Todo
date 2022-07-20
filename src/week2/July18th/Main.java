package week2.July18th;

import java.io.*;
import java.util.Stack;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/07/18
 * @Problem : 괄호 : https://www.acmicpc.net/problem/9012
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> vpsStack = new Stack<>();
            String temp = br.readLine();
            boolean answer = true;

            // 입력받은 문자열 만큼 반복
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '(') {
                    vpsStack.push(temp.charAt(j));
                }
                else { // ")"인 경우,
                    // ")"가 들어왔는데 "("가 없는경우, VPS가 아님.
                    if (vpsStack.isEmpty()) {
                        answer = false;
                        break;
                    }
                    vpsStack.pop();
                }
            }

            // 답 출력
            // 모든 문자열을 돌았는데 "("가 남는 경우, VPS가 아님.
            if (answer && vpsStack.isEmpty()) {
                bw.write("YES" + '\n');
            }
            else {
                bw.write("NO" + '\n');
            }
        }

        bw.flush();
        bw.close();
    }
}