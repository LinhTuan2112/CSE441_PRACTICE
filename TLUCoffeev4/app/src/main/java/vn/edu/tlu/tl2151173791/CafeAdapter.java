package vn.edu.tlu.tl2151173791;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.CafeViewHolder> {
    private List<Cafe> cafeList;
    public CafeAdapter(List<Cafe> cafeList){
        this.cafeList = cafeList;
    }

    @NonNull
    @Override
    public CafeAdapter.CafeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cafe, parent, false);
        return new CafeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeAdapter.CafeViewHolder holder, int position) {
        Cafe cafe = cafeList.get(position);
        holder.cafeName.setText(cafe.getName());
        holder.cafePrice.setText(cafe.getPrice() + " VND");

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(), "Bạn đã chọn: " + cafe, Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return cafeList.size();
    }

    public static class CafeViewHolder extends RecyclerView.ViewHolder {
        TextView cafeName, cafePrice;
        public CafeViewHolder(@NonNull View itemView) {
            super(itemView);
            cafeName = itemView.findViewById(R.id.cafe_name);
            cafePrice = itemView.findViewById(R.id.cafe_price);
        }
    }
}
