package com.ux.blindkeyboard.stroke_im

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class StrokeIMGestureDetector : GestureDetector.SimpleOnGestureListener() {

    companion object {

        const val SWIPE_THRESHOLD = 100
        const val SWIPE_VELOCITY_THRESHOLD = 100

    }

//    override fun onFling(
//        e1: MotionEvent?,
//        e2: MotionEvent?,
//        velocityX: Float,
//        velocityY: Float
//    ): Boolean {
//        var isResult = false
//        if (e1 != null && e2 != null)
//            try {
//                var diffY = e2.y - e1.y
//                var diffX = e2.x - e1.x
//
//                if()
//            }
//    }

}