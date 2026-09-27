package pl.jawegiel.charactercreator.characterdecorator;

import android.graphics.Bitmap;

public class DecoratorItem {

    private String description;
    private Bitmap bitmap;
    private int color;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public DecoratorItem(String description, Bitmap bitmap, int color) {
        this.description = description;
        this.bitmap = bitmap;
        this.color = color;
    }
}
