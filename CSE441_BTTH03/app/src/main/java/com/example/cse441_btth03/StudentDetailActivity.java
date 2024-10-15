package com.example.cse441_btth03;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {

    private TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        tvDetails = findViewById(R.id.tvDetails);

        Student student = (Student) getIntent().getSerializableExtra("student");
        displayStudentDetails(student);
    }

    private void displayStudentDetails(Student student) {
        String details = "ID: " + student.getId() + "\n" +
                "Họ và tên: " + student.getFullName() + "\n" +
                "Giới tính: " + student.getGender() + "\n" +
                "Ngày sinh: " + student.getBirth_date() + "\n" +
                "Email: " + student.getEmail() + "\n" +
                "Địa chỉ: " + student.getAddress() + "\n" +
                "Chuyên ngành: " + student.getMajor() + "\n" +
                "Điểm GPA: " + student.getGpa() + "\n" +
                "Năm học: " + student.getYear();

        tvDetails.setText(details);
    }
}
