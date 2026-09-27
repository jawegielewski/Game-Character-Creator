package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairCurlyLongBlond extends AdditiveHairCurlyLong {

    public AdditiveHairCurlyLongBlond(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "curly long blonde";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6fdee87");
    }
}
