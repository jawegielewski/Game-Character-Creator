package pl.jawegiel.charactercreator.characterdecorator;

import android.graphics.Bitmap;

import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.interfaces.IOnSpriteGet;

public class AdditiveEmpty extends CharacterDecorator {

    SpriteElement spriteElement;

    public AdditiveEmpty(Character baseCharacter, SpriteElement spriteElement) {
        this.baseCharacter = baseCharacter;
        this.spriteElement = spriteElement;
    }

    @Override
    public void passLook(IOnSpriteGet onSpriteGet) {
        onSpriteGet.onGet(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        ((BaseCharacter) baseCharacter).deleteAdditive(spriteElement);
    }

    @Override
    public SpriteElement getSpriteElement() {
        return spriteElement;
    }

    @Override
    public int getElementDescription() {
        if (spriteElement == SpriteElement.HAIR)
            return R.string.no_hair;
        else if (spriteElement == SpriteElement.PANTS_MALE
                || spriteElement == SpriteElement.PANTS_FEMALE)
            return R.string.no_pants;
        else if (spriteElement == SpriteElement.LONGSLEEVE_MALE
                || spriteElement == SpriteElement.LONGSLEEVE_FEMALE)
            return R.string.no_longsleeve;
        else if (spriteElement == SpriteElement.SHORTSLEEVE_MALE
                || spriteElement == SpriteElement.SHORTSLEEVE_FEMALE)
            return R.string.no_shortsleeve;
        else if (spriteElement == SpriteElement.SHOES_MALE
                || spriteElement == SpriteElement.SHOES_FEMALE)
            return R.string.no_shoes;
        else
            return R.string.no_unknown;
    }

    @Override
    public int getColor() {
        return android.R.color.transparent;
    }
}
