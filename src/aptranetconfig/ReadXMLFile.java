/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aptranetconfig;

/**
 *
 * @author a.sinenko
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ReadXMLFile 
{

    public ReadXMLFile(){
        try {
            fXmlFile = new File("TCPIPCommunicationsServiceConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ReadXMLFile(File fileName){
        try {
            fXmlFile = fileName;
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public void SaveXMLFile(File fileName){
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fileName);
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public String getTCPIPCommunicationsLinkAttribute(String nameAttribute){
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("TCPIPCommunicationsLink");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        return eElement.getAttribute(nameAttribute);
    }
    
    public void setTCPIPCommunicationsLinkAttribute(String nameAttribute, String val){
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("TCPIPCommunicationsLink");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        eElement.setAttribute(nameAttribute, val);
    }
    
    public String getMessageDelimiter(String nameAttribute){
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("MessageDelimiter");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        return eElement.getAttribute(nameAttribute);
    }
    
    public void setMessageDelimiter(String nameAttribute, String val){
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("MessageDelimiter");
        Node nNode = nList.item(0);
        Element eElement = (Element) nNode;
        eElement.setAttribute(nameAttribute, val);
    }
    
    private File fXmlFile;
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;


//========================================================
    public static void main(String argv[]) {

	ReadXMLFile xml = new ReadXMLFile();
    System.out.println(xml.getTCPIPCommunicationsLinkAttribute("RemotePort"));
    System.out.println(xml.getMessageDelimiter("LengthFormat"));
    }

}

