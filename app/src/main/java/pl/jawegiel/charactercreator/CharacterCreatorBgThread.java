package pl.jawegiel.charactercreator;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import lombok.Getter;
import lombok.Setter;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorThreadRun;

@Getter
@Setter
public class CharacterCreatorBgThread extends Thread {

    private static final String TAG = CharacterCreatorBgThread.class.getSimpleName();

    private boolean isRunning;
    private long startTime, loopTime;
    private long delay = 10;
    private IOnCharacterCreatorThreadRun onCharacterCreatorThreadRun;
    private Context context;

    public CharacterCreatorBgThread(Context context, IOnCharacterCreatorThreadRun onCharacterCreatorThreadRun)  {
        this.context = context;
        this.onCharacterCreatorThreadRun = onCharacterCreatorThreadRun;
        isRunning = true;
    }

    @Override
    public void run()  {
        while(isRunning) {
            startTime = SystemClock.uptimeMillis();

            ((Activity)context).runOnUiThread(() -> onCharacterCreatorThreadRun.onRun());


            loopTime = SystemClock.uptimeMillis() - startTime;

            if(loopTime < delay) {
                try {
                    Thread.sleep(5 * (delay - loopTime));
                }
                catch (InterruptedException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}