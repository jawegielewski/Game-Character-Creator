package pl.jawegiel.charactercreator.characterdecorator.pants;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditivePantsMaleBlack extends AdditivePantsMale {

    public AdditivePantsMaleBlack(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.black;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6000000");
    }
}
