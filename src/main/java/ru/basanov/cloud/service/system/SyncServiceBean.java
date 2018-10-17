package ru.basanov.cloud.service.system;

import ru.basanov.cloud.api.system.SyncService;
import ru.basanov.cloud.api.system.TimerService;

import javax.inject.Inject;

public class SyncServiceBean implements SyncService {

    @Inject
    private TimerService timerService;


    @Override
    public boolean status() {
        return false;
    }

    @Override
    public void sync() {

    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }

}
