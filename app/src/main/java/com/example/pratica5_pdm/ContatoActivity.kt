package com.example.pratica5_pdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class ContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        val btnTelefone = findViewById<Button>(R.id.btnTelefone)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnLinkedIn = findViewById<Button>(R.id.btnLinkedIn)
        val btnPartilhar = findViewById<Button>(R.id.btnPartilhar)


        btnTelefone.setOnClickListener {
            val uri = ("tel:38997527519").toUri()
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)

        }

        btnEmail.setOnClickListener {
            val uri = ("mailto:arthurgoncalves.profissional@gmail.com").toUri()
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(intent)
        }


        btnLinkedIn.setOnClickListener {
            val uri = ("https://www.linkedin.com/in/arthur-gon%C3%A7alves-reis-b5a720371/").toUri()
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }
        btnPartilhar.setOnClickListener {
            val textoPartilha = "Arthur - Analista de Sistemas\nTelefone: (38) 9 9752-7519\nE-mail: arthurgoncalves.profissional@gmail.com"
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textoPartilha)
            }
            val chooser = Intent.createChooser(intent, "Partilhar via")
            startActivity(chooser)
        }
    }
}