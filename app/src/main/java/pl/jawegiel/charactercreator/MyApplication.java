package pl.jawegiel.charactercreator;

import android.app.Application;

import com.codemonkeylabs.fpslibrary.TinyDancer;

import pl.jawegiel.charactercreator.utility.SharedPrefs;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TinyDancer.create()
                .redFlagPercentage(.1f)
                .startingXPosition(150)
                .startingYPosition(150)
                .show(getApplicationContext());

        SharedPrefs.init(getApplicationContext());
    }
}