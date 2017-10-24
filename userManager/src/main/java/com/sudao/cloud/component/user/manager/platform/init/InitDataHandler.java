package com.sudao.cloud.component.user.manager.platform.init;

import com.google.gson.Gson;
import com.sudao.cloud.component.user.manager.platform.common.utils.HttpClientUtil;
import com.sudao.cloud.component.user.manager.platform.init.ro.ExecRO;
import org.apache.logging.log4j.core.util.Loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * 初始化数据处理
 *
 * @author chen
 * @company sudao
 * @create 2017-09-04 16:27
 **/
public class InitDataHandler {

    protected  static final String  PATH = "doc/database/init_datas.sql";

    protected static void init() {

        //读取文件
        BufferedReader reader = null;
        try {
            URL url = Loader.getResource(PATH, InitDataHandler.class.getClassLoader());
            reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                     sb.append(line);
            }
            // 请求数据
            System.out.println(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    protected  static  void  recursionFile(File file) {

        File[] files = file.listFiles();
        for(File a:files){
            System.out.println(a.getAbsolutePath());
            if(a.isDirectory()){
                recursionFile(a);
            }
        }

    }


    public static void main(String[] args) {

//        String url = "http://192.168.0.105:8080/exec/sql";
        String url = "http://execsql.labs.sudaotech.com/exec/sql";

        BasicScanner scan = new SqlFileScanner("doc/database/");
        try {
            List<String> sqlList = scan.getFullyQualifiedSqlList();

            for (String sqlStr:sqlList
                 ) {

                ExecRO execRO = new ExecRO("ecoc","1002","192.168.0.101","3306","testbase","root","root",sqlStr);

                Gson gson = new Gson();
                String  json = gson.toJson(execRO);

                System.out.println(HttpClientUtil.postWithJSON(url,json));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
