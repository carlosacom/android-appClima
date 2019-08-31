package com.example.probandohttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.probandohttp.models.City;
import com.example.probandohttp.models.Town;
import com.example.probandohttp.services.WeatherService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        Call<City> cityCall = service.getCity("Bogota,CO", "b1b15e88fa797225412429c1c50c122a1");
        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();

            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        // String string_City =   "{ \"id\": 200, \"name\": \"Cúcuta\", yo: 'tu' }";
        // String json = "{cities:[" + string_City  + "," + string_City  + "," + string_City +"]}";

        /* try {
            City city = null;
            JSONObject mJson = new JSONObject(json);
            int id = mJson.getInt("id");
            String name = mJson.getString("name");
            city = new City(id, name);
        } catch (JSONException e) {
            e.getStackTrace();
        } */
        // Toast.makeText(this, city.getId() + " " + city.getName(), Toast.LENGTH_LONG).show();

        // Gson gson = new GsonBuilder().create();
        //  Town town = gson.fromJson(json, Town.class);

        // Toast.makeText(this, town.getId() + " " + city1.getName(), Toast.LENGTH_LONG).show();
    }
}
