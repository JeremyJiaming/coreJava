package com.jeremy.io.imooc.mc_04;

import java.io.*;

/**
 * 4-1 字节流之文件输入流FileInputStream-1
 * 4-2 字节流之文件输入流FileInputStream-2
 */
public class IOUtil {
    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且没输出10个byte换行
     *
     * @param fileName
     * @throws IOException
     */
    public static void printHex(String fileName) throws IOException {
        //将文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            //单位数前面补零
            if (b <= 0xf)
                System.out.print(0);
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[20 * 1024];
        /*从in中批量读取字节，放入到buf这个字节数组中，
         * 从第0个位置开始放，最多放buf.length个
         * 返回的是读到的字节的个数
         */
/*        int bytes = in.read(buf, 0, buf.length);//一次性读完，说明字节数组足够大
        int j = 1;
        for (int i = 0; i < bytes; i++) {
            //补零
            if (buf[i] <= 0xf)
                System.out.print(0);
            System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
            if (j++ % 10 == 0)
                System.out.println();
        }*/
        int bytes;
        int j = 1;
        while ((bytes = in.read(buf,0,buf.length))!=-1) {
            for (int i = 0; i < bytes; i++) {
                //补零
                if (buf[i] <= 0xf)
                    System.out.print(0);
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                if (j++ % 10 == 0)
                    System.out.println();
            }
        }
    }

    /**
     * 拷贝文件，字节批量读取
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("找不到"+srcFile+"文件！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile+"不是文件！");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        int b;
        byte[] buf=new byte[15*1024];
        while ((b=in.read(buf,0,buf.length))!=-1){
            out.write(buf,0,b);
            out.flush();//最好加上
        }
        in.close();
        out.close();
    }

    /**
     * 拷贝文件，利用带缓冲的字节流
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("找不到"+srcFile+"文件！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile+"不是文件！");
        }

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        int b;

        while ((b=bin.read())!=-1){
            bos.write(b);
            bos.flush();//必须加上
        }
        bin.close();
        bos.close();
    }

    /**
     * 拷贝文件，一个字节一个字节读取
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile,File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("找不到"+srcFile+"文件！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile+"不是文件！");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        int b;
        while ((b=in.read())!=-1){
            out.write(b);
            out.flush();//最好加上
        }
        in.close();
        out.close();
    }
}
