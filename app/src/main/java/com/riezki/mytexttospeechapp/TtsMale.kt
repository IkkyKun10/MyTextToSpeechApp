package com.riezki.mytexttospeechapp

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale

/**
 * @author riezky maisyar
 */

class TtsMale(
    private val context: Context
) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale("id", "ID"))

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language not supported!")
            } else {
                for (voice in tts?.voices!!) {
                    Log.i("Voice", "Voice: ${voice.name}")
                    if (voice.name == "id-id-x-ide-local") {
                        tts?.voice = voice
                        println("terpanggil")
                        break
                    }
                }
            }
        }
    }

    fun speakOut() {
        val text = "Halo, saya ngomong"
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    fun onDestroy() {
        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
        }
    }
}