package com.example.myapplication.view.activities

import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import dev.shreyaspatil.MaterialDialog.BottomSheetMaterialDialog
import dev.shreyaspatil.MaterialDialog.MaterialDialog
import dev.shreyaspatil.MaterialDialog.model.TextAlignment
import kotlinx.android.synthetic.main.custom_toolbar.*

open class DcbBaseActivity : AppCompatActivity() {
    private var progress: BottomSheetMaterialDialog? = null
    fun initToolbar(title: String, desc: String?) {
        try {
            tvToolbarTitle.text = title
            if (desc == null) {
                tvToolbarDesc.visibility = View.GONE
            } else {
                tvToolbarDesc.text = desc
                tvToolbarDesc.visibility = View.VISIBLE
            }

            ivToolbarBack.setOnClickListener {
                onBackPressed()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

   private fun initLoadingDialog() {
        progress = BottomSheetMaterialDialog.Builder(this)
            .setTitle(getString(R.string.title_loading), TextAlignment.CENTER)
            .setMessage(getString(R.string.msg_wait_loading), TextAlignment.CENTER)
            .setCancelable(false)
            .setAnimation("loading.json")
            .build()
    }

    fun showProgress() {
        if (progress == null) {
            initLoadingDialog()
        }
        progress!!.show()
        val animationView = progress!!.animationView
        animationView.scaleType = ImageView.ScaleType.CENTER_INSIDE
    }

    fun hideProgress() {
        if (progress != null) {
            progress!!.dismiss()
        }
    }
}