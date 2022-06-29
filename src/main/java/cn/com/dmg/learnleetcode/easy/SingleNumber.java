package cn.com.dmg.learnleetcode.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName SingleNumber 136 只出现一次的数  https://leetcode.cn/problems/single-number/
 * @Description
 * @author zhum
 * @date 2022/6/28 16:55
 */
public class SingleNumber {


    public static void main(String[] args) {
        int[] nums = {4,4,3,1,2,1,2};
        System.out.println(singleNumber1(nums));

    }

    public static int singleNumber1(int[] nums) {
        /*

            遍历数组，引入数据结构set 遍历数组 如果值n包含则在set中，则在set中删除，最后剩下的则为想要的值
            @author zhum
            @date 2022/6/28 16:56
         */
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)){
                set.remove(num);
                continue;
            }
            set.add(num);
        }

        int result = 0;
        Iterator<Integer> iterator = set.iterator();
        if(iterator.hasNext()){
            result = iterator.next();
        }

        return result;
    }

    public static int singleNumber2(int[] nums) {
        /*
            异或运算
            1.任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
            2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0
            3.异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
            @author zhum
            @date 2022/6/28 17:12
         */
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }



}
