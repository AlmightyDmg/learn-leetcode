package cn.com.dmg.learnleetcode.difficult;

import java.util.Arrays;

/**
 * @ClassName MaxSlidingWindow 力扣 239
 * @Description
 * @author zhum
 * @date 2022/5/31 21:10
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * --------超出时间限制
     * @author zhum
     * @date 2022/5/31 21:34
     * @param nums
     * @param k
     * @return int[]
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //返回的结果
        int size = nums.length - k + 1;
        int[] result = new int[size];
        int resultIndex = 0;
        //窗口起点
        int start = 0;
        //窗口终点
        int end = k-1;
        while (end <= nums.length - 1){
            //取出k个数，进行排序 将最大的数取出放进数组
            int i = start;
            int[] tempArr = new int[k];
            int tempIndex = 0;
            while (i <= end){
                tempArr[tempIndex] = nums[i];
                i++;
                tempIndex++;
            }
            Arrays.sort(tempArr);
            result[resultIndex] = tempArr[k - 1];

            start++;
            end++;
            resultIndex++;
        }
        return result;
    }

}
