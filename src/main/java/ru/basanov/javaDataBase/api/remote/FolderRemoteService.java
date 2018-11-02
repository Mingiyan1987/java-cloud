package ru.basanov.javaDataBase.api.remote;

import ru.basanov.javaDataBase.api.basic.FolderService;

public interface FolderRemoteService extends FolderService {

    void init();

    void printListFolderNameRoot();

    void clearRoot();
}
