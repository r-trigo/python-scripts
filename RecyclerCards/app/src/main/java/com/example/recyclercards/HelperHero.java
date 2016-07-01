package com.example.recyclercards;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Seksu on 01/07/2016.
 */
public class HelperHero {

    private ArrayList<Hero> heroes = new ArrayList<>();

    public ArrayList fillMyArray() {
        heroes.add(new Hero(/*R.drawable.genji_portrait,*/ "Genji", "Offense", "3"));
        heroes.add(new Hero(/*R.drawable.bastion_portrait,*/ "Bastion", "Defense", "1"));
        heroes.add(new Hero(/*R.drawable.dva_portrait,*/ "Dva", "Tank", "2"));
        heroes.add(new Hero(/*R.drawable.lucio_portrait,*/ "Lúcio", "Support", "2"));
        return heroes;
    }

    public ArrayList getJsonFromString(String imjson) {

//        String imjson = "[\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Genji\",\n" +
//                "\t\t\"role\":\"Offense\",\n" +
//                "\t\t\"difficulty_level\":\"3\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Bastion\",\n" +
//                "\t\t\"role\":\"Defense\",\n" +
//                "\t\t\"difficulty_level\":\"1\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Dva\",\n" +
//                "\t\t\"role\":\"Tank\",\n" +
//                "\t\t\"difficulty_level\":\"2\"\n" +
//                "\t},\n" +
//                "\t{\n" +
//                "\t\t\"name\":\"Lúcio\",\n" +
//                "\t\t\"role\":\"Support\",\n" +
//                "\t\t\"difficulty_level\":\"2\"\n" +
//                "\t}\n" +
//                "]";

        try {
            JSONArray jsonArray = new JSONArray(imjson);
            for (int i = 0; i < jsonArray.length(); i++) {
                Hero h = new Hero();

                JSONObject heroObject = jsonArray.getJSONObject(i);
                h.setName(heroObject.getString("name"));
                h.setRole(heroObject.getString("role"));
                h.setDifficulty_level(heroObject.getString("difficulty_level"));

                heroes.add(h);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public ArrayList getJsonFromURL(URL[] myURL) {
        //array due to async task requirements
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        StringBuffer buffer = new StringBuffer();

        try {
            conn = (HttpURLConnection) myURL[0].openConnection();
            conn.connect();

            InputStream stream = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String jsonString = buffer.toString();
        return getJsonFromString(jsonString);
    }
}
