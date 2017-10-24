package com.sudao.cloud.component.user.manager.platform.init.ro;

/**
 * 请求封装参数
 *
 * @author chen
 * @company sudao
 * @create 2017-09-04 22;
 * */
public class ExecRO {

    private   String    systemCode;
    private   String    execNo;
    private   String    hostIp;
    private   String    hostPort;
    private   String    dbName;
    private   String    dbuUsername;
    private   String    dbPasswd;
    private   String    dbSchema;

    public ExecRO() {

    }

    public ExecRO(String systemCode, String execNo, String hostIp, String hostPort, String dbName, String dbuUsername, String dbPasswd, String dbSchema) {
        this.systemCode = systemCode;
        this.execNo = execNo;
        this.hostIp = hostIp;
        this.hostPort = hostPort;
        this.dbName = dbName;
        this.dbuUsername = dbuUsername;
        this.dbPasswd = dbPasswd;
        this.dbSchema = dbSchema;
    }
}
