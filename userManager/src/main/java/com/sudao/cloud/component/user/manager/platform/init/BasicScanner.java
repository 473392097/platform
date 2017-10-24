package com.sudao.cloud.component.user.manager.platform.init;

import java.io.IOException;
import java.util.List;

/**
 * 扫描器
 *
 * @author chen
 * @create 2017-09-04 20:40
 **/
public abstract class BasicScanner {

    abstract List<String> getFullyQualifiedSqlList() throws IOException;


}
