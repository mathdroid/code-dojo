package com.pervasive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Vibrator;
import android.bluetooth.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import android.content.Intent;


public class PervasiveActivity extends Activity {
/** Called when the activity is first created. */
public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, pair, btncon, btndis, btnsend;
int turns;
public TextView tries, status, tvtries;
private Vibrator v;
private long ms;
private BluetoothAdapter mBluetoothAdapter = null;
private BluetoothSocket btSocket = null;
Intent intent = new Intent();
String action = intent.getAction();
BluetoothDevice mBluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
//private static String address = "00:06:66:01:4E:55";
private static String address = "00:18:F8:89:A4:8A";
long[] pattern1={0L,100L,100L,100L,100L,100L,100L};
private OutputStream mmOutStream;




@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    btn1 =(Button)findViewById(R.id.btn1);
    btn2 =(Button)findViewById(R.id.btn2);
    btn3 =(Button)findViewById(R.id.btn3);
    btn4 =(Button)findViewById(R.id.btn4);
    btn5 =(Button)findViewById(R.id.btn5);
    btn6 =(Button)findViewById(R.id.btn6);
    btn7 =(Button)findViewById(R.id.btn7);
    btn8 =(Button)findViewById(R.id.btn8);
    btn9 =(Button)findViewById(R.id.btn9);
    btn10 =(Button)findViewById(R.id.btn10);
    btn11 =(Button)findViewById(R.id.btn11);
    btn12 =(Button)findViewById(R.id.btn12);
    btn13 =(Button)findViewById(R.id.btn13);
    btn14 =(Button)findViewById(R.id.btn14);
    btn15 =(Button)findViewById(R.id.btn15);
    btn16 =(Button)findViewById(R.id.btn16);
    btn17 =(Button)findViewById(R.id.btn17);
    btn18 =(Button)findViewById(R.id.btn18);
    btn19 =(Button)findViewById(R.id.btn19);
    btn20 =(Button)findViewById(R.id.btn20);
    btn21 =(Button)findViewById(R.id.btn21);
    btn22 =(Button)findViewById(R.id.btn22);
    btn23 =(Button)findViewById(R.id.btn23);
    btn24 =(Button)findViewById(R.id.btn24);
    pair =(Button)findViewById(R.id.pair);


    btn1.setOnClickListener(btn1_handler);
    btn2.setOnClickListener(btn2_handler);
    btn3.setOnClickListener(btn3_handler);
    btn4.setOnClickListener(btn4_handler);
    btn5.setOnClickListener(btn5_handler);
    btn6.setOnClickListener(btn6_handler);
    btn7.setOnClickListener(btn7_handler);
    btn8.setOnClickListener(btn8_handler);
    btn9.setOnClickListener(btn9_handler);
    btn10.setOnClickListener(btn10_handler);
    btn11.setOnClickListener(btn11_handler);
    btn12.setOnClickListener(btn12_handler);
    btn13.setOnClickListener(btn13_handler);
    btn14.setOnClickListener(btn14_handler);
    btn15.setOnClickListener(btn15_handler);
    btn16.setOnClickListener(btn16_handler);
    btn17.setOnClickListener(btn17_handler);
    btn18.setOnClickListener(btn18_handler);
    btn19.setOnClickListener(btn19_handler);
    btn20.setOnClickListener(btn20_handler);
    btn21.setOnClickListener(btn21_handler);
    btn22.setOnClickListener(btn22_handler);
    btn23.setOnClickListener(btn23_handler);
    btn24.setOnClickListener(btn24_handler);
    pair.setOnClickListener(pair_handler);
    btncon=(Button) findViewById(R.id.con);
    btndis=(Button) findViewById(R.id.dis);
    btnsend=(Button) findViewById(R.id.send);

    turns=0;
    ((TextView)findViewById(R.id.tries)).setText("Tries: "+turns);
 mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
 mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(address);
 status=(TextView) findViewById(R.id.status1);

tvtries=(EditText) findViewById(R.id.tries);
v=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
ms=2000;

btndis.setEnabled(false);
btnsend.setEnabled(false);
//v.cancel();
if (mBluetoothAdapter.isEnabled())
{
    v.vibrate(200);
}
else
{
    mBluetoothAdapter.enable();
    v.vibrate(200);
}

}

View.OnClickListener btn1_handler = new View.OnClickListener() {

    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn1.setBackgroundResource(R.drawable.grnapp);

    }
};
View.OnClickListener btn2_handler = new View.OnClickListener() {

    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn2.setBackgroundResource(R.drawable.grnapp);
    }
};
View.OnClickListener btn3_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn3.setBackgroundResource(R.drawable.banana);

    }
};
View.OnClickListener btn4_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn4.setBackgroundResource(R.drawable.kiwi);

    }
};
View.OnClickListener btn5_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn5.setBackgroundResource(R.drawable.lemon);

    }
};
View.OnClickListener btn6_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn6.setBackgroundResource(R.drawable.lime);

    }
};
View.OnClickListener btn7_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn7.setBackgroundResource(R.drawable.strawberry);

    }
};
View.OnClickListener btn8_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn8.setBackgroundResource(R.drawable.coconut);
    }
};
View.OnClickListener btn9_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn9.setBackgroundResource(R.drawable.icecream);
    }
};
View.OnClickListener btn10_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn10.setBackgroundResource(R.drawable.teapot);

    }
};
View.OnClickListener btn11_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn11.setBackgroundResource(R.drawable.muffin);
    }
};
View.OnClickListener btn12_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn12.setBackgroundResource(R.drawable.bread);
    }
};
View.OnClickListener btn13_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn13.setBackgroundResource(R.drawable.beer);
    }
};
View.OnClickListener btn14_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn14.setBackgroundResource(R.drawable.kiwi);
    }
};
View.OnClickListener btn15_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn15.setBackgroundResource(R.drawable.strawberry);
    }
};
View.OnClickListener btn16_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn16.setBackgroundResource(R.drawable.coconut);
    }
};
View.OnClickListener btn17_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn17.setBackgroundResource(R.drawable.lime);
    }
};
View.OnClickListener btn18_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn18.setBackgroundResource(R.drawable.bread);
    }
};
View.OnClickListener btn19_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn19.setBackgroundResource(R.drawable.lemon);
    }
};
View.OnClickListener btn20_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn20.setBackgroundResource(R.drawable.teapot);
    }
};
View.OnClickListener btn21_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn21.setBackgroundResource(R.drawable.icecream);
    }
};
View.OnClickListener btn22_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn22.setBackgroundResource(R.drawable.beer);
    }
};
View.OnClickListener btn23_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn23.setBackgroundResource(R.drawable.muffin);
    }
};
View.OnClickListener btn24_handler = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        btn24.setBackgroundResource(R.drawable.banana);
    }
};
View.OnClickListener pair_handler = new View.OnClickListener() {


    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (btn1.getBackground() == btn2.getBackground()){
            btn1.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.INVISIBLE);

            }
        else if (btn3.getBackground() == btn24.getBackground()){
            btn3.setVisibility(View.INVISIBLE);
            btn24.setVisibility(View.INVISIBLE);
        }
        else if (btn4.getBackground() == btn14.getBackground()){
            btn4.setVisibility(View.INVISIBLE);
            btn14.setVisibility(View.INVISIBLE);
        }
        else if (btn5.getBackground() == btn19.getBackground()){
            btn5.setVisibility(View.INVISIBLE);
            btn19.setVisibility(View.INVISIBLE);
        }
        else if (btn6.getBackground() == btn17.getBackground()){
            btn6.setVisibility(View.INVISIBLE);
            btn17.setVisibility(View.INVISIBLE);
        }
        else if (btn7.getBackground() == btn15.getBackground()){
            btn7.setVisibility(View.INVISIBLE);
            btn15.setVisibility(View.INVISIBLE);
        }
        else if (btn8.getBackground() == btn16.getBackground()){
            btn8.setVisibility(View.INVISIBLE);
            btn16.setVisibility(View.INVISIBLE);
        }
        else if (btn9.getBackground() == btn21.getBackground()){
            btn9.setVisibility(View.INVISIBLE);
            btn21.setVisibility(View.INVISIBLE);
        }
        else if (btn10.getBackground() == btn20.getBackground()){
            btn10.setVisibility(View.INVISIBLE);
            btn20.setVisibility(View.INVISIBLE);
        }
        else if (btn11.getBackground() == btn23.getBackground()){
            btn11.setVisibility(View.INVISIBLE);
            btn23.setVisibility(View.INVISIBLE);
        }
        else if (btn12.getBackground() == btn18.getBackground()){
            btn12.setVisibility(View.INVISIBLE);
            btn18.setVisibility(View.INVISIBLE);
        }
        else if (btn13.getBackground() == btn22.getBackground()){
            btn13.setVisibility(View.INVISIBLE);
            btn22.setVisibility(View.INVISIBLE);
        }

        else {
            btn1.setBackgroundResource(R.drawable.ic_launcher);
            btn2.setBackgroundResource(R.drawable.ic_launcher2);
            btn3.setBackgroundResource(R.drawable.ic_launcher3);
            btn4.setBackgroundResource(R.drawable.ic_launcher4);
            btn5.setBackgroundResource(R.drawable.ic_launcher5);
            btn6.setBackgroundResource(R.drawable.ic_launcher6);
            btn7.setBackgroundResource(R.drawable.ic_launcher7);
            btn8.setBackgroundResource(R.drawable.ic_launcher8);
            btn9.setBackgroundResource(R.drawable.ic_launcher9);
            btn10.setBackgroundResource(R.drawable.ic_launcher10);
            btn11.setBackgroundResource(R.drawable.ic_launcher11);
            btn12.setBackgroundResource(R.drawable.ic_launcher12);
            btn13.setBackgroundResource(R.drawable.ic_launcher13);
            btn14.setBackgroundResource(R.drawable.ic_launcher14);
            btn15.setBackgroundResource(R.drawable.ic_launcher15);
            btn16.setBackgroundResource(R.drawable.ic_launcher16);
            btn17.setBackgroundResource(R.drawable.ic_launcher17);
            btn18.setBackgroundResource(R.drawable.ic_launcher18);
            btn19.setBackgroundResource(R.drawable.ic_launcher19);
            btn20.setBackgroundResource(R.drawable.ic_launcher20);
            btn21.setBackgroundResource(R.drawable.ic_launcher21);
            btn22.setBackgroundResource(R.drawable.ic_launcher22);
            btn23.setBackgroundResource(R.drawable.ic_launcher23);
            btn24.setBackgroundResource(R.drawable.ic_launcher24);
        }
        turns++;
        ((TextView)findViewById(R.id.tries)).setText("Tries: "+turns);


    }
};
 public void myConnectHandler(View view) {
        try
        {
        btSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(MY_UUID);

        } catch (IOException e) {
        //  // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (mBluetoothAdapter.isEnabled())
        {
            try
            {
                btSocket.connect(); //connection here

                status.setText("Connected to Remote Device");
                btncon.setEnabled(false);
                btndis.setEnabled(true);
                btnsend.setEnabled(true);
                v.vibrate(ms);

                }

            catch (IOException e)
            {
                Toast.makeText(this, "Unable to Connect to Remote Device!", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Bluetooth Adapter is off!", Toast.LENGTH_SHORT).show();
        }

    }
    public void mySendHandler (View view){
        if (tvtries.length() > 0) {
            String score = tvtries.getText().toString();   //put string score here
            byte[] send = score.getBytes();
            try {
                mmOutStream = btSocket.getOutputStream();
                mmOutStream.write(send);
                btSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Toast.makeText(this, "Cannot send message!", Toast.LENGTH_SHORT).show();
            }
        }
        btnsend.setEnabled(false);


    }






    public void myDisconnectHandler(View view) {
        try
        {
            btSocket.close();
            v.vibrate(pattern1,6);
        }
        catch (IOException e)
        {
            Toast.makeText(this, "unable to disconnect from Remote Device!", Toast.LENGTH_SHORT).show();
        }
        try
        {
            mBluetoothAdapter.disable();
            btncon.setEnabled(true);
            btndis.setEnabled(false);
            btnsend.setEnabled(false);
            status.setText("Press the Button to Connect");
        }
        finally{
        }
        btncon.setEnabled(true);
        btndis.setEnabled(false);
    }


    @Override
    public void onDestroy(){

        super.onDestroy();

    }




};
