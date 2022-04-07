package projekt.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekt.projekt.models.Opinia;
import projekt.projekt.repositiories.OpiniaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OpiniaService {

    @Autowired
    private OpiniaRepository repository;

    public OpiniaService(){}

    public List<Opinia> findAll() {
        return repository.findAll();
    }

    public <S extends Opinia> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<Opinia> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

}
