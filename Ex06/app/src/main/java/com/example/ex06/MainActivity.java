package com.example.ex06;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editHoten, editCMND, editBoSung;
    RadioGroup radioGroupBangCap;
    RadioButton radTrungCap, radCaoDang, radDaiHoc;
    CheckBox chkDocBao, chkDocSach, chkDocCode;
    Button btnGuiTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editHoten = findViewById(R.id.editHoten);
        editCMND = findViewById(R.id.editCMND);
        editBoSung = findViewById(R.id.editBoSung);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocCode = findViewById(R.id.chkDocCode);
        btnGuiTT = findViewById(R.id.btnGuiTT);
        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                doShowInfomation();
            }
        });
    }

    private void doShowInfomation() {
        String ten = editHoten.getText().toString();
        ten = ten.trim();
        if(ten.length() < 3){
            editHoten.requestFocus();
            editHoten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự",
                    Toast.LENGTH_LONG).show();
            return;

        }
        //kiểm tra CMND hợp lệ
        String cmnd = editCMND.getText().toString();
        cmnd = cmnd.trim();
        if (cmnd.length()!=9)
        {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự",Toast.LENGTH_LONG).show();
            return;
        } //Kiểm tra bằng cấp
        String bang="";
        radioGroupBangCap = findViewById(R.id.radioGroupBangCap);
        int id = radioGroupBangCap.getCheckedRadioButtonId();// Trả về Id if (id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp",Toast.LENGTH_LONG).show();
            return;
    }
    RadioButton rad = findViewById(radioGroupBangCap);
    bang = rad.getText()+ "";
    String sothich = "";
    if(chkDocBao.isChecked())
        sothich += chkDocBao.getText() + " \n";
    if (chkDocCode.isChecked())
        sothich += chkDocCode.getText() + "\n";
    if (chkDocSach.isChecked())
        sothich += chkDocSach.getText() + "\n";
    String bosung = editBoSung.getText() + "";
    //Ta dialog
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Thông tin cá nhân");
    builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    });
        String msg = ten+"\n";
        msg+= cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="\n";
        msg+="Thông tin bổ sung: \n";
        msg+=bosung+ "\n";
        msg+="--";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage ("Are you sure you want to exit?");
        b.setIcon (R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }}); finish();
        b.setNegativeButton("No", new
                DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        finish();
                    }});
        b.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.create().show();
                }

}