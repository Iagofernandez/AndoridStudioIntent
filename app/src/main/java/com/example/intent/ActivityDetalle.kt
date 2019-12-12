package com.example.intent

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class ActivityDetalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        //EN ESTA ACTIVITY MEDIANTE UNA VARIABLE LE INDICAMOS A QUE COLOR DEBE CAMBIAR
        //RELACIONAMOS LOS DOS BOTONES DE COLORES CON ESTA ACTIVITY
        //CUANDO SE PULSA EL BTNROJO POR EJEMPLO
        //LA MAIN LE PASA EL VALOR "ROJO" STRING
        //ESTA ACTIVITY LO RECOGE Y AL VER QUE ESTA EL STRNG "ROJO"
        //SE DIRJE A LA PARTE DEL CONDICIONAL QUE PONE VALOR(QUE ES QUIEN RECOGE LE VALOR Y LO ALMACENA
        // LA ACTIVA
        val valor = intent.getStringExtra("color")
        textoColor.setText("valor")

        if(valor=="amarillo"){
            textoColor.setTextColor(Color.YELLOW)
        }else if(valor=="rojo"){
            textoColor.setTextColor(Color.RED)
        }
    }
}
