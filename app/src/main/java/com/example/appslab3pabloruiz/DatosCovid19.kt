package com.example.appslab3pabloruiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.appslab3pabloruiz.databinding.ActivityDatosCovid19Binding
/**
 * <h1>DatosCovid19</h1>
 *<p>
 * Class that contains the functionalities that display the information requested by the user
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-19
 **/
class DatosCovid19 : AppCompatActivity() {

    // Uses databinding
    private lateinit var binding: ActivityDatosCovid19Binding
    private val selectedAttribute: CovidDataClass = CovidDataClass()

    /**
     * Builds the app initialization displays the information requested
     * @param savedInstanceState saved App data
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Gets which button was pressed
        val selectedInformation = intent.getStringExtra("buttonPressed")

        // Sets elements of selectedAttributes according to the user request
        when(selectedInformation) {
            "virus" -> {
                selectedAttribute.title = "Virus Covid-19"
                selectedAttribute.subtitle = "\n\nCovid-19, tambien conocido como: Coronavirus\n\n"
                selectedAttribute.description = "Información general:\n \n" +
                        "Una persona puede contraer la COVID-19 por contacto con otra que esté " +
                        "infectada por el virus. La enfermedad puede propagarse de persona a persona" +
                        " a través de las gotículas procedentes de la nariz o la boca que salen " +
                        "despedidas cuando una persona infectada tose o exhala. Estas gotículas caen " +
                        "sobre los objetos y superficies que rodean a la persona, de modo que otras " +
                        "personas pueden contraer la COVID-19 si tocan estos objetos o superficies y " +
                        "luego se tocan los ojos, la nariz o la boca. También pueden contagiarse si " +
                        "inhalan las gotículas que haya esparcido una persona con COVID-19 al toser o " +
                        "exhalar. Por eso es importante mantenerse a más de 1 metro (3 pies) de " +
                        "distancia de una persona que se encuentre enferma.\n" +
                        "\n" +
                        "La COVID-19 es la enfermedad infecciosa causada por el coronavirus que se " +
                        "ha descubierto más recientemente. Tanto el nuevo virus como la enfermedad" +
                        " eran desconocidos antes de que estallara el brote en Wuhan (China) en " +
                        "diciembre de 2019." +
                        "\n \n Formas de contagio:\n \n " +
                        "Una persona puede contraer la COVID-19 por contacto con otra que esté " +
                        "infectada por el virus. La enfermedad puede propagarse de persona a persona" +
                        " a través de las gotículas procedentes de la nariz o la boca que salen " +
                        "despedidas cuando una persona infectada tose o exhala. Estas gotículas caen " +
                        "sobre los objetos y superficies que rodean a la persona, de modo que otras " +
                        "personas pueden contraer la COVID-19 si tocan estos objetos o superficies y" +
                        " luego se tocan los ojos, la nariz o la boca. También pueden contagiarse si" +
                        " inhalan las gotículas que haya esparcido una persona con COVID-19 al toser " +
                        "o exhalar. Por eso es importante mantenerse a más de 1 metro (3 pies) de " +
                        "distancia de una persona que se encuentre enferma.\n" +
                        "\n" +
                        "La OMS está estudiando las investigaciones en curso sobre las formas de " +
                        "propagación de la COVID-19 y seguirá informando sobre los resultados actualizados." +
                        "(OMS, 2020).\n\n"
            }
            "symptoms" -> {
                selectedAttribute.title = "Sintomas del Covid-19"
                selectedAttribute.subtitle = "\n\nSintomas del coronavirus\n\n"
                selectedAttribute.description = "Los síntomas más comunes de la COVID-19 son: \n \n" +
                        "-Fiebre \n-Cansancio \n-Tos seca \n \n" +
                        "Algunos pacientes pueden presentar dolores, congestión nasal, rinorrea," +
                        " dolor de garganta o diarrea. Estos síntomas suelen ser leves y aparecen" +
                        " de forma gradual. Algunas personas se infectan pero no desarrollan ningún" +
                        " síntoma y no se encuentran mal. La mayoría de las personas " +
                        "(alrededor del 80%) se recupera de la enfermedad sin necesidad" +
                        " de realizar ningún tratamiento especial. Alrededor de 1 de cada 6" +
                        " personas que contraen la COVID-19 desarrolla una enfermedad grave" +
                        " y tiene dificultad para respirar. Las personas mayores y las que" +
                        " padecen afecciones médicas subyacentes, como hipertensión arterial," +
                        " problemas cardiacos o diabetes, tienen más probabilidades de desarrollar" +
                        " una enfermedad grave. En torno al 2% de las personas que han contraído " +
                        "la enfermedad han muerto. Las personas que tengan fiebre, tos y dificultad" +
                        " para respirar deben buscar atención médica (OMS, 2020).\n\n"
            }
            "indications" -> {
                selectedAttribute.title = "Indicaciones para el Covid-19"
                selectedAttribute.subtitle = "\n\nMedidas a tomar para protegerse del virus\n\n"
                selectedAttribute.description = "Medidas de protección para todas las personas \n" +
                        "\n" +
                        "Manténgase al día de la información más reciente sobre el brote de" +
                        " COVID-19, a la que puede acceder en el sitio web de la OMS y a través de " +
                        "las autoridades de salud pública pertinentes a nivel nacional y local. Se" +
                        " han registrado casos en muchos países de todo el mundo, y en varios de " +
                        "ellos se han producido brotes. Las autoridades chinas y las de otros" +
                        " países han conseguido enlentecer o detener el avance de los brotes," +
                        " pero la situación es impredecible y es necesario comprobar con " +
                        "regularidad las noticias más recientes.\n" +
                        "\n" +
                        "Hay varias precauciones que se pueden adoptar para reducir la probabilidad " +
                        "de contraer o de contagiar la COVID-19:\n" +
                        "\n" +
                        "    Lávese las manos a fondo y con frecuencia usando un desinfectante a " +
                        "base de alcohol o con agua y jabón.\n" +
                        "\n" +
                        "¿Por qué? Lavarse las manos con agua y jabón o usando un desinfectante a" +
                        " base de alcohol mata los virus que pueda haber en sus manos.\n" +
                        "\n" +
                        "    Mantenga una distancia mínima de 1 metro (3 pies) entre usted y " +
                        "cualquier persona que tosa o estornude.\n" +
                        "\n" +
                        "¿Por qué? Cuando alguien tose o estornuda, despide por la nariz o por la" +
                        " boca unas gotículas de líquido que pueden contener el virus. Si está" +
                        " demasiado cerca, puede respirar las gotículas y con ellas el virus de " +
                        "la COVID-19, si la persona que tose tiene la enfermedad.\n" +
                        "\n" +
                        "    Evite tocarse los ojos, la nariz y la boca\n" +
                        "\n" +
                        "¿Por qué? Las manos tocan muchas superficies y pueden recoger virus. Una " +
                        "vez contaminadas, las manos pueden transferir el virus a los ojos, la" +
                        " nariz o la boca. Desde allí, el virus puede entrar en su cuerpo y " +
                        "causarle la enfermedad.\n" +
                        "\n" +
                        "    Tanto usted como las personas que les rodean deben asegurarse de " +
                        "mantener una buena higiene de las vías respiratorias. Eso significa" +
                        " cubrirse la boca y la nariz con el codo doblado o con un pañuelo de" +
                        " papel al toser o estornudar. El pañuelo usado debe desecharse de" +
                        " inmediato.\n" +
                        "\n" +
                        "¿Por qué? Los virus se propagan a través de las gotículas. Al mantener" +
                        " una buena higiene respiratoria está protegiendo a las personas que le " +
                        "rodean de virus como los del resfriado, la gripe y la COVID-19.\n" +
                        "\n" +
                        "    Permanezca en casa si no se encuentra bien. Si tiene fiebre, tos " +
                        "y dificultad para respirar, busque atención médica y llame con " +
                        "antelación. Siga las instrucciones de las autoridades sanitarias" +
                        " locales.\n" +
                        "\n" +
                        "¿Por qué? Las autoridades nacionales y locales dispondrán " +
                        "de la información más actualizada sobre la situación en su zona. Llamar" +
                        " con antelación permitirá que su dispensador de atención de salud le" +
                        " dirija rápidamente hacia el centro de salud adecuado. Esto también le" +
                        " protegerá a usted y ayudará a prevenir la propagación de virus y otras " +
                        "infecciones.\n" +
                        "\n" +
                        "    Manténgase informado sobre las últimas novedades en relación con la" +
                        " COVID-19. Siga los consejos de su dispensador de atención de salud, de " +
                        "las autoridades sanitarias pertinentes a nivel nacional y local o de su " +
                        "empleador sobre la forma de protegerse a sí mismo y a los demás ante la " +
                        "COVID-19.\n" +
                        "\n" +
                        "¿Por qué? Las autoridades nacionales y locales dispondrán de la" +
                        "información más actualizada acerca de si la COVID-19 se está propagando " +
                        "en su zona. Son los interlocutores más indicados para dar consejos sobre" +
                        " lo que debe hacer la gente de su zona para protegerse.\n" +
                        "\n" +
                        "    Consulte las noticias más recientes sobre las zonas de mayor peligro " +
                        "(es decir, las ciudades y lugares donde la enfermedad se está propagando" +
                        " más extensamente). Si le es posible, evite desplazarse a estas zonas," +
                        " sobre todo si su edad es avanzada o tiene usted diabetes, cardiopatías" +
                        " o neumopatías.\n" +
                        "\n" +
                        "¿Por qué? Estas precauciones se deben adoptar en estas zonas porque la " +
                        "probabilidad de contraer la COVID-19 es más elevada.\n" +
                        "\n" +
                        "Medidas de protección para las personas que se encuentran en zonas donde" +
                        " se está propagando la COVID-19 o que las han visitado recientemente" +
                        " (en los últimos 14 días)\n" +
                        "\n" +
                        "    Siga las orientaciones antes expuestas (Medidas de protección para" +
                        " todas las personas)\n" +
                        "\n" +
                        "    Permanezca en casa si empieza a encontrarse mal, aunque se trate " +
                        "de síntomas leves como dolor de cabeza, fiebre ligera (37,3 oC o más) " +
                        "y rinorrea leve, hasta que se recupere. Si le resulta indispensable salir" +
                        " de casa o recibir una visita (por ejemplo, para conseguir alimentos)," +
                        " póngase una mascarilla para no infectar a otras personas.\n" +
                        "\n" +
                        "¿Por qué? Evitar los contactos con otras personas y las visitas a centros" +
                        " médicos permitirá que estos últimos funcionen con mayor eficacia y " +
                        "ayudará a protegerle a usted y a otras personas de posibles infecciones " +
                        "por el virus de la COVID-19 u otros.\n" +
                        "\n" +
                        "    Si tiene fiebre, tos y dificultad para respirar, busque rápidamente" +
                        " asesoramiento médico, ya que podría deberse a una infección respiratoria" +
                        " u otra afección grave. Llame con antelación e informe a su dispensador " +
                        "de atención de salud sobre cualquier viaje que haya realizado " +
                        "recientemente o cualquier contacto que haya mantenido con viajeros.\n" +
                        "\n" +
                        "¿Por qué? Llamar con antelación permitirá que su dispensador de atención " +
                        "de salud le dirija rápidamente hacia el centro de salud adecuado. Esto " +
                        "ayudará también a prevenir la propagación de virus y otras infecciones (OMS, 2020).\n\n"
            }
        }

        // Data binding content applied to the activity
        binding = DataBindingUtil.setContentView(this, R.layout.activity_datos_covid19)
        binding.selectedAttribute = selectedAttribute   // Updates the variable to show
        binding.publishButton.setOnClickListener{publishButton(it)}     // To pubish a comment
        binding. apply {
            invalidateAll()
        }
    }

    /**
     * Initializes main activity and sends the comment to it
     * @param view
     */
    private fun publishButton(view: View?) {
        val mainActivity = Intent(this, MainActivity::class.java)
        mainActivity.putExtra("comment", binding.comment.text.toString())
        startActivity(mainActivity)
    }
}
