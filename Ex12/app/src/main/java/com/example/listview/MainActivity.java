package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listview.adapter.ProductListViewAdapter;
import com.example.listview.objects.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;
    ArrayList<Product> listProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Iphone 6", 500));
        listProduct.add(new Product(2, "Iphone 7", 700));
        listProduct.add(new Product(3, "Iphone 8", 1000));
        listProduct.add(new Product(4, "Samsung note5", 300));
        listProduct.add(new Product(5, "Nokia", 1500));


        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Product product = (Product) productListViewAdapter.getItem(position);
                Toast.makeText(MainActivity.this,product.name, Toast.LENGTH_LONG).show();

            }
        });
        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listProduct.size() > 0){
                    int productpost = 0;
                    listProduct.remove(productpost);
                    productListViewAdapter.notifyDataSetChanged();
                }

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}