package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairCourtainBrown extends AdditiveHairCourtain {

    public AdditiveHairCourtainBrown(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "courtain brown";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a68b4513");
    }
}
