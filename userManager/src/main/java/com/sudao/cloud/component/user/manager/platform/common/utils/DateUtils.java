package com.sudao.cloud.component.user.manager.platform.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/27.
 */
public class DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_TIME_FORMAT_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_3 = "yyMMdd";

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final Pattern DATE_TIME_PATTERN_1 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}[T]\\d{2}:\\d{2}:\\d{2}$");
    private static final Pattern DATE_TIME_PATTERN_2 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$");

    public static Date parse(String dateString) {
        Date date = null;
        if (!StringUtils.isBlank(dateString)) {
            try {
                if (DATE_PATTERN.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
                } else if (DATE_TIME_PATTERN_1.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT_1).parse(dateString);
                } else if (DATE_TIME_PATTERN_2.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT_2).parse(dateString);
                }
            } catch (ParseException e) {
                logger.debug("Exception: {}", e);
            }
        }

        return date;
    }

    /**
     * 格林威治时间转北京时间
     * <p>
     * 例如:2017-06-28T16:00:00.000Z
     * 返回:Thu Jun 29 00:00:00 CST 2017
     *
     * @return 北京时间
     */
    public static Date parseWithGMT(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        Date date = null;
        try {
            TimeZone gmtTz = TimeZone.getTimeZone("GMT");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_1);
            simpleDateFormat.setTimeZone(gmtTz);
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            return date;
        }
    }


    public static String formatDatetoFormat() {
        SimpleDateFormat date = new SimpleDateFormat(DATE_TIME_FORMAT_3);
        return date.format(new Date());
    }

    public static String formatDate(Date date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = DATE_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


    public static Date getDateCalcHours(Date date, Integer hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public static Date getTomorrowDateBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public static Date getDateBegin(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static int getDateGaps(Date start, Date end) {
        Calendar cs = Calendar.getInstance();
        cs.setTime(start);

        Calendar ce = Calendar.getInstance();
        ce.setTime(end);

        long gaps = ce.getTimeInMillis() - cs.getTimeInMillis();
        return (int) (gaps / (1000 * 60 * 60 * 24));
    }

    public static int getDateHoursGaps(Date start, Date end) {
        Calendar cs = Calendar.getInstance();
        cs.setTime(start);

        Calendar ce = Calendar.getInstance();
        ce.setTime(end);

        long gaps = ce.getTimeInMillis() - cs.getTimeInMillis();
        return (int) (gaps / (1000 * 60 * 60));
    }

    public static void main(String ss[]) {
        System.out.println(getDateGaps(getDateBegin(new Date()), addDays(new Date(), 10)));
    }


    public static Date addDays(Date start, int addDay) {
        if(start == null){
            return null;
        }
        Date date = getDateBegin(start);
        Calendar cs = Calendar.getInstance();
        cs.setTime(date);
        cs.set(Calendar.DAY_OF_MONTH, cs.get(Calendar.DAY_OF_MONTH) + addDay);//让日期加1
        return cs.getTime();
    }

    /**
     * 根据当前日期获取前N个月的日期
     * @param month
     * @return
     */
    public static String getFormatDate(int month) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,month);
        Date date = cal.getTime();
        return df.format(date);
    }

    public static Date getDate(int month) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,month);
        return cal.getTime();
    }

    public static Date stringToDate(String str) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_2);
        Date date;
        try {
            date = df.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            date = new Date();
        }
        return date;
    }
}
