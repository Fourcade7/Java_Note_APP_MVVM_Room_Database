package com.pr.java_note_app_mvvm_room_database_.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.pr.java_note_app_mvvm_room_database_.View.MainActivity;
import com.pr.java_note_app_mvvm_room_database_.Model.Note;

import java.util.List;

public class MainViewModel extends ViewModel {


    public LiveData<List<Note>> getallnotelivedata(){
        return MainActivity.noteDao.getAll();
    }


}
