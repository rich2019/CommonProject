package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类，处理日期和字符串之间相互转换
 *
 * @author 徐晓阳
 * @创建日期（ 2019-12-02 16:27 ）
 * @description
 */
public class DateUtil {
    /**
     * 匹配年月日正则 yyyy-MM-dd
     */
    public static final String DATE_REGEX = "^((?!0000)[0-9]{4}-([0-1][0-9]|[1-9])-([1-9]|[0-2][0-9]|[3][0-1]))$";
    /**
     * 匹配年月日正则 yyyy-MM
     */
    public static final String MONTH_REGEX = "^((?!0000)[0-9]{4}-([0-1][0-9]|[1-9]))$";
    /**
     * 匹配年月日正则 yyyy
     */
    public static final String YEAR_REGEX = "^((?!0000)[0-9]{4})$";


    public static final String Y = "yyyy";
    public static final String dd = "dd";
    public static final String MD = "MM-dd";
    public static final String MDD = "MMdd";
    public static final String M = "MM";
    public static final String MM = "yyyyMM";
    public static final String DD = "yyyyMMdd";
    public static final String H = "HH";
    public static final String HM = "HH:mm";
    public static final String HMS = "HH:mm:ss";
    public static final String YM = "yyyy-MM";
    public static final String YMD = "yyyy-MM-dd";
    public static final String YMDH = "yyyy-MM-dd HH";
    public static final String YMDHM = "yyyy-MM-dd HH:mm";
    public static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String TABLENAME = "yyyyMMdd";
    private static final GregorianCalendar GC = new GregorianCalendar();
    public static final String LONGDATE = "yyyyMMddHHmmss";

    /**
     * 按默认格式解析字符串日期
     *
     * @param date
     * @return Date
     */
    public static Date parse(String date) {
        DateFormat format = new SimpleDateFormat(DEFAULT);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按指定格式解析字符串日期
     *
     * @param date
     * @return Date
     */
    public static Date parse(String date, String format) {
        DateFormat fmt = new SimpleDateFormat(format);
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按默认格式解析日期字符串
     *
     * @param date
     * @return 字符串日期
     */
    public static String format(Date date) {
        DateFormat format = new SimpleDateFormat(DEFAULT);
        return format.format(date);
    }

    /**
     * 按指定格式解析日期字符串
     *
     * @param date
     * @return 字符串日期
     */
    public static String format(Date date, String format) {
        DateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(date);
    }

    /**
     * offset为正则往后,为负则往前
     *
     * @param date   时间
     * @param offset 增加减少时间
     * @param type   类型
     * @return
     */
    public static Date subtract(Date date, int offset, int type) {
        GC.setTime(date);
        GC.add(type, offset);
        return GC.getTime();
    }

    /**
     * 往前为减 往后为加
     *
     * @param date   时间
     * @param offset 加减
     * @param type   加减的类型
     * @param format 返回的格式
     * @return
     */
    public static Date subtract(Date date, int offset, int type, String format) {
        GC.setTime(date);
        GC.add(type, offset);
        return parse(format(GC.getTime(), format), format);
    }

    /**
     * 从开始到结束日期，按照周期返回日期列表
     *
     * @param startTime
     * @param endTime
     * @param cycle
     * @return
     */
    public static List<String> getTimeSpace(Date startTime, Date endTime,
                                            int cycle, int type, String format) {
        List<String> resultList = new ArrayList<String>();
        while (startTime.before(endTime)) {
            resultList.add(format(startTime, format));
            startTime = subtract(startTime, cycle, type);
        }
        return resultList;
    }

    public static List<String> getTimeSpaceMM(Date startTime, Date endTime,
                                              int cycle, int type, String format) {
        List<String> resultList = new ArrayList<String>();
        resultList.add(format(startTime, format));
        if (!startTime.equals(endTime)) {
            do {
                startTime = subtract(startTime, cycle, type);
                resultList.add(format(startTime, format));
            } while (startTime.before(endTime));
        }
        return resultList;
    }

    public static boolean isSameTime(Date date1, Date date2) {
        if (date1.getTime() == date2.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    public static Date getDateofPreMonth(Date date) {
        long datelong = date.getTime() / 1000 - 60 * 60 * 24 * 365;
        date.setTime(datelong * 1000);
        return date;
    }


    /**
     * 根据一个日期，返回是星期几的字符串
     *
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(YMD);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 获取当前时间最近一周的，时间日期年月日的字符串
     *
     * @param date
     * @return
     */
    static public List<String> getRecentWeekDateDayString(Date date) {
        List<String> list = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -7);
        for (int i = 1; i <= 7; i++) {
            calendar.add(Calendar.DATE, 1);
            list.add(format(calendar.getTime(), YMD));
        }
        return list;
    }

    static public Date getBeginDate(Date inDate) {
        String dayString = format(inDate, YMD);
        Date outDate = parse(dayString, YMD);
        return outDate;
    }

    /**
     * 获取输入时间最接近的间隔时间,例如2015-11-11 13:41:33,如果是五分钟的时间间隔的话，找到的时间就是2015-11-11 13:41:30
     *
     * @return
     */
    static public Date getNearestPeriodDate(Date date, String format, int peroid) {
        int mm = Integer.valueOf(format(new Date(), format));
        mm = mm - mm % peroid;
        String fomartString = "yyyy-MM-dd HH:mm:ss";
        String resDateString = fomartString.replaceFirst(format, String.valueOf(mm));
        resDateString = format(date, resDateString);
        return parse(resDateString);
    }

    /**
     * 根据num单位分钟将一天分为288个刻度，计算当前时间是在哪个刻度下
     *
     * @param num
     * @return
     */
    static public long getTimeIndexForPeriod(int num) {
        Date date1 = new Date();
        Date date2 = parse(format(date1, "yyyy-MM-dd 00:00:00"));
        long time = (int) (date1.getTime() - date2.getTime());
        return time / (5 * 60 * 1000) - 1;
    }

    /**
     * 时间按5分钟分为288个刻度，获取时间的刻度
     *
     * @param date
     * @return
     */
    static public int getPeroidDateIndex(Date date) {
        long peroidTimeFor5Min = (5 * 60 * 1000);
        Date dayStartDate = date;
        Date dayDate = parse(format(dayStartDate, "yyyy-MM-dd") + " 00:00:00");
        long deltaTime = date.getTime() - dayDate.getTime();
        int currentPeroidIndex = (int) (deltaTime / peroidTimeFor5Min);
        return currentPeroidIndex + 1;
    }


    /**
     * 时间按5分钟分为288个刻度，通过刻度获取属于的小时
     *
     * @param num
     * @return
     */
    public static String getHourByScale(int num) {
        //hh 12小时制  HH 24小时制
        return format(new Date(parse(format(new Date(), YMD), YMD).getTime() + num * 5L * 60L * 1000), "HH");
    }

    /**
     * 传入月份时间获取当天月的天数数组
     *
     * @param
     * @return
     */
    public static String[] getMonthDaysByDate(Date originDate, Date compareDate) {
        Calendar a = Calendar.getInstance();
        a.setTime(originDate);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        //原日期
        int maxDate1 = a.get(Calendar.DATE);

        a.setTime(compareDate);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        //对比日期
        int maxDate2 = a.get(Calendar.DATE);

        int param = maxDate1 > maxDate2 ? maxDate1 : maxDate2;
        String[] strs = new String[param];
        for (int i = 0; i < param; i++) {
            if (i < 9) {
                strs[i] = "0" + (i + 1) + "";
            } else {
                strs[i] = (i + 1) + "";
            }
        }
        return strs;
    }

    public static String[] getArrayBySum(int sum) {
        String[] strs = new String[sum];
        for (int i = 0; i < sum; i++) {
            if (i < 9) {
                strs[i] = "0" + (i + 1);
            } else {
                strs[i] = (i + 1) + "";
            }
        }
        return strs;
    }

}