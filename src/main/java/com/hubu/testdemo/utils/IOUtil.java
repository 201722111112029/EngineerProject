package com.hubu.testdemo.utils;

import java.io.*;

public class IOUtil {
    private FileOutputStream os = null;
    private FileInputStream is = null;
    private String sourceUrl;
    private String destinationUrl;

    public void saveResource() {
        // 创建一个1M大小的缓冲区
        byte[] buffer = new byte[1024 * 1024];
        try {
            int len = -1;
            os = new FileOutputStream(new File(destinationUrl));
            is = new FileInputStream(new File(sourceUrl));
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, buffer.length);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(os, is);
        }
    }

    public static void releaseResource(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public IOUtil(String sourceUrl,String destinationUrl) {
        this.sourceUrl = sourceUrl;
        this.destinationUrl = destinationUrl;
    }
}
