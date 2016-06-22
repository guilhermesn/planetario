package planetario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyXMLFile {
    
    public ModifyXMLFile() {
        
    }
    
    public void setDadosHibernate(ArrayList<String> dados) throws TransformerConfigurationException, TransformerException {
        
        try {
            String filepath = "src/hibernate.cfg.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            //doc.setTextContent("<!DOCTYPE hibernate-configuration PUBLIC \"-//Hibernate/Hibernate Configuration DTD 3.0//EN\" \"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">");
            for (int i = 2; i < doc.getElementsByTagName("property").getLength(); i++) {
                //NamedNodeMap list = doc.getElementsByTagName("property").item(i).getAttributes();
                
                if (!doc.getElementsByTagName("property").item(i).getTextContent().trim().isEmpty()) {
                    
                    Node alterar = doc.getElementsByTagName("property").item(i);
                    
                    alterar.setTextContent(dados.get(i));
                    
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
            System.out.println("ok");
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
        
    }
    
    public ArrayList<String> getDadosHibernate() {
        ArrayList<String> dados = new ArrayList<String>();
        
        try {
            String filepath = "src/hibernate.cfg.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            Node sessionfactory = doc.getElementsByTagName("session-factory").item(0);
            NodeList list = sessionfactory.getChildNodes();
            
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (!node.getTextContent().trim().isEmpty()) {
                    dados.add(node.getTextContent());
                    //System.out.println(node.getTextContent() + " ----- " + i);
                }
            }
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
        return dados;
    }
}
