package pl.jawegiel.charactercreator.characterdecorator.shortsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShortsleeveFemaleTan extends AdditiveShortsleeveFemale {

    public AdditiveShortsleeveFemaleTan(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "tan";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6B7996A");
    }
}
