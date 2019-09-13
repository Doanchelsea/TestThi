package com.example.testthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText tvName;
    private EditText tvGioiTinh;
    private EditText tvNgaySinh;
    private EditText tvDiaChi;
    private TextView textView;
    private List<Person> personList;
    String name;
    String gioitinh;
    int ngaysinh;
    String DiaChi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();






    }




    private void showInfo() {
        textView.setText("Name : " +personList.get(0).getName() +"\n" +
                         "Gioi Tinh : " +personList.get(0).getGioitinh() +"\n" +
                          "NgaySinh : " +personList.get(0).getNgaysinh() +"\n" +
                          "DiaChi : " +personList.get(0).getDiachi() +"\n");
    }

    private void inputInfo() {
        personList.add(new Person(name,gioitinh,ngaysinh,DiaChi));
    }

    private void AnhXa() {
        textView = findViewById(R.id.tvText);
        tvName = (EditText) findViewById(R.id.tvName);
        tvGioiTinh = (EditText) findViewById(R.id.tvGioiTinh);
        tvNgaySinh = (EditText) findViewById(R.id.tvNgaySinh);
        tvDiaChi = (EditText) findViewById(R.id.tvDiaChi);
        personList = new ArrayList<>();
    }

    public void click(View view) {
        name = tvName.getText().toString().trim();
        gioitinh = tvGioiTinh.getText().toString();
        String NgaySinh = tvNgaySinh.getText().toString();
        ngaysinh = Integer.valueOf(NgaySinh);
        DiaChi = tvDiaChi.getText().toString();
        inputInfo();
        showInfo();
        Intent view_order_intent = new Intent(this, Main2Activity.class);
        startActivity(view_order_intent);
    }
}
