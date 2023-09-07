package com.bk.composelistsample.ui.webview

import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.doOnLayout
import com.bk.core.data.model.Setting

@Composable
fun WebViewScreen(url: String, onBackPressed: () -> Unit) {
    SettingContent(url)

}

@Composable
private fun SettingContent(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()

        }
    },
        update = { webView ->
            webView.doOnLayout {
                webView.loadUrl(url)
            }
        })
}