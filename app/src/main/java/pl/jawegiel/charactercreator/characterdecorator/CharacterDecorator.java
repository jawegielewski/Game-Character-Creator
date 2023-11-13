package pl.jawegiel.charactercreator.characterdecorator;

import android.content.Context;

import lombok.Getter;
import lombok.Setter;
import pl.jawegiel.charactercreator.interfaces.IOnSpriteGet;

@Getter
@Setter
public abstract class CharacterDecorator extends Character {

    protected Character baseCharacter;
    protected Context context;

    public abstract void passLook(IOnSpriteGet onSpriteGet);
}
