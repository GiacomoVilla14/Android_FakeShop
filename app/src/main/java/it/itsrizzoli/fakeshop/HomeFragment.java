package it.itsrizzoli.fakeshop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import it.itsrizzoli.fakeshop.adapter.CardProductAdapter;
import it.itsrizzoli.fakeshop.adapter.ProductsAdapter;
import it.itsrizzoli.fakeshop.adapter.SelectionListener;
import it.itsrizzoli.fakeshop.controller.ProductModel;
import it.itsrizzoli.fakeshop.controller.ProductsAsyncResponse;
import it.itsrizzoli.fakeshop.controller.ProductsRepository;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new ProductsRepository().getSmartphones(new ProductsAsyncResponse() {
            @Override
            public void onSuccess(ArrayList<ProductModel> products) {
                ProgressBar progressBar = view.findViewById(R.id.progress_bar);
                TextView loadingText = view.findViewById(R.id.loadingText);
                LinearLayout linearLayout = view.findViewById(R.id.home_ll);
                View include = view.findViewById(R.id.smartphones_recycler_view);
                RecyclerView recyclerView = include.findViewById(R.id.home_recycler_view);
                TextView title = include.findViewById(R.id.category_title);
                title.setText("Smartphones");
                CardProductAdapter cardProductAdapter = new CardProductAdapter(products, new SelectionListener() {
                    @Override
                    public void onItemClicked(ProductModel product) {
                        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.fl_fragment, new DetailFragment(product), null)
                                .addToBackStack(null)
                                .setReorderingAllowed(true)
                                .commit();
                    }
                });
                recyclerView.setAdapter(cardProductAdapter);
                progressBar.setVisibility(View.GONE);
                loadingText.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Exception e) {
                Log.d("Errore", e.getMessage());
                e.printStackTrace();
            }
        });

        new ProductsRepository().getLaptops(new ProductsAsyncResponse() {

            @Override
            public void onSuccess(ArrayList<ProductModel> products) {
                ProgressBar progressBar = view.findViewById(R.id.progress_bar);
                TextView loadingText = view.findViewById(R.id.loadingText);
                LinearLayout linearLayout = view.findViewById(R.id.home_ll);
                View include = view.findViewById(R.id.laptops_recycler_view);
                RecyclerView recyclerView = include.findViewById(R.id.home_recycler_view);
                TextView title = include.findViewById(R.id.category_title);
                title.setText("Laptops");
                CardProductAdapter cardProductAdapter = new CardProductAdapter(products, new SelectionListener() {
                    @Override
                    public void onItemClicked(ProductModel product) {
                        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.fl_fragment, new DetailFragment(product), null)
                                .addToBackStack(null)
                                .setReorderingAllowed(true)
                                .commit();
                    }
                });
                recyclerView.setAdapter(cardProductAdapter);
                progressBar.setVisibility(View.GONE);
                loadingText.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Exception e) {
                Log.d("Errore", e.getMessage());
                e.printStackTrace();
            }
        });

        new ProductsRepository().getSkincare(new ProductsAsyncResponse() {

            @Override
            public void onSuccess(ArrayList<ProductModel> products) {
                ProgressBar progressBar = view.findViewById(R.id.progress_bar);
                TextView loadingText = view.findViewById(R.id.loadingText);
                LinearLayout linearLayout = view.findViewById(R.id.home_ll);
                View include = view.findViewById(R.id.skincare_recycler_view);
                RecyclerView recyclerView = include.findViewById(R.id.home_recycler_view);
                TextView title = include.findViewById(R.id.category_title);
                title.setText("Skincare");
                CardProductAdapter cardProductAdapter = new CardProductAdapter(products, new SelectionListener() {
                    @Override
                    public void onItemClicked(ProductModel product) {
                        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.fl_fragment, new DetailFragment(product), null)
                                .addToBackStack(null)
                                .setReorderingAllowed(true)
                                .commit();
                    }
                });
                recyclerView.setAdapter(cardProductAdapter);
                progressBar.setVisibility(View.GONE);
                loadingText.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Exception e) {
                Log.d("Errore", e.getMessage());
                e.printStackTrace();
            }
        });

    }
}