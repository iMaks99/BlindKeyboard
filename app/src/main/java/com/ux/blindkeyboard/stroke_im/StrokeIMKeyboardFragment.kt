package com.ux.blindkeyboard.stroke_im

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.ux.blindkeyboard.R
import kotlinx.android.synthetic.main.stroke_i_m_keyboard_fragment.*

class StrokeIMKeyboardFragment : Fragment() {

    companion object {
        fun newInstance() = StrokeIMKeyboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stroke_i_m_keyboard_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        strokeIMKeyboardEditText.setOnTouchListener { _, _ ->
            false
        }

        strokeIMKeyboardContainer.setOnTouchListener(object : StrokeIMTouchListener(context!!) {
            override fun onDirectionDetected(direction: StrokeIMDirection) {
                when (direction) {

                    StrokeIMDirection.UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}2")
                    StrokeIMDirection.DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}8")
                    StrokeIMDirection.RIGHT -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}4")
                    StrokeIMDirection.LEFT -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}6")
                    StrokeIMDirection.RIGHT_DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}7")
                    StrokeIMDirection.LEFT_DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}9")
                    StrokeIMDirection.RIGHT_UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}1")
                    StrokeIMDirection.LEFT_UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}3")

                }
            }
        })

    }

}
