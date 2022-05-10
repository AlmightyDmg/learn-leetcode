package cn.com.dmg.learnleetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum 两数之和
 * @Description
 * @author zhum
 * @date 2022/3/11 10:37
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = twoSum(nums, 6);
        System.out.println(ints[0]+","+ints[1]);
    }


    /**
     * 暴力解法 时间复杂度O(n^2) 空间复杂度O(1)
     * @author zhum
     * @date 2022/5/10 11:14
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        /*
            给定一个整数数组 nums 和一个整数目标值 target，
            请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
            你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
            你可以按任意顺序返回答案。

            示例 1：

            输入：nums = [2,7,11,15], target = 9
            输出：[0,1]
            解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

            示例 2：

            输入：nums = [3,2,4], target = 6
            输出：[1,2]

            示例 3：

            输入：nums = [3,3], target = 6
            输出：[0,1]

            提示：

                2 <= nums.length <= 104
                -109 <= nums[i] <= 109
                -109 <= target <= 109
                只会存在一个有效答案

            进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

            来源：力扣（LeetCode）
            链接：https://leetcode-cn.com/problems/two-sum
            著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
            @author zhum
            @date 2022/3/11 10:38
         */
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i+1;j<nums.length;j++){
                if(nums[j] == target-num1){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;

        /*
            执行用时：40 ms, 在所有 Java 提交中击败了43.58% 的用户
            内存消耗：41.8 MB, 在所有 Java 提交中击败了6.75% 的用户

            时间复杂度：O(N^2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。

            空间复杂度：O(1)。

            @author zhum
            @date 2022/3/11 11:14
         */
    }


    /**
     * 哈希表两次遍历 时间复杂度O(n) 通过空间换时间 空间复杂度 O(n)
     * @author zhum
     * @date 2022/5/10 11:15
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum2(int[] nums, int target) {
        //1.遍历数组，将数组的值和值所在的索引存储到map中
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        //2.再次遍历数组，找到另一个匹配的值使用之和为target 并且 当前值不等于map中的key
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }


    /**
     * 哈希表一次遍历 时间复杂度O(n) 空间复杂度 O(n)
     * @author zhum
     * @date 2022/5/10 11:15
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
