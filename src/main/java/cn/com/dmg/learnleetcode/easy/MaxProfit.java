package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName MaxProfit 121买卖股票的最佳时机
 * @Description
 * @author zhum
 * @date 2022/6/29 11:13
 */
public class MaxProfit {
    public static void main(String[] args) {

        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        /*
            1.进行双重循环遍历
                第一次循环 选取买入的一天的价格（最多n-1天买入）
                第二次循环 选取卖出的一天的价格(买入的后边天数才能卖出)
            @author zhum
            @date 2022/8/2 14:33
         */
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }

        return  maxProfit ;
    }
}
