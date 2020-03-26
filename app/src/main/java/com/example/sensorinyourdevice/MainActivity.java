package com.example.sensorinyourdevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
      public ListView listView;
      public SensorManager sensorManager;
      public List<Sensor> listsensor;
       public List<String> liststring ;
        public ArrayAdapter<String> adopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        liststring=new ArrayList<String>();
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);

        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (int i=0;i<listsensor.size();i++)
        {
            liststring.add(listsensor.get(i).getName());
        }
        adopter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_2,android.R.id.text1,liststring);
        listView.setAdapter(adopter);


    }
}
