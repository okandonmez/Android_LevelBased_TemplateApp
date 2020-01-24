package com.okandonmez.leveldesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GameScene extends AppCompatActivity implements View.OnClickListener {
    Button gs_btnTemp;
    int levelIndice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        Button btnTemp = findViewById(R.id.gs_btnTempLvlFinis);
        btnTemp.setOnClickListener(this);

        Intent intent = getIntent();
        levelIndice = intent.getIntExtra("levelChoose", 0);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.gs_btnTempLvlFinis:
                incLevelIndice();
        }
    }

    private void incLevelIndice() {
        SharedPreferences prefs = getSharedPreferences("levelDesignLogic", MODE_PRIVATE);
        int lastLvOld = prefs.getInt("lastLevel", 0);

        SharedPreferences.Editor editor = getSharedPreferences("levelDesignLogic", MODE_PRIVATE).edit();
        Toast.makeText(getApplicationContext(), lastLvOld + "", Toast.LENGTH_SHORT).show();

        if(lastLvOld == levelIndice || lastLvOld == 0){
            lastLvOld++;
            editor.putInt("lastLevel", lastLvOld);
            Toast.makeText(getApplicationContext(), "asdas2222", Toast.LENGTH_SHORT).show();
            editor.apply();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), LevelChoose.class));
        GameScene.this.finish();
    }
}
