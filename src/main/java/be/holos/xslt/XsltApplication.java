package be.holos.xslt;

/**
 * @author Dieter D'haeyere on 16/01/17.
 */
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
//  www.java2s.com
public class XsltApplication {

    public static void main(String args[]) throws Exception {
        StreamSource source = new StreamSource("./src/main/resources/be/holos/xslt/phonebook.xml");
        StreamSource stylesource = new StreamSource("./src/main/resources/be/holos/xslt/phonebook.xslt");

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(stylesource);

        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);
    }
}
