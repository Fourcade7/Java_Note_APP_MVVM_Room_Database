package com.pr.java_note_app_mvvm_room_database_.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pr.java_note_app_mvvm_room_database_.Model.Note;
import com.pr.java_note_app_mvvm_room_database_.R;
import com.pr.java_note_app_mvvm_room_database_.databinding.ActivityMain2Binding;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button1.setOnClickListener(v -> {
            Calendar calendar=Calendar.getInstance();
            int year=calendar.get(Calendar.YEAR);
            int month=calendar.get(Calendar.MONTH);
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            int hour=calendar.get(Calendar.HOUR_OF_DAY);
            int minute=calendar.get(Calendar.MINUTE);

            Note note=new Note();
            note.setMessage(binding.edittext1.getText().toString());
            note.setDatatime(day+"/"+month+"/"+year+" "+hour+":"+minute);
            MainActivity.noteDao.insert(note);
            Toast.makeText(MainActivity2.this, "Saved Succesfully !", Toast.LENGTH_SHORT).show();
            binding.edittext1.setText("");
        });


    }
}