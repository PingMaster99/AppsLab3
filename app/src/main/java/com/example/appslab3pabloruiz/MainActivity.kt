package com.example.appslab3pabloruiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.appslab3pabloruiz.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val buttonPressed = "buttonPressed"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.virusButton.setOnClickListener{virusButton(it)}
        binding.symptomsButton.setOnClickListener{symptomsButton(it)}
        binding.indicationsButton.setOnClickListener{indicationsButton(it)}
        binding.star.setOnClickListener{starButton(it)}
        val comment = intent.getStringExtra("comment")

        if(comment != "" && comment != null) {
            Toast.makeText(this, comment, Toast.LENGTH_SHORT).show()
        }
    }

    private fun virusButton(view: View?) {
        val displayData = Intent(this, DatosCovid19::class.java)
        displayData.putExtra(buttonPressed, "virus")
        startActivity(displayData)
    }

    private fun symptomsButton(view: View?) {
        val displayData = Intent(this, DatosCovid19::class.java)
        displayData.putExtra(buttonPressed, "symptoms")
        startActivity(displayData)
    }

    private fun indicationsButton(view: View?) {
        val displayData = Intent(this, DatosCovid19::class.java)
        displayData.putExtra(buttonPressed, "indications")
        startActivity(displayData)
    }

    private fun starButton(view: View?) {

        binding.apply {

            if(personalRisk.visibility == View.GONE) {
                var age = -1
                var name = ""
                lateinit var message: String
                lateinit var riesgo: String

                try {
                    name = nameText.text.toString()
                    age = ageText.text.toString().toInt()
                } catch (e: Exception) {
                }

                if(name != "" && age in 0..120) {
                    if(age in 0..29) {
                        riesgo = "bajo"
                    } else if (age in 30..59) {
                        riesgo = "moderado"
                    } else {
                        riesgo = "alto"
                    }

                    message = "$name, con $age años, te encuentras en riesgo $riesgo"
                    ageTag.visibility = View.GONE
                    nameTag.visibility = View.GONE
                    ageText.visibility = View.GONE
                    nameText.visibility = View.GONE
                    personalRisk.text = message
                    personalRisk.visibility = View.VISIBLE
                } else {
                    Toast.makeText(this@MainActivity,
                        "Por favor revise que el nombre no se encuentre vacio y que la edad sea entre 0 y 120", Toast.LENGTH_SHORT).show()
                }

            } else {
                nameText.text.clear()
                ageText.text.clear()
                ageTag.visibility = View.VISIBLE
                nameTag.visibility = View.VISIBLE
                ageText.visibility = View.VISIBLE
                nameText.visibility = View.VISIBLE
                personalRisk.visibility = View.GONE
            }
        }

        // Esconde el teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }


}
