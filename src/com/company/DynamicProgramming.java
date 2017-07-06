package com.company;

/**
 * Created by sunbinqiang on 06/07/2017.
 */
public class DynamicProgramming {
    /**
     * 分治算法 复杂度： O（2^N)
     * @param n
     * @return
     */
    public static int count = 0;
    public int fib(int n) {
        count ++;
        if (n <=2) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public long fibDp(int n) {
        if (n <= 0) return 0;
        long[] fib = new long[2];
        //初始状态
        fib[0] = fib[1] = 1;
        //递推
        int j = n-1;
        for (int i = 3; i < n + 1; i ++) {
            j = i % 2;
            fib[j] = fib[0] + fib[1];
        }
        return fib[j];
    }


    public static void test(int n) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        long start = System.currentTimeMillis();
        System.out.println(dynamicProgramming.fibDp(n));
        System.out.println("time: " + (System.currentTimeMillis() - start));
//        start = System.currentTimeMillis();
        //System.out.println(dynamicProgramming.fib(n));
//        System.out.println(System.currentTimeMillis() - start);
        //System.out.println(count);
    }

}
