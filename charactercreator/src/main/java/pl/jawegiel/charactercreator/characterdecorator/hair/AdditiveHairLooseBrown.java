package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairLooseBrown extends AdditiveHairLoose {

    public AdditiveHairLooseBrown(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.loose_blonde;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a68b4513");
    }
}
