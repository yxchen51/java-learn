package com.yxchen51.learn.leet;

/**
 * 已知青蛙一次可以跳1步或者2步台阶，求跳到n级台阶上有多少种跳法
 * 思路：
 * 台阶1级=>1
 * 台阶2级=>2
 * 台阶3级=>3
 * 台阶4级=>5
 * 这个时候就能看出来规律了，这是一个斐波拉契数列
 * f(n)=f(n-1)+f(n-2)
 */
public class JumpCount {

    /**
     * 正常逐步求解，从1开始计算下一步
     * 使用for循环
     *
     * @return
     */
    public int jumpCount1(int target) {
        int[] targets = {0, 1, 2};
        if (target == 1 || target == 2) {
            return target;
        }
        /**
         * 数组的值依次前移：{0,1,2}，{1,2,3}，{2,3,5}
         * 数组的第三位永远为 [0]+[1]
         */
        for (int i = 0; i < target; i++) {
            targets[2] = targets[0] + targets[1];
            targets[0] = targets[1];
            targets[1] = targets[2];
        }
        return targets[2];
    }


    /**
     * 从上面分析的规律可以看出来
     * f(n) = f(n-1) + f(n-2)
     * 这样使用递归可以算出最后的步数
     *
     * @param target
     * @return
     */
    public int jumpCount2(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int res = jumpCount2(target - 1) + jumpCount2(target - 2);
        return res;
    }


    /**
     * 变态跳台阶
     * 假如青蛙一次可以跳n级台阶，跳到n级的台阶有多少种跳法
     * 思路：
     * 台阶1级=>1
     * 台阶2级=>2
     * 台阶3级=>4
     * 台阶4级=>8
     * 台阶5级=>16
     * f(n)=f(n-1)+f(n-2)+...+f(1)+1
     * @param target
     * @return
     */
    public int jumpCountPlus(int target){
        if (target == 1 || target == 2) {
            return target;
        }
        int res = 1;
        for (int i=1;i<target;i++){
            res += jumpCountPlus(i);
        }
        return res;
    }

    /**
     * 通过观察可以发现规律
     * f(n)=2^n-1
     * @param target
     * @return
     */
    public int jumpCountPlus2(int target){
        return (int) Math.pow(2,target-1);

    }

    public static void main(String[] args) {
        System.out.println(new JumpCount().jumpCountPlus2(10));
        System.out.println(new JumpCount().jumpCountPlus(10));

    }
}
