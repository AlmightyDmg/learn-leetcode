package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName LongestCommonPrefix
 * @Description 最长公共前缀
 * @author zhum
 * @date 2022/8/9 10:18
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {" "," "," "};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        /*
            1.以第一个字符串为基准，遍历剩余的字符串数组
            2.定义一个指针，遍历基准字符串，然后查看其余字符串的相应位置是否为该字节
                是：继续往下遍历
                否：结束遍历 返回最长公共前缀
            @author zhum
            @date 2022/8/9 10:19
         */
        String baseStr = strs[0];
        if(strs.length == 1){
            return baseStr;
        }

        int index = 0;
        while (index < baseStr.length()){
            char c = baseStr.charAt(index);
            //是否全部匹配
            boolean b = true;
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if(index > str.length() -1 ||c != str.charAt(index)){
                    b = false;
                    break;
                }
            }
            if(!b){
                break;
            }
            index ++;
        }

        if(index==0){
            return "";
        } else {
            return baseStr.substring(0,index);
        }
    }
}
