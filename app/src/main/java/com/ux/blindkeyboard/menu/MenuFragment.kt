package com.ux.blindkeyboard.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ux.blindkeyboard.R
import com.ux.blindkeyboard.stroke_im.StrokeIMKeyboardFragment
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamBtn.setOnClickListener {
            //TODO create link to team's keyboard fragment
        }

        strokeIMBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack(StrokeIMKeyboardFragment::class.java.name)
                .replace(R.id.main_container, StrokeIMKeyboardFragment.newInstance())
                .commit()
        }

    }


}
