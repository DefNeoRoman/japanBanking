package com;

import model.JPYModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.Scanner;


//<Valute ID="R01820">
public class Worker {
    public static void main(String[] args) {
        // определяем название файла, куда будем сохранять
        String fileName = "E:\\Roman\\DTT\\projects\\japanBanking\\res.xml";

        //создаем объект Student с какими-то данными
        JPYModel jPYModel = new JPYModel();
        jPYModel.setCharCode("JPY");
        jPYModel.setValute_id("R01820");
        jPYModel.setName("йена");
        jPYModel.setNominal(200);
        jPYModel.setNumCode(4);
        jPYModel.setValue(90.90);
        // сохраняем объект в XML файл
        convertObjectToXml(jPYModel, fileName);

        // восстанавливаем объект из XML файла
        JPYModel unmarshStudent = fromXmlToObject(fileName);
        if (unmarshStudent != null) {
            System.out.println(unmarshStudent.toString());
        }
    }


    // восстанавливаем объект из XML файла
    private static JPYModel fromXmlToObject(String filePath) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(JPYModel.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (JPYModel) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // сохраняем объект в XML файл
    private static void convertObjectToXml(JPYModel student, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(JPYModel.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(student, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
