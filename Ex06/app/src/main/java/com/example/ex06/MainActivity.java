package com.example.ex06;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editHoten, editCMND, editBosung;
    private RadioGroup radioGroupBangCap;
    private RadioButton radDH;
    private CheckBox chkDocBao, chkDocSach, chkDocCode;
    private Button btnGuiTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        editHoten = findViewById(R.id.editHoten);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBoSung);
        radioGroupBangCap = findViewById(R.id.radioGroupBangCap);
        radDH = findViewById(R.id.radDaiHoc);
        radDH.setChecked(true); // Mặc định chọn "Đại học"

        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocCode = findViewById(R.id.chkDocCode);

        btnGuiTT = findViewById(R.id.btnGuiTT);

        // Sự kiện khi nhấn nút gửi thông tin
        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = editHoten.getText().toString();
        String id = editCMND.getText().toString();
        String additionalInfo = editBosung.getText().toString();
        String degree = ((RadioButton) findViewById(radioGroupBangCap.getCheckedRadioButtonId())).getText().toString();

        // Kiểm tra hợp lệ của dữ liệu nhập vào
        if (TextUtils.isEmpty(name) || name.length() < 3) {
            Toast.makeText(this, "Tên phải có ít nhất 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(id) || id.length() != 9 || !id.matches("\\d+")) {
            Toast.makeText(this, "CMND phải có đúng 9 chữ số", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!chkDocBao.isChecked() && !chkDocSach.isChecked() && !chkDocCode.isChecked()) {
            Toast.makeText(this, "Phải chọn ít nhất 1 sở thích", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy sở thích
        StringBuilder hobbies = new StringBuilder();
        if (chkDocBao.isChecked()) hobbies.append("Đọc báo - ");
        if (chkDocSach.isChecked()) hobbies.append("Đọc sách - ");
        if (chkDocCode.isChecked()) hobbies.append("Đọc coding");

        if (hobbies.toString().endsWith(" - ")) {
            hobbies.setLength(hobbies.length() - 3); // Xóa ký tự thừa
        }

        // Hiển thị thông tin qua AlertDialog
        new AlertDialog.Builder(this)
                .setTitle("Thông tin cá nhân")
                .setMessage("Tên: " + name + "\n" +
                        "CMND: " + id + "\n" +
                        "Bằng cấp: " + degree + "\n" +
                        "Sở thích: " + hobbies.toString() + "\n" +
                        "Thông tin bổ sung: " + (TextUtils.isEmpty(additionalInfo) ? "Không có" : additionalInfo))
                .setPositiveButton("Đóng", null)
                .show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setTitle("Question")
                    .setMessage("Are you sure you want to exit?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("NO", null)
                    .show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
