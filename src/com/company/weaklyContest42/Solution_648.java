package com.company.weaklyContest42;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by sunbinqiang on 24/07/2017.
 * 替换单词的字符串
 */
public class Solution_648 {
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder result = new StringBuilder("");
        Queue<String> queue = new PriorityQueue<>();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i ++) {
            String word = words[i];
            int len = Integer.MAX_VALUE;
            for (int j = 0; j < dict.size(); j ++) {
                if (word.startsWith(dict.get(j))) {
                    if (dict.get(j).length() < len) {
                        words[i] = dict.get(j);
                        len = dict.get(j).length();
                    }
                }
            }
        }
        for (String word : words) {
            result.append(word);
            result.append(" ");
        }

        return result.substring(0, result.length()-1);
    }
}
