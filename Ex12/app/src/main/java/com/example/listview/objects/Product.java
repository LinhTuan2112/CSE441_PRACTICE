package com.example.listview.objects;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import com.example.listview.R;

import java.util.ArrayList;
import java.util.Objects;

public class Product{

    public String name;
    public int price;
    public int productID;
    public Product(int productID, String name, int price){
        this.name = name;
        this.price = price;
        this.productID = productID;
    }
}

