package pl.jawegiel.charactercreator.utility;

import android.app.Activity;
import android.graphics.Color;

public class Util {
    public static void setNavigationBarBlackColor(Activity activity) {
        activity.getWindow().setNavigationBarColor(Color.parseColor("#000000"));
    }
}
