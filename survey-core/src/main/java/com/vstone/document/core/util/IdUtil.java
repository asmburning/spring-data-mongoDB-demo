package com.vstone.document.core.util;

import com.vstone.api.util.id.IdWorker;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class IdUtil {

    private static IdWorker idWorker = new IdWorker(6);

    public static String nextId() {
        return idWorker.nextId() + "";
    }
}
