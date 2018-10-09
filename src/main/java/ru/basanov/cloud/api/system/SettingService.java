package ru.basanov.cloud.api.system;

import org.jetbrains.annotations.NotNull;

public interface SettingService {

    void init();

    @NotNull
    Boolean getJcrActive();

    @NotNull
    String getJcrUrl();

    @NotNull
    String getJcrLogin();

    @NotNull
    String getJcrPassword();

    @NotNull
    String getSyncFolder();

    @NotNull
    Integer getSyncTimeout();

    @NotNull
    String getSencEndpoint();

    @NotNull
    Boolean getSyncActive();

}
