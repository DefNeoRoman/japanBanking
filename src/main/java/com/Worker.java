package com;

import model.JPYModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Scanner;


//<Valute ID="R01820">
public class Worker {
    public static JPYModel marshaller(String string) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(JPYModel.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(string);
        JPYModel jpyModel = (JPYModel) unmarshaller.unmarshal(reader);
        return jpyModel;
    }
    public static String readURLContent(String urlString)
            throws IOException
    {
        URL url = new URL(urlString);
        Scanner scan = new Scanner(url.openStream());

        String content = new String();
        while (scan.hasNext())
            content += scan.nextLine();
        scan.close();
        return content;
    }

    // Find title within the HTML content


    public static void main(String[] args) throws IOException, JAXBException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type in a URL:");
        String  urlString = scan.nextLine();
        if (urlString.length() == 0){

        }


        String content = readURLContent(urlString);
        JPYModel jpyModel = marshaller(content);
        System.out.println(content);
        System.out.println(jpyModel.toString());
    }
}
