package ru.basanov.cloud.handler;

import lombok.SneakyThrows;
import ru.basanov.cloud.api.local.FileLocalService;
import ru.basanov.cloud.api.local.FolderLocalService;
import ru.basanov.cloud.api.remote.FileRemoteService;
import ru.basanov.cloud.api.remote.FolderRemoteService;
import ru.basanov.cloud.api.system.ApplicationService;
import ru.basanov.cloud.api.system.EndpointService;
import ru.basanov.cloud.api.system.SyncService;
import ru.basanov.cloud.event.keyboard.KeyboardCommandEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.PrintStream;
import java.util.Scanner;

@ApplicationScoped
public class KeyboardCommandHandler {

    public static final String CMD_HELP = "help";

    public static final String CMD_SYNC = "sync";

    public static final String CMD_EXIT = "exit";

    public static final String CMD_SOAP = "soap";

    public static final String CMD_LOGIN = "login";

    public static final String CMD_LOGOUT = "logout";

    public static final String CMD_START = "start";

    public static final String CMD_STOP = "stop";

    public static final String CMD_REMOTE_CLEAR = "remote_clearRoot";

    public static final String CMD_LOCAL_CLEAR = "local-printListFolderNameRoot";

    public static final String CMD_REMOTE_FOLDERS = "remote-folders";

    public static final String CMD_LOCAL_FOLDERS = "local-folders";

    public static final String CMD_REMOTE_FILES = "remote_files";

    public static final String CMD_LOCAL_FILES = "local-files";

    public static final String CMD_LOCAL_FILES_CLEAR = "local-files-clear";

    public static final String CMD_REMOTE_FILES_CLEAR = "remote-files-clear";

    public static final String CMD_LOCAL_FOLDERS_CLEAR = "local-folders-clear";

    public static final String CMD_REMOTE_FOLDERS_CLEAR = "remote-folders-clear";

    @Inject
    private Event<KeyboardCommandEvent> keyboardCommandEventEvent;

    @Inject
    private ApplicationService applicationService;

    @Inject
    private SyncService syncService;

    @Inject
    private EndpointService endpointService;

    @Inject
    private FolderRemoteService folderRemoteService;

    @Inject
    private FolderLocalService folderLocalService;

    @Inject
    private FileLocalService fileLocalService;

    @Inject
    private FileRemoteService fileRemoteService;

    @SneakyThrows
    public void observe(@Observes final KeyboardCommandEvent event) {
        System.out.println();
        System.out.println("cmd: ");
        final Scanner scan = new Scanner(System.in);
        final String cmd = scan.nextLine();

        switch (cmd) {
            case CMD_HELP:
                help();
                break;
            case CMD_SYNC:
                syncService.sync();
                break;
            case CMD_START:
                syncService.start();
                break;
            case CMD_LOGOUT:
                applicationService.logout();
                break;
            case CMD_STOP:
                syncService.stop();
                break;
            case CMD_SOAP:
                endpointService.start();
                break;
            case CMD_LOGIN:
                applicationService.login();
                break;
            case CMD_REMOTE_CLEAR:
                folderRemoteService.clearRoot();
                fileRemoteService.clearRoot();
                break;
            case CMD_LOCAL_CLEAR:
                folderLocalService.clearRoot();
                fileLocalService.clearRoot();
                break;
            case CMD_REMOTE_FOLDERS:
                folderRemoteService.printListFolderNameRoot();
                break;
            case CMD_LOCAL_FOLDERS:
                folderLocalService.printListFolderNameRoot();
                break;
            case CMD_REMOTE_FILES:
               fileRemoteService.printListFileNameRoot();
                break;
            case CMD_LOCAL_FILES:
               fileRemoteService.printListFileNameRoot();
                break;
            case CMD_REMOTE_FILES_CLEAR:
                fileRemoteService.clearRoot();
                break;
            case CMD_LOCAL_FILES_CLEAR:
                folderLocalService.clearRoot();
                break;
            case CMD_REMOTE_FOLDERS_CLEAR:
                folderRemoteService.clearRoot();
                break;
            case CMD_LOCAL_FOLDERS_CLEAR:
                folderLocalService.clearRoot();
                break;
            default:
                System.out.println("Undefined command... ");
            break;
        }
        keyboardCommandEventEvent.fire(new KeyboardCommandEvent());
    }

    private void help() {
        final PrintStream stream = System.out;
        stream.println(KeyboardCommandHandler.CMD_HELP + "  - Display list commands");
        stream.println(KeyboardCommandHandler.CMD_SYNC + "  - Call cloud synchromization");
        stream.println(KeyboardCommandHandler.CMD_EXIT + "  - Shutdown cloid application");
        stream.println(KeyboardCommandHandler.CMD_SOAP + "  - Initialize soap web-services");
        stream.println(KeyboardCommandHandler.CMD_LOGIN + "  - Open cloud session");
        stream.println(KeyboardCommandHandler.CMD_LOGOUT + "  - Close cloud session");
        stream.println(KeyboardCommandHandler.CMD_START + "  - Start cloud synchronizqtion");
        stream.println(KeyboardCommandHandler.CMD_STOP + "  - Stop cloud synchronization");
        stream.println(KeyboardCommandHandler.CMD_LOCAL_FILES + "  - Display local root file");
        stream.println(KeyboardCommandHandler.CMD_LOCAL_FOLDERS + "  - Display local root folder");
        stream.println(KeyboardCommandHandler.CMD_REMOTE_FILES + "  - Display remote root files");
        stream.println(KeyboardCommandHandler.CMD_REMOTE_FOLDERS + "  - Display remote root");
        stream.println();
    }

}
