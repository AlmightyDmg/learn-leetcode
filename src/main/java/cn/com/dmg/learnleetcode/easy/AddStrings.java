package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName AddStrings 力扣415 字符串相加
 * @Description
 * @author zhum
 * @date 2022/5/17 14:00
 */
public class AddStrings {
    public static void main(String[] args) {

    }

    /**
     * 方法一
     * @author zhum
     * @date 2022/5/17 14:09
     * @param num1
     * @param num2
     * @return java.lang.String
     */
    public static String addStrings(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        //从每个数组的个位数开始遍历
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        //保存进位的数字
        int carry = 0;
        //当i大于等于0 或者j大于等于0或者还存在进位的时候就需要进行遍历
        while (i >= 0 || j >= 0 || carry > 0 ){
            //数组1的对应的数字 需要判断i是否大于等于0 如果不是则取0 还需要将取出的 char 类型数字转换为 数字 一般用 -'0'
            int x = i >=0 ? num1.charAt(i) - '0' : 0;
            int y = j >=0 ? num2.charAt(j) - '0' : 0;
            //求和 求和的时候需要加上上进位
            int sum = x + y + carry;
            //求出该位要保存的数字
            result.append(sum % 10);
            //求出新的carry
            carry = sum / 10;

            i--;
            j--;
        }
        //将结果反转 然后返回
        return result.reverse().toString();
    }
}
