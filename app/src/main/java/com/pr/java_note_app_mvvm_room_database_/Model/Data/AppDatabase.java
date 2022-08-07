package com.pr.java_note_app_mvvm_room_database_.Model.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.pr.java_note_app_mvvm_room_database_.Model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao userDao();
}