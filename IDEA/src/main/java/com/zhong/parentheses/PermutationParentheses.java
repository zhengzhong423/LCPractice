package com.zhong.parentheses;

import java.util.LinkedList;
import java.util.List;

public class PermutationParentheses {
    public static void main(String[] args) {
        List<String> rs = new LinkedList<>();
        int N = 2;
        new PermutationParentheses().permutationParentheses(N,N, "", rs);
        System.out.println(rs);
    }

    public void permutationParentheses(int l, int r, String cur, List<String> rs) {
        if (l < 0 || r < 0 || l > r) {
            return;
        }

        if (l == 0 && r == 0) {
            rs.add(cur);
        }

        permutationParentheses(l - 1, r, cur + "{", rs);
        permutationParentheses(l, r - 1, cur + "}", rs);

    }
}
