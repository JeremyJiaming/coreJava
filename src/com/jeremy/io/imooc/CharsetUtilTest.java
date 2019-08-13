package com.jeremy.io.imooc;

import java.io.File;

public class CharsetUtilTest {
    public static void main(String[] args) {
        System.out.println(CharsetUtil.getFilecharset(new File("D:\\迅雷下载\\idea快捷键.txt")));
        System.out.println(CharsetUtil.getFilecharset(new File("D:\\迅雷下载\\idea快捷键1.txt")));
    }
}
