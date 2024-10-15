package com.example.ex04_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity (
        EditText edt_doF, edt_doC;
        Button btn_cf,btn_fc;
    Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_doC findViewById(R.id.edt_doC);
        edt_doF findViewById(R.id.edt_doF);
        btn_cf findViewById(R.id.btn_cf):
        btn_fc findViewById(R.id.btn_fc);
        btn_cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    // TODO Auto-generated method stub
                DecimalFormat dcf-new DecimalFormat("#.00");
                String doc edtdoc.getText()+"";
                Int C-Integer.parseInt(doc);
                edtdof.setText(""+dcf.format(C*1.8+32));
            });
    btn_fc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DecimalFormat dcf-new DecimalFormat("8.00");
    // TODO Auto-generated method stub
                    String dofedtdoF.getText()+"";
                    int F-Integer.parseInt(doF);
                    edt_doC.setText(""+dcf.format((F-32)/1.8));
                });
            }
    });
}