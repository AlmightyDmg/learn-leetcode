package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName MoveZeroes 283 移动零 https://leetcode.cn/problems/move-zeroes/
 * @Description
 * @author zhum
 * @date 2022/6/28 17:19
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes1(nums);
        for (int num : nums) {
            System.out.print(num);
        }

    }

    public static void moveZeroes1(int[] nums) {
        /*
            假如移动零的话，会导致移动次数增多，那么换个思路 移动不等于0的数

            当遇到大于零的数的时候，就像数组的前方移动，移动的时候要保持相对位置，
            比如第一个遇到的移动到第一个位置 2到2 3到3

            这种方法和 官方的左右指针如出一辙

            @author zhum
            @date 2022/6/28 17:19
         */

        //记录当前大于零的数应该移动到第几个位置
        int curIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            //获得值
            int num = nums[i];
            if(num != 0){
                int temp = nums[curIdx];
                nums[curIdx] = num;
                nums[i] = temp;
                curIdx ++;
            }
        }

    }

}
