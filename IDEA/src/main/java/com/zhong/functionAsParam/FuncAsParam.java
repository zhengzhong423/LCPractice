package com.zhong.functionAsParam;

import java.util.function.Function;
import java.util.stream.IntStream;

public class FuncAsParam {
    public static void main(String[] args) {
        FuncAsParam func = new FuncAsParam();
        func.retries(5, s -> Integer.parseInt(s) + 100, "2");
    }

    private void retries(int times, Function<String, Integer> func, String input) {
        IntStream.range(0, times).forEach(e -> System.out.println(func.apply(input)));
    }
}
