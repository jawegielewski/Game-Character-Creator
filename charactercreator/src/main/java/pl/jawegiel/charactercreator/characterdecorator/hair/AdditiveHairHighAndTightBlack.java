package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairHighAndTightBlack extends AdditiveHairHighAndTight {

    public AdditiveHairHighAndTightBlack(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.high_and_tight_black;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6000000");
    }
}
