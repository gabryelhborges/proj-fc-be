package unoeste.fipp.ativooperante_be.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unoeste.fipp.ativooperante_be.db.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
