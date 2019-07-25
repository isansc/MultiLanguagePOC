package com.isansc.multilanguagepoc.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class LocaleManager {

    private static final String PREF_KEY_CURRENT_LANGUAGE = "PREF_KEY_CURRENT_LANGUAGE";

    public static Context setLocale(Context context, String language) {
        saveCurrentLanguage(context, language);
        return updateBaseContextLocale(context);
    }

    public static Context updateBaseContextLocale(Context context) { // NEW
        Locale locale = getCurrentLocale(context);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            return updateResourcesLocale(context, locale);
//        }

        return updateResourcesLocaleLegacy(context, locale);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResourcesLocale(Context context, Locale locale) {

        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);

        return context.createConfigurationContext(configuration);
    }

    @SuppressWarnings("deprecation")
    private static Context updateResourcesLocaleLegacy(Context context, Locale locale) {
        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return context;
    }

    public static Locale getCurrentLocale(Context context) {
        return getSavedLocale(context);
    }

    private static Locale getSavedLocale(Context context) {
        String defLanguage = Locale.getDefault().getLanguage();
        String language = PreferencesUtil.getString(context, PREF_KEY_CURRENT_LANGUAGE, defLanguage);
        Locale locale = parseLocaleFromLanguageTag(language);

        Locale.setDefault(locale);

        return locale;
    }

    private static void saveCurrentLanguage(Context context, String language) {
        PreferencesUtil.save(context, PREF_KEY_CURRENT_LANGUAGE, language);
    }

    private static Locale parseLocaleFromLanguageTag(String languageTag){
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            locale = (new Locale.Builder()).setLanguageTag(languageTag).build();
        }
        else{

            if (languageTag.contains("-")) {
                String[] args = languageTag.split("-");
                if (args.length > 2) {
                    locale = new Locale(args[0], args[1], args[3]);
                }
                else if (args.length > 1) {
                    locale = new Locale(args[0], args[1]);
                }
                else if (args.length == 1) {
                    locale = new Locale(args[0]);
                }
                else{
                    locale = new Locale(languageTag);
                }
            }
            else if (languageTag.contains("_")){
                String[] args = languageTag.split("_");
                if (args.length > 2) {
                    locale = new Locale(args[0], args[1], args[3]);
                }
                else if (args.length > 1) {
                    locale = new Locale(args[0], args[1]);
                }
                else if (args.length == 1) {
                    locale = new Locale(args[0]);
                }
                else{
                    locale = new Locale(languageTag);
                }
            }
            else{
                locale = new Locale(languageTag);
            }
        }

        return locale;
    }

}