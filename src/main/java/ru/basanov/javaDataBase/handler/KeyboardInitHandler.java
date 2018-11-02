package ru.basanov.javaDataBase.handler;

import lombok.SneakyThrows;
import ru.basanov.javaDataBase.event.keyboard.KeyboardCommandEvent;
import ru.basanov.javaDataBase.event.keyboard.KeyboardInitEvent;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class KeyboardInitHandler {

    @Inject
    private Event<KeyboardCommandEvent> keyboardInputCommandEvent;

    @SneakyThrows
    public void observe(@Observes final KeyboardInitEvent event) {
        System.out.println();
        System.out.println("*** WELCOME TO COMMAND LINE INTERFACE ***");
        System.out.println("*** ENTER \"help\" FOR LIST OF COMMANDS ***");
        keyboardInputCommandEvent.fire(new KeyboardCommandEvent());

    }
}
