package cn.com.dmg.learnleetcode.difficult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2},nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //合并数组
        int[] all = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,all,0,nums1.length);
        System.arraycopy(nums2,0,all,nums1.length,nums2.length);
        Arrays.sort(all);

        if(all.length % 2 == 0){
            double n1 = all[all.length /2 -1];
            double n2 = all[all.length / 2];
            return (n1 + n2)/2;
        } else {
            return all[all.length/2];
        }
    }
}
