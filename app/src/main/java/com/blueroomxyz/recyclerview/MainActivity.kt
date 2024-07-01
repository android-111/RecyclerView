package com.blueroomxyz.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blueroomxyz.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = mutableListOf<Note>(
            Note("Saturday Meeting!!",true),
            Note("Call tomorrow",false),
            Note("Incoming sunday go for outing",false),
            Note("Saturday Meeting!!",true),
            Note("Call tomorrow",false),
            Note("Incoming sunday go for outing",false),
        )

        val adapter = NoteAdapter(list,this@MainActivity)
        binding.mRecyclerView.adapter = adapter
        val layoutManger = LinearLayoutManager(this@MainActivity)
        binding.mRecyclerView.layoutManager = layoutManger
        layoutManger.reverseLayout = true
        layoutManger.stackFromEnd = true

        binding.button.setOnClickListener {
            val text = binding.editTextText.text.toString()
            val note = Note(text,false)
            list.add(note)
            adapter.notifyItemInserted(list.size - 1)
            binding.editTextText.setText("")
        }

    }
}