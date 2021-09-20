/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pzj_zajecie2_gr1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author krzysiek
 */
public class NewClass {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File("dl.xml");
        Document doc = builder.parse(f);
        Element root = doc.getDocumentElement();

        HashMap<String, Integer> wyniki = new HashMap<>();

        NodeList cos = root.getElementsByTagName("numer");
        for (int i = 0; i < cos.getLength(); i++) {

            wyniki.compute(cos.item(i).getFirstChild().getNodeValue(), (key, value) -> value == null ? 1 : value + 1);
        }

        ArrayList<Wartosc> wartoscLista = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entrySet = wyniki.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            wartoscLista.add(new Wartosc(entry.getKey(), entry.getValue()));
        }

        Collections.sort(wartoscLista);
        
        ArrayList<Liczba> liczbaLista = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entrySet2 = wyniki.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet2) {
            liczbaLista.add(new Liczba(entry.getKey(), entry.getValue()));
        }

        Collections.sort(liczbaLista);

        int size = liczbaLista.size();
        
        
        
        DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = factory2.newDocumentBuilder();
        Document doc2 = builder2.newDocument();
        
        Element root2 = doc2.createElement("root");
        doc2.appendChild(root2);
        
        Element czesto = doc2.createElement("czestotliwosc");
        root2.appendChild(czesto);
  
        
        
        
        
       for(int i=0 ;i<49;i++)
      {
          
          Text tekst = doc2.createTextNode(String.valueOf(wartoscLista.get(i)));
          Element liczba1 = doc2.createElement("Liczba"+(i+1));
          root2.appendChild(liczba1);
         czesto.appendChild(liczba1);
         liczba1.appendChild(tekst);
          
      }
        Element najczesciej = doc2.createElement("najczesciej");
        root2.appendChild(najczesciej);
        Text najczen = doc2.createTextNode(String.valueOf(liczbaLista.get(0)));
        najczesciej.appendChild(najczen);

        Element najrzadziej = doc2.createElement("najrzadziej");
        root2.appendChild(najrzadziej);
        Text najrzadze = doc2.createTextNode(String.valueOf(liczbaLista.get(size-1)));
        najrzadziej.appendChild(najrzadze);
       
       
       
       
        File f1 = new File("wynik_dl.xml");
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.transform(new DOMSource(doc2), new StreamResult(f1));

  
 
     }
}
    

