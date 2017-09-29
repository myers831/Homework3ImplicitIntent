package com.example.admin.implicitintent;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void implicitIntentFunction(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Intent intentSM = new Intent();
                intentSM.setAction(Intent.ACTION_SEND);
                intentSM.putExtra(Intent.EXTRA_TEXT, "This is a Message ");
                intentSM.setType("text/plain");
                startActivity(intentSM);
                break;
            case R.id.btn2:
                Intent intentSW = new Intent();
                intentSW.setAction(Intent.ACTION_WEB_SEARCH);
                intentSW.putExtra(SearchManager.QUERY, "Food");
                startActivity(intentSW);
                break;
            case R.id.btn3:
                String number = "23454568678";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                    return;
                }
                startActivity(intent);
                break;
        }
    }
}
