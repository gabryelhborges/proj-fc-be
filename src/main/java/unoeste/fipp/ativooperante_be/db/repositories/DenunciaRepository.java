package unoeste.fipp.ativooperante_be.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unoeste.fipp.ativooperante_be.db.entities.Denuncia;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

}
