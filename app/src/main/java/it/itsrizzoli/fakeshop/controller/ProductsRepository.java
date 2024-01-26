package it.itsrizzoli.fakeshop.controller;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import it.itsrizzoli.fakeshop.controller.AppController;
import it.itsrizzoli.fakeshop.controller.ProductModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductsRepository {

    String urlProduct = "https://dummyjson.com/products?limit=100";

    String urlSmartphones = "https://dummyjson.com/products/category/smartphones";

    String urlLaptops = "https://dummyjson.com/products/category/laptops";

    String urlSkincare = "https://dummyjson.com/products/category/skincare";

    public void getProducts(final ProductsAsyncResponse callback) {
        ArrayList<ProductModel> products = new ArrayList<ProductModel>();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, urlProduct, null, response -> {
            try {
                JSONArray productsJsonArray = response.getJSONArray("products");
                for (int i = 0; i < productsJsonArray.length(); i++) {
                    JSONObject productJson = productsJsonArray.getJSONObject(i);
                    int id = productJson.getInt("id");
                    String title = productJson.getString("title");
                    String description = productJson.getString("description");
                    int price = productJson.getInt("price");
                    double discountPercentage = productJson.getDouble("discountPercentage");
                    double rating = productJson.getDouble("rating");
                    int stock = productJson.getInt("stock");
                    String brand = productJson.getString("brand");
                    String category = productJson.getString("category");
                    String thumbnail = productJson.getString("thumbnail");
                    ArrayList<String> images = new ArrayList<>();
                    JSONArray imagesJson = productJson.getJSONArray("images");
                    for (int a = 0; a < imagesJson.length(); a++) {
                        String image = imagesJson.getString(a);
                        images.add(image);
                    }
                    ProductModel product = new ProductModel(id, title, description, price, discountPercentage, rating,
                            stock, brand, category, thumbnail, images);
                    products.add(product);
                }
                callback.onSuccess(products);
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onError(e);
            }
        }, error -> {
            Log.d("Main", "Error");
        }
        );
        AppController.getInstance().addToRequestQueue(request);
    }

    public void getSmartphones(final ProductsAsyncResponse callback) {

        ArrayList<ProductModel> smartphones = new ArrayList<ProductModel>();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, urlSmartphones, null, response -> {
            try {
                JSONArray productsJsonArray = response.getJSONArray("products");
                for (int i = 0; i < productsJsonArray.length(); i++) {
                    JSONObject productJson = productsJsonArray.getJSONObject(i);
                    int id = productJson.getInt("id");
                    String title = productJson.getString("title");
                    String description = productJson.getString("description");
                    int price = productJson.getInt("price");
                    double discountPercentage = productJson.getDouble("discountPercentage");
                    double rating = productJson.getDouble("rating");
                    int stock = productJson.getInt("stock");
                    String brand = productJson.getString("brand");
                    String category = productJson.getString("category");
                    String thumbnail = productJson.getString("thumbnail");
                    ArrayList<String> images = new ArrayList<>();
                    JSONArray imagesJson = productJson.getJSONArray("images");
                    for (int a = 0; a < imagesJson.length(); a++) {
                        String image = imagesJson.getString(a);
                        images.add(image);
                    }
                    ProductModel product = new ProductModel(
                            id,
                            title,
                            description,
                            price,
                            discountPercentage,
                            rating,
                            stock,
                            brand,
                            category,
                            thumbnail,
                            images
                    );
                    smartphones.add(product);
                }
                callback.onSuccess(smartphones);
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onError(e);
            }
        }, error -> {
            Log.d("Main", "Error");
        }
        );
        AppController.getInstance().addToRequestQueue(request);
    }

    public void getLaptops(final ProductsAsyncResponse callback) {

        ArrayList<ProductModel> laptops = new ArrayList<ProductModel>();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, urlLaptops, null, response -> {
            try {
                JSONArray productsJsonArray = response.getJSONArray("products");
                for (int i = 0; i < productsJsonArray.length(); i++) {
                    JSONObject productJson = productsJsonArray.getJSONObject(i);
                    int id = productJson.getInt("id");
                    String title = productJson.getString("title");
                    String description = productJson.getString("description");
                    int price = productJson.getInt("price");
                    double discountPercentage = productJson.getDouble("discountPercentage");
                    double rating = productJson.getDouble("rating");
                    int stock = productJson.getInt("stock");
                    String brand = productJson.getString("brand");
                    String category = productJson.getString("category");
                    String thumbnail = productJson.getString("thumbnail");
                    ArrayList<String> images = new ArrayList<>();
                    JSONArray imagesJson = productJson.getJSONArray("images");
                    for (int a = 0; a < imagesJson.length(); a++) {
                        String image = imagesJson.getString(a);
                        images.add(image);
                    }
                    ProductModel product = new ProductModel(
                            id,
                            title,
                            description,
                            price,
                            discountPercentage,
                            rating,
                            stock,
                            brand,
                            category,
                            thumbnail,
                            images
                    );
                    laptops.add(product);
                }
                callback.onSuccess(laptops);
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onError(e);
            }
        }, error -> {
            Log.d("Main", "Error");
        }
        );
        AppController.getInstance().addToRequestQueue(request);
    }

    public void getSkincare(final ProductsAsyncResponse callback) {

        ArrayList<ProductModel> skincares = new ArrayList<ProductModel>();
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, urlSkincare, null, response -> {
            try {
                JSONArray productsJsonArray = response.getJSONArray("products");
                for (int i = 0; i < productsJsonArray.length(); i++) {
                    JSONObject productJson = productsJsonArray.getJSONObject(i);
                    int id = productJson.getInt("id");
                    String title = productJson.getString("title");
                    String description = productJson.getString("description");
                    int price = productJson.getInt("price");
                    double discountPercentage = productJson.getDouble("discountPercentage");
                    double rating = productJson.getDouble("rating");
                    int stock = productJson.getInt("stock");
                    String brand = productJson.getString("brand");
                    String category = productJson.getString("category");
                    String thumbnail = productJson.getString("thumbnail");
                    ArrayList<String> images = new ArrayList<>();
                    JSONArray imagesJson = productJson.getJSONArray("images");
                    for (int a = 0; a < imagesJson.length(); a++) {
                        String image = imagesJson.getString(a);
                        images.add(image);
                    }
                    ProductModel product = new ProductModel(
                            id,
                            title,
                            description,
                            price,
                            discountPercentage,
                            rating,
                            stock,
                            brand,
                            category,
                            thumbnail,
                            images
                    );
                    skincares.add(product);
                }
                callback.onSuccess(skincares);
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onError(e);
            }
        }, error -> {
            Log.d("Main", "Error");
        }
        );
        AppController.getInstance().addToRequestQueue(request);
    }
}
