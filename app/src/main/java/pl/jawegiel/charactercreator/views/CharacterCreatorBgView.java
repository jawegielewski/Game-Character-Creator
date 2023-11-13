package pl.jawegiel.charactercreator.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import pl.jawegiel.charactercreator.CharacterCreator;
import pl.jawegiel.charactercreator.CharacterCreatorBgThread;
import pl.jawegiel.charactercreator.R;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorThreadRun;

public class CharacterCreatorBgView extends View implements IOnCharacterCreatorThreadRun {

    private int screenWidth, screenHeight, newWidth, newHeight;
    private float cloud1X, grassX, grassY, mountainsCloserY;
    private Bitmap mountain;
    private CharacterCreator characterCreator;
    private Bitmap cloud1Resized;
    private Bitmap cloud2Resized;
    private Bitmap grassResized;
    private Bitmap skyResized;
    private float cloud2X;
    private int newWidth2;
    private Bitmap mountainFarAway;

    public void setCharacterCreator(CharacterCreator characterCreator) {
        this.characterCreator = characterCreator;
    }

    public CharacterCreatorBgView(Context context) {
        super(context);
        init();
    }

    public CharacterCreatorBgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CharacterCreatorBgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CharacterCreatorBgThread characterCreatorThread = new CharacterCreatorBgThread(getContext(), this);
        characterCreatorThread.setRunning(true);
        characterCreatorThread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cloud1X -= 1.25F;
        if(cloud1X < -newWidth) {
            cloud1X = 0;
        }
        cloud2X -= 2;
        if(cloud2X < -newWidth2) {
            cloud2X = 0;
        }
        canvas.drawBitmap(skyResized, 0, 0, null);
        canvas.drawBitmap(cloud1Resized, cloud1X, 100, null);
        canvas.drawBitmap(cloud2Resized, cloud2X, 0, null);
        if(cloud1X < screenWidth - newWidth) {
            canvas.drawBitmap(cloud1Resized, cloud1X +newWidth, 100, null);
        }
        if(cloud2X < screenWidth - newWidth2) {
            canvas.drawBitmap(cloud2Resized, cloud2X +newWidth2, 0, null);
        }

        if (characterCreator != null) {

            if (characterCreator.roundDirection == 1) {
                grassX += 4;
                if (grassX < -newWidth) {
                    grassX = 0;
                }
            }
            if (characterCreator.roundDirection == 2) {
                grassY += 1;
                if (grassY < -newHeight) {
                    grassY = 0;
                }
                mountainsCloserY += 1;
            }
            if (characterCreator.roundDirection == 3) {
                grassX -= 4;
                if (grassX < -newWidth) {
                    grassX = 0;
                }
            }
            if (characterCreator.roundDirection == 0) {
                grassY -= 1;
                if (grassY < -newHeight) {
                    grassY = 0;
                }
                mountainsCloserY -= 1;
            }
        }

        canvas.drawBitmap(mountainFarAway, 0, screenHeight - 850, null);
        canvas.drawBitmap(mountain, 0, screenHeight - mountainsCloserY - 800, null);

        canvas.drawBitmap(grassResized, grassX, (int)(screenHeight-(screenHeight * 0.15))+grassY, null);
        if(grassX < screenWidth - newWidth) {
            canvas.drawBitmap(grassResized, grassX+newWidth, (int)(screenHeight-(screenHeight * 0.15))+grassY, null);
        }
    }

    private void init() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap sky = BitmapFactory.decodeResource(getResources(), R.drawable.sky, options);
        Bitmap clouds1 = getBitmapFromVectorDrawable(R.drawable.clouds);
        Bitmap clouds2 = getBitmapFromVectorDrawable(R.drawable.clouds2);
        mountain = BitmapFactory.decodeResource(getResources(), R.drawable.mountains3, options);
        mountainFarAway = BitmapFactory.decodeResource(getResources(), R.drawable.mountains_far_away, options);
        Bitmap grass = BitmapFactory.decodeResource(getResources(), R.drawable.grass3, options);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;

        float clouds1Width = clouds1.getWidth();
        float clouds1Height = clouds1.getHeight();
        float clouds1Ratio = clouds1Width / clouds1Height;
        float clouds2Width = clouds2.getWidth();
        float clouds2Height = clouds2.getHeight();
        float clouds2Ratio = clouds2Width / clouds2Height;
        newHeight = screenHeight;
        newWidth = (int) (clouds1Ratio * screenHeight) / 2;
        newWidth2 = (int) (clouds2Ratio * screenHeight) / 2;
        skyResized = Bitmap.createScaledBitmap(sky, screenWidth, screenHeight, false);
        cloud1Resized = Bitmap.createScaledBitmap(clouds1, newWidth, (int)(screenHeight/1.75), false);
        cloud2Resized = Bitmap.createScaledBitmap(clouds2, newWidth2, (int)(screenHeight/1.75), false);
        grassResized = Bitmap.createScaledBitmap(grass, newWidth, grass.getHeight()+(grass.getHeight()), false);
        grassX = - (float)(grassResized.getWidth() / 2) + (float)(screenWidth / 2);



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
