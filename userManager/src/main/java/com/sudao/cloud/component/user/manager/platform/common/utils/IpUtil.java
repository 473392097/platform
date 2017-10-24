package com.sudao.cloud.component.user.manager.platform.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017/7/4.
 */
public class IpUtil {
    /**
     * 获取登录用户IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        return ip;
    }

    /**
     * 获取服务器本地的ip地址
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static String getLocalIp() {
        InetAddress ip;
        String localIp = "127.0.0.2";
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces
                        .nextElement();
                ip = ni.getInetAddresses().nextElement();
                if (!ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {
                    localIp = ip.getHostAddress();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localIp;
    }
}
