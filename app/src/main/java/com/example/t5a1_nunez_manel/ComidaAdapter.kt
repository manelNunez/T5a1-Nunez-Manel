package com.example.t5a1_nunez_manel

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t5a1_nunez_manel.databinding.ItemComidaBinding

class ComidaAdapter (private val comidas: List<Comida>,private val
listener: OnClickListener):RecyclerView.Adapter<ComidaAdapter.ViewHolder>() {

    private lateinit var context: Context
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemComidaBinding.bind(view)

        fun setListener(comida:Comida) {
            binding.root.setOnClickListener { listener.onClick(comida) }
        }
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
            setListener(comida)
            binding.lblTitulo.text = comida.getNombre()
            binding.lblSubtitulo.text = comida.getPais()
            binding.imagen.setImageResource(comida.imageResource)
        }
    }

}