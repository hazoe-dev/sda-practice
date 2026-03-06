package dev.hazoe.exercise;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonHandler {
    public static void main(String[] args) {
        JSONObject item1 = new JSONObject();
        item1.put("barcode", "1234");
        item1.put("price", 50);

        JSONObject item2 = new JSONObject();
        item2.put("barcode", "1235");
        item2.put("price", 51);

        JSONArray arr = new JSONArray();
        arr.put(item1);
        arr.put(item2);

        JSONObject data = new JSONObject();
        data.put("data", arr);


        JSONArray readArr = data.getJSONArray("data");
        for (int i = 0; i < readArr.length(); i++) {
            JSONObject obj = readArr.getJSONObject(i);
            String barCode = obj.getString("barcode");
            int price = obj.getInt("price");
            System.out.println(barCode + " " + price);
        }

    }
}
