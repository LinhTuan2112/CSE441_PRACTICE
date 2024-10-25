package vn.edu.tlu.tl2151173791;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NuocTraiCayAdapter  extends RecyclerView.Adapter<NuocTraiCayAdapter .NuocTraiCayViewHolder> {
    private List<NuocTraiCay> nuocTraiCayList;
    public NuocTraiCayAdapter (List<NuocTraiCay> nuocTraiCayList){
        this.nuocTraiCayList = nuocTraiCayList;
    }

    @NonNull
    @Override
    public NuocTraiCayAdapter.NuocTraiCayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nuoctraicay, parent, false);
        return new NuocTraiCayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NuocTraiCayAdapter.NuocTraiCayViewHolder holder, int position) {
        NuocTraiCay nuocTraiCay = nuocTraiCayList.get(position);
        holder.nuocTraiCayName.setText(nuocTraiCay.getName());
        holder.nuocTraiCayPrice.setText(nuocTraiCay.getPrice() + " VND");

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(v.getContext(), "Bạn đã chọn: " + nuocTraiCay, Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return nuocTraiCayList.size();
    }

    public static class NuocTraiCayViewHolder extends RecyclerView.ViewHolder {
        TextView nuocTraiCayName, nuocTraiCayPrice;
        public NuocTraiCayViewHolder(@NonNull View itemView) {
            super(itemView);
            nuocTraiCayName = itemView.findViewById(R.id.nuoctraicay_price);
            nuocTraiCayPrice = itemView.findViewById(R.id.nuoctraicay_price);
        }
    }
}