package pl.jawegiel.charactercreator;

import android.os.SystemClock;
import android.util.Log;

import pl.jawegiel.charactercreator.interfaces.IOnCharacterCreatorThreadRun;

public class CharacterCreatorThread extends Thread {

    private static final String TAG = CharacterCreatorThread.class.getSimpleName();

    private boolean isRunning;
    private long startTime, loopTime;
    private long delay = 33;
    private IOnCharacterCreatorThreadRun onCharacterCreatorThreadRun;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getLoopTime() {
        return loopTime;
    }

    public void setLoopTime(long loopTime) {
        this.loopTime = loopTime;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public IOnCharacterCreatorThreadRun getOnCharacterCreatorThreadRun() {
        return onCharacterCreatorThreadRun;
    }

    public void setOnCharacterCreatorThreadRun(IOnCharacterCreatorThreadRun onCharacterCreatorThreadRun) {
        this.onCharacterCreatorThreadRun = onCharacterCreatorThreadRun;
    }

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