package pl.jawegiel.charactercreator.characterdecorator.pants;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditivePantsFemaleGreen extends AdditivePantsFemale {

    public AdditivePantsFemaleGreen(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "blue gray";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6214437");
    }
}
