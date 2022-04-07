package projekt.projekt.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekt.projekt.models.Zgloszenie;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZgloszenieRepository extends JpaRepository<Zgloszenie, Long> {
}
