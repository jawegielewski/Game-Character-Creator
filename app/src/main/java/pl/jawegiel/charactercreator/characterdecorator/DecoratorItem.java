package pl.jawegiel.charactercreator.characterdecorator;

import android.graphics.Bitmap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecoratorItem {

    private String description;
    private Bitmap bitmap;
    private int color;

    public DecoratorItem(String description, Bitmap bitmap, int color) {
        this.description = description;
        this.bitmap = bitmap;
        this.color = color;
    }
}
