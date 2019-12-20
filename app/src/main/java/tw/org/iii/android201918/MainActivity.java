package tw.org.iii.android201918;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (Sensor sensor : sensors){
//            Log.v("brad", sensor.getName() + ":" + sensor.getStringType());
//        }

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myListener = new MyListener();
        sensorManager.registerListener(myListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(myListener);
    }

    private class MyListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

}
