package com.sudao.cloud.component.user.manager.platform.init;

import org.apache.logging.log4j.core.util.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  sql文件扫描器
 *
 */
public class SqlFileScanner extends BasicScanner {

    private Logger logger = LoggerFactory.getLogger(SqlFileScanner.class);

    private String basePath;

    private ClassLoader cl;

    public SqlFileScanner(String basePath) {
        this.basePath = basePath;
        this.cl = getClass().getClassLoader();

    }

    public SqlFileScanner(String basePath, ClassLoader cl) {
        this.basePath = basePath;
        this.cl = cl;
    }


    @Override
    public List<String> getFullyQualifiedSqlList() throws IOException {
        logger.info("开始扫描{}下的所有sql", basePath);

        return doScan(basePath, new ArrayList<>());
    }


    private List<String> doScan(String basePath, List<String> nameList) throws IOException {

        URL url = Loader.getResource(basePath, cl);
        List<String>  names = readFromDirectory(url.getPath());

        for (String name : names) {
            if (isSqlFile(name)) {
                nameList.add(toReadFromSqlFile(name,url.getPath()));
            } else {
                doScan(basePath + "/" + name, nameList);
            }
        }

        if (logger.isDebugEnabled()) {
            for (String n : nameList) {
                 logger.debug("找到{}", n);
            }
        }

        return nameList;
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * @param sqlFileName
     * @param filePath
     * @return
     */
    private String toReadFromSqlFile(String sqlFileName , String filePath) {

            File file = new File(eliminateSlash(filePath) + sqlFileName);
            BufferedReader reader = null;
            StringBuffer sb = null ;
            try {
                reader = new BufferedReader(new FileReader(file));
                sb = new StringBuffer();
                String tempString = null;
                while ((tempString = reader.readLine()) != null) {
                    sb.append(tempString );
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
            return  sb.toString();
    }

    private String eliminateSlash(String filePath){
        if (filePath.startsWith("/")) {
            return  filePath.substring(1);
        }
        return filePath;
    }


    private List<String> readFromDirectory(String path) {
        File file = new File(path);
        String[] names = file.list();

        if (null == names) {
            return null;
        }

        return Arrays.asList(names);
    }

    private boolean isSqlFile(String name) {
        return name.endsWith(".sql") || name.endsWith(".SQL");
    }


    /**
     * For test purpose.
     */
    public static void main(String[] args) throws Exception {
        BasicScanner scan = new SqlFileScanner("doc/database/");
        List<String> sqlList = scan.getFullyQualifiedSqlList();
        System.out.println(sqlList.size());
    }

}