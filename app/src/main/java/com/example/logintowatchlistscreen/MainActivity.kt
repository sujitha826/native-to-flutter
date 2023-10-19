package com.example.logintowatchlistscreen

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.WindowCompat
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import android.view.Menu
//import android.view.MenuItem
//import com.example.logintowatchlistscreen.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
// import androidx.appcompat.widget.Toolbar
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MainActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)

        val receivedMessage = intent.getStringExtra("groups") ?: ""
        val finalMsg = "No of watchlist groups:$receivedMessage"
        val message = findViewById<TextView>(R.id.messageIdView)
        message.text = finalMsg
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            Log.d("username entered", username.toString())
            // Handle the login logic here
            // val isLoginSuccessful = username == "user" && password == "1234"
            // val methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.login_to_watchlist_screen/platform_channel")
            if (username == "user" && password == "1234"){
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
//                startActivity(
//                    FlutterActivity.createDefaultIntent(this)
//                )
                navigateToFlutterScreen()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToFlutterScreen() {
        val intent = Intent(this, LoginActivity2::class.java)
        startActivity(intent)
    }



//    fun configureFlutterEngine(flutterEngine: FlutterEngine) {
//        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "watchlist/module").setMethodCallHandler { call, result ->
//            if (call.method == "helloFromFlutter") {
//                // Handle the data received from Flutter
//                val receivedData = call.argument<Int>("groups")
//                // Perform any necessary processing
//                Log.d("Value received from Flutter", receivedData.toString())
//                // Send a response (if needed) back to Flutter
//                result.success("Response from Android")
//            } else {
//                result.notImplemented()
//            }
//        }
//    }
}

