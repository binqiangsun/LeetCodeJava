package com.company.contest45;

/**
 * Created by sunbinqiang on 13/08/2017.
 */
public class Solution1 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i ++) {
            switch (moves.charAt(i)) {
                case 'L' :
                    x -= 1;
                    break;
                case 'R' :
                    x += 1;
                    break;
                case 'U':
                    y -= 1;
                    break;
                case 'D':
                    y += 1;
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        } else {
            return false;
        }

    }
}
