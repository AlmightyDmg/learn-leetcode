package cn.com.dmg.learnleetcode.middle;

/**
 * @ClassName Multiply
 * @Description 字符串相乘 力扣43
 * @author zhum
 * @date 2022/5/17 14:44
 */
public class Multiply {
    public static void main(String[] args) {

    }

    /**
     * 方法一
     * @author zhum
     * @date 2022/5/17 14:45
     * @param num1
     * @param num2
     * @return java.lang.String
     */
    public static String multiply(String num1, String num2) {
        /*
            基本实现思路
            将一个字符串中的每一位分别去乘以另一个字符串的每一位，将最终相乘的结果相加 得到 字符串的每一位*另一个字符串的结果
            然后再将最后的结果分别相加，得到最终的值

            类似乘法的竖式
            @author zhum
            @date 2022/5/17 14:45
         */
        //特殊情况 当其中一个字符串为"0"的时候直接返回"0"
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        //最终返回的结果
        String result = "0";

        //从字符串num1的个位开始 进行计算
        for (int i = num1.length() - 1; i >= 0; i--) {
            //得到num1的每位数字
            int a = num1.charAt(i) - '0';
            //定义进位
            int carry = 0;
            //定义num1的每一位和num2相乘得到的结果
            StringBuffer currentResult = new StringBuffer();
            //由于在竖式中进行相加的时候，根据num1的位数不同，后面需要进行补0，所以提前加上0
            for(int j = 0;j < num1.length() - 1 - i;j++){
                currentResult.append("0");
            }

            //遍历num2的每一位进行相乘
            for (int j = num2.length() - 1; j >=0 ; j--) {
                //num2的每一位数字
                int x = num2.charAt(j) - '0';
                int product = x * a + carry;
                currentResult.append(product % 10);
                carry = product / 10;
            }

            //当carry不为0的时候 还需要再加上carry
            if (carry != 0) {
                currentResult.append(carry);
            }

            //将所有的结果相加
            result = addStrings(result,currentResult.reverse().toString());

        }

        return result;

    }

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
