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

    private var clickCount = -1

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

        strokeIMKeyboardEditText.showSoftInputOnFocus = false

        strokeIMKeyboardContainer.setOnTouchListener(object : StrokeIMTouchListener(context!!) {
            override fun onDirectionDetected(direction: StrokeIMDirection) {
                when (direction) {
// =================================================== NUMBERS ===================================================
//                    StrokeIMDirection.UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}2")
//                    StrokeIMDirection.DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}8")
//                    StrokeIMDirection.RIGHT -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}4")
//                    StrokeIMDirection.LEFT -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}6")
//                    StrokeIMDirection.RIGHT_DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}7")
//                    StrokeIMDirection.LEFT_DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}9")
//                    StrokeIMDirection.RIGHT_UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}1")
//                    StrokeIMDirection.LEFT_UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}3")
//                    StrokeIMDirection.UP_DOWN -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}5")
//                    StrokeIMDirection.DOWN_UP -> strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text}0")

                    StrokeIMDirection.UP -> strokeIMKeyboardContainer.setOnClickListener(object :
                        StrokeIMKeyboardClickListener() {
                        override fun increaseCounter() {
                            clickCount = (clickCount + 1) % 4
                        }

                        override val inputText = Runnable {
                            strokeIMKeyboardEditText.setText(
                                "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                    R.array.alphabet_up
                                )[clickCount]}"
                            )
                            clickCount = -1
                        }

                    })

                    StrokeIMDirection.DOWN -> strokeIMKeyboardContainer.setOnClickListener(
                        object : StrokeIMKeyboardClickListener() {
                            override fun increaseCounter() {
                                clickCount = (clickCount + 1) % 4
                            }

                            override val inputText = Runnable {
                                strokeIMKeyboardEditText.setText(
                                    "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                        R.array.alphabet_down
                                    )[clickCount]}"
                                )
                                clickCount = -1
                            }
                        })

                    StrokeIMDirection.LEFT -> strokeIMKeyboardContainer.setOnClickListener(object :
                        StrokeIMKeyboardClickListener() {
                        override fun increaseCounter() {
                            clickCount = (clickCount + 1) % 4
                        }

                        override val inputText = Runnable {
                            strokeIMKeyboardEditText.setText(
                                "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                    R.array.alphabet_right
                                )[clickCount]}"
                            )
                            clickCount = -1
                        }
                    })

                    StrokeIMDirection.RIGHT -> strokeIMKeyboardContainer.setOnClickListener(object :
                        StrokeIMKeyboardClickListener() {
                        override fun increaseCounter() {
                            clickCount = (clickCount + 1) % 4
                        }

                        override val inputText = Runnable {
                            strokeIMKeyboardEditText.setText(
                                "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                    R.array.alphabet_left
                                )[clickCount]}"
                            )
                            clickCount = -1
                        }
                    })

                    StrokeIMDirection.LEFT_DOWN -> strokeIMKeyboardContainer.setOnClickListener(
                        object : StrokeIMKeyboardClickListener() {
                            override fun increaseCounter() {
                                clickCount = (clickCount + 1) % 4
                            }

                            override val inputText = Runnable {
                                strokeIMKeyboardEditText.setText(
                                    "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                        R.array.alphabet_down_right
                                    )[clickCount]}"
                                )
                                clickCount = -1
                            }
                        })

                    StrokeIMDirection.RIGHT_DOWN -> strokeIMKeyboardContainer.setOnClickListener(
                        object : StrokeIMKeyboardClickListener() {
                            override fun increaseCounter() {
                                clickCount = (clickCount + 1) % 4
                            }

                            override val inputText = Runnable {
                                strokeIMKeyboardEditText.setText(
                                    "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                        R.array.alphabet_down_left
                                    )[clickCount]}"
                                )
                                clickCount = -1
                            }
                        })

                    StrokeIMDirection.LEFT_UP -> strokeIMKeyboardContainer.setOnClickListener(
                        object : StrokeIMKeyboardClickListener() {
                            override fun increaseCounter() {
                                clickCount = (clickCount + 1) % 4
                            }

                            override val inputText = Runnable {
                                strokeIMKeyboardEditText.setText(
                                    "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                        R.array.alphabet_up_right
                                    )[clickCount]}"
                                )
                                clickCount = -1
                            }
                        })

                    StrokeIMDirection.RIGHT_UP -> strokeIMKeyboardContainer.setOnClickListener(object :
                        StrokeIMKeyboardClickListener() {
                        override fun increaseCounter() {
                            clickCount = (clickCount + 1) % 4
                        }

                        override val inputText = Runnable {
                            strokeIMKeyboardEditText.setText(
                                "${strokeIMKeyboardEditText.text}${resources.getStringArray(
                                    R.array.alphabet_up_left
                                )[clickCount]}"
                            )
                            clickCount = -1
                        }
                    })

                    StrokeIMDirection.LEFT_RIGHT -> {
                        strokeIMKeyboardEditText.setText("${strokeIMKeyboardEditText.text} ")
                    }
                    StrokeIMDirection.RIGHT_LEFT -> {
                        strokeIMKeyboardEditText.setText(
                            "${strokeIMKeyboardEditText.text.dropLast(
                                1
                            )}"
                        )
                    }

                }

                strokeIMKeyboardEditText.setSelection(strokeIMKeyboardEditText.text.length)
            }
        })

    }


}
