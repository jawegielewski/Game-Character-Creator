package pl.jawegiel.charactercreator.characterdecorator.pants;

import android.graphics.BitmapFactory;
import android.util.Base64;

import pl.jawegiel.charactercreator.characterdecorator.Character;
import pl.jawegiel.charactercreator.characterdecorator.CharacterDecorator;
import pl.jawegiel.charactercreator.characterdecorator.SpriteElement;
import pl.jawegiel.charactercreator.interfaces.IOnSpriteGet;
import pl.jawegiel.charactercreator.utility.AppConstants;

public abstract class AdditivePantsMale extends CharacterDecorator {

    public AdditivePantsMale(Character baseCharacter) {
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public void passLook(IOnSpriteGet onSpriteGet) {
        byte[] decodedString = Base64.decode(AppConstants.getSpriteString(context, "pants_male_white"), Base64.DEFAULT);
        onSpriteGet.onGet(BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
    }

    @Override
    public SpriteElement getSpriteElement() {
        return SpriteElement.PANTS_MALE;
    }
}
