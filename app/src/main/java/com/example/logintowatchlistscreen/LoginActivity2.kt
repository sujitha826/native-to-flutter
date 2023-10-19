package com.example.logintowatchlistscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.engine.FlutterEngine

class LoginActivity2 : FlutterActivity() {
    private val channelSet = "watchlist/module"
    private val methodSet = "helloFromFlutter"

    private lateinit var channel: MethodChannel

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        channel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, channelSet)
        channel.setMethodCallHandler { call, result ->
            when(call.method) {
                methodSet -> {
                    val receivedData = call.argument<Int>("groups")
                    Log.d("Value received from Flutter", receivedData.toString())
//                // Send a response (if needed) back to Flutter
                    result.success("Response from Android")
                }
                else -> result.notImplemented()
            }
        }
    }

}