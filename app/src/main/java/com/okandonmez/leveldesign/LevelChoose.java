package com.okandonmez.leveldesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class LevelChoose extends AppCompatActivity {
    int lastLevel;

    GridView grLevels;
    private final int totalLevel = 8;

    String[] valuesUnlocked = {"1_unlocked",
            "2_unlocked",
            "3_unlocked",
            "4_unlocked",
            "5_unlocked",
            "6_unlocked",
            "7_unlocked",
            "8_unlocked"
    };

    String[] valuesLocked = {"1_locked",
            "2_locked",
            "3_locked",
            "4_locked",
            "5_locked",
            "6_locked",
            "7_locked",
            "8_locked"
    };

    int[] imagesUnlocked = {R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock,
            R.drawable.unlock};

    int[] imagesLocked = {R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked,
            R.drawable.locked};

    int[] imagesFinal;
    String[] valuesFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choose);

        setLevelUnlockLogic();
        connectUI();

    }

    private void setLevelUnlockLogic() {
        SharedPreferences prefs = getSharedPreferences("levelDesignLogic", MODE_PRIVATE);
        lastLevel = prefs.getInt("lastLevel", 0);
        Toast.makeText(getApplicationContext(), lastLevel + "", Toast.LENGTH_SHORT).show();
        //lastLevel = 4;

        valuesFinal = new String[totalLevel];
        imagesFinal = new int[totalLevel]   ;

        for(int i = 0; i < totalLevel; i++){
            if(i <= lastLevel){
                valuesFinal[i] = valuesUnlocked[i];
                imagesFinal[i] = imagesUnlocked[i];
            }
            else{
                valuesFinal[i] = valuesLocked[i];
                imagesFinal[i] = imagesLocked[i];
            }
        }

    }

    private void connectUI(){
        grLevels = findViewById(R.id.lc_grLevels);
        grLevels.setNumColumns(3);
        CustomLevelsAdapter c_adapter = new CustomLevelsAdapter(this, valuesFinal, imagesFinal);
        grLevels.setAdapter(c_adapter);

        grLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(lastLevel >= i){
                    Intent intent = new Intent(getApplicationContext(), GameScene.class);
                    intent.putExtra("levelChoose", i);
                    startActivity(intent);
                    LevelChoose.this.finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Dont unlocked", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        LevelChoose.this.finish();
    }
}
