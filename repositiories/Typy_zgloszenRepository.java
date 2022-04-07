package projekt.projekt.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekt.projekt.models.Typy_zgloszen;

@Repository
public interface Typy_zgloszenRepository extends JpaRepository<Typy_zgloszen, Long> {
}
