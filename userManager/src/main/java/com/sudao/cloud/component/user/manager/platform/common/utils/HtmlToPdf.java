package com.sudao.cloud.component.user.manager.platform.common.utils;

/**
 * Created by Administrator on 2017/8/4.
 */
public class HtmlToPdf {
    private static final String toPdfTool = "wkhtmltopdf";

    public static boolean coverHtmlToPdf(String inputUrl, String outputUrl){
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append(inputUrl);
        cmd.append(" ");
        cmd.append(outputUrl);
        boolean result = true;
        try {
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
            error.start();
            output.start();
            proc.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
