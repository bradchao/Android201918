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
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyListener myListener;
//    private TextView x, y,z;
    private int viewW, viewH;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);

        viewW = getWindowManager().getDefaultDisplay().getWidth();
        viewH = getWindowManager().getDefaultDisplay().getHeight();
        Log.v("brad", viewW + " x " + viewH);

//        x = findViewById(R.id.vX);
//        y = findViewById(R.id.vY);
//        z = findViewById(R.id.vZ);

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
        sensorManager.registerListener(myListener, sensor,
                SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(myListener);
    }

    private class MyListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
//            x.setText("" + (int)(values[0]*100)/100f);
//            y.setText("" + (int)(values[1]*100)/100f);
//            z.setText("" + (int)(values[2]*100)/100f);

            float fx = values[0];
            float fy = values[1]*-1;
            float fz = values[2];
            changeXY(fx, fy, fz);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void changeXY(float x, float y, float z){
        float xx = x*viewW/20 + viewW/2;
        float yy = y*viewH/20 + viewH/2;
        myView.setXY(xx, yy, z);
    }


}
