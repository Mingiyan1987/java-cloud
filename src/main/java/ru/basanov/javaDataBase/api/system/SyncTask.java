package ru.basanov.javaDataBase.api.system;

import java.util.TimerTask;

public interface SyncTask extends Runnable {

    TimerTask get();

    boolean cancel();
}
