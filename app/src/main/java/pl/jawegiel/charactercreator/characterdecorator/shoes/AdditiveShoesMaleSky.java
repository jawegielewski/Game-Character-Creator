package pl.jawegiel.charactercreator.characterdecorator.shoes;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveShoesMaleSky extends AdditiveShoesMale {

    public AdditiveShoesMaleSky(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "sky";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A69FBBCB");
    }
}
