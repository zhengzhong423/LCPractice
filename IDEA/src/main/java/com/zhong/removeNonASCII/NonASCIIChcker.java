package com.zhong.removeNonASCII;

public class NonASCIIChcker {
    public static void main(String[] args) {
        String emojiStr = "abc\r\nbb   b" + (char) 10 + (char) 13 + "ss   s";
        String resultString = emojiStr.replaceAll("[^\\x00-\\x7F]|\\r|\\n|\\s", "");
        System.out.println(resultString);
    }
}
