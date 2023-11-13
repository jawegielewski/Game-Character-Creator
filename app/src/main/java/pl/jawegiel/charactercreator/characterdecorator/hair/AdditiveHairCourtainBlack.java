package pl.jawegiel.charactercreator.characterdecorator.hair;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveHairCourtainBlack extends AdditiveHairCourtain {

    public AdditiveHairCourtainBlack(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "courtain black";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#a6000000");
    }
}
