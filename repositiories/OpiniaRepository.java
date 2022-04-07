package projekt.projekt.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekt.projekt.models.Opinia;

@Repository
public interface OpiniaRepository extends JpaRepository<Opinia, Long> {
}
