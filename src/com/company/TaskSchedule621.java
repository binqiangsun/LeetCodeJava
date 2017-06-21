package com.company;

/**
 * Created by sunbinqiang on 19/06/2017.
 */
public class TaskSchedule621 {
    public int leastInterval(char[] tasks, int n) {
        int[] charList = new int[26];
        for (int i = 0; i < 26; i ++) {
            charList[i] = 0;
        }
        for (char a : tasks) {
            int index = a - 'A';
            charList[index] ++;
        }

        return 0;

    }
}
