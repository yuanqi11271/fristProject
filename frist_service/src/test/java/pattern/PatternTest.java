package pattern;

import org.junit.Test;

/**
 * @Author: yq
 * @Date：2019/6/6 10:19
 * @Describe: 模式测试类
 */
public class PatternTest implements Runnable {

    /**
     * 单例模式测试
     */
    @Test
    public void singleTest() {
        PatternTest patternTest = new PatternTest();
        Thread thread = new Thread(patternTest);
        thread.start();

        PatternTest patternTest1 = new PatternTest();
        Thread thread1 = new Thread(patternTest1);
        thread1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Thread: " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
