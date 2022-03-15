package com.quocdat.noteapp

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    val context: Context,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickInterface: NoteClickInterface)
    : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNoteTitle = itemView.findViewById<TextView>(R.id.tvNotesTitle)
        val tvTimeStamp = itemView.findViewById<TextView>(R.id.tvTimeStamp)
        val ivDelete = itemView.findViewById<ImageView>(R.id.ivDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNoteTitle.setText(allNotes.get(position).noteTitle)
        holder.tvTimeStamp.setText("Last update: " + allNotes.get(position).timeStamp)

        holder.ivDelete.setOnClickListener(){
            noteClickDeleteInterface.onClickDeleteIcon(allNotes.get(position))
        }

        holder.itemView.setOnClickListener(){
            noteClickInterface.onClickNote(allNotes.get(position))
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface{
    fun onClickDeleteIcon(note: Note)
}

interface NoteClickInterface{
    fun onClickNote(note: Note)
}