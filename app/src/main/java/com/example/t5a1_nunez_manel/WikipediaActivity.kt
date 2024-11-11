package com.example.t5a1_nunez_manel

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t5a1_nunez_manel.databinding.ActivityWikipediaBinding

class WikipediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWikipediaBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWikipediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura el WebView
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient() // Aquí se indica al WebView que use su propio cliente

        // Cargar URL del Intent
        val url = intent.getStringExtra("urlComida")
        val comidaNombre = intent.getStringExtra("comidaNombre")
        if (url != null) {
            binding.webView.loadUrl(url+comidaNombre)
        }
    }
}