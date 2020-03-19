package com.ux.blindkeyboard.stroke_im

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sqrt

abstract class StrokeIMTouchListener(context: Context) : View.OnTouchListener {

//    private val gestureDetector: GestureDetector =
//        GestureDetector(context, StrokeIMGestureListener())

    private var startX: Float? = null
    private var startY: Float? = null
    private val touchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop

    private var direction: StrokeIMDirection? = null

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//        return gestureDetector.onTouchEvent(event)
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y

                return true
            }

            MotionEvent.ACTION_MOVE -> {
                if (getDistance(event) > touchSlop) {
                    val x = event.x
                    val y = event.y

                    direction = StrokeIMDirection.get(getAngle(startX!!, startY!!, x, y))
                }
                return true
            }

            MotionEvent.ACTION_UP -> {
                startX = 0.0f
                startY = 0.0f


                if(direction != null)
                    onDirectionDetected(direction!!)
                return true
            }

            MotionEvent.ACTION_CANCEL -> {
            }
        }
        return false
    }

    private fun getAngle(x1: Float, y1: Float, x2: Float, y2: Float): Double {
        val rad = atan2((y1 - y2).toDouble(), (x1 - x2).toDouble()) + PI
        return (rad * 180 / PI + 180) % 360
    }

    private fun getDistance(event: MotionEvent): Float {
        var distance = 0f

        val dx = (event.getX(0) - startX!!)
        val dy = (event.getY(0) - startY!!)

        distance += sqrt(dx * dx + dy * dy)
        return distance
    }

//    private inner class StrokeIMGestureListener : GestureDetector.SimpleOnGestureListener() {
//
//        private val SWIPE_THRESHOLD = 100
//        private val SWIPE_VELOCITY_THRESHOLD = 100
//
//        override fun onDown(e: MotionEvent?): Boolean {
//            return true
//        }
//
//        override fun onFling(
//            e1: MotionEvent?,
//            e2: MotionEvent?,
//            velocityX: Float,
//            velocityY: Float
//        ): Boolean {
//            var isResult = false
//            if (e1 != null && e2 != null)
//                try {
//                    val diffY = e2.y - e1.y
//                    val diffX = e2.x - e1.x
//
//                    if (abs(diffX) > abs(diffY)) {
//                        if (abs(diffX) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
//                            if (diffX > 0) {
//                                onSwipeRight()
//                            } else {
//                                onSwipeLeft()
//                            }
//
//                            isResult = true
//                        }
//                    } else if (abs(diffY) > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
//                        if (diffY > 0) {
//                            onSwipeDown()
//                        } else {
//                            onSwipeUp()
//                        }
//
//                        isResult = true
//                    }
//                } catch (e: Exception) {
//                    Log.w(this::class.java.name, e.message!!)
//                }
//
//            return isResult
//        }
//    }

    abstract fun onDirectionDetected(direction: StrokeIMDirection)
}