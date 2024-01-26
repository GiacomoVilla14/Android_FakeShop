package it.itsrizzoli.fakeshop.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import it.itsrizzoli.fakeshop.R;
import it.itsrizzoli.fakeshop.controller.ProductModel;

public class CardProductAdapter extends RecyclerView.Adapter<CardProductAdapter.CardProductViewHolder> {

    private final ArrayList<ProductModel> productModels;

    private SelectionListener listener;

    public CardProductAdapter(ArrayList<ProductModel> productModels, SelectionListener listener) {
        this.productModels = productModels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CardProductAdapter.CardProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_layout, parent, false);
        return new CardProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardProductAdapter.CardProductViewHolder holder, int position) {
        holder.bind(productModels.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public static class CardProductViewHolder extends RecyclerView.ViewHolder {

        private final ConstraintLayout productCard;
        private final TextView title;
        private final TextView brand;
        private final TextView price;
        private final ImageView thumbnail;
        private final ProgressBar progressBar;

        public CardProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productCard = itemView.findViewById(R.id.product_card_ll);
            title = itemView.findViewById(R.id.product_card_title);
            brand = itemView.findViewById(R.id.product_card_brand);
            price = itemView.findViewById(R.id.product_card_price);
            thumbnail = itemView.findViewById(R.id.product_card_iv);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }

        public void bind(ProductModel productModel, SelectionListener listener) {
            title.setText(productModel.title);
            brand.setText(productModel.brand);
            price.setText(productModel.price + "€");
            Picasso.get()
                    .load(productModel.thumbnail)
                    .into(thumbnail, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            progressBar.setVisibility(View.GONE);
                            thumbnail.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("Error", Objects.requireNonNull(e.getMessage()));
                            e.printStackTrace();
                        }
                    });
            productCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(productModel);
                }
            });
        }
    }
}
