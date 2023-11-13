package pl.jawegiel.charactercreator.characterdecorator;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    Bitmap bitmapBase;
    Bitmap bitmapFinal;
    SpriteElement baseSpriteElement;
    Map<SpriteElement, DecoratorItem> decorationsMap = new HashMap<>();
    CharacterDecorator skin;
    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public abstract SpriteElement getSpriteElement();
    public abstract String getElementDescription();
    public abstract int getColor();
}
