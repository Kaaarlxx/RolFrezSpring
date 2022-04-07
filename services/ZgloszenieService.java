package projekt.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekt.projekt.models.Zgloszenie;
import projekt.projekt.repositiories.ZgloszenieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ZgloszenieService {

    @Autowired
    private ZgloszenieRepository repository;


    public List<Zgloszenie> findAll() {
        return repository.findAll();
    }

    public <S extends Zgloszenie> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Zgloszenie> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }




}
