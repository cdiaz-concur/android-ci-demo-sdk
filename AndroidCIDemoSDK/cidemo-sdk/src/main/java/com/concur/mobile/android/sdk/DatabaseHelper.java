package com.concur.mobile.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Chris Diaz
 */
public class DatabaseHelper {

    private static DatabaseHelper instance;

    private final SharedPreferences sharedPreferences;

    private DatabaseHelper(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * The single instance of this class.
     *
     * @param context
     * @return
     */
    public static DatabaseHelper getInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseHelper(context);
        }

        return instance;
    }

    /**
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void setData(String key, String value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
