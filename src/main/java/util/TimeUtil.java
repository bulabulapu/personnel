package util;

import java.util.Calendar;

public class TimeUtil {

    /**
     * 获取当前时间
     *
     * @return 时间
     */
    public static String getNowTime() {
        Long stamp = System.currentTimeMillis();
        String str = "";
        int year = stampToYear(stamp);
        str += year;
        str += "-";
        int month = stampToMonth(stamp);
        if (month < 10) {
            str += "0";
        }
        str += month;
        str += "-";
        int day = stampToDay(stamp);
        if (day < 10) {
            str += "0";
        }
        str += day;
        return str;
    }

    /**
     * 根据年和月返回当月的起止时间
     *
     * @param year  年
     * @param month 月
     * @return 起止时间
     */
    public static String[] getMonthStartAndEnd(int year, int month) {
        String[] strs = new String[2];
        String start = year + "-";
        if (month < 10) {
            start += "0";
        }
        start += month;
        start += "-01";
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
        String end = year + "-";
        if (month < 10) {
            end += "0";
        }
        end += month;
        end += "-01";
        strs[0] = start;
        strs[1] = end;
        return strs;
    }

    /**
     * 时间戳的月份
     *
     * @param stamp 时间戳
     * @return 月
     */
    private static int stampToMonth(Long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 时间戳的年
     *
     * @param stamp 时间戳
     * @return 年
     */
    private static int stampToYear(Long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 时间戳的当月的几号
     *
     * @param stamp 时间戳
     * @return 当月的第几天
     */
    private static int stampToDay(Long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stamp);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

}
