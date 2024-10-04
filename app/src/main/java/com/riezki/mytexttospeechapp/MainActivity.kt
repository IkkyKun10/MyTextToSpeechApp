package com.riezki.mytexttospeechapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.riezki.mytexttospeechapp.R.id
import com.riezki.mytexttospeechapp.R.layout
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var ttsMale: TtsMale
    private lateinit var ttsFemale: TtsFemale
    private var btnCowok: Button? = null
    private var btnCewek: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ttsMale = TtsMale(this)
        ttsFemale = TtsFemale(this)

        btnCewek = findViewById(id.btn_1)
        btnCowok = findViewById(id.btn_2)

        btnCewek?.setOnClickListener { ttsFemale.speakOut() }
        btnCowok?.setOnClickListener { ttsMale.speakOut() }

    }

    public override fun onDestroy() {
        // Shutdown TTS when
        // activity is destroyed
        super.onDestroy()
        ttsMale.onDestroy()
        ttsFemale.onDestroy()
    }
}