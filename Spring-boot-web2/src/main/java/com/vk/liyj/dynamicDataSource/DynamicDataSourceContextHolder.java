package com.vk.liyj.dynamicDataSource;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder {
    //当前线程id是key，value是数据源名称
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    //value是数据源名称
    public static List<String> dataSourceIds = new ArrayList<String>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * 判断指定DataSrouce当前是否存在
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }
}
