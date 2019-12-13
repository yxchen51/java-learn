package com.yxchen51.learn.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组和一个两数之和target
 * 当数组中有两数之和为给定的target
 * 则输出两数的数组下标
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class FindIndexOfSum {


    /**
     * 目前最优解，解决思路：
     * 建立数组的Hash表，用空间换时间,一次for循环结束
     * 执行时间：4 ms
     * 内存消耗：36.5 MB
     * @param nums
     * @param target
     * @return
     */
    public int[] findIndexOne(int[] nums, int target) {
        int[] res = new int[2];
        //建立数字值为Key,index为value的hash表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int less = target - nums[i];
            if (map.containsKey(less)) {
                res[0] = i;
                res[1] = map.get(less);
            }
            map.put(nums[i], i);
        }
        return res;
    }


    /**
     * 普通解:暴力for循环使用
     * 使用2次for循环
     * 执行时间：39 ms
     * 内存消耗：36.5 MB
     * @param nums
     * @param target
     * @return
     */
    public int[] findIndexTwo(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }




}
