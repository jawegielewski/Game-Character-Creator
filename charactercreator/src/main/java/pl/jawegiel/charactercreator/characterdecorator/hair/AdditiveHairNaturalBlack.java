package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairNaturalBlack extends AdditiveHairNatural {

    public AdditiveHairNaturalBlack(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.natural_black;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6000000");
    }
}
