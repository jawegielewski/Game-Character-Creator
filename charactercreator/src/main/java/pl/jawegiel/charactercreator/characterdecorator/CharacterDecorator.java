package pl.jawegiel.charactercreator.characterdecorator;

import android.content.Context;

import pl.jawegiel.charactercreator.interfaces.IOnSpriteGet;

public abstract class CharacterDecorator extends Character {

    protected Character baseCharacter;
    protected Context context;

    public Character getBaseCharacter() {
        return baseCharacter;
    }

    public void setBaseCharacter(Character baseCharacter) {
        this.baseCharacter = baseCharacter;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void passLook(IOnSpriteGet onSpriteGet);
}
