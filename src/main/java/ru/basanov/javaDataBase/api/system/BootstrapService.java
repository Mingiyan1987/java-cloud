package ru.basanov.javaDataBase.api.system;

public interface BootstrapService {

    void init();

    void cleanupAfterBoot();

    void cleanup();
}
