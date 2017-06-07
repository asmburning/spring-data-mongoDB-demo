package com.vstone.document.core.util;


import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class IdUtil {

    // private static IdWorker idWorker = new IdWorker(6);

    public static String nextId() {
        return RandomStringUtils.randomNumeric(15);
    }
}
