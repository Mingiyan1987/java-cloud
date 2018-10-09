package ru.basanov.cloud.service.system;

import ru.basanov.cloud.api.annotation.Loggable;
import ru.basanov.cloud.api.local.FolderLocalService;
import ru.basanov.cloud.api.system.ApplicationService;
import ru.basanov.cloud.api.system.BootstrapService;
import ru.basanov.cloud.api.system.EndpointService;
import ru.basanov.cloud.api.system.SettingService;
import ru.basanov.cloud.event.keyboard.KeyboardInitEvent;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class BootstrapServiceBean implements BootstrapService {

    @Inject
    private ApplicationService applicationService;

    @Inject
    private SettingService settingService;

    @Inject
    private EndpointService endpointService;

    @Inject
    private FolderLocalService folderLocalService;

   @Inject
   private Event<KeyboardInitEvent> keyboardInputInitEvent;

    @Loggable
    public void init() {
        settingService.init();
        endpointService.init();
        folderLocalService.init();
        applicationService.init();

        keyboardInputInitEvent.fire(new KeyboardInitEvent());
    }
}
