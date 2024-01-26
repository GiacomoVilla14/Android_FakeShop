package it.itsrizzoli.fakeshop.controller;

import java.util.ArrayList;

public interface ProductsAsyncResponse {

    void onSuccess(ArrayList<ProductModel> products);

    void onError(Exception e);
}
