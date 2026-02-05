package Borbon_Ariel.MiniWeather

import android.content.Intent
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

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)        //sacamos las variables con findViewById
        val tvCity = findViewById<TextView>(R.id.tvCity)
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        val tvDescription = findViewById<TextView>(R.id.tvWeather)
        val btnCambiarClima = findViewById<Button>(R.id.btnCambiarClima)

    tvGreeting.text = "Buenos Dias!"
        tvCity.text = "Cd.Obregon, Sonora"
        tvTemperature.text = "35°c"
        tvDescription.text = "Nublado"              //colocamos todos los textos desde aqui en lugar de hardcodearlos
        btnCambiarClima.text = "Cambiar"


        val ivWeather = findViewById<ImageView>(R.id.ivWeather)
        ivWeather.setImageResource(R.drawable.ic_cloudy)            //seteamos la imagen de cloudy a la imagen

        val weatherList = listOf(
            WeatherOption(R.drawable.ic_sunny, "Soleado"),
            WeatherOption(R.drawable.ic_cloudy, "Nublado"),
            WeatherOption(R.drawable.ic_rainy, "Lluvioso"),             //creamos una lista de objetos de la clase Weather option
            WeatherOption(R.drawable.ic_stormy, "Tormenta"),        //la cual trae int para el R.drawable y la descripcion
            WeatherOption(R.drawable.ic_snowy, "Nevado"),           //(clase al final del codigo)
            WeatherOption(R.drawable.ic_windy, "Ventoso")
        )

        btnCambiarClima.setOnClickListener {
                        //agregamos un listener (lo que pasa cuando le das click)
                        //que saque un objeto rrandom de la lista de arriba y saque sus datos para colocarlos en la app
            val randomClima = weatherList.random()
            ivWeather.setImageResource(randomClima.imageResId)
            tvDescription.text = randomClima.description
        }

        val btnCreditos = findViewById<Button>(R.id.btnCreditos)

        btnCreditos.setOnClickListener {
            //un listerner con un intent hacia la otra pagina de la app ("creditos / pruebas")
            val intent = Intent(this, CreditosActivity::class.java)
            //y el startActivity para enviarnos hacia ella
            startActivity(intent)
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