package pl.jawegiel.charactercreator.characterdecorator.shortsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShortsleeveMaleSlate extends AdditiveShortsleeveMale {

    public AdditiveShortsleeveMaleSlate(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "slate";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6B3AFA1");
    }
}
