package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainPojo {
    public static void main(String[] args) {
        JSONObject jsonNumber = new JSONObject("{\"serialNumber\":\"123-321\"}");
        List<String> list = new ArrayList<>();
        list.add("BMW");
        list.add("Blue");
        JSONArray jsonColor = new JSONArray(list);
        final Auto auto = new Auto(false, 2004, new Number("123-321"),
                new String[]{"Ford", "blue"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dateOfManufacture", auto.getDateOfManufacture());
        jsonObject.put("sale", auto.isSale());
        jsonObject.put("number", jsonNumber);
        jsonObject.put("color", jsonColor);
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(auto).toString());
    }
}
