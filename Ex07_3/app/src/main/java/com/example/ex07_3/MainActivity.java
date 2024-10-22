package com.example.ex07_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB, edtKQ;
    Button btnrequest;

    private ActivityResultLauncher<Intent> activityResultLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edt_A);
        edtB = findViewById(R.id.edt_B);
        edtKQ = findViewById(R.id.edt_KQ);
        btnrequest = findViewById(R.id.btn_request);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == 33) {
                        Intent data = result.getData();
                        if (data != null) {
                            int sum = data.getIntExtra("kq", 0);
                            edtKQ.setText("Tổng hai số là: " + sum);
                        }
                    }
                    if (result.getResultCode() == 34) {
                        Intent data = result.getData();
                        if (data != null) {
                            int sub = data.getIntExtra("kq", 0);
                            edtKQ.setText("Hiệu hai số là: " + sub);
                        }
                    }
                }
        );

        btnrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);

                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                myintent.putExtra("soa", a);
                myintent.putExtra("sob", b);

                activityResultLauncher.launch(myintent);
            }
        });
    }
}
