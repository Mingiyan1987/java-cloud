package ru.basanov.enterprise.ex3;

import org.junit.Test;
import ru.basanov.enterprise.AbstractTestJCR;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public class ExampleFolderTest extends AbstractTestJCR {

    @Test
    public void test() throws RepositoryException {
        final Node node = session.getRootNode();
        final String folderName = "folder" + System.currentTimeMillis();
        node.addNode(folderName);
    }
}
