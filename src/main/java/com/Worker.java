package com;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


//<Valute ID="R01820">
public class Worker {

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


    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type in a URL:");
        String  urlString = scan.nextLine();
        if (urlString.length() == 0){

        }


        String content = readURLContent(urlString);

        System.out.println(content);
    }
}
