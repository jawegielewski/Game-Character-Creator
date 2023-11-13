package pl.jawegiel.charactercreator.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import lombok.Getter;
import lombok.Setter;
import pl.jawegiel.charactercreator.CharacterCreator;
import pl.jawegiel.charactercreator.CharacterCreatorThread;
import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorCreated;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorThreadRun;

@Getter
@Setter
public class CharacterCreatorView extends View implements IOnCharacterCreatorThreadRun {

    private CharacterCreator characterCreator;
    private IOnCharacterCreatorCreated onCharacterCreatorCreated;

    public CharacterCreatorView(Context context) {
        super(context);
        init();
    }

    public CharacterCreatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CharacterCreatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (onCharacterCreatorCreated != null)
            onCharacterCreatorCreated.onCreated(characterCreator);

        CharacterCreatorThread characterCreatorThread = new CharacterCreatorThread(CharacterCreatorView.this);
        characterCreatorThread.setRunning(true);
        characterCreatorThread.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(characterCreator.imageResized.getWidth(), MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(characterCreator.imageResized.getHeight(), MeasureSpec.EXACTLY));
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if(characterCreator != null)
            characterCreator.draw(canvas);
        invalidate();
    }

    @Override
    public void onRun() {
        if(characterCreator != null)
            characterCreator.update();
    }

    private void init() {
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inPreferredConfig = Bitmap.Config.ARGB_8888;
        characterCreator = new CharacterCreator(BitmapFactory.decodeResource(getResources(), R.drawable.white_male, op));
    }
}