package com.sudao.cloud.module.praise.vo.req;

import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.praise.enums.ReadStatus;

public class FeedbackQuery extends Pagination {
    private String feedbackCellphone;
    private ReadStatus readStatus;

    public String getFeedbackCellphone() {
        return feedbackCellphone;
    }

    public FeedbackQuery setFeedbackCellphone(String feedbackCellphone) {
        this.feedbackCellphone = feedbackCellphone;
        return this;
    }

    public ReadStatus getReadStatus() {
        return readStatus;
    }

    public FeedbackQuery setReadStatus(ReadStatus readStatus) {
        this.readStatus = readStatus;
        return this;
    }
}
