package pl.jawegiel.charactercreator;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import lombok.Getter;

@Getter
public class CharacterCreator {

    public static final int COL_COUNT = 13;
    public static final int ROW_COUNT = 21;

    private static final int ROW_BOTTOM_TO_TOP = 8;
    private static final int ROW_RIGHT_TO_LEFT = 9;
    private static final int ROW_TOP_TO_BOTTOM = 10;
    private static final int ROW_LEFT_TO_RIGHT = 11;

    private final Bitmap[] leftToRights;
    private final Bitmap[] rightToLefts;
    private final Bitmap[] topToBottoms;
    private final Bitmap[] bottomToTops;
    private int widthOneFrame, heightOneFrame;
    private Bitmap image;
    private Bitmap imageResized;
    private int rowUsing = 10;
    private int colUsing = 0;
    private int widthAllCols;
    private int heightAllRows;
    private int roundDirection;

    public CharacterCreator(Bitmap baseSprite) {
        this.image = baseSprite;

        this.widthAllCols = image.getWidth();
        this.heightAllRows = image.getHeight();

        this.widthOneFrame = this.widthAllCols / 13;
        this.heightOneFrame = this.heightAllRows / ROW_COUNT;

        this.topToBottoms = new Bitmap[COL_COUNT];
        this.rightToLefts = new Bitmap[COL_COUNT];
        this.leftToRights = new Bitmap[COL_COUNT];
        this.bottomToTops = new Bitmap[COL_COUNT];

        createBitmapFrames(COL_COUNT);

        imageResized = Bitmap.createScaledBitmap(getMoveBitmaps()[0], 300, 300, false);
    }

    public void modifySprite(Bitmap finalBitmap) {
        this.image = finalBitmap;

        this.widthAllCols = image.getWidth();
        this.heightAllRows = image.getHeight();

        this.widthOneFrame = this.widthAllCols / COL_COUNT;
        this.heightOneFrame = this.heightAllRows / ROW_COUNT;
    }

    public void createBitmapFrames(int colCount) {
        for (int col = 0; col < colCount; col++) {
            this.topToBottoms[col] = this.createSubImageAt(ROW_TOP_TO_BOTTOM, col);
            this.rightToLefts[col] = this.createSubImageAt(ROW_RIGHT_TO_LEFT, col);
            this.leftToRights[col] = this.createSubImageAt(ROW_LEFT_TO_RIGHT, col);
            this.bottomToTops[col] = this.createSubImageAt(ROW_BOTTOM_TO_TOP, col);
        }
    }

    public void draw(Canvas canvas) {
        imageResized = Bitmap.createScaledBitmap(getCurrentMoveBitmap(), 300, 300, false);
        canvas.drawBitmap(imageResized, 0, 0, null);

    }

    public void update() {
        if (roundDirection == 0) {
            this.rowUsing = ROW_TOP_TO_BOTTOM;
        } else if (roundDirection == 1) {
            this.rowUsing = ROW_RIGHT_TO_LEFT;
        } else if (roundDirection == 2) {
            this.rowUsing = ROW_BOTTOM_TO_TOP;
        } else if (roundDirection == 3) {
            this.rowUsing = ROW_LEFT_TO_RIGHT;
        }

        colUsing++;
        if (colUsing >= 9) {
            if (rowUsing == ROW_TOP_TO_BOTTOM || rowUsing == ROW_BOTTOM_TO_TOP)
                colUsing = 1;
            else
                colUsing = 0;
            roundDirection++;
            if (roundDirection > 3)
                roundDirection = 0;
        }
    }

    public Bitmap getCurrentMoveBitmap() {
        Bitmap[] bitmaps = this.getMoveBitmaps();
        return bitmaps[this.colUsing];
    }

    public Bitmap[] getMoveBitmaps() {
        switch (rowUsing) {
            case ROW_BOTTOM_TO_TOP:
                return this.bottomToTops;
            case ROW_RIGHT_TO_LEFT:
                return this.rightToLefts;
            case ROW_TOP_TO_BOTTOM:
                return this.topToBottoms;
            case ROW_LEFT_TO_RIGHT:
                return this.leftToRights;
            default:
                return null;
        }
    }

    protected Bitmap createSubImageAt(int row, int col) {
        return Bitmap.createBitmap(image, col * widthOneFrame, row * heightOneFrame, widthOneFrame, heightOneFrame);
    }
}
