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
/**
 * <h1>MainActivity</h1>
 *<p>
 * Class that shows risk factor of the user and allows to navigate to information about Covid-19
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-19
 **/
class MainActivity : AppCompatActivity() {
    // Uses data binding
    private lateinit var binding: ActivityMainBinding
    private val buttonPressed = "buttonPressed" // Used to not write "buttonPressed" multiple times

    /**
     * Builds the app initialization displays the information requested
     * @param savedInstanceState saved App data
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Setting click listeners
        binding.virusButton.setOnClickListener{virusButton()}
        binding.symptomsButton.setOnClickListener{symptomsButton()}
        binding.indicationsButton.setOnClickListener{indicationsButton()}
        binding.star.setOnClickListener{starButton(it)}

        // Gets the comment from previous activity
        val comment = intent.getStringExtra("comment")

        // Displays it only if its valid
        if(comment != "" && comment != null) {
            Toast.makeText(this, comment, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * The following 3 functions load the next activity and indicate which button was pressed
     */
    private fun virusButton() {
        val displayData = Intent(this, DatosCovid19::class.java)
        displayData.putExtra(buttonPressed, "virus")
        startActivity(displayData)
    }

    private fun symptomsButton() {
        val displayData = Intent(this, DatosCovid19::class.java)
        displayData.putExtra(buttonPressed, "symptoms")
        startActivity(displayData)
    }

    private fun indicationsButton() {
        val displayData = Intent(this, DatosCovid19::class.java)
        displayData.putExtra(buttonPressed, "indications")
        startActivity(displayData)
    }

    /**
     * Displays or hides risk factor results according to age
     * @param view
     */
    private fun starButton(view: View?) {

        binding.apply {
            // Does this if risk factor is not visible
            if(personalRisk.visibility == View.GONE) {
                var age = -1
                var name = ""
                lateinit var message: String
                lateinit var riesgo: String

                // Tires to get the values introduced
                try {
                    name = nameText.text.toString()
                    age = ageText.text.toString().toInt()
                } catch (e: Exception) {
                    // Does nothing in exception as variable definition serves for this purpose
                }

                // Only if values are valid,
                if(name != "" && age in 0..120) {
                    // Gets the risk factor according to age
                    if(age in 0..29) {
                        riesgo = "bajo"
                    } else if (age in 30..59) {
                        riesgo = "moderado"
                    } else {
                        riesgo = "alto"
                    }

                    // Formats it into a message
                    message = "$name, con $age años, te encuentras en riesgo $riesgo"

                    // Hides the inputs and displays the message
                    ageTag.visibility = View.GONE
                    nameTag.visibility = View.GONE
                    ageText.visibility = View.GONE
                    nameText.visibility = View.GONE
                    personalRisk.text = message
                    personalRisk.visibility = View.VISIBLE
                // If input is not valid
                } else {
                    Toast.makeText(this@MainActivity,
                        "Por favor revise que el nombre no se encuentre vacio y que la edad sea entre 0 y 120", Toast.LENGTH_SHORT).show()
                }
            // The risk factor was visible
            } else {
                // Clears previous inputs
                nameText.text.clear()
                ageText.text.clear()

                // Sets the inputs visible and hides the risk result
                ageTag.visibility = View.VISIBLE
                nameTag.visibility = View.VISIBLE
                ageText.visibility = View.VISIBLE
                nameText.visibility = View.VISIBLE
                personalRisk.visibility = View.GONE
            }
        }

        // Hides the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }


}
