package com.sudao.cloud.component.user.manager.platform.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/27.
 */
public class IDUtils {

    //订单编号的生成20位数字
    public static String getOrderNO() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String oid = df.format(new Date());
        StringBuilder sb = new StringBuilder();
        //加上三位随机数
        Random random = new Random();
        int num = random.nextInt(999);
        //如果不足两位前面补0
        String str = String.format("%03d", num);
        sb.append(oid).append(str);
        return sb.toString();
    }
}
