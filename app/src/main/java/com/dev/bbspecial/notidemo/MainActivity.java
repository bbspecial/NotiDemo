package com.dev.bbspecial.notidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public TextView tv,tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_status = (TextView) findViewById(R.id.tv_status);


    }


    public void testFN(View view){
        tv = (TextView) findViewById(R.id.tv_showResult);
        tv.setText("olo");
    }

    public void showToken(View view) {
        // แสดง token มาให้ดูหน่อยเสะ

        tv_status.setText(FirebaseInstanceId.getInstance().getToken());
        Log.i("token", FirebaseInstanceId.getInstance().getToken());
    }

    public void subscribe(View view) {
        // สับตะไคร้หัวข้อ news
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        tv_status.setText("subscribed");
    }
    public void unsubscribe(View view) {
        // ยกเลิกสับตะไคร้หัวข้อ news
        FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
        tv_status.setText("unsubscribed");
    }
}
