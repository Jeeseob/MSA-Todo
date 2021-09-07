package study;

import java.util.*;

public class ScannerEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        String input = scanner.nextLine(); // input에 입력받은 값 저장
        int num = Integer.parseInt(input); // input 값을 int형으로 변환하여 num에 저장

        System.out.println(num);
        System.out.println("입력내용 : " + num); // String + 다른 type변수 = String 이라는 점을 활용한 것
        System.out.printf("num = %d%n", num); // 데이터 값을 변환하기 위해서는 printf를 사용해야함(ex. double형의 소수점 아래 값 수)

    }
}
