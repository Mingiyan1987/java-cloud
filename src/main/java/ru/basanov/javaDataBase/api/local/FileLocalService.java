package ru.basanov.javaDataBase.api.local;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.basanov.javaDataBase.api.basic.FileService;

import java.util.List;

public interface FileLocalService extends FileService {

    @NotNull
    List<String> getListFileNameRoot();

    void clearRoot();

    @Nullable
    @Override
    byte[] readData(String name);
}
