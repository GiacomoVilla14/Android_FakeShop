package it.itsrizzoli.fakeshop.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import it.itsrizzoli.fakeshop.controller.ProductModel;
import it.itsrizzoli.fakeshop.R;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private final ArrayList<ProductModel> productModels;

    private SelectionListener listener;

    public ProductsAdapter(ArrayList<ProductModel> productModels, SelectionListener listener) {
        this.productModels = productModels;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(productModels.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final RelativeLayout productCard;
        private final TextView title;
        private final TextView description;
        private final ImageView thumbnail;
        private final ProgressBar progressBar;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productCard = itemView.findViewById(R.id.card_view_project_icon_container);
            title = itemView.findViewById(R.id.text_view_project_title);
            description = itemView.findViewById(R.id.text_view_project_description);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }

        public void bind(ProductModel productModel, SelectionListener listener) {
            title.setText(productModel.title);
            description.setText(productModel.description);
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
