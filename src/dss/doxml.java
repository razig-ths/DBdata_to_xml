/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dss;

import java.io.File;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author abdelmalek___rezig
 */
public class doxml {
    
    public void generateXML(Vector<Object> row, String radioType, String fileName) throws TransformerConfigurationException, TransformerException
    {
    
    
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element pat = document.createElement("patient");
            document.appendChild(pat);

            Element id = document.createElement("id");
            pat.appendChild(id);
            id.appendChild(document.createTextNode(row.get(0).toString()));

            Element nom = document.createElement("nom");
            pat.appendChild(nom);
            nom.appendChild(document.createTextNode(row.get(1).toString()));

            Element prenom = document.createElement("prenom");
            pat.appendChild(prenom);
            prenom.appendChild(document.createTextNode(row.get(2).toString()));

            Element age = document.createElement("age");
            pat.appendChild(age);
            age.appendChild(document.createTextNode(row.get(3).toString()));

            Element sexe = document.createElement("sexe");
            pat.appendChild(sexe);
            sexe.appendChild(document.createTextNode(row.get(4).toString()));

            Element radio = document.createElement("radio");
            pat.appendChild(radio);
            radio.appendChild(document.createTextNode(radioType));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult destination = new StreamResult(new File(fileName + ".xml"));
            transformer.transform(source, destination);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(doxml.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
