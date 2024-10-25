package vn.edu.tlu.tl2151173791;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NuocTraiCayActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NuocTraiCayAdapter nuocTraiCayAdapter;
    private List<NuocTraiCay> nuocTraiCayList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuoctraicay);

        recyclerView = findViewById(R.id.recycler_view_nuoctraicay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         nuocTraiCayList = new ArrayList<>();
        nuocTraiCayList.add(new NuocTraiCay("Cam Vắt", 25000));
        nuocTraiCayList.add(new NuocTraiCay("Sinh Tố Bơ", 35000));
        nuocTraiCayList.add(new NuocTraiCay("Nước Dừa", 30000));
        nuocTraiCayList.add(new NuocTraiCay("Sinh Tố Dưa Hấu", 40000));
        nuocTraiCayList.add(new NuocTraiCay("Sinh Tố Dứa", 45000));

         nuocTraiCayAdapter = new NuocTraiCayAdapter(nuocTraiCayList);
        recyclerView.setAdapter(nuocTraiCayAdapter);
    }
}
