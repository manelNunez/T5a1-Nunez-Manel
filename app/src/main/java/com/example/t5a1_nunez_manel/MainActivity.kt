package com.example.t5a1_nunez_manel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5a1_nunez_manel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var comidaAdapter: ComidaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        comidaAdapter = ComidaAdapter(ComidaDatos.COMIDAS)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerId.apply {
            layoutManager = linearLayoutManager
            adapter = comidaAdapter
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}