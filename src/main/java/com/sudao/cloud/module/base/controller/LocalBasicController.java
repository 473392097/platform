package com.sudao.cloud.module.base.controller;

import com.sudao.cloud.module.base.config.ResultCode;
import com.sudao.framework.controller.BasicController;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Spector on 2017/6/29.
 */
public abstract class LocalBasicController extends BasicController {

    private static final String SESSION_USER_ID = "userId";

    protected void setOk(Object data) {
        this.setRecord(ResultCode.OK.getCode(), ResultCode.OK.getMessage(), data);
    }

    protected void setFail(ResultCode data) {
        this.setRecord(data.getCode(), data.getMessage());
    }


    protected void setRecord(String code, String message){
        this.setRecord(code, message, null);
    }

    protected void setRecord(String code, String message, Object data){
        baseRecord.setData(data);
        baseRecord.setCode(code);
        baseRecord.setMessage(message);
    }

    protected void writeFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        ServletOutputStream outputStream = super.response.getOutputStream();
        super.response.setHeader("Content-Disposition", "attachment;filename=" +
                URLEncoder.encode(path.getFileName().toString(), "UTF-8"));
        super.response.setContentType("application/octet-stream");

        byte[] bytes = Files.readAllBytes(path);
        outputStream.write(bytes);
        outputStream.close();
    }

    /**
     * 获取用户ID
     * @return
     */
    protected long getUserId(){
        Object userId = super.getRequest().getAttribute(SESSION_USER_ID);
        return null == userId ? 0 : (long) userId;
    }
}
