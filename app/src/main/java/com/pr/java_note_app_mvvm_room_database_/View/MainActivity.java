package com.pr.java_note_app_mvvm_room_database_.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.pr.java_note_app_mvvm_room_database_.Model.Data.AppDatabase;
import com.pr.java_note_app_mvvm_room_database_.Model.Data.NoteDao;
import com.pr.java_note_app_mvvm_room_database_.Model.Note;
import com.pr.java_note_app_mvvm_room_database_.ViewModel.MainViewModel;
import com.pr.java_note_app_mvvm_room_database_.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    public static NoteDao noteDao;
    MainViewModel mainViewModel;
    ActivityMainBinding binding;
    NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "note").allowMainThreadQueries().build();
        noteDao =appDatabase.userDao();
        binding.recyclerview1.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        binding.floatingbutton.setOnClickListener(v -> {
             startActivity(new Intent(MainActivity.this,MainActivity2.class));
        });

        mainViewModel= new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
        mainViewModel.getallnotelivedata().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter=new NoteAdapter(MainActivity.this,(ArrayList<Note>) notes);
                binding.recyclerview1.setAdapter(noteAdapter);
            }
        });




    }
}