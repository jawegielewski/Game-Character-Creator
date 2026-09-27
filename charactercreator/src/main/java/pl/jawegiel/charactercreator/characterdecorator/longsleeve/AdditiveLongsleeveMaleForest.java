package pl.jawegiel.charactercreator.characterdecorator.longsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveLongsleeveMaleForest extends AdditiveLongsleeveMale {

    public AdditiveLongsleeveMaleForest(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "forest";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a63B2413");
    }
}
