package projekt.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekt.projekt.models.Typy_zgloszen;
import projekt.projekt.repositiories.Typy_zgloszenRepository;


import java.util.List;
import java.util.Optional;

@Service
public class Typy_zgloszenService {
    @Autowired
    private Typy_zgloszenRepository repository;

    public Typy_zgloszenService() {
        super();
    }

    public List<Typy_zgloszen> findAll() {
        return repository.findAll();
    }

    public <S extends Typy_zgloszen> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Typy_zgloszen> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

}
