package service;

import model.JPYModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JPYRepository;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.util.List;

@Service
public class JpyService {

    @Autowired
    JPYRepository repository;
    public void fillRepository(){

        repository.save(new JPYModel(12,45.90));
    }
    public List<JPYModel> getAll() throws Exception {

        Document doc = loadTestDocument("http://cbr.ru/scripts/XML_daily.asp");
        System.out.println(doc);
        doc = loadTestDocument("http://localhost/array.xml");
        System.out.println(doc);
        return repository.findAll();
    }
    private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new URL(url).openStream());
    }


}
