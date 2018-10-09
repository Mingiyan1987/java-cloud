package ru.basanov.enterprise;

import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;
import org.junit.After;
import org.junit.Before;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import java.net.MalformedURLException;

public abstract class AbstractTestJCR {
    private static final String URL = "http://localhost:8080/rmi";

    private static final String ADMIN_LOGIN = "admin";

    private static final String ADMIN_PASSWORD = "admin";

    protected Repository repository;

    protected Session session;

    @Before
    public void before() throws MalformedURLException, RepositoryException {
        repository = new URLRemoteRepository(URL);
        session = repository.login(new SimpleCredentials(ADMIN_LOGIN, ADMIN_PASSWORD.toCharArray()));
    }

    @After
    public void after() throws RepositoryException {
        session.save();
        session.logout();
    }
}
