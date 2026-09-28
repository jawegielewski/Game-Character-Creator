package pl.jawegiel.charactercreator.characterdecorator.shortsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShortsleeveFemaleBlue extends AdditiveShortsleeveFemale {

    public AdditiveShortsleeveFemaleBlue(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.blue;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6466AC9");
    }
}
