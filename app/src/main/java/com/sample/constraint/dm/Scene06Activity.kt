package com.sample.constraint.dm

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Scene06Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_06)
    }

    @Suppress("unused")
    class ToastView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : View(context, attrs, defStyleAttr) {

        fun showUpToast() {
            Toast.makeText(context, "UP!", Toast.LENGTH_SHORT).show()
        }

        fun showDownToast() {
            Toast.makeText(context, "DOWN!", Toast.LENGTH_SHORT).show()
        }
    }
}
