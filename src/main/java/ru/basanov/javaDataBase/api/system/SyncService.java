package ru.basanov.javaDataBase.api.system;

public interface SyncService {

    boolean status();

    void sync();

    boolean start();

    boolean stop();

}
