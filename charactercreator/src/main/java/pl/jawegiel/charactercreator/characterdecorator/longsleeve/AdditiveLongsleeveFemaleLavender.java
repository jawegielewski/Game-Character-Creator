package pl.jawegiel.charactercreator.characterdecorator.longsleeve;

import android.graphics.Color;

import pl.jawegiel.charactercreator.characterdecorator.Character;

public class AdditiveLongsleeveFemaleLavender extends AdditiveLongsleeveFemale {

    public AdditiveLongsleeveFemaleLavender(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public String getElementDescription() {
        return "lavender";
    }

    @Override
    public int getColor() {
        return Color.parseColor("#A6A966DD");
    }
}
