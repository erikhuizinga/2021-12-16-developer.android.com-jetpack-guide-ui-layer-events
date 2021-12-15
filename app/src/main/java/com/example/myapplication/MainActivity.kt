package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.example.myapplication.ui.main.MainFragment
import com.example.myapplication.ui.secondary.SecondaryFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container1, MainFragment())
                replace(R.id.container2, SecondaryFragment())
            }
        }
    }
}
