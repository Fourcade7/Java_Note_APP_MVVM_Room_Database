package com.pr.java_note_app_mvvm_room_database_.View;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pr.java_note_app_mvvm_room_database_.Model.Note;
import com.pr.java_note_app_mvvm_room_database_.R;
import com.pr.java_note_app_mvvm_room_database_.databinding.RecyclerviewItemBinding;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    Context context;
    ArrayList<Note> noteArrayList;
    MainActivity mainActivity;

    public NoteAdapter(Context context, ArrayList<Note> noteArrayList) {
        this.context = context;
        this.noteArrayList = noteArrayList;
        mainActivity= (MainActivity) context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewItemBinding rbinding=RecyclerviewItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new NoteViewHolder(rbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        if (noteArrayList.get(position).isDone()){
            holder.recyclerviewItemBinding.checkbox1.setChecked(true);
            holder.recyclerviewItemBinding.textview1.setPaintFlags(holder.recyclerviewItemBinding.textview1.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        }else {
            holder.recyclerviewItemBinding.checkbox1.setChecked(false);
            holder.recyclerviewItemBinding.textview1.setPaintFlags(holder.recyclerviewItemBinding.textview1.getPaintFlags() & Paint.STRIKE_THRU_TEXT_FLAG);


        }

        holder.recyclerviewItemBinding.textview1.setText(noteArrayList.get(position).getMessage());
        holder.recyclerviewItemBinding.checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.recyclerviewItemBinding.checkbox1.isChecked()){
                    Note note= noteArrayList.get(position);
                    note.setDone(true);
                    mainActivity.noteDao.update(note);
                }else {
                    Note note= noteArrayList.get(position);
                    note.setDone(false);
                    mainActivity.noteDao.update(note);
                }

            }
        });

        holder.recyclerviewItemBinding.relativelay1.setOnClickListener(v -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(context,R.style.RoundedCornersDialog);
            builder.setTitle("Information");
            builder.setIcon(R.drawable.ic_round_info_24);
            builder.setMessage(noteArrayList.get(position).getMessage()+"\n"+noteArrayList.get(position).getDatatime());
            builder.setPositiveButton("Ok",null);
            builder.create().show();
        });

        holder.recyclerviewItemBinding.relativelay1.setOnLongClickListener(v -> {

            AlertDialog.Builder builder=new AlertDialog.Builder(context,R.style.RoundedCornersDialog);
            builder.setTitle("Delete");
            builder.setIcon(R.drawable.ic_round_delete_242);
            builder.setMessage(noteArrayList.get(position).getMessage()+"\n"+noteArrayList.get(position).getDatatime());
            builder.setPositiveButton("Yes", (dialog, which) -> {
                mainActivity.noteDao.delete(noteArrayList.get(position));

            });
            builder.setNegativeButton("No",(dialog, which) -> {

            });
            builder.setNeutralButton("Cancel",null);
            builder.create().show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewItemBinding recyclerviewItemBinding;
        public NoteViewHolder(RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            recyclerviewItemBinding=binding;

        }
    }
}
