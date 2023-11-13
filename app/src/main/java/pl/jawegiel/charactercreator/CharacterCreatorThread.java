package pl.jawegiel.charactercreator;

import android.os.SystemClock;
import android.util.Log;

import lombok.Getter;
import lombok.Setter;
import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorThreadRun;

@Getter
@Setter
public class CharacterCreatorThread extends Thread {

    private static final String TAG = CharacterCreatorThread.class.getSimpleName();

    private boolean isRunning;
    private long startTime, loopTime;
    private long delay = 33;
    private IOnCharacterCreatorThreadRun onCharacterCreatorThreadRun;

    public CharacterCreatorThread(IOnCharacterCreatorThreadRun onCharacterCreatorThreadRun)  {
        this.onCharacterCreatorThreadRun = onCharacterCreatorThreadRun;
        isRunning = true;
    }

    @Override
    public void run()  {
        while(isRunning) {
            startTime = SystemClock.uptimeMillis();

            onCharacterCreatorThreadRun.onRun();

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