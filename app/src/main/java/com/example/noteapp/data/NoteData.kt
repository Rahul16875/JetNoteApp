package com.example.noteapp.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.noteapp.model.Note

class NotesDataSource{
    @RequiresApi(Build.VERSION_CODES.O)
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "A good day", description = "We went on a vacation "),
            Note(title = "A movie day", description = "We went on a movie date "),
            Note(title = "A sports day", description = "We played cricket "),
            Note(title = "A movie day", description = "We went on a movie date "),
            Note(title = "A movie day", description = "We went on a vacation "),
            Note(title = "A good day", description = "We went on a vacation "),

        )
    }
}