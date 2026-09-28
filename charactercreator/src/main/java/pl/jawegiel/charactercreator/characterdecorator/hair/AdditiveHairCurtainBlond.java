package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairCurtainBlond extends AdditiveHairCurtain {

    public AdditiveHairCurtainBlond(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.curtain_blonde;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6fdee87");
    }
}
