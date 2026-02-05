package Borbon_Ariel.MiniWeather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreditosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_creditos)


        val btnSaludo = findViewById<Button>(R.id.btnSaludar)
        val btnPropina = findViewById<Button>(R.id.btnPropina)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val txtSaludo = findViewById<EditText>(R.id.txtSaludo)
        val txtComida = findViewById<EditText>(R.id.txtComida)

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvPropina = findViewById<TextView>(R.id.tvPropina)

        btnVolver.setOnClickListener {
            //listener del boton volver para "dispose" esta pantalla regresando a la principal
            finish()
        }

        btnSaludo.setOnClickListener {
            //saludo estilo formulario clase
            val nombre = txtSaludo.text.toString()

            if (nombre.isNotEmpty()) {
                tvSaludo.text = "Hola, $nombre"
            } else {
                tvSaludo.text = "No hay nombre"
            }
        }


        btnPropina.setOnClickListener {
            //una prueba de propina donde se saca el txt, luego se hace double y despues de saca *.10 para mostrarlo
            val valorString = txtComida.text.toString()

            if (valorString.isNotEmpty()) {
                val valorNumerico = valorString.toDouble()

                val resultado = valorNumerico * 0.10

                tvPropina.text = "Propina: $${String.format("%.2f", resultado)}"
            } else {
                tvPropina.text = "Ingresa Cantidad"
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}