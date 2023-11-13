package pl.jawegiel.charactercreator.characterdecorator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.Base64;

import pl.jawegiel.charactercreator.interfaces.IOnAdditiveAdded;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterChangeElement;
import pl.jawegiel.charactercreator.utility.AppConstants;

public class BaseCharacter extends Character {

    IOnCharacterChangeElement onCharacterChangeElement;
    IOnAdditiveAdded onAdditiveAdded;

    public BaseCharacter(Context context, IOnCharacterChangeElement onCharacterChangeElement, IOnAdditiveAdded onAdditiveAdded) {
        this.context = context;
        this.onAdditiveAdded = onAdditiveAdded;
        this.onCharacterChangeElement = onCharacterChangeElement;

        doOnStartBase(context, onAdditiveAdded);
    }

    public void doOnStartBase(Context context, IOnAdditiveAdded onAdditiveAdded) {
        byte[] decodedString = Base64.decode(AppConstants.getSpriteString(context, "white_male"), Base64.DEFAULT);

        bitmapBase = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        bitmapFinal = bitmapBase;

        setBaseSpriteElement(SpriteElement.MALE);
        onAdditiveAdded.onAdded(SpriteElement.BASE);

        skin = new White(this);

        if (!decorationsMap.isEmpty()) {
            decorationsMap.clear();
        }
    }

    public void changeBase(SpriteElement spriteElementNow) {
        setBaseSpriteElement(spriteElementNow);

        skin.passLook(bitmap -> {
            Bitmap bmOverlay = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(bmOverlay);

            canvas.drawBitmap(bitmap, new Matrix(), null);
            if (!decorationsMap.isEmpty()) {
                for (DecoratorItem decoratorItem : decorationsMap.values()) {
                    Paint paint = new Paint();
                    ColorFilter filter = new PorterDuffColorFilter(decoratorItem.getColor(), PorterDuff.Mode.SRC_ATOP);
                    paint.setColorFilter(filter);
                    canvas.drawBitmap(decoratorItem.getBitmap(), new Matrix(), paint);
                }
            }
            bitmapBase = bitmap;
            bitmapFinal = bmOverlay;

            onCharacterChangeElement.onChange();
            onAdditiveAdded.onAdded(spriteElementNow);
        });
    }

    public void appendSkin(CharacterDecorator decorator) {
        skin = decorator;

        decorator.passLook(bitmap -> {
            bitmapBase = bitmap;

            Bitmap bmOverlay = Bitmap.createBitmap(bitmapBase.getWidth(), bitmapBase.getHeight(), bitmapBase.getConfig());
            Canvas canvas = new Canvas(bmOverlay);

            canvas.drawBitmap(bitmapBase, new Matrix(), null);
            if (!decorationsMap.isEmpty()) {
                for (DecoratorItem decoratorItem : decorationsMap.values()) {
                    Paint paint = new Paint();
                    ColorFilter filter = new PorterDuffColorFilter(decoratorItem.getColor(), PorterDuff.Mode.SRC_ATOP);
                    paint.setColorFilter(filter);
                    canvas.drawBitmap(decoratorItem.getBitmap(), new Matrix(), paint);
                }
            }

            bitmapFinal = bmOverlay;

            onCharacterChangeElement.onChange();
            onAdditiveAdded.onAdded(decorator.getSpriteElement());
        });
    }

    public void appendAdditive(CharacterDecorator decorator) {

        Bitmap bmOverlay = Bitmap.createBitmap(bitmapBase.getWidth(), bitmapBase.getHeight(), bitmapBase.getConfig());
        Canvas canvas = new Canvas(bmOverlay);

        canvas.drawBitmap(bitmapBase, new Matrix(), null);

        decorator.passLook(bitmap -> {
            DecoratorItem decoratorItem = new DecoratorItem(decorator.getElementDescription(), bitmap, decorator.getColor());
            decorationsMap.put(decorator.getSpriteElement(), decoratorItem);

            if (!decorationsMap.isEmpty()) {
                for (DecoratorItem decoratorItem2 : decorationsMap.values()) {
                    if (decoratorItem == decoratorItem2) {
                        Paint paint = new Paint();
                        ColorFilter filter = new PorterDuffColorFilter(decoratorItem2.getColor(), PorterDuff.Mode.SRC_ATOP);
                        paint.setColorFilter(filter);
                        canvas.drawBitmap(decoratorItem2.getBitmap(), new Matrix(), paint);
                    } else {
                        Paint paint = new Paint();
                        ColorFilter filter = new PorterDuffColorFilter(decoratorItem2.getColor(), PorterDuff.Mode.SRC_ATOP);
                        paint.setColorFilter(filter);
                        canvas.drawBitmap(decoratorItem2.getBitmap(), new Matrix(), paint);
                    }
                }
            }

            bitmapFinal = bmOverlay;

            onCharacterChangeElement.onChange();
            onAdditiveAdded.onAdded(decorator.getSpriteElement());
        });
    }


    public String getDecoratorItemDescription(SpriteElement spriteElement) {
        if (!spriteElement.equals(SpriteElement.SKIN)) {
            if (decorationsMap.get(spriteElement) != null)
                return decorationsMap.get(spriteElement).getDescription();
        } else
            return skin.getElementDescription();

        throw new RuntimeException("Cannot get decorator item description.");
    }

    public void deleteAdditive(SpriteElement spriteElement) {
        if (decorationsMap.get(spriteElement) != null) {
            decorationsMap.remove(spriteElement);
        }
    }

    @Override
    public SpriteElement getSpriteElement() {
        return this.getBaseSpriteElement();
    }

    @Override
    public String getElementDescription() {
        return "base";
    }

    @Override
    public int getColor() {
        return android.R.color.transparent;
    }
}
