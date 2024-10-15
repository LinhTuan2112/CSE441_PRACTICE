package com.example.cse441_btth03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;
    private OnStudentClickListener listener;


    public interface OnStudentClickListener {
        void onStudentClick(Student student);
    }
    public StudentAdapter(OnStudentClickListener listener, List<Student> studentList) {
        this.listener = listener;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvFullName.setText(student.getFullName().getLast() + " "  + student.getFullName().getFirst());
        holder.tvGpa.setText(String.valueOf(student.getGpa()));

        // Hiển thị icon theo giới tính
        if (student.getGender().equals("Nữ")) {
            holder.imgGender.setImageResource(R.drawable.ic_female);
        } else {
            holder.imgGender.setImageResource(R.drawable.ic_male);
        }

        holder.itemView.setOnClickListener(v -> listener.onStudentClick(student));
    }
    
    @Override
    public int getItemCount() {
        return studentList.size();
    }
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName, tvGpa;
        ImageView imgGender;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvGpa = itemView.findViewById(R.id.tvGpa);
            imgGender = itemView.findViewById(R.id.imgGender);
        }
    }

}
