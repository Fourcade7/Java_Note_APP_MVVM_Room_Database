package com.pr.java_note_app_mvvm_room_database_.Model.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.pr.java_note_app_mvvm_room_database_.Model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAll();

    @Query("SELECT * FROM Note WHERE uid LIKE:uid LIMIT 1")
    Note findByName(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Note... users);

    @Update
    void update(Note... notes);

    @Delete
    void delete(Note user);

}
