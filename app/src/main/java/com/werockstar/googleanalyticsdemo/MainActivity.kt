package com.werockstar.googleanalyticsdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.analytics.HitBuilders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startTime = System.currentTimeMillis()
        val tracker = (application as App).getDefaultTracker()

        buttonScreen.setOnClickListener {
            tracker?.setScreenName("Main")
            tracker?.send(HitBuilders.ScreenViewBuilder().build())
        }

        buttonEvent.setOnClickListener {
            tracker?.setScreenName("Main")

            tracker?.send(HitBuilders.EventBuilder()
                    .setCategory("Privilege Redemption")
                    .setAction("Redeem")
                    .setLabel("Description")
                    .build())
        }
        buttonTimming.setOnClickListener {
            val endTime = System.currentTimeMillis()
            tracker?.send(HitBuilders.TimingBuilder()
                    .setCategory("Scan Card")
                    .setValue(endTime - startTime)
                    .build())

        }
    }
}

