package com.zhong.innerClassCaller;

public class OuterClass {
    private String slogan;

    public class InnerClass {
        private String innerSlogan;
        public void outputSlogan() throws InterruptedException {
            System.out.println("slogan: " + slogan);
            Thread.sleep(1000 * 5);
            System.out.println("innerSlogan: " + innerSlogan);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new OuterClass().new InnerClass().outputSlogan();
    }

}
