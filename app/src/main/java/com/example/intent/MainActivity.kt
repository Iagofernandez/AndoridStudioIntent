package com.example.intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import java.lang.Integer.parseInt

const val SUMA_REQUEST = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUrl.setOnClickListener{browse("http://www.google.com")}

        btnRojo.setOnClickListener{CambiarColor(it)}
        button6.setOnClickListener{CambiarColor(it)}
        btnSuma.setOnClickListener{suma(it)}


    }
    //PARA EL CAMBIO DE COLOR
    //SE EMPLEA UN BOTON AUXILIAR
    fun CambiarColor(v:View){

        val apoyo = v as Button
        //ESTE INTENT NOS PERMITE ACCEDER A OTRA ACTIVITY Y PASARLE DATOS DEESTA ACTIVITY
        val nuevoIntent = Intent(this, ActivityDetalle::class.java)
        //CONDICIONALES PARA PASARLE UN STRINg QUE SE USARA EN LA OTRA ACTIVITY
        if(apoyo==button6){
            nuevoIntent.putExtra("color","amarillo")
            startActivity(nuevoIntent)
        }else if(apoyo==btnRojo){
            nuevoIntent.putExtra("color", "rojo")
            startActivity(nuevoIntent)
        }
    }
//SUMA DE VALORES IMPRESOS EN UNA CAJA
    fun suma (v:View){
        val apoyo = v as Button
        val nuevoIntent = Intent(this, ActivitySuma::class.java)

    //NECESITAMOS QUE SEAN TOSTRING Y LUEGO SON TARNSFORMADOS EN UN INT
        nuevoIntent.putExtra("num1", parseInt(num1Input.text.toString()))
        nuevoIntent.putExtra("num2", parseInt(num2Input.text.toString()))


        //ESTO ES NECESARIO PUESTO QUE AHORA SE NECESITAN RECOGER DATOS DE OTRA ACTIVITY EXTRA
        //QUE ES EL RESULTADO
        startActivityForResult(nuevoIntent, SUMA_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==SUMA_REQUEST){
            if(resultCode== Activity.RESULT_OK){
                if(data!=null) {
                    resultado1.setText(data.getIntExtra("result", 0).toString())
                }
            }
        }
    }

}
