package com.sample.constraint.dm

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        val activity = when (view.id) {
            R.id.scene01 -> Scene01Activity::class.java
            R.id.scene02 -> Scene02Activity::class.java
            R.id.scene03 -> Scene03Activity::class.java
            R.id.scene04 -> Scene04Activity::class.java
            R.id.scene05 -> Scene05Activity::class.java
            R.id.scene06 -> Scene06Activity::class.java
            R.id.lottie -> LottieActivity::class.java
            R.id.recycler -> RecyclerActivity::class.java
            R.id.fragments -> FragmentsActivity::class.java
            else -> null
        }
        activity?.let {
            startActivity(Intent(this, it))
        }
    }
}
