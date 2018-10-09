package ru.basanov.cloud.api.remote;

import ru.basanov.cloud.api.basic.FolderService;

public interface FolderRemoteService extends FolderService {

    void init();

    void printListFolderNameRoot();

    void clearRoot();
}
