package pl.jawegiel.charactercreator.characterdecorator.longsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveLongsleeveMaleLavender extends AdditiveLongsleeveMale {

    public AdditiveLongsleeveMaleLavender(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public int getElementDescription() {
        return R.string.lavender;
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6A966DD");
    }
}
