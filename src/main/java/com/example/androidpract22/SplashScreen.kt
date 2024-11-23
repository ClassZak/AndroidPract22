package com.example.androidpract22

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class SplashScreen : AppCompatActivity() {
    private lateinit var animatedVector:AnimatedVectorDrawableCompat
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        runSplashScreen()
    }
    private fun runSplashScreen() {
        val splashScreenDuration: Long = 4700

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreen,
                MainActivity::class.java)
            startActivity(intent)

            finish()
        }, splashScreenDuration)


        animatedVector= AnimatedVectorDrawableCompat.create(this,R.drawable.hello_android_waving)!!
        imageView=findViewById<ImageView>(R.id.imageObject)
        imageView.setImageDrawable(animatedVector)

        animatedVector.start()

        animatedVector.registerAnimationCallback(object : Animatable2Compat.AnimationCallback(){
            override fun onAnimationEnd(drawable: Drawable?) {
                Handler(Looper.getMainLooper()).postDelayed({},1000)
            }
        })
    }
}