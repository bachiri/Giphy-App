package io.bachirio.gighyapp;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by bachiri on 9/25/17.
 */

public class GighyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    //Associate The Line number
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });
        }

    }
}
