package com.sample.constraint.dm

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_recycler.*

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SampleRecyclerAdapter()
    }

    class SampleRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            object : RecyclerView.ViewHolder(TextView(parent.context)) {}

        override fun getItemCount() = 100

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = holder.itemView as? TextView
            view?.text = position.toString()
        }
    }

    class CollapsibleToolbar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : MotionLayout(context, attrs, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

        override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
            progress = kotlin.run { -verticalOffset / appBarLayout.totalScrollRange.toFloat() }
                .let { if (it.isNaN()) 1f else it }
        }

        override fun onAttachedToWindow() {
            super.onAttachedToWindow()
            (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
        }

        override fun onDetachedFromWindow() {
            super.onDetachedFromWindow()
            (parent as? AppBarLayout)?.removeOnOffsetChangedListener(this)
        }
    }
}
