package com.sudao.cloud.component.user.manager.platform.base.core;

public interface SessionAware {
    Session getSession();
    boolean clearSession();
}
