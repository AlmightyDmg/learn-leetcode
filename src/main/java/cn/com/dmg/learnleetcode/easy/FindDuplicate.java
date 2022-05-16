package cn.com.dmg.learnleetcode.easy;

import java.util.Arrays;

/**
 * @ClassName FindDuplicate
 * @Description 力扣 287
 * @author zhum
 * @date 2022/5/16 16:05
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(findDuplicate1(nums));

    }

    /**
     * 数组不能被修改 所以该方法不可以
     * @author zhum
     * @date 2022/5/16 14:38
     * @param nums
     * @return int
     */
    @Deprecated
    public static int findDuplicate1(int[] nums) {

        //1.首先对数组进行排序
        Arrays.sort(nums);

        //2.循环数组，同时查看【当前数】和【当前数的下一个】 判断是否相等，相等则直接返回

        for (int i = 0; i < nums.length -1 ; i++) {
            int current = nums[i];
            int next = nums[i+1];
            if(current == next){
                return current;
            }
        }

        return -1;

    }


    /**
     * 快慢指针法  时间复杂度O(n) 空间复杂度O(1)
     * @author zhum
     * @date 2022/5/16 15:46
     * @param nums
     * @return int
     */
    public static int findDuplicate2(int[] nums) {
        //定义快慢指针
        int fast = 0,low = 0;
        //第一阶段：寻找链表中的环
        do {
            //快指针一次两步 慢指针一次一步
            fast = nums[nums[fast]];
            low = nums[low];
        } while (fast != low);

        //第二阶段：寻找还在链表上的入口
        int ptr1 = 0,ptr2 = low;
        while (ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }




}
