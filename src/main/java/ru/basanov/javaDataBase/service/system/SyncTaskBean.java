package ru.basanov.javaDataBase.service.system;

import ru.basanov.javaDataBase.api.system.SyncTask;
import ru.basanov.javaDataBase.api.system.SyncService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.TimerTask;

@ApplicationScoped
public class SyncTaskBean extends TimerTask implements SyncTask {

    @Inject
    private SyncService syncService;

    @Override
    public boolean cancel() {
        return super.cancel();
    }

    @Override
    public TimerTask get() {
        return this;
    }

    @Override
    public void run() {
        syncService.sync();
    }
}
