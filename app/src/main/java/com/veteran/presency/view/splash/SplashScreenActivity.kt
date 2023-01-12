package com.veteran.presency.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.veteran.presency.R
import android.content.Intent
import android.os.Handler
import com.veteran.presency.view.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    //Deklarasi variabel timer Splash Screen muncul
    private val SPLASH_TIME_OUT:Long = 3000 // delay 3 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //Kode untuk menjalankan main screen setelah timer splash screen habis
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}