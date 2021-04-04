package com.mrvk.videogames.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.mrvk.videogames.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoAnimation = Thread()
        val background = object : Thread() {
            override fun run() {
                try {
                    var animation =
                            AnimationUtils.loadAnimation(applicationContext, R.anim.fade_intro_anim)
                    tv_splash.startAnimation(animation)
                    img_splash.startAnimation(animation)
                    logoAnimation.start()
                    Thread.sleep(2200)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}