package ru.basanov.enterprise.ex4;

import org.junit.Test;
import ru.basanov.enterprise.AbstractTestJCR;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

public class ExampleFolderListTest extends AbstractTestJCR {

    @Test
    public void test() throws RepositoryException {
        final Node root = session.getRootNode();
        final NodeIterator nodeIterator = root.getNodes();
        while (nodeIterator.hasNext()) {
            final Node node = nodeIterator.nextNode();
            System.out.println(node.getName());
        }
    }
}
