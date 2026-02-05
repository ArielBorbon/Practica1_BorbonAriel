package Borbon_Ariel.MiniWeather

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        val btnCambiarClima = findViewById<Button>(R.id.btnCambiarClima)

    tvGreeting.text = "Buenos Dias!"
        tvCity.text = "Cd.Obregon, Sonora"
        tvTemperature.text = "35°c"
        tvDescription.text = "Nublado"
        btnCambiarClima.text = "Cambiar"


        val ivWeather = findViewById<ImageView>(R.id.ivWeather)
        ivWeather.setImageResource(R.drawable.ic_cloudy)

        val weatherList = listOf(
            WeatherOption(R.drawable.ic_sunny, "Soleado"),
            WeatherOption(R.drawable.ic_cloudy, "Nublado"),
            WeatherOption(R.drawable.ic_rainy, "Lluvioso"),
            WeatherOption(R.drawable.ic_stormy, "Tormenta"),
            WeatherOption(R.drawable.ic_snowy, "Nevado"),
            WeatherOption(R.drawable.ic_windy, "Ventoso")
        )

        btnCambiarClima.setOnClickListener {

            val randomClima = weatherList.random()
            ivWeather.setImageResource(randomClima.imageResId)
            tvDescription.text = randomClima.description
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


data class WeatherOption(
    val imageResId: Int,
    val description: String
)