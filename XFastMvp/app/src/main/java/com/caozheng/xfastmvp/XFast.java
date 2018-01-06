package com.caozheng.xfastmvp;

import okhttp3.OkHttpClient;

/**
 * @author caozheng
 * @date 2017/10/28
 *
 * describe:
 */
public class XFast {

    /** 是否打印log */
    public static boolean LOG = true;
    public static String LOG_TAG = "XFast";

    /** 缓存相关文件名 */
    public static String CACHE_SP_NAME = "cache_sp";
    public static String CACHE_DISK_DIR = "cache_disk";

    private boolean logEnable = true;
    private String logTag = "XFast";
    private OkHttpClient okHttpClient;

    private volatile static XFast singleton;

    private XFast() {

    }

    public static XFast getInstance() {
        if (singleton == null) {
            synchronized (XFast.class) {
                if (singleton == null) {
                    singleton = new XFast();
                }
            }
        }
        return singleton;
    }

    public boolean isLogEnable() {
        return logEnable;
    }

    public XFast setLogEnable(boolean logEnable) {
        this.logEnable = logEnable;
        return this;
    }

    public String getLogTag() {
        return logTag;
    }

    public XFast setLogTag(String logTag) {
        this.logTag = logTag;
        return this;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public XFast setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        return this;
    }

    public void init(){

    }

}
