package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName Fib
 * @Description 509. 斐波那契数 https://leetcode.cn/problems/fibonacci-number/
 * @author zhum
 * @date 2022/8/4 10:58
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(4));


    }

    public static int fib(int n) {

        if(n == 0 || n == 1){
            return n;
        }

        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
