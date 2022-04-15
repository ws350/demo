package com.example.leecode;

/**
 * @Description  反转int
 * @Author: vansn
 * @Date: 2021/11/16 下午5:07
 */
public class ReverseInt {

    public static void main(String[] args) {
        int num = 1234567;
        System.out.println(solution(num));

    }

    public static int solution(int num){
        int res = 0;
        while(num != 0){
            int digit =  num % 10;
            res = res * 10 + digit;
            num = num / 10;
        }

        return res;

    }
}
