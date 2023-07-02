package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btncalcular: Button = findViewById(R.id.btncalcular)
        val edtPeso: EditText = findViewById(R.id.Edtpeso)
        val edtaltura: EditText = findViewById(R.id.Edtaltura)
        val tvResultado: TextView = findViewById(R.id.texto)

        btncalcular.setOnClickListener {


            val alturastr = edtaltura.text.toString()
            val pesostr = edtPeso.text.toString()

            if (alturastr.isNotEmpty() && pesostr.isNotEmpty()) {
                val altura: Float = alturastr.toFloat()
                val peso: Float = pesostr.toFloat()

                val alturaFinal: Float = altura * altura
                val result = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("EXTRA_RESULT", result)
                }

                startActivity(intent)


            } else {
                Toast.makeText(this, "preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}


