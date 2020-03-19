package com.ux.blindkeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ux.blindkeyboard.menu.MenuFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .addToBackStack(MenuFragment::class.java.name)
            .replace(R.id.main_container, MenuFragment())
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1)
            finishAffinity()
        else
            super.onBackPressed()

    }
}
