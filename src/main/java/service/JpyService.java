package service;

import model.JPYModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JPYRepository;
import java.util.List;

@Service
public class JpyService {

    @Autowired
    JPYRepository repository;
    public void fillRepository(){

        repository.save(new JPYModel(12,45.90));
    }
    public List<JPYModel> getAll(){

        return repository.findAll();
    }

}
