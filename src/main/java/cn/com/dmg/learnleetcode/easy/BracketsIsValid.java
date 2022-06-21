package cn.com.dmg.learnleetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName BracketsIsValid
 * @Description 力扣 https://leetcode.cn/problems/valid-parentheses/ 判断括号是否有效
 * @author zhum
 * @date 2022/6/20 16:17
 */
public class BracketsIsValid {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));

    }

    /**
     * @author zhum
     * @date 2022/6/20 16:40
     * @param s
     * @return boolean
     */
    public static boolean isValid(String s) {
        /*
            思路：根据题目意思，是要紧邻的两个元素为同一类型的左右括号
            那么可以使用 滑动窗口（每次滑动两个单元） 判断相邻的两个是否是同一类型
            只要发现不是同一类型，就返回 false
            @author zhum
            @date 2022/6/20 16:18

            运行结果不正确 {[]} 应该是true 我返回的是 false

            看评论 有一个说用 栈，很好的解决了题意的问题 也能很好的写出代码
         */
        int length = s.length();
        int start = 0;

        while (start <= length-2){
            //获得 start 位置的字节
            char startChar = s.charAt(start);
            //获得 start 位置下一个位置的字节
            char endChar = s.charAt(start + 1);
            //如果 两个能够合并 则合规
            switch (startChar){
                case '(':
                    if(endChar != ')') {
                        return false;
                    }
                    break;
                case '{':
                    if(endChar != '}') {
                        return false;
                    }
                    break;
                case '[':
                    if(endChar != ']') {
                        return false;
                    }
                    break;
            }
            //start向后移动两位
            start += 2;
        }
        return true;
    }


    public static boolean isValid1(String s){

        //当长度为奇数的时候肯定不合规
        if(s.length() % 2 > 0){
            return false;
        }

        //将左右括号放到 map 中
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        //定义一个栈
        LinkedList<Character> stack = new LinkedList<>();



        return true;
    }

}
