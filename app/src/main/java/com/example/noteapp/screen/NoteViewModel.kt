package com.example.noteapp.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepositiry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)

@HiltViewModel
class NoteViewModel @Inject constructor(private val repositiry: NoteRepositiry) : ViewModel() {

        private val _noteList = MutableStateFlow<List<Note>>(emptyList())
        val noteList = _noteList.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            repositiry.getAllNotes().distinctUntilChanged()
                .collect{ listOfNotes ->
                    if(listOfNotes.isNullOrEmpty()){
                        Log.d("Empty",": Empty list")
                    } else{
                        _noteList.value = listOfNotes
                    }

                }
        }
//        noteList.addAll(NotesDataSource().loadNotes())
    }

//    fun addNote(note: Note){
//        noteList.add(note)
//    }
      fun addNote(note: Note) = viewModelScope.launch{repositiry.addNote(note) }
     fun updateNote(note: Note) = viewModelScope.launch{repositiry.updateNote(note) }
      fun removeNote(note: Note) = viewModelScope.launch{repositiry.deleteNote(note) }



//        fun removeNote(note: Note){
//        noteList.remove(note)
//    }
//    fun getAllNotes(): List<Note>{
//        return noteList
//    }

}
