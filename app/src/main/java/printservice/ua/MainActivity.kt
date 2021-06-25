package printservice.ua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //реклама
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //конец рекламного кода
        //настройка webView
        webView = findViewById(R.id.wb_view)
        val webSettings = webView?.settings
        webSettings?.javaScriptEnabled = true
        webSettings?.domStorageEnabled = true
        webSettings?.loadWithOverviewMode = true
        webSettings?.useWideViewPort = true
        webSettings?.builtInZoomControls = true
        webSettings?.displayZoomControls = false
        webSettings?.setSupportZoom(true)
        webSettings?.defaultTextEncodingName = "utf-8"
        val webViewClient = SimpleWebViewClient(this)
        webView?.webViewClient = webViewClient

        webView?.loadUrl("https://print-service.ua/ru/")

    }
}