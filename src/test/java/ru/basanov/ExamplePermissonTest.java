package ru.basanov;

import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;
import org.junit.Test;

import javax.jcr.*;
import java.net.MalformedURLException;
import java.util.UUID;

public class ExamplePermissonTest {
    private static final String URL = "http://localhost:8080/rmi";

    @Test
    public void testGuest() throws MalformedURLException, RepositoryException {
        final Repository repository = new URLRemoteRepository(URL);
        final Session session = repository.login(new GuestCredentials());
        session.logout();
    }

    @Test
    public void testAdmin() throws MalformedURLException, RepositoryException {
        final Repository repository = new URLRemoteRepository(URL);
        final Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
        session.logout();
    }

    @Test(expected = LoginException.class)
    public void testUser() throws MalformedURLException, RepositoryException {
        final Repository repository = new URLRemoteRepository(URL);
        final Session session = repository.login(new SimpleCredentials("qwerty", "qwerty".toCharArray()));
    }

    @Test(expected = AccessDeniedException.class)
    public void testGuestWrite() throws MalformedURLException, RepositoryException {
        final Repository repository = new URLRemoteRepository(URL);
        final Session session = repository.login(new GuestCredentials());
        session.getRootNode().addNode(UUID.randomUUID().toString());
        session.save();
        session.logout();
    }

}
