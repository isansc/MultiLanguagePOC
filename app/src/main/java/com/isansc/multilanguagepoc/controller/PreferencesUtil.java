package com.isansc.multilanguagepoc.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class PreferencesUtil {

    public static void save(Context context, String key, String value) {
        if(context != null){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putString(key, value);
            editor.apply();
        }
    }

    public static void delete(Context context, String key) {
        if(context != null){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.remove(key).apply();
        }
    }

    public static String getString(Context context, String key) {
        return getString(context, key, "");
    }

    public static String getString(Context context, String key, String defValue) {
        String result = null;
        if(context != null){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            result = preferences.getString(key, defValue);
        }
        return result;
    }

    public static void save(Context context, String key, boolean value) {
        if(context != null){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putBoolean(key, value);
            editor.apply();
        }
    }

    public static Uri getUri(Context context, String key) {
        Uri result = null;
        if(context != null){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            String savedValue = preferences.getString(key, "");
            if(!TextUtils.isEmpty(savedValue)){
                result = Uri.parse(savedValue);
            }
        }
        return result;
    }

    public static void save(Context context, String key, Uri value) {
        if(context != null){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            if (value != null){
                editor.putString(key, value.toString());
            }
            else{
                editor.putString(key, null);
            }
            editor.apply();
        }
    }

    public static boolean getBoolean(Context context, String key) {
        boolean result = false;
        if(context != null){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            result = preferences.getBoolean(key, false);
        }
        return result;
    }

    public static void save(Context context, String key, int value) {
        if(context != null){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putInt(key, value);
            editor.apply();
        }
    }

    public static int getInt(Context context, String key) {
        int result = 0;
        if(context != null){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            result = preferences.getInt(key, 0);
        }
        return result;
    }

    public static void save(Context context, String key, long value) {
        if(context != null){
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putLong(key, value);
            editor.apply();
        }
    }

    public static long getLong(Context context, String key) {
        long result = 0;
        if(context != null){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            result = preferences.getLong(key, 0);
        }
        return result;
    }
}
