package com.sudao.cloud.component.user.manager.platform.base.core;

import javax.servlet.http.HttpServletRequest;

public interface SessionAware {
    Session getSession(HttpServletRequest request);

    boolean clearSession(HttpServletRequest request);
}
