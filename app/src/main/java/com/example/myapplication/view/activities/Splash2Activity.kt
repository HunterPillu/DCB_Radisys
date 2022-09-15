package com.example.myapplication.view.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.common_util.PrefUtils
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.*

class Splash2Activity : AppCompatActivity() {
    private val TAG: String = Splash2Activity::class.java.name
    private var mJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        tvVersion.text = "APK-2"

        val isLoggedIn = PrefUtils.getBoolean(this, PrefUtils.KEY_LOGGED_IN)
        mJob = lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                if (isLoggedIn) {
                    startActivity(Intent(this@Splash2Activity, SubscriptionActivity::class.java))
                } else {
                    startActivity(Intent(this@Splash2Activity, LoginActivity::class.java))
                }
                finish()
            }
        }
    }

    override fun onBackPressed() {
        mJob?.cancel()
        finish()
    }

}