package pl.jawegiel.charactercreator.characterdecorator;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Base64;

import pl.jawegiel.charactercreator.interfaces.IOnSpriteGet;
import pl.jawegiel.charactercreator.utility.AppConstants;

public class Black extends CharacterDecorator {

    @Override
    public int getColor() {
        return 0;
    }

    private final Context context;

    public Black(Character baseCharacter) {
        this.baseCharacter = baseCharacter;
        this.context = baseCharacter.getContext();
    }

    @Override
    public void passLook(IOnSpriteGet onSpriteGet) {
        if (baseCharacter.getBaseSpriteElement().equals(SpriteElement.MALE)) {
            byte[] decodedString = Base64.decode(AppConstants.getSpriteString(context, "black_male"), Base64.DEFAULT);
            onSpriteGet.onGet(BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
        } else if (baseCharacter.getBaseSpriteElement().equals(SpriteElement.FEMALE)) {
            byte[] decodedString = Base64.decode(AppConstants.getSpriteString(context, "black_female"), Base64.DEFAULT);
            onSpriteGet.onGet(BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
        }
        else
            throw new RuntimeException("Not recognizable sex");
    }

    @Override
    public SpriteElement getSpriteElement() {
        return SpriteElement.SKIN;
    }

    @Override
    public String getElementDescription() {
        return "black";
    }
}
