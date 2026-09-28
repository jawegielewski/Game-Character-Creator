package pl.jawegiel.charactercreator.characterdecorator.longsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveLongsleeveMaleSky extends AdditiveLongsleeveMale {

    public AdditiveLongsleeveMaleSky(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.sky;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6C6EEFD");
    }
}
