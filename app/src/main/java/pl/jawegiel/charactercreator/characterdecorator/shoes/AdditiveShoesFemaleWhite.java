package pl.jawegiel.charactercreator.characterdecorator.shoes;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShoesFemaleWhite extends AdditiveShoesFemale {

    public AdditiveShoesFemaleWhite(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "white";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6FFFFFF");
    }
}
