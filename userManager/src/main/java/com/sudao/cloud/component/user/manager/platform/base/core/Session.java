package com.sudao.cloud.component.user.manager.platform.base.core;

import java.util.Map;


public interface Session {

    Long getUserId();

    String getLoginName();

    Map<String,Object> getPermissions();

}
