package it.itsrizzoli.fakeshop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.text.DecimalFormat;
import java.util.ArrayList;

import it.itsrizzoli.fakeshop.controller.ProductModel;

public class DetailFragment extends Fragment {

    private ProductModel product;

    public DetailFragment(ProductModel product) {
        this.product = product;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageCarousel carousel = view.findViewById(R.id.carousel_fd);
        ArrayList<CarouselItem> items = new ArrayList<>();

        for (String image : product.images) {
            items.add(new CarouselItem(image));
        }
        carousel.addData(items);

        TextView title = view.findViewById(R.id.title_fd);
        TextView brand = view.findViewById(R.id.brand_fd);
        TextView ogPrice = view.findViewById(R.id.og_price_fd);
        TextView discount = view.findViewById(R.id.discount_fd);
        TextView discountedPrice = view.findViewById(R.id.ds_price_fd);
        TextView description = view.findViewById(R.id.description_fd);
        title.setText(product.title);
        brand.setText(product.brand);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        ogPrice.setText("Original price: " + String.format("%.2f", Double.parseDouble(decimalFormat.format(product.price))) + "$");
        discount.setText("Discount: " + product.discountPercentage + "%");
        discountedPrice.setText("Best price: " + Double.parseDouble(decimalFormat.format((product.price / 100 * (100 - product.discountPercentage)))) + "$");
        description.setText(product.description);

        if (product.discountPercentage == 0.0) {
            discount.setVisibility(View.GONE);
            ogPrice.setVisibility(View.GONE);
        }
    }
}