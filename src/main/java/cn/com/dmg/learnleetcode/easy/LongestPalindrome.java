package cn.com.dmg.learnleetcode.easy;

import java.util.*;

/**
 * @ClassName LongestPalindrome
 * @Description 409. 最长回文串 https://leetcode.cn/problems/longest-palindrome/
 * @author zhum
 * @date 2022/8/2 14:55
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));

    }
    public static int longestPalindrome(String s) {

        /*
            1.创建一个map<Character,Integer> 用于存放字节和他出现的次数
            2.遍历字符串 记录每个字节出现的次数
            3.遍历map 当一个字节出现的次数是
                偶数的时候 那么他一定能够成为回文字符串的一部分
                奇数的时候 则当前奇数-1能够作为回文字符串的一部分
                如果整个字符串中存在出现奇数次数的字节，则需要在最后的结果上+1 因为回文字符串可以是奇数
            @author zhum
            @date 2022/8/2 14:55
         */
        if(s.length() == 1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(map.containsKey(aChar)){
                Integer integer = map.get(aChar);
                integer++;
                map.put(aChar,integer);
            } else {
                map.put(aChar,1);
            }
        }
        int resultLength = 0;
        boolean hasOddNum = false;
        //遍历
        Set<Character> keySet = map.keySet();
        Iterator<Character> iterator = keySet.iterator();
        while (iterator.hasNext()){
            Character key = iterator.next();
            Integer value = map.get(key);
            //偶数
            if(value % 2 == 0){
                resultLength += value;
            } else {
                resultLength += (value -1);
                hasOddNum = true;
            }
        }

        if(hasOddNum){
            resultLength++;
        }
        return resultLength;
    }
}
