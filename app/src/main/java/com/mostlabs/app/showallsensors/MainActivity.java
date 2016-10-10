package com.mostlabs.app.showallsensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Fais Al Huda on 10/1/2016.
 */
public class MainActivity extends AppCompatActivity {
    // Digunakan untuk mengakses sensor pada device
    SensorManager sensorManager;

    // Berfungsi untuk menampilkan data sensor yang didapatkan dari sensorManager
    TextView sensorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanisasi sensorManager
        sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);

        sensorText = (TextView)findViewById(R.id.sensorText);

        // Dikarenakan data sensor yang akan ditampilkan cukup banyak
        // sehingga dibutuhkan fungsi scrooling untuk membantu
        // melihat data yang melebihi batas screen bawah
        sensorText.setMovementMethod(new ScrollingMovementMethod());

        // Untuk mendapatkan data dari sensorManager berupa list
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // Perulanangan untuk menampilkan seluruh data sensor pada list
        for (int i = 0; i < sensorList.size();i++) {
            sensorText.append(sensorList.get(i).getName() + "\n" +
                    sensorList.get(i).getVendor() + "\n" +
                    sensorList.get(i).getVersion() + "\n"+
                    "--------------------------------------------------"+"\n");
        }
    }
}
