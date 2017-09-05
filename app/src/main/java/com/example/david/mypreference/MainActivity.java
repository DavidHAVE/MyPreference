package com.example.david.mypreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String sumberKalori;
    private String sumberLatihan;

    private boolean isNotification = true;
    private int feetLength;

    private TextView mSumberKaloriTextView, mSumberLatihanTextView, mNotifikasiTextView, mLangkahTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSumberKaloriTextView = (TextView) findViewById(R.id.sumberkalori_text_view);
        mSumberLatihanTextView = (TextView) findViewById(R.id.sumberLatihan_text_view);
        mNotifikasiTextView = (TextView) findViewById(R.id.notifikasi_text_view);
        mLangkahTextView = (TextView) findViewById(R.id.jaraklangkah_text_view);

        setUpSharedPreferences();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpSharedPreferences();
    }

    private void setUpSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sumberKalori = sharedPreferences.getString("dailyCalorieSource", "1");
        sumberLatihan = sharedPreferences.getString("exerciseSource", "1");
        isNotification = sharedPreferences.getBoolean("notification", true);
        feetLength = Integer.parseInt(sharedPreferences.getString("stepLength", "70"));

        mSumberKaloriTextView.setText(sumberKalori);
        mSumberLatihanTextView.setText(sumberLatihan);

        mNotifikasiTextView.setText(String.valueOf(isNotification));
        mLangkahTextView.setText(String.valueOf(feetLength));
        Log.e("EatPlan", "sKalori = " + sumberKalori + " sLatihan = " + sumberLatihan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.setting_action_menu) {
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
            return true;
        } else {
            //
        }

        return super.onOptionsItemSelected(item);
    }
}
