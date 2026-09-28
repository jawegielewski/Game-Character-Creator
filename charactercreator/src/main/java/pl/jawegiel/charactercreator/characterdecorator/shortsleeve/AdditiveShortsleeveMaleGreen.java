package pl.jawegiel.charactercreator.characterdecorator.shortsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShortsleeveMaleGreen extends AdditiveShortsleeveMale {

    public AdditiveShortsleeveMaleGreen(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.green;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A62F8136");
    }
}
