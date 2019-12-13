package com.yxchen51.learn.leet;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 */
public class JudgeHuiWen {


    /**
     * 解决思路:
     * 1、先判断特殊情况，x<0返回false，0-9返回true；
     * 2、直接去该整数的倒序数值，如果两数相等返回true，否则返回false；
     * 执行时间：9ms > 98.64%
     * 内存消耗：36.7 MB > 93.23%
     * @param x
     * @return
     */
    public boolean isHuiWen(int x) {
        if (0 <= x && x < 10) {
            return true;
        } else if (x < 0) {
            return false;
        }
        int dao = 0;
        int temp = x;
        while (temp > 0) {//当余数不为0的时候，继续操作
            int d = temp % 10;
            dao = dao * 10 + d;
            temp = temp / 10;
        }
        if (dao == x) {
            return true;
        } else {
            return false;
        }
    }
}
