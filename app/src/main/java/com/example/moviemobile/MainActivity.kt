// Student Name: Anaz Afsal
//Student ID: 71396

package com.example.moviemobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain and fill data for the Movie class
        val movies = arrayOf(
            Movie(
                "KUNG FU PANDA 4",
                "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/a223aaeb-6a2d-4561-92f0-e3efa105a21e_kung-fu-panda-4_posters_kf4_intl_dgtl_payoff_1sheet_uk_712px.jpg?mw=450&rev=7239547d058742c7b4ee0899fe51c29e",
                "PG",
                "After Po is tapped to become the Spiritual Leader of the Valley of Peace, he needs to find and train a new Dragon Warrior, while a wicked sorceress plans to re-summon all the master villains whom Po has vanquished to the spirit realm.",
                arrayOf(
                    "Jack Black",
                    "Awkwafina",
                    "Viola David",
                    "Dustin Hoffman",
                    "Bryan Cranston",
                    "Mr. Beast"
                ),
                (Math.random() * 16).toInt(),
                94
            ),
            Movie(
                "CIVIL WAR",
                "https://www.myvue.com/-/jssmedia/vuecinemas/film-and-events/apr-2024/civil-war_sun_1sht_imax.jpg?mw=450&rev=6eb928814f0f4676a666f6f9552ff2e4",
                "15A",
                "In the near future, a team of journalists travel across the United States during a rapidly escalating civil war that has engulfed the entire nation.",
                arrayOf(
                    "Wagner Moura",
                    "Kirsten Dunst",
                    "Cailee Spaeny",
                    "Stephen McKinley Henderson"
                ),
                (Math.random() * 16).toInt(),
                109
            ),
            Movie(
                "GHOSTBUSTERS: FROZEN EMPIRE",
                "https://www.myvue.com/-/jssmedia/vuecinemas/film-and-events/feb-2024/ghostbusters-poster.jpg?mw=450&rev=890c7016efc4412293629c8d63844732",
                "12A",
                "In Ghostbusters: Frozen Empire, the Spengler family returns to where it all started – the iconic New York City firehouse – to team up with the original Ghostbusters.",
                arrayOf("Paul Rudd", "Bill Murray", "Finn Wolfhard", "Dan Aykroud", "Annie Potts", "Mckenna Grace", "Ernie Hudson"),
                (Math.random() * 16).toInt(),
                144
            ),
            Movie(
                "MIGRATION",
                "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/fddf86f4-a848-4ffd-9a05-b602edc77b70_migration_posters_mig_intl_dgtl_one_sheet_opt_1_landing_uk_712p.jpg?mw=450&rev=69acf0619d6946d596b112f278bf4bd5",
                "PG",
                "A family of ducks decides to leave the safety of a New England pond for an adventurous trip to Jamaica. However, their well-laid plans quickly go awry when they get lost and wind up in New York City.",
                arrayOf(
                    "Elizabeth Banks",
                    "Danny DeVito",
                    "Keegan-Michael Key",
                    "Kumail Nanjinani",
                    "Awkwafina"
                ),
                (Math.random() * 16).toInt(),
                110
            ),
            Movie(
                "DUNE: PART TWO",
                "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/7a7a20aa-1064-46fd-96cc-4b271268f2c5_dune-part-ii_posters_one-sheet_712px.jpg?mw=450&rev=c61dcb539042435c973daaeeb97100b6",
                "12A",
                "Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family.",
                arrayOf("Timothée Chalamet", "Florence Pugh", "Zendaya", "Souheila Yacoub", "Austin Butler"),
                (Math.random() * 3).toInt(),
                166
            ),
            Movie(
                "AADUJEEVITHAM - THE GOAT LIFE",
                "https://www.myvue.com/-/jssmedia/vuecinemas/img/import/4f0a5cff-2a8a-44cc-b666-e33b560ddaa9_aadujeevitham-malayalam_posters_aadujeevitham-1_712px.jpg?mw=450&rev=55474e2f43344f839e3d3f9f0eb250d5",
                "12A",
                "The real-life incident of an Indian migrant worker, Najeeb Muhammad, who goes to Saudi Arabia to earn money.",
                arrayOf("Ruseel Crowe", "Daniel Zovatto", "Franco Nero"),
                (Math.random() * 16).toInt(),
                161
            )
        )

        // Display the movies in a RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MovieAdapter(movies)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
