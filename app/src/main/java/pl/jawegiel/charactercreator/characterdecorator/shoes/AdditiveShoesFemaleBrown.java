package pl.jawegiel.charactercreator.characterdecorator.shoes;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShoesFemaleBrown extends AdditiveShoesFemale {

    public AdditiveShoesFemaleBrown(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "brown";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a68b4513");
    }
}
