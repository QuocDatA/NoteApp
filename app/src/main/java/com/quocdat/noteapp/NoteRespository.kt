package com.quocdat.noteapp

import androidx.lifecycle.LiveData

class NoteRespository(private val noteDao: NoteDao) {

    val allNote: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun update(note: Note){
        noteDao.update(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}