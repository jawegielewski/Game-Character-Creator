package pl.jawegiel.charactercreator.characterdecorator;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map;


public abstract class Character {

    Bitmap bitmapBase;
    Bitmap bitmapFinal;
    SpriteElement baseSpriteElement;
    Map<SpriteElement, DecoratorItem> decorationsMap = new LinkedHashMap<>();
    CharacterDecorator skin;
    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public Bitmap getBitmapBase() {
        return bitmapBase;
    }

    public void setBitmapBase(Bitmap bitmapBase) {
        this.bitmapBase = bitmapBase;
    }

    public Bitmap getBitmapFinal() {
        return bitmapFinal;
    }

    public void setBitmapFinal(Bitmap bitmapFinal) {
        this.bitmapFinal = bitmapFinal;
    }

    public SpriteElement getBaseSpriteElement() {
        return baseSpriteElement;
    }

    public void setBaseSpriteElement(SpriteElement baseSpriteElement) {
        this.baseSpriteElement = baseSpriteElement;
    }

    public Map<SpriteElement, DecoratorItem> getDecorationsMap() {
        return decorationsMap;
    }

    public void setDecorationsMap(Map<SpriteElement, DecoratorItem> decorationsMap) {
        this.decorationsMap = decorationsMap;
    }

    public CharacterDecorator getSkin() {
        return skin;
    }

    public void setSkin(CharacterDecorator skin) {
        this.skin = skin;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SharedPreferences getSp() {
        return sp;
    }

    public void setSp(SharedPreferences sp) {
        this.sp = sp;
    }

    public SharedPreferences.Editor getSpEditor() {
        return spEditor;
    }

    public void setSpEditor(SharedPreferences.Editor spEditor) {
        this.spEditor = spEditor;
    }

    public abstract SpriteElement getSpriteElement();
    public abstract String getElementDescription();
    public abstract int getColor();
}
