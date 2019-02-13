package com.fz.csgo;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import dm.sdk.DMPlug;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        int anInt = Dispatch.call(DMPlug.com, "Reg", "allen1112b46ddfa453d1dc7615fa8c255df64676", "pToc").getInt();
        if(anInt==-2) {
            JOptionPane.showMessageDialog(null,"请使用管理员权限运行此程序!", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }else if(anInt!=1) {
            System.err.println("Error dm.dll");
            JOptionPane.showMessageDialog(null,"程序初始化失败!", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //获取句柄
        int hwnd = Dispatch.call(DMPlug.com, "FindWindowByProcess", "csgo.exe","", "").getInt();
        System.out.println(hwnd);
//        //获取对应窗口句柄进程下的指定模块的基址
//        long serverClass = Dispatch.call(DMPlug.com, "GetModuleBaseAddr", hwnd, "server.dll").getLong();
//        System.out.println(serverClass);
//        //获取整数
//        //serverClass+hex2decimal("989EBC")
//        long me = Dispatch.call(DMPlug.com, "ReadInt", hwnd, "[<server.dll>+989EBC]", 1).getLong();
//        System.out.println("m="+me);

        //获取自身坐标
//        Float me_x = Dispatch.call(DMPlug.com, "ReadFloat", hwnd, "[<server.dll>+989EBC]+1DC").getFloat();
//        Float me_y = Dispatch.call(DMPlug.com, "ReadFloat", hwnd, "[<server.dll>+989EBC]+1E0").getFloat();
//        Float me_z = Dispatch.call(DMPlug.com, "ReadFloat", hwnd, "[<server.dll>+989EBC]+1E4").getFloat();
//        System.out.println("x="+me_x);
//        System.out.println("y="+me_y);
//        System.out.println("z="+me_z);
        long serverClass = Dispatch.call(DMPlug.com, "GetModuleBaseAddr", hwnd, "client_panorama.dll").getLong();
        System.out.println(serverClass);
//        Float me_x = Dispatch.call(DMPlug.com, "ReadFloat", hwnd, "[<server.dll>+989EBC]+1DC").getFloat();
//        Float me_y = Dispatch.call(DMPlug.com, "ReadFloat", hwnd, "[<server.dll>+989EBC]+1E0").getFloat();
//        Float me_z = Dispatch.call(DMPlug.com, "ReadFloat", hwnd, "[<server.dll>+989EBC]+1E4").getFloat();
//        System.out.println("x="+me_x);
//        System.out.println("y="+me_y);
//        System.out.println("z="+me_z);
    }
    /**
     * 16进制转10进制
     *
     * @param hex
     * @return
     */
    public static int hex2decimal(String hex) {
        return Integer.parseInt(hex, 16);
    }
}
