package com.ux.blindkeyboard.stroke_im

enum class StrokeIMDirection {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    LEFT_UP,
    RIGHT_UP,
    LEFT_DOWN,
    RIGHT_DOWN;

    companion object {

        fun get(angle: Double): StrokeIMDirection {
            return if (inRange(angle, 67.5f, 112.5f))
                UP
            else if (inRange(angle, 0f, 22.5f) || inRange(angle, 337.5f, 360f))
                RIGHT
            else if (inRange(angle, 247.5f, 292.5f))
                DOWN
            else if (inRange(angle, 157.5f, 202.5f))
                LEFT
            else if (inRange(angle, 22.5f, 67.5f))
                RIGHT_UP
            else if (inRange(angle, 112.5f, 157.5f))
                LEFT_UP
            else if (inRange(angle, 202.5f, 247.5f))
                LEFT_DOWN
            else
                RIGHT_DOWN
        }

        private fun inRange(angle: Double, start: Float, end: Float): Boolean {
            return (angle >= start) && (angle < end)
        }
    }
}