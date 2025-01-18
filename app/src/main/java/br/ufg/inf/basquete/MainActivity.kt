package br.ufg.inf.basquete

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var ptsA = 0
    private var ptsB = 0
    //Cria variavel do titpo do componente
    private lateinit var scoreA : TextView
    private lateinit var btn3ptA : Button
    private lateinit var btn2ptA : Button
    private lateinit var btn1ptA : Button
    private lateinit var scoreB : TextView
    private lateinit var btn3ptB : Button
    private lateinit var btn2ptB : Button
    private lateinit var btn1ptB : Button
    private lateinit var btnReset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Vincula variavel ao componente do layout
        btn3ptA = findViewById(R.id.btn3ptA)
        btn2ptA = findViewById(R.id.btn2ptA)
        btn1ptA = findViewById(R.id.btn1ptA)
        scoreA = findViewById(R.id.placarA)
        btn3ptB = findViewById(R.id.btn3ptB)
        btn2ptB = findViewById(R.id.btn2ptB)
        btn1ptB = findViewById(R.id.btn1ptB)
        scoreB = findViewById(R.id.placarB)
        btnReset = findViewById(R.id.btnReset)

        //Define OnClick dos botões
        btn3ptA.setOnClickListener { addPtos( "A", 3) }
        btn2ptA.setOnClickListener { addPtos( "A", 2) }
        btn1ptA.setOnClickListener { addPtos( "A", 1) }
        btn3ptB.setOnClickListener { addPtos( "B", 3) }
        btn2ptB.setOnClickListener { addPtos( "B", 2) }
        btn1ptB.setOnClickListener { addPtos( "B", 1) }
        btnReset.setOnClickListener { reset() }
    }

    fun addPtos( time : String, pontos : Int){
        if ( time == "A"){
            ptsA = ptsA + pontos
        }else if(time == "B"){
            ptsB = ptsB + pontos
        }
        updatePlacar(time)
    }

    fun updatePlacar(time : String){
        if ( time == "A"){
            scoreA.setText(ptsA.toString())
        }else if(time == "B"){
            scoreB.setText(ptsB.toString())
        }
    }

    fun reset(){
        ptsA = 0
        ptsB = 0
        updatePlacar("A")
        updatePlacar("B")
    }

}
