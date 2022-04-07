package projekt.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekt.projekt.models.User;
import projekt.projekt.repositiories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll() {
        return repository.findAll();
    }

    public <S extends User> S save(S entity) {
        return repository.save(entity);
    }

    public Optional<User> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public Optional<User> findByEmail(String username) {
        return repository.findByEmail(username);
    }
}
