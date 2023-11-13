package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairLooseBlack extends AdditiveHairLoose {

    public AdditiveHairLooseBlack(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "loose black";
    }


    @Override
    public int getColor() {
        return Color.parseColor("#a6000000");
    }
}
