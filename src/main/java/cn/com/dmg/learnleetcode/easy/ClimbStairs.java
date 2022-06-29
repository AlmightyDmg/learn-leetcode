package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName ClimbStairs 爬楼梯 https://leetcode.cn/problems/climbing-stairs/
 * @Description
 * @author zhum
 * @date 2022/6/22 17:05
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));

    }

    /**
     * 动态规划
     * @author zhum
     * @date 2022/6/22 17:05
     * @param n
     * @return int
     */
    public static int climbStairs(int n) {
        /*
            爬到当前节点的时候一共有多少种方式 f(x)
            f(x) = f(x-1) + f(x-2)
            @author zhum
            @date 2022/6/22 17:05
         */
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        //当前台阶
        int current = 3;
        //n-1的时候数量
        int lastOneWay = 2;
        //n-2的时候数量
        int lastTwoWay = 1;
        //当前台阶时的总方法数量
        int currentWay = lastOneWay + lastTwoWay;
        while (current < n){
            current++;
            //n-2 变为 n-1
            lastTwoWay = lastOneWay;
            //n-1 变为 currentWay
            lastOneWay = currentWay;
            //计算当前的数量
            currentWay = lastOneWay + lastTwoWay;
        }
        return currentWay;
    }
}
