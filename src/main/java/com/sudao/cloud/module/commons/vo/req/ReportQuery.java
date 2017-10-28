package com.sudao.cloud.module.commons.vo.req;

import com.sudao.cloud.module.base.dao.page.Pagination;
import com.sudao.cloud.module.idea.enums.ProcessStatus;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportQuery extends Pagination {
    private String beginTime;
    private String endTime;
    private Date beginDateTime;
    private Date endDateTime;
    private ProcessStatus processStatus;



    public String getBeginTime() {
        return beginTime;
    }

    public ReportQuery setBeginTime(String beginTime) throws ParseException {
        this.beginTime = beginTime;
        // long
        if(NumberUtils.isCreatable(this.beginTime)) {
            this.beginDateTime = new Date(Long.parseLong(this.beginTime));
        } else {
            // string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.beginDateTime = sdf.parse(this.beginTime);
        }

        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public ReportQuery setEndTime(String endTime) throws ParseException {
        this.endTime = endTime;
        // long
        if(NumberUtils.isCreatable(this.endTime)) {
            this.endDateTime = new Date(Long.parseLong(this.endTime));
        } else {
            // string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.endDateTime = sdf.parse(this.endTime);
        }
        return this;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public ReportQuery setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
        return this;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public ReportQuery setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
        return this;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public ReportQuery setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }
}
