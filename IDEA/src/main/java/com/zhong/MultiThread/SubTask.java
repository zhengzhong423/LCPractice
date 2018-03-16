package com.zhong.MultiThread;

import java.util.concurrent.Callable;

public class SubTask implements Callable<String> {

    private int val;

    public SubTask(int j) {
        this.val = j;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return new String("Subtask Job " + val);
    }
}
