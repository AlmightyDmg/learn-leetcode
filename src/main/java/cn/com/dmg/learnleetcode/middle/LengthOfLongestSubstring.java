package cn.com.dmg.learnleetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LengthOfLongestSubstring
 * @Description 3. 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author zhum
 * @date 2022/8/9 9:32
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        /*
            滑动窗口

            abcabcbb
            1.设置两个指针（起始位置为0，0），分别表示子串的左右边界
            2.右指针像又移动一位，判断新指向的字节在子串中是否存在
                存在：
                    不移动，并记录下之前子串的长度，则为以k为起点，无重复子串的长度 记录下长度
                    本次查询结束，将 左指针向右移动一位，重复之前的步骤
                不存在：
                    指针向右移动

            3.所有节点遍历完毕之后，返回最大长度

            使用hashset存储子串的字节 左指针向右-字节  右指针向右+字节
            @author zhum
            @date 2022/8/9 9:32
         */
        if(s.length()==0){
            return 0;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        //子串的最大长度
        int maxLength = 1;
        //存储子串的set
        Set<Character> set = new HashSet<>();
        //起始的时候放入第一个字节
        set.add(chars[0]);
        while (left < chars.length){
            //右指针向右移动 不存在
            if(right+1 < chars.length && set.add(chars[right+1])){
                right++;
            } else {
                //存在
                if(set.size() > maxLength){
                    maxLength = set.size();
                }
                set.remove(chars[left]);
                left ++;
            }
        }
        return maxLength;
    }
}
