package ru.basanov.cloud.api.remote;

import ru.basanov.cloud.api.basic.FileService;

public interface FileRemoteService extends FileService {

    void clearRoot();

    void printListFileNameRoot();
}
