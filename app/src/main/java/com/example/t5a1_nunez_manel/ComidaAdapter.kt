package com.example.t5a1_nunez_manel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t5a1_nunez_manel.databinding.ItemComidaBinding

class ComidaAdapter (private val comidas: List<Comida>):RecyclerView.Adapter<ComidaAdapter.ViewHolder>() {

    private lateinit var context: Context
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemComidaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_comida, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = comidas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comida = comidas.get(position)
        with(holder){
            println(comidas.size)
            binding.lblTitulo.text = comida.getNombre()
            binding.lblSubtitulo.text = comida.getPais()
        }
    }

}