package com.werockstar.googleanalyticsdemo

import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker


class App : Application() {

    private var sAnalytics: GoogleAnalytics? = null
    private var sTracker: Tracker? = null

    override fun onCreate() {
        super.onCreate()

        sAnalytics = GoogleAnalytics.getInstance(this);
    }

    @Synchronized fun getDefaultTracker(): Tracker? {
        if (sTracker == null) {
            sTracker = sAnalytics?.newTracker(R.xml.global_tracker)
        }

        return sTracker
    }
}