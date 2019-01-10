package com.pp.wms.storage.util;

/**
 * PP
 * Created by Makkah at 2019/1/10 9:40
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TimeStampTool {
    private static TimeStampTool timeStampTool;

    private TimeStampTool() {

    }

    public static TimeStampTool getInstance() {
        if (timeStampTool != null) {
            return timeStampTool;
        } else {
            return new TimeStampTool();
        }
    }

    /**
     * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
     * dateString 需要转换为timestamp的字符串
     * dataTime timestamp
     */
    java.sql.Timestamp string2Time(String dateString)
            throws java.text.ParseException {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH);//设定格式
        //dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);
        dateFormat.setLenient(false);//设置为非严格限制字符串格式
        java.util.Date timeDate = dateFormat.parse(dateString);//util类型
        java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
        return dateTime;
    }

    /**
     * method 将字符串类型的日期转换为一个Date（java.sql.Date）
     * dateString 需要转换为Date的字符串
     * dataTime Date
     */
    public java.sql.Date string2Date(String dateString)
            throws java.lang.Exception {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateFormat.setLenient(false);
        java.util.Date timeDate = dateFormat.parse(dateString);//util类型
        java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//sql类型
        return dateTime;
    }

//    public static void main(String[] args) {
//        Book book = new Book();
//        try {
//            book.setPublicationDate(TimeStampTool.string2Date("2012-12-12"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(book.toString());
//        System.out.println(Timestamp.valueOf("2012-12-12"));
//
////        Date da = new Date();
////        //注意：这个地方da.getTime()得到的是一个long型的值
////        System.out.println(da.getTime());
////
////        //由日期date转换为timestamp
////
////        //第一种方法：使用new Timestamp(long)
////        Timestamp t = new Timestamp(new Date().getTime());
////        System.out.println(t);
////
////        //第二种方法：使用Timestamp(int year,int month,int date,int hour,int minute,int second,int nano)
////        Timestamp tt = new Timestamp(Calendar.getInstance().get(
////                Calendar.YEAR) - 1900, Calendar.getInstance().get(
////                Calendar.MONTH), Calendar.getInstance().get(
////                Calendar.DATE), Calendar.getInstance().get(
////                Calendar.HOUR), Calendar.getInstance().get(
////                Calendar.MINUTE), Calendar.getInstance().get(
////                Calendar.SECOND), 0);
////        System.out.println(tt);
////
////        try {
////            String sToDate = "2005-8-18";//用于转换成java.sql.Date的字符串
////            String sToTimestamp = "2005-8-18 14:21:12.123";//用于转换成java.sql.Timestamp的字符串
////            Date date1 = string2Date(sToDate);
////            Timestamp date2 = string2Time(sToTimestamp);
////            System.out.println("Date:" + date1.toString());//结果显示
////            System.out.println("Timestamp:" + date2.toString());//结果显示
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }
}