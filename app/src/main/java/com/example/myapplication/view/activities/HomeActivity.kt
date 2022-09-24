package com.example.myapplication.view.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.common_util.PrefUtils
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : DcbBaseActivity() {
    private val TAG: String = HomeActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initToolbar(getString(R.string.title_my_radisys), null)
        initViews()
    }

    private fun initViews() {

        cvRegistration.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        cvDetails.setOnClickListener {
            startActivity(Intent(this, BillingActivity::class.java))
        }
        cvSubscriptions.setOnClickListener {
            startActivity(Intent(this, SubscriptionActivity::class.java))
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onResume() {
        super.onResume()
        if (PrefUtils.getBoolean(this, PrefUtils.KEY_LOGGED_IN)) {
            cvSubscriptions.visibility = View.VISIBLE
        } else {
            cvSubscriptions.visibility = View.GONE
        }
    }

}