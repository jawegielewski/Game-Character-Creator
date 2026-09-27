package pl.jawegiel.charactercreator.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import pl.jawegiel.charactercreator.CharacterCreator;
import pl.jawegiel.charactercreator.CharacterCreatorBgThread;
import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorThreadRun;

public class BgView extends View implements IOnCharacterCreatorThreadRun {

    private int screenWidth, screenHeight, newWidth;
    private float cloud1X, grassX, grassY;
    private CharacterCreator characterCreator;
    private Bitmap cloud1Resized;
    private Bitmap cloud2Resized;
    private Bitmap grassResized;
    private Bitmap skyResized;
    private float cloud2X;
    private int newWidth2;

    public void setCharacterCreator(CharacterCreator characterCreator) {
        this.characterCreator = characterCreator;
    }

    public BgView(Context context) {
        super(context);
    }

    public BgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CharacterCreatorBgThread characterCreatorThread = new CharacterCreatorBgThread(getContext(), this);
        characterCreatorThread.setRunning(true);
        characterCreatorThread.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        screenWidth = w;
        screenHeight = h;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap sky = BitmapFactory.decodeResource(getResources(), R.drawable.sky, options);
        Bitmap clouds1 = getBitmapFromVectorDrawable(R.drawable.clouds_blue);
        Bitmap clouds2 = getBitmapFromVectorDrawable(R.drawable.clouds_white);
        Bitmap grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass3, options);

        float clouds1Ratio = (float) clouds1.getWidth() / clouds1.getHeight();
        float clouds2Ratio = (float) clouds2.getWidth() / clouds2.getHeight();

        newWidth = (int) (clouds1Ratio * screenHeight) / 2;
        newWidth2 = (int) (clouds2Ratio * screenHeight) / 2;

        skyResized = Bitmap.createScaledBitmap(sky, screenWidth, screenHeight, false);

        cloud1Resized = Bitmap.createScaledBitmap(clouds1, newWidth, (int) (screenHeight / 1.75), false);
        cloud2Resized = Bitmap.createScaledBitmap(clouds2, newWidth2, (int) (screenHeight / 1.75), false);

        int grassHeight = (int) (screenHeight * 0.45f);
        grassResized = Bitmap.createScaledBitmap(grass, newWidth, grassHeight, false);
        grassX = -(float) (grassResized.getWidth() / 2) + (float) (screenWidth / 2);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (skyResized == null) return;

        cloud1X -= 1.25f;
        if (cloud1X < -newWidth) {
            cloud1X = 0;
        }
        cloud2X -= 2;
        if (cloud2X < -newWidth2) {
            cloud2X = 0;
        }
        canvas.drawBitmap(skyResized, 0, 0, null);
        canvas.drawBitmap(cloud1Resized, cloud1X, 100, null);
        canvas.drawBitmap(cloud2Resized, cloud2X, 0, null);

        if (cloud1X < screenWidth - newWidth) {
            canvas.drawBitmap(cloud1Resized, cloud1X + newWidth, 100, null);
        }
        if (cloud2X < screenWidth - newWidth2) {
            canvas.drawBitmap(cloud2Resized, cloud2X + newWidth2, 0, null);
        }

        if (characterCreator != null) {

            if (characterCreator.getRoundDirection() == 1) {
                grassX += 4;
                if (grassX > 0) {
                    grassX -= newWidth;
                }
            } else if (characterCreator.getRoundDirection() == 2) {
                grassY += 4;
                if (grassY > 100) {
                    grassY = 100;
                }
            } else if (characterCreator.getRoundDirection() == 3) {
                grassX -= 4;
                if (grassX < -newWidth) {
                    grassX += newWidth;
                }
            } else if (characterCreator.getRoundDirection() == 0) {
                grassY -= 4;
                if (grassY < -100) {
                    grassY = -100;
                }
            }
        }

        int grassYPos = (int) (screenHeight - (screenHeight * 0.25)) + (int) grassY;
        canvas.drawBitmap(grassResized, grassX, grassYPos, null);
        canvas.drawBitmap(grassResized, grassX + newWidth, grassYPos, null);
    }

    public Bitmap getBitmapFromVectorDrawable(int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), drawableId);

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    @Override
    public void onRun() {
        invalidate();
    }
}
