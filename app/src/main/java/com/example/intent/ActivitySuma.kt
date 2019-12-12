package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_suma.*

class ActivitySuma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma)
        //SE CREAN DOS VARIABLES, QUE SE RECOGEN LOS DATOS DE LOS CUADROS DE NUEMROS DELPRIMER ACTIVITY

        val num1 = intent.getIntExtra("num1", 0)
        val num2 = intent.getIntExtra ("num2", 0)
        //SE SUMAN LOS VALORES RECOGIDOS
        val resultado = num1 + num2

        //SE ESCRIBE EL RESULATDO EN EL DATA
        val data = Intent()
        data.putExtra("resultado", resultado)
        setResult(Activity.RESULT_OK, data)

        textoSuma.setText(resultado.toString())
        btnVolver.setOnClickListener{finish()}
    }
}
