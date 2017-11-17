package sandbox;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class XMLGetter {
    public static void main(String[] args) {

        URL url;
        try {
            url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");

            InputStreamReader isr = new InputStreamReader(url.openStream(),"windows-1251");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                sb.append(br.readLine() + "\n");
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;

                builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(sb.toString())));
            br.close();
            NodeList nodeList = document.getElementsByTagName("Valute");
           


        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
