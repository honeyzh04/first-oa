package com.first.util;
/**
 *
 * 获取上周周二日期
 * @Title: DateUtil
 * @ProjectName first-oa
 * @Description: TODO
 * @author: zhaoh
 * @date 2018/9/279:50
 * @Title: DateUtil
 * @ProjectName first-oa
 * @Description: TODO
 * @author Administrator
 * @date 2018/9/279:50
 */


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static Date geLastWeekTuesday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekTuesday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    public static Date getThisWeekTuesday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        if (2 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -2);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.TUESDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    public static Date getNextWeekTuesday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekTuesday(date));
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }
    /**
     * 明天时间
     * @return
     */
    public static Date getnNext(){
        Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);
        date=calendar.getTime();
        return  date;
    }
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2018-09-25");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


