package com.yuanqi.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:YaoJun
 * Date:2018/12/29
 * Time:15:37
 */
@Slf4j
public class CmdUtil {
    public static boolean run_cmd(String strcmd) {
        //
        Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
        Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
        try {
            ps = rt.exec(strcmd);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            ps.waitFor();  //等待子进程完成再往下执行。
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            log.error("异常."+e.getMessage());
            e.printStackTrace();
            return false;
        }

        int i = ps.exitValue();  //接收执行完毕的返回值
        System.out.println(i);
        ps.destroy();  //销毁子进程
        ps = null;
        if (i == 0) {

            log.error("执行完成."+i);
            return true;

        } else {
            log.error("执行失败."+i);
            return false;
        }


    }
    public static void main(String[] args) {
        String strcmd1 = "cmd /c taskkill /f /im F:/本地服务/本地web化windows服务/terminal-app-win32-ia32/terminal-app.exe";
        String strcmd = "cmd /c net stop YuanTu.Enet.LocalWeb";
        run_cmd(strcmd);

    }



}
