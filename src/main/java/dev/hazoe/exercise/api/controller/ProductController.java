package dev.hazoe.exercise.api.controller;

import dev.hazoe.exercise.api.dto.FilteredProduct;
import dev.hazoe.exercise.api.dto.SortedProduct;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductController {

    private final String URL = "https://jsonmock.hackerrank.com/api/inventory";
    RestTemplate restTemplate = new RestTemplate();

    String result = restTemplate.getForObject(URL, String.class);
    JSONObject root = new JSONObject(result);
    JSONArray data = root.getJSONArray("data");

    @GetMapping("/products/filter/{min}/{max}")
    public ResponseEntity<List<FilteredProduct>> filter(
            @PathVariable int min,
            @PathVariable int max) {
        try {
            if (min > max) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            List<FilteredProduct> resultList = new ArrayList<>();
            for (int i = 0; i < data.length(); i++) {
                JSONObject obj = data.getJSONObject(i);
                int price = Integer.parseInt(obj.get("price").toString());

                if (price >= min && price <= max) {

                    String barCode = obj.getString("barcode");

                    resultList.add(new FilteredProduct(barCode));
                }
            }
            if (resultList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(resultList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/sort")
    public ResponseEntity<SortedProduct[]> sort() {

        try {

            SortedProduct[] arr = new SortedProduct[data.length()];

            for (int i = 0; i < data.length(); i++) {

                JSONObject obj = data.getJSONObject(i);

                String barCode = obj.getString("barcode");
                int price = Integer.parseInt(obj.get("price").toString());

                arr[i] = new SortedProduct(barCode, price);
            }

            Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice());

            return new ResponseEntity<>(arr, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
