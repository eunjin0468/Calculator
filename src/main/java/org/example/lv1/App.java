package org.example.lv1;

import org.example.lv2.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

//사용자 입력, while 반복, Calculator 호출
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        boolean exit = false;

        while (!exit) {
            try {
                //양의 정수(0 포함) 입력받기
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double a = sc.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double b = sc.nextDouble();

                //사칙연산 기호 입력받기
                System.out.print("사칙연산 기호를 입력하세요 (+,-,*,/): ");
                char operator = sc.next().charAt(0);

                try{
                    cal.calculate((double) a, (double) b, operator);
                    System.out.println("> 연산 결과 : "+cal.getResultHistory().get(0));
                    cal.removeFirstResult();
                }catch (ArithmeticException e){ //나눗셈 예외 처리
                    System.out.println(e.getMessage());
                }catch (IllegalArgumentException e) { //연산자 예외 처리
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해야 합니다.");
                sc.nextLine();
                continue;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String str = sc.next();

            exit = str.equals("exit");
        }
        sc.close();
    }
}


