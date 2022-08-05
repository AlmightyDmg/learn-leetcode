package cn.com.dmg.learnleetcode.middle;

import java.util.Arrays;

/**
 * @ClassName LargestNumber
 * @Description  79. 最大数 https://leetcode.cn/problems/largest-number/
 * @author zhum
 * @date 2022/8/4 17:41
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {111311,1113};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        /*
            对每个数的最高位进行排序
            @author zhum
            @date 2022/8/4 17:46
         */
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(isSwap(nums[j],nums[j+1])){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        String result = "";
        for (int num : nums) {
            result += num;
        }
        if(result.startsWith("0")){
            result = "0";
        }
        return result;
    }



    public static boolean isSwap(int num1,int num2){
        String s1 = num1 + "" + num2;
        String s2 = num2 + "" + num1;
        int i1 = s1.compareTo(s2);
        if(i1 < 0){
            return true;
        }
        return false;

    }

}
