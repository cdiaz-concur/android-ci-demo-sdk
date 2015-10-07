package com.concur.mobile.android.sdk.utils;

import android.content.Context;

import com.concur.mobile.android.sdk.DatabaseHelper;


/**
 * @author Chris Diaz
 */
public class DBUtil {

    // Util class.
    private DBUtil() {
    }

    /**
     *
     * @param context
     * @param key
     * @return
     */
    public final static String getString(Context context, String key) {

        if(context == null || key == null) {
            throw new IllegalArgumentException("Context and key must not be null!");
        }

        return DatabaseHelper.getInstance(context).getString(key);
    }

    /**
     *
     * @param context
     * @param key
     * @param value
     */
    public final static void setString(Context context, String key, String value) {

        if(context == null || key == null) {
            throw new IllegalArgumentException("Context and key must not be null!");
        }

        DatabaseHelper.getInstance(context).setData(key, value);
    }

}
