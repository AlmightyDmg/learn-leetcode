package cn.com.dmg.learnleetcode.easy;
/**
 * @ClassName MaxSubArray 力扣 53 最大子数组和 https://leetcode.cn/problems/maximum-subarray/
 * @Description
 * @author zhum
 * @date 2022/6/21 15:59
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {-2,-3,-5};
        System.out.println(maxSubArray2(nums));

    }

    /**
     * 贪心策略
     * @author zhum
     * @date 2022/6/21 15:58
     * @param nums
     * @return int
     */
    public static int maxSubArray1(int[] nums) {
        /*
            思路：
            当
                当前元素前面的列表和小于0的时候，将前面的列表丢弃
                当前元素前面的列表和大于0的时候，与当前节点相加 算出最大值
            @author zhum
            @date 2022/6/21 15:59
         */
        //最大和
        int max = 0;
        //当前节点索引
        int curIndex = 0;
        //前面队列的和
        int subArrSum = 0;
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //当前节点值
            int current = nums[i];
            if(i == 0){
                max = current;
                subArrSum = current;
                continue;
            }

            //如果前面队列的和<0则丢弃 将当前子队列的值设置为当前值
            if(subArrSum < 0){
                subArrSum = current;
            } else {
                subArrSum += current;
            }
            //设置最大值
            if(subArrSum > max){
                max = subArrSum;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @author zhum
     * @date 2022/6/21 17:16
     * @param nums
     * @return int
     */
    public static int maxSubArray2(int[] nums) {
        /*
            思路：
                求出每个节点的最大值
                当前一位是负数的时候不添加
                当前一位为正数的时候添加
            @author zhum
            @date 2022/6/21 17:17
         */
        //最大值 默认为第一位
        int max = nums[0];


        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                continue;
            }
            if(nums[i - 1] > 0){
                //修改当前位置的值
                nums[i] = nums[i-1] + nums[i];
                if(nums[i] > max){
                    max = nums[i];
                }
            }
        }

        return max;
    }


}
