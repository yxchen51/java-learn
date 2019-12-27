package com.yxchen51.learn.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * 翻转一个整数，当翻转之后溢出的返回0
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ForBackInteger {


    /**
     * 结题思路:
     * 1、先判断特殊情况，x∈(-9,9)返回x本身;
     * 2、将该整数进行翻转，并用long型接受
     * 3、判断结果是否∈(0x8000000,0x7fffffff),不是则返回0
     * 总结：
     * 遇到问题时先理清思路，判断出题要点，然后再寻找解决方案
     * 执行用时 :1 ms > 100%
     * 内存消耗 :33.5 MB > 81.62%
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }
        int temp = x;
        long dao = 0;//这里很重要，使用long接受应对int类型溢出
        while (temp != 0) {
            int d = temp % 10;
            dao = dao * 10 + d;
            temp = temp / 10;
        }
        return (dao < 0x80000000 || dao > 0x7fffffff) ? 0 : (int) dao;
    }
}
