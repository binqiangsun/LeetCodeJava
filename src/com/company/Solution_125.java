package com.company;

/**
 * Created by sunbinqiang on 12/05/2017.
 * 判断一个字符串是否回文字符串，不区分大小写， 只判断数字和字母
 */
public class Solution_125 {

    public static boolean isValidPalindrome(String s) {
        int len = s.length();
        for (int i = 0, j = len - 1; i < len && j > 0; ) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i))
                    != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
