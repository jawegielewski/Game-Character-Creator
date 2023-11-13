package pl.jawegiel.charactercreator.characterdecorator.shoes;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShoesFemaleYellow extends AdditiveShoesFemale {

    public AdditiveShoesFemaleYellow(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "yellow";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6F3C03F");
    }
}
