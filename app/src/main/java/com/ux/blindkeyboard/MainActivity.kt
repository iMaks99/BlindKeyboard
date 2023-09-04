package com.ux.blindkeyboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ux.blindkeyboard.menu.MenuFragment

/**
 *
 */
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
