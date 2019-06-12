package com.yuanqi.service.practice;

import com.yuanqi.service.practice.single.SinglePatternLazy;

/**
 * @Author: yq
 * @Date：2019/6/6 14:13
 * @Describe:
 */
class RunnableDemo implements Runnable {

    public String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 400; i++) {
                System.out.println("Thread" + name + " : " + SinglePatternLazy.getInstance());
                Thread.sleep(50);
            }
        } catch (Exception e) {}
    }

    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo("t1");
        Thread t1 = new Thread(R1);
        t1.start();

        RunnableDemo R2 = new RunnableDemo("t2");
        Thread t2 = new Thread(R2);
        t2.start();
    }
}




