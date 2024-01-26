package it.itsrizzoli.fakeshop;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import it.itsrizzoli.fakeshop.adapter.ProductsAdapter;
import it.itsrizzoli.fakeshop.adapter.SelectionListener;
import it.itsrizzoli.fakeshop.controller.ProductModel;
import it.itsrizzoli.fakeshop.controller.ProductsAsyncResponse;
import it.itsrizzoli.fakeshop.controller.ProductsRepository;


public class ListFragment extends Fragment {

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new ProductsRepository().getProducts(new ProductsAsyncResponse() {
            @Override
            public void onSuccess(ArrayList<ProductModel> products) {
                ProgressBar progressBar = view.findViewById(R.id.progress_bar);
                TextView loadingText = view.findViewById(R.id.loadingText);
                RecyclerView recyclerView = view.findViewById(R.id.recycler_view_projectsF);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                ProductsAdapter productsAdapter = new ProductsAdapter(products, new SelectionListener() {
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
                recyclerView.setAdapter(productsAdapter);
                progressBar.setVisibility(View.GONE);
                loadingText.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(Exception e) {
                Log.d("Errore", e.getMessage());
                e.printStackTrace();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}