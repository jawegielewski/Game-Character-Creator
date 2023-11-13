package pl.jawegiel.charactercreator.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pl.jawegiel.charactercreator.utility.Util;

public class ActivityBase extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Util.setNavigationBarBlackColor(this);
    }
}
