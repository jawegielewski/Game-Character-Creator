package pl.jawegiel.charactercreator.interfaces;

import android.app.Activity;
import android.graphics.Bitmap;

import pl.jawegiel.charactercreator.model.UserLookDTO;

public interface IOnNextPressed {
    void onPressed(UserLookDTO userLookDTO, Activity activity, Bitmap bitmapFinal);
}