package com.example.ex05;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bước 1: Lấy EditText và Button
        EditText editNamDuong = findViewById(R.id.editnamduonglich);
        Button buttonChuyenDoi = findViewById(R.id.button1);
        TextView textNamAm = findViewById(R.id.textView3);

        // Thiết lập sự kiện khi nhấn nút
        buttonChuyenDoi.setOnClickListener(view -> {
            String namDuongStr = editNamDuong.getText().toString();

            try {
                // Bước 2: Ép giá trị nhập vào về số nguyên
                int namDuong = Integer.parseInt(namDuongStr);

                // Bước 3: Tính năm âm lịch dựa trên Can - Chi
                String[] can = {"Giáp", "Ất", "Bính", "Đinh", "Mậu",
                        "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
                String[] chi = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ",
                        "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

                // Tính Can và Chi
                int indexCan = (namDuong + 6) % 10;  // +6 để khớp với chu kỳ Can bắt đầu từ Giáp
                int indexChi = (namDuong + 8) % 12;  // +8 để khớp với chu kỳ Chi bắt đầu từ Tý

                String canChi = can[indexCan] + " " + chi[indexChi];

                // Hiển thị kết quả vào TextView
                textNamAm.setText(canChi);

            } catch (NumberFormatException e) {
                // Xử lý ngoại lệ khi người dùng nhập sai định dạng
                Toast.makeText(MainActivity.this,
                        "Vui lòng nhập một số nguyên hợp lệ!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
