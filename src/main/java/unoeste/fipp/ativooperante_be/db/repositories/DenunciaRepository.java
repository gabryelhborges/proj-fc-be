package unoeste.fipp.ativooperante_be.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unoeste.fipp.ativooperante_be.db.entities.Denuncia;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    @Query(value = "SELECT * FROM denuncia WHERE usu_id = :id", nativeQuery = true)
    public List<Denuncia> findAllByUsuarioId(Long id);

    //public List<Denuncia> findAllByUsuario(Long id);
}
