package ru.basanov.cloud.api.basic;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface FileService {

    @NotNull
    List<String> getListFileName();

    void printListFileNameRoot();

    void cleatRoot();

    @Nullable
    byte[] readData(String name);

    void writeData(String name, byte[] data);

    boolean exist(String name);

    void remove(String name);

    void createTextfile(String name, String text);

}
