package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairCurlyLongBrown extends AdditiveHairCurlyLong {

    public AdditiveHairCurlyLongBrown(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "curly long brown";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a68b4513");
    }
}
