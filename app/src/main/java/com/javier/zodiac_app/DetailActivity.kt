package com.javier.zodiac_app

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var imageView: ImageView
    lateinit var descTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //acceso al id de horoscopo en detalle (usar !! es para decirle que si o si paso el id)
        val id = intent.getStringExtra("HOROSCOPE_ID")!!

        val horoscope = Horoscope.getById(id)!!
        Log.i("ZODIAC", "${getString(horoscope.name)} -> ${getString(horoscope.dates)}")

        // Conectamos con XML
        nameTextView = findViewById(R.id.nameTextView)
        imageView= findViewById(R.id.imageView)
        descTextView= findViewById(R.id.descTextView)

        nameTextView.text = getString(horoscope.name)
        imageView.setImageResource(horoscope.image)
        descTextView.text = getString(horoscope.desc)
    }
}