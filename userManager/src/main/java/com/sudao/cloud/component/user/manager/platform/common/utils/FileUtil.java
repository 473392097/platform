package com.sudao.cloud.component.user.manager.platform.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;


/**
 * Created by Administrator on 2017/7/4.
 */
public class FileUtil {

    /**
     * 判断文件是否为图片
     * @param filename
     * @return
     */
    public static boolean isPicture(String filename) {
        if (StringUtils.isBlank(filename)) {
            return false;
        }
        // 获得文件后缀名
        //String tmpName = getExtend(filename);
        String tmpName = filename;
        // 声明图片后缀名数组
        String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" },
                { "gif", "2" }, { "jfif", "3" }, { "jpe", "4" },
                { "jpeg", "5" }, { "jpg", "6" }, { "png", "7" },
                { "tif", "8" }, { "tiff", "9" }, { "ico", "10" } };
        // 遍历名称数组
        for (int i = 0; i < imgeArray.length; i++) {
            // 判断单个类型文件的场合
            if (imgeArray[i][0].equals(tmpName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除指定的文件
     * @param strFileName
     * @return
     */
    public static boolean delete(String strFileName) {
        File fileDelete = new File(strFileName);
        if (!fileDelete.exists() || !fileDelete.isFile()) {
            return false;
        }
        return fileDelete.delete();
    }

    /**
     * 创建目录
     *
     * @param destDirName
     *            目标目录名
     * @return 目录创建成功返回true，否则返回false
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (dir.mkdirs()) {
            return true;
        } else {
            return false;
        }
    }
}
