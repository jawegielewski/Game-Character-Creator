package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairHighAndTightBlond extends AdditiveHairHighAndTight {

    public AdditiveHairHighAndTightBlond(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "high and tight blonde";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6fdee87");
    }
}
