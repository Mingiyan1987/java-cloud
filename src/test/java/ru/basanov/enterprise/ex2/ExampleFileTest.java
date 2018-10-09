package ru.basanov.enterprise.ex2;

import org.junit.Test;
import ru.basanov.enterprise.AbstractTestJCR;

import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import java.io.ByteArrayInputStream;
import java.util.Calendar;

public class ExampleFileTest extends AbstractTestJCR {

    @Test
    public void test() throws RepositoryException {
        final Node root = session.getRootNode();
        final String fileName = "file" + System.currentTimeMillis() + ".txt";
        final Node file = root.addNode(fileName, "nt:file");
        final Node contentNode = file.addNode("jcr:content", "nt:resource");
        final String content = "HELLO";
        final ByteArrayInputStream stream = new ByteArrayInputStream(content.getBytes());
        final Binary binary = session.getValueFactory().createBinary(stream);
        contentNode.setProperty("jct:data", binary);
        final Calendar creared = Calendar.getInstance();
        contentNode.setProperty("jcr:lastModified", creared);
    }
}
