package pl.jawegiel.charactercreator.characterdecorator.longsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveLongsleeveMaleBrown extends AdditiveLongsleeveMale {

    public AdditiveLongsleeveMaleBrown(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.brown;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a68b4513");
    }
}
