package be.holos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author Dieter D'haeyere on 30/03/15.
 */
public class ZipCapabilityCreation {


    public static void main(String[] args) {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("zipcapabilities.shp.xml", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.println("<!DOCTYPE data PUBLIC \"-//PearlChain//Shape-it//EN\" \"http://validation.pearlchain.net/shapeit/3.6.5.2/Aton2.dtd\">");
        writer.println("<data>");
        writer.println("<owner name=\"FortronGeneratedOwner\" level=\"PROJECT\" description=\"Created by code\"/>");
        writer.println("<defaultOwner name=\"FortronGeneratedOwner\"/>");


        for (int zip = 10; zip < 100; zip++) {
            String capabilityNode = "<node name=\"ZIP" + zip + "Capability\" attributeGroup=\"CAP\" description=\"Code generated node\">\n" +
                    "\t<is name=\"Capability\" sequence=\"1.0\"/>\n" +
                    "</node>";
            writer.println(capabilityNode);
        }

        for (int zip = 1000; zip < 10000; zip++) {
            String hasRelation = "<has name=\"ZIP"+ zip / 100 + "Capability\" description=\"Code generated relation\" alwaysEvaluate=\"true\" sequence=\"1.0\"> " +
            "<atomic name=\"zipcode\" operator=\"EQUALS\" value=\""  + zip+ "\"/>"+
            "</has>";




            writer.println(hasRelation);
        }

        writer.println("</data>");
        writer.close();
    }
}
