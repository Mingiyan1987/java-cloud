package ru.basanov.javaDataBase.api.local;

import ru.basanov.javaDataBase.api.basic.FolderService;

public interface FolderLocalService extends FolderService {

    void init();

    void clearRoot();

    void printListFolderNameRoot();
}