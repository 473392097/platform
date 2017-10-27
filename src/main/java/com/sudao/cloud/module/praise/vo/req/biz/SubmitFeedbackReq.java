package com.sudao.cloud.module.praise.vo.req.biz;

import java.io.Serializable;

/**
 * Created by hao.ch on 2017/10/26.
 */
public class SubmitFeedbackReq implements Serializable {
    private String context;
    private String nickName;
    private Integer level;

    public String getContext() {
        return context;
    }

    public SubmitFeedbackReq setContext(String context) {
        this.context = context;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public SubmitFeedbackReq setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public SubmitFeedbackReq setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
