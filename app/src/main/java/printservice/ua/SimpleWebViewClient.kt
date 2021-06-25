package printservice.ua

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.util.Log
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient


class SimpleWebViewClient(var activity: Activity) : WebViewClient() {

   /* override fun onReceivedSslError(
        view: WebView?,
        handler: SslErrorHandler,
        error: SslError?
    ) {
        handler.proceed()
    }*/
   /*override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError) {
       val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
       var message = "SSL Certificate error."
       when (error.primaryError) {
           SslError.SSL_UNTRUSTED -> message = "The certificate authority is not trusted."
           SslError.SSL_EXPIRED -> message = "The certificate has expired."
           SslError.SSL_IDMISMATCH -> message = "The certificate Hostname mismatch."
           SslError.SSL_NOTYETVALID -> message = "The certificate is not yet valid."
       }
       message += " Do you want to continue anyway?"
       builder.setTitle("SSL Certificate Error")
       builder.setMessage(message)
       builder.setPositiveButton("continue",
           DialogInterface.OnClickListener { dialog, which -> handler.proceed() })
       builder.setNegativeButton("cancel",
           DialogInterface.OnClickListener { dialog, which -> handler.cancel() })
       val dialog: AlertDialog = builder.create()
       dialog.show()
   }
*/


    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
       // view?.loadUrl("javascript:window.HTMLOUT.processHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");

    }
    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {

        if ("print-service.ua" in url) {
            webView.loadUrl(url)
            Log.v("url in brouser   ",url)
            return false
        }
        else{
            // все остальные ссылки будут спрашивать какой браузер открывать
            Log.v("url in brouser new    ",url)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            activity.startActivity(intent)
            return true
        }
    }

}