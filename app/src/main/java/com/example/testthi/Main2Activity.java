package com.example.testthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
    private TextView tvThongTin;
    private EditText edMaSV;
    private EditText edDiem;
    private EditText edGmail;
    private List<Student> students;
    private TextView tvHocBong;
    private List<Person> listperson;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();

    }

    private void AnhXa() {
        tvThongTin = (TextView) findViewById(R.id.tvThongTin);
        edMaSV = (EditText) findViewById(R.id.edMaSV);
        edDiem = (EditText) findViewById(R.id.edDiem);
        edGmail = (EditText) findViewById(R.id.edGmail);
        tvHocBong = (TextView) findViewById(R.id.tvHocBong);
        students = new ArrayList<>();
    }

    public void OnClick(View view) {
        String validate = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"+
                "(" +
                "\\." +"[a-zA-Z-0-9][a-zA-Z0-9\\-]{0,25}"+
                ")+";

        String masv = edMaSV.getText().toString().trim();
        String diem = edDiem.getText().toString().trim();
        double Diem = Double.valueOf(diem);
        String gmail = edGmail.getText().toString().trim();

        Matcher matcher  = Pattern.compile(validate).matcher(gmail);

        if (masv.equals("")){
            edMaSV.setError("Không được nhập trống");
        } else if (diem.equals("")) {
            edDiem.setError("Không được nhập trống");
        }
        else if (gmail.equals("")) {
            edGmail.setError("Không được nhập trống");
        }else if (Diem < 0) {
            edDiem.setError("Nhập lớn hơn 0.0");
        }
        else if (Diem >10) {
            edDiem.setError("Nhập nhỏ hơn 10.0");
        }else if (!matcher.matches()) {
            edGmail.setError("chưa đúng định dạng");
        } else {
            students.add(new Student(masv, Diem, gmail));
            if (Diem >= 8.0) {
                tvHocBong.setText("Ma SV : " + students.get(0).getMasv() + "\n" +
                        "Diem : " + students.get(0).getDiem() + "\n" +
                        "Gmail : " + students.get(0).getMail() + "\n" + "Có học bổng");
            } else {
                tvHocBong.setText("Ma SV : " + students.get(0).getMasv() + "\n" +
                        "Diem : " + students.get(0).getDiem() + "\n" +
                        "Gmail : " + students.get(0).getMail() + "\n" + "Không học bổng");
            }

        }
    }
}
