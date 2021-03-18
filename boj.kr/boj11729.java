package boj;

import java.util.Scanner;

public class boj11729 {
    public static void main(String[] args){
        //하노이 탑 이동순서
        //boj.kr/11729
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        func(1, 3, k);

        sc.close();

    }

    static void func(Integer a  , int b , int n){
        if(n == 1){
            System.out.println(a + " "+ b);
            return;
        }
        func(a,6-a-b, n-1);
        System.out.println(a + " "+ b);
        func(6-a-b, b, n-1);
    }
}

