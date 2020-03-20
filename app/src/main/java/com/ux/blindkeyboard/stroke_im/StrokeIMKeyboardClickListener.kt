package com.ux.blindkeyboard.stroke_im

import android.os.Handler
import android.view.View

abstract class StrokeIMKeyboardClickListener : View.OnClickListener {

    private val delay = 500L
    private val handler = Handler()
    private var isFirstClick = true

    override fun onClick(v: View?) {
        if(isFirstClick) {
            isFirstClick = false
            increaseCounter()
        } else {
            handler.removeCallbacks(inputText)
            increaseCounter()
        }

        handler.postDelayed(inputText, delay)
    }

    abstract fun increaseCounter()

    abstract val inputText: Runnable
}