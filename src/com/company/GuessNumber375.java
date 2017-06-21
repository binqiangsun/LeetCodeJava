package com.company;

/**
 * Created by sunbinqiang on 20/06/2017.
 */
public class GuessNumber375 {
    public int getMoneyAmount(int n) {
        return getMaxAmount(0, 0, n+1);
    }

    public int binarySearch(int a[], int x, int start, int end) {
        if (a[start] > x || a[end] < x) return -1;
        int mid = (start + end) / 2;
        if (a[mid] < x) return binarySearch(a, x, mid, end);
        if (a[mid] > x) return binarySearch(a, x, start, mid);
        return mid;
    }

    public int getMaxAmount(int amount, int start, int end) {
        if (end - start <= 2) return amount;
        int mid = (start + end) / 2;
        if ((end - start)  > 3) {
            mid = (start + end + 1);
        }
        amount += mid;
        return getMaxAmount(amount, mid, end);
    }
}
