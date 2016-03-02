package com.example.testplayer;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.web_view);

	   webView = (WebView) findViewById(R.id.webView1);
	   webView.getSettings().setJavaScriptEnabled(true);
	   //webView.loadUrl("http://www.google.com");

	   String customHtml = "<!DOCTYPE html>"+
"<html>"+
"<body>"+

"<script src=\"soundmanager2.js\"></script>"+
"<script>"+
"var audio = new Audio('http://192.168.220.1:8080/RESTfulExample/rest/file/');"+
"audio.play();"+
"</script>"+

"</body>"+
"</html>"
;
	   webView.loadData(customHtml, "text/html", "UTF-8");

	}

}