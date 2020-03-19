package com.ux.blindkeyboard.stroke_im

import android.content.Context
import android.util.ArraySet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.sqrt

abstract class StrokeIMTouchListener(context: Context) : View.OnTouchListener {

    private var startX: Float? = null
    private var startY: Float? = null
    private val touchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop

    private var direction: StrokeIMDirection? = null
    private var directions = LinkedHashSet<StrokeIMDirection>()

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
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

                    startX = event.x
                    startY = event.y

                    directions.add(direction!!)
                }
                return true
            }

            MotionEvent.ACTION_UP -> {
                startX = 0.0f
                startY = 0.0f

                if (directions.size > 1) {

                    if (directions.elementAt(0) == StrokeIMDirection.LEFT && directions.elementAt(1) == StrokeIMDirection.RIGHT)
                        onDirectionDetected(StrokeIMDirection.LEFT_RIGHT)
                    else if (directions.elementAt(0) == StrokeIMDirection.RIGHT && directions.elementAt(1) == StrokeIMDirection.LEFT)
                        onDirectionDetected(StrokeIMDirection.RIGHT_LEFT)
                    else if (directions.elementAt(0) == StrokeIMDirection.UP && directions.elementAt(1) == StrokeIMDirection.DOWN)
                        onDirectionDetected(StrokeIMDirection.UP_DOWN)
                    else if (directions.elementAt(0) == StrokeIMDirection.DOWN && directions.elementAt(1) == StrokeIMDirection.UP)
                        onDirectionDetected(StrokeIMDirection.DOWN_UP)
                    else {
                        onDirectionDetected(direction!!)
                        directions.clear()
                        direction = null
                        return true
                    }

                    directions.clear()
                    direction = null
                    return true

                } else if (direction != null) {

                    onDirectionDetected(direction!!)
                    direction = null
                    directions.clear()
                    return true
                }

                directions.clear()
                direction = null
                return false
            }

            MotionEvent.ACTION_CANCEL -> {
                directions.clear()
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

    abstract fun onDirectionDetected(direction: StrokeIMDirection)
}