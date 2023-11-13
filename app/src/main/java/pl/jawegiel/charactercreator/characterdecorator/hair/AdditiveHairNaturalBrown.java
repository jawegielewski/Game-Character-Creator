package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairNaturalBrown extends AdditiveHairNatural {

    public AdditiveHairNaturalBrown(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "natural brown";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a68b4513");
    }
}
