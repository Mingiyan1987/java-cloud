package ru.basanov.cloud.api.local;

import ru.basanov.cloud.api.basic.FolderService;

public interface FolderLocalService extends FolderService {

    void init();

    void clearRoot();

    void printListFolderNameRoot();
}
