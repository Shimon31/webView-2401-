package com.example.webview2401

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webview2401.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.webView.loadUrl("https://www.creativeitinstitute.com/")

        binding.webView.settings.javaScriptEnabled = true


        binding.webView.webViewClient = object : WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                binding.webView.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE

            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.webView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE

            }


        }

    }

    override fun onBackPressed() {

        if (binding.webView.canGoBack()){

            binding.webView.goBack()
        }else{
            super.onBackPressed()
        }


    }
}