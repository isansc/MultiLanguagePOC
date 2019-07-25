package com.isansc.multilanguagepoc.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.isansc.multilanguagepoc.R;
import com.isansc.multilanguagepoc.controller.LocaleManager;

import java.util.Locale;

public abstract class BaseActivity extends AppCompatActivity {
    private Locale currentLocale = Locale.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentLocale = LocaleManager.getCurrentLocale(this);
    }

    @Override
    protected void onRestart() {
        if(!currentLocale.equals(LocaleManager.getCurrentLocale(this))){
            changeLanguage(LocaleManager.getCurrentLocale(this).getLanguage());
        }

        super.onRestart();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.updateBaseContextLocale(base));
    }

    public void changeLanguage(String languageCode){
        //Change Application level locale
        LocaleManager.setLocale(this, languageCode);

        //It is required to recreate the activity to reflect the change in UI.
        recreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lang, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btn_english) {
            changeLanguage("en-US");
        }

        if (item.getItemId() == R.id.btn_portuguese) {
            changeLanguage("pt-BR");
        }

        if (item.getItemId() == R.id.btn_japanese) {
            changeLanguage("ja-JP");
        }

        return true;
    }


}
