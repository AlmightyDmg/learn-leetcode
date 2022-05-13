package cn.com.dmg.learnleetcode.middle;

/**
 * @ClassName RotateImage
 * @Description 力扣48
 * @author zhum
 * @date 2022/5/13 14:57
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate1(nums);

        for (int[] num : nums) {
            for (int i : num) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

    /**
     * 数学方法 时间复杂度O(n^2) 空间复杂度O(1)
     * @author zhum
     * @date 2022/5/13 14:57
     * @param matrix
     * @return void
     */
    public static void rotate1(int[][] matrix) {

        /*
            1.先进行矩阵的置换（行变为列）变换为 以左上到右下的对角线为轴进行替换
            1 4 7
            2 5 8
            3 6 9

            @author zhum
            @date 2022/5/13 15:00
         */
        int length = matrix.length;
        //行
        for (int i = 0; i < length; i++) {
            //列
            for (int j = i + 1; j < length; j++) {
                //进行替换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        /*
            2.再将置换后的矩阵 以中间列为轴，进行元素的互换 变换为
            7 4 1
            8 5 2
            9 6 3
            @author zhum
            @date 2022/5/13 15:00
         */
        //行
        for (int i = 0; i < length; i++) {
            //列
            for (int j = 0; j < length/2; j++) {
                //进行替换
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }
}
