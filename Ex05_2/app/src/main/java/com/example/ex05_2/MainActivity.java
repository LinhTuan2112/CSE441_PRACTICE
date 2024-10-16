package com.example.ex05_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnTieptuc, btnGiai, btnThoat;
    EditText edita, editb, editc;
    TextView txtkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnTieptuc = findViewById(R.id.btnTieptuc);
        btnGiai = findViewById(R.id.btnGiai);
        btnThoat = findViewById(R.id.btnThoat);
        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtkq = findViewById(R.id.txtkq);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sa = edita.getText().toString();
                String sb = editb.getText().toString();
                String sc = editc.getText().toString();

                // Kiểm tra xem người dùng đã nhập đủ số liệu chưa
                if (sa.isEmpty() || sb.isEmpty() || sc.isEmpty()) {
                    txtkq.setText("Vui lòng nhập tất cả các hệ số a, b, c.");
                    return;
                }

                // Chuyển đổi chuỗi sang double
                double a = Double.parseDouble(sa);
                double b = Double.parseDouble(sb);
                double c = Double.parseDouble(sc);
                String ketqua = "";
                DecimalFormat df = new DecimalFormat("0.00");

                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) ketqua = "PT vô số nghiệm";
                        else ketqua = "PT vô nghiệm";
                    } else {
                        ketqua = "Pt có 1 No, x=" + df.format(-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        ketqua = "PT vô nghiệm";
                    } else if (delta == 0) {
                        ketqua = "Pt có nghiệm kép x1=x2=" + df.format(-b / (2 * a));
                    } else {
                        ketqua = "Pt có 2 nghiệm: x1=" + df.format((-b + Math.sqrt(delta)) / (2 * a)) + "; x2=" + df.format((-b - Math.sqrt(delta)) / (2 * a));
                    }
                }
                txtkq.setText(ketqua);
            }
        });

        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edita.setText("");
                editb.setText("");
                editc.setText("");
                edita.requestFocus();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
