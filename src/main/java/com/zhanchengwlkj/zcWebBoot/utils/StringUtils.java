package com.zhanchengwlkj.zcWebBoot.utils;

public class StringUtils {
    public static boolean isBlank(String str){
        if(null == str)return true;
        if("".equals(str))return true;
        if("".equals(str.trim()))return true;
        return false;
    }
}
