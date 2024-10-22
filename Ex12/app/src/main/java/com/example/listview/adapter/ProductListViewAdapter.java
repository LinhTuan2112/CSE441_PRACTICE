package com.example.listview.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview.R;
import com.example.listview.objects.Product;

import java.util.ArrayList;

public class ProductListViewAdapter extends BaseAdapter {
    //Dữ liệu liên kết bởi Adapter là 1 mảng các sản phẩm
    final ArrayList<Product>listProduct;

    public ProductListViewAdapter(ArrayList<Product> listProduct){
        this.listProduct = listProduct;
    }


    @Override
    public int getCount() {
        //trả về số phần tử , nó được gọi là listview
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về ID của phần
        return listProduct.get(position).productID;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {

        View viewProduct;
        //Nếu convertView == null nghĩa là view chưa tồn tại
        //thì tạo mowsi 1 view từ file layout product_view.xml
        if (convertview == null){
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        }else{
            //nNếu convertView != null nghĩa là view tồn tại và có thể tái sử dụng
            viewProduct = convertview;
        }
        Product product = (Product) getItem(position);
        //lấy đối tượng product tại vị trí position trong danh sách
        ((TextView) viewProduct.findViewById(R.id.idproduct)).setText(String.format("ID = %d", product.productID));
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Tên SP = %s", product.name));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("Giá %d", product.price));

        //lấy textView từ viewProduct bằng ID của nó rồi gán giá trị cho nó 
        return viewProduct;
    }
}
