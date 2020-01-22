package com.okandonmez.leveldesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class LevelChoose extends AppCompatActivity {
    GridView grLevels;

    String[] values = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"
    };

    int[] images = {R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choose);
        connectUI();
        int a;

    }

    private void connectUI(){
        grLevels = findViewById(R.id.lc_grLevels);
        grLevels.setNumColumns(3);
        CustomLevelsAdapter c_adapter = new CustomLevelsAdapter(this, values, images);
        grLevels.setAdapter(c_adapter);

        grLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), i + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        LevelChoose.this.finish();
    }
}
