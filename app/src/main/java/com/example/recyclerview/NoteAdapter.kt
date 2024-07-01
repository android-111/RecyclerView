package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.NoteDesignRvBinding

class NoteAdapter(private val list: MutableList<Note>, private val context: Context):RecyclerView.Adapter<NoteAdapter.ViewHolder>(){

    class ViewHolder(val binding: NoteDesignRvBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = NoteDesignRvBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.noteTv.text = list[position].noteText
        holder.binding.checkbox.isChecked = list[position].isChecked

    }

}