package Borbon_Ariel.MiniWeather

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val tvCity = findViewById<TextView>(R.id.tvCity)
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val tvDescription = findViewById<TextView>(R.id.tvWeather)

    tvGreeting.text = "Buenos Dias!"
        tvCity.text = "Cd.Obregon, Sonora"
        tvTemperature.text = "35°c"
        tvDescription.text = "Nublado"



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}