package cn.com.dmg.learnleetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 力扣算法31题 三数之和
 * @author zhum
 */
public class ThreeSum {
    public static void main(String[] args) {

        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(threeSum3(input));


    }

    /**
     * 方法一：暴力法
     * @author zhum
     * @date 2022/5/12 10:19
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            for (int j = i+1; j < length - 1; j++) {
                for (int k = j+1; k < length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }

        //这里没有进行去重
        return result;
    }

    /**
     * 使用哈希表保存结果
     * @author zhum
     * @date 2022/5/12 11:12
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            for (int j = i+1; j < length - 1; j++) {
                for (int k = j+1; k < length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }

        //这里没有进行去重
        return result;
    }


    /**
     * 方法三 双指针法
     * @author zhum
     * @date 2022/5/12 11:12
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        //先对数组进行排序
        Arrays.sort(nums);
        //循环数组 获得的值作为标准数
        for (int i = 0; i < length; i++) {
            //因为目标和 为0 而数组是经过排序的，因此 标准值右边的数都比标准值大，因此当标准值大于0的时候循环应当终止
            if(nums[i] > 0){
                break;
            }
            //当当前标准值和上一个值相同的时候，该次可以跳过 不进行比较
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            //定义两个指针 全都在标准值右侧
            int lp = i+1;
            int rp = length-1;
            //当左指针小于右指针的时候进行比对
            while (lp < rp){
                int sum = nums[i] + nums[lp] + nums[rp];
                //判断三数相加的结果
                if(sum == 0){
                    //当三个数相加=0的时候，将结果加入result 并将左指针右移 右指针左移
                    result.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    lp ++;
                    rp --;
                    //此时还需要判断 如果新移动的值和之前的值相同，则也跳过 继续进行移动
                    while (lp < rp && nums[lp] == nums[lp - 1]){
                        lp ++;
                    }
                    while (lp < rp && nums[rp] == nums[rp + 1]){
                        rp --;
                    }
                } else if (sum < 0){
                    //当和小于0的时候 左指针右移
                    lp ++;
                } else {
                    //当和大于0的时候 右指针左移
                    rp --;
                }
            }
        }

        //这里没有进行去重
        return result;
    }
}
