package pl.jawegiel.charactercreator.utility;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class AppConstants {

    public static String getSpriteString(Context context, String spriteElement) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(spriteElement+".txt"), StandardCharsets.UTF_8));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                stringBuilder.append(mLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}

