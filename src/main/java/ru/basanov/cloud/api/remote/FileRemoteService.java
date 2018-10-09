package ru.basanov.cloud.api.remote;

import ru.basanov.cloud.api.basic.FileService;

public interface FileRemoteService extends FileService {

    boolean clearRoot();

    boolean prinListFileNameRoot();
}
