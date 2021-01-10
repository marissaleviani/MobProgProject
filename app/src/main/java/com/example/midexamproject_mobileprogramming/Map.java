package com.example.midexamproject_mobileprogramming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Map extends AppCompatActivity {

    SupportMapFragment supportMapFragment;
    TextView locTxt;
    GoogleMap gmap;
    ImageView backBtn;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.google_map);
        client = LocationServices.getFusedLocationProviderClient(this);
        backBtn = findViewById(R.id.backtoHome);
        locTxt = (TextView) findViewById(R.id.locationtxt);


        if(ActivityCompat.checkSelfPermission(Map.this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            //PERMISSION GRANTED
            getCurrentLocation();
        }else{
            //PERMISSION DENIED
            ActivityCompat.requestPermissions(Map.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Map.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getCurrentLocation() {
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                if(location!= null){
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            Geocoder geocoder = new Geocoder(Map.this, Locale.getDefault());
                            try {
                                List<Address> add = geocoder.getFromLocation(
                                        location.getLatitude(), location.getLongitude(), 1
                                );
                                locTxt.setText(Html.fromHtml(add.get(0).getAddressLine(0)+" , "+
                                        add.get(0).getLocality() +" , "+ add.get(0).getCountryName()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            MarkerOptions op = new MarkerOptions().position(latLng).title("I'm here");

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            googleMap.addMarker(op);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 44){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getCurrentLocation();
            }
        }
    }


//    private class PlaceTask extends AsyncTask<String, Integer, String>{
//        @Override
//        protected String doInBackground(String... strings){
//            String data = null;
//            try {
//                data = downloadUrl(strings[0]);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return data;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
////            new ParserTask().execute(s);
//        }
//    }
//
//    private  String downloadUrl(String string) throws IOException{
//        URL url = new URL(string);
//        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//        connection.connect();
//        InputStream stream = connection.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//        StringBuilder builder = new StringBuilder();
//        String line = "";
//        while((line = reader.readLine())!= null){
//            builder.append(line);
//        }
//        String data = builder.toString();
//        reader.close();
//        return data;
//    }


}
