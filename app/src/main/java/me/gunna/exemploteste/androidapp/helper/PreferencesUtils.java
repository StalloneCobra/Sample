package me.gunna.exemploteste.androidapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import me.gunna.exemploteste.androidapp.app.Constants;

/**
 * Created by root on 06/08/17.
 */

public class PreferencesUtils {


    private static final String PREF_NAME = Constants.SharedPreferences.FILE_PATH;

    private static PreferencesUtils sInstance;
    private final SharedPreferences mPref;

    private PreferencesUtils(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesUtils(context);
        }
    }

    public static synchronized PreferencesUtils getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferencesUtils.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setValue(String key, long value) {
        mPref.edit()
                .putLong(key, value)
                .commit();
    }

    public void setValue(String key, int value) {
        mPref.edit()
                .putInt(key, value)
                .commit();
    }

    public void setValue(String key, float value) {
        mPref.edit()
                .putFloat(key, value)
                .commit();
    }

    public void setValue(String key, String value) {
        mPref.edit()
                .putString(key, value)
                .commit();
    }

    public void setValue(String key, boolean value) {
        mPref.edit()
                .putBoolean(key, value)
                .commit();
    }

    public long getLong(String key) {
        return mPref.getLong(key, 0);
    }


    public int getInt(String key) {
        return mPref.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        return mPref.getInt(key, defaultValue);
    }

    public float getFloat(String key) {
        return mPref.getFloat(key, 0);
    }


    public String getString(String key) {
        return mPref.getString(key, "");
    }

    public boolean getBoolean(String key) {
        return mPref.getBoolean(key, false);
    }


    public boolean getBoolean(String key, boolean defaultValue) {
        return mPref.getBoolean(key, defaultValue);
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}


