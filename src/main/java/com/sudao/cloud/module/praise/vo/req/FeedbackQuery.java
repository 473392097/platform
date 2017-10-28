package com.sudao.cloud.module.praise.vo.req;

import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.commons.vo.req.ReportQuery;
import com.sudao.cloud.module.praise.enums.ReadStatus;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedbackQuery extends Pagination {
    private String feedbackCellphone;
    private ReadStatus readStatus;
    private  String feedbackUsername;



    //反馈时间  统计时间范围
    private String beginTime;
    private String endTime;
    private Date beginDateTime;
    private Date endDateTime;


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

    public String getFeedbackUsername() {
        return feedbackUsername;
    }

    public FeedbackQuery setFeedbackUsername(String feedbackUsername) {
        this.feedbackUsername = feedbackUsername;
        return this;
    }

    public String getBeginTime() {
        return beginTime;
    }

    //把起始时间beginTime  long  或者 String类型转换成Date类型的
    public FeedbackQuery setBeginTime(String beginTime) throws ParseException {
        this.beginTime = beginTime;
        // long
        if(NumberUtils.isCreatable(this.beginTime)) {
            this.beginDateTime = new Date(Long.parseLong(this.beginTime));
        } else {
            // string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            this.beginDateTime = sdf.parse(this.beginTime);
        }
        return this;
    }



    public String getEndTime() {
        return endTime;
    }

    //把结束时间setEndTime  long String类型转换成Date类型的
    public FeedbackQuery setEndTime(String endTime) throws ParseException {
        this.endTime = endTime;
        // long
        if(NumberUtils.isCreatable(this.endTime)) {
            this.endDateTime = new Date(Long.parseLong(this.endTime));
        } else {
            // string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            this.endDateTime = sdf.parse(this.endTime);
        }
        return this;
    }


    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public FeedbackQuery setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
        return this;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public FeedbackQuery setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }
}
