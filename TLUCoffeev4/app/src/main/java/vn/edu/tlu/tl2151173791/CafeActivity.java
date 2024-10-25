package vn.edu.tlu.tl2151173791;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class CafeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CafeAdapter cafeAdapter;
    private List<Cafe> cafeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        recyclerView = findViewById(R.id.recycler_view_coffee);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         cafeList = new ArrayList<>();
        cafeList.add(new Cafe("Espresso", 30000));
        cafeList.add(new Cafe("Cappuccino", 40000));
        cafeList.add(new Cafe("Latte", 45000));
        cafeList.add(new Cafe("Americano", 35000));
        cafeList.add(new Cafe("Mocha", 50000));
        cafeList.add(new Cafe("Macchiato", 55000));

//        List<Cafe> nuocTraiCayList = new ArrayList<>();
//        nuocTraiCayList.add(new Cafe("Cam Vắt", 40000));
//        nuocTraiCayList.add(new Cafe("Sinh Tố Bơ", 45000));
//        nuocTraiCayList.add(new Cafe("Sinh Tố Dưa Hấu", 40000));
//        nuocTraiCayList.add(new Cafe("Sinh Tố Dứa", 45000));

         cafeAdapter = new CafeAdapter(cafeList);
        recyclerView.setAdapter(cafeAdapter);

//        CafeAdapter nuocTraiCayAdapter = new CafeAdapter(nuocTraiCayList);
//        recyclerView.setAdapter(nuocTraiCayAdapter);
    }
}
