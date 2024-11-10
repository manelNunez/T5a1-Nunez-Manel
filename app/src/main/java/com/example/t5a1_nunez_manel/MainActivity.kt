package com.example.t5a1_nunez_manel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5a1_nunez_manel.databinding.ActivityMainBinding
import com.example.t5a1_nunez_manel.databinding.ActivityWikipediaBinding

class MainActivity : AppCompatActivity(),OnClickListener {

    private lateinit var comidaAdapter: ComidaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemDecoration: DividerItemDecoration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        comidaAdapter = ComidaAdapter(ComidaDatos.COMIDAS,this)
        itemDecoration = DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerId.apply {
            layoutManager = linearLayoutManager
            adapter = comidaAdapter
            addItemDecoration(itemDecoration)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(comida: Comida) {


        val comidaNombre = comida.getNombre().replace(" ", "_")

        Toast.makeText(this, comidaNombre, Toast.LENGTH_SHORT).show()

        var url = "https://es.wikipedia.org/wiki/"



        val intent = Intent(this, WikipediaActivity::class.java)
        intent.putExtra("comidaNombre", comidaNombre)
        intent.putExtra("urlComida", url)
        startActivity(intent)
    }

}