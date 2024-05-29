package unoeste.fipp.ativooperante_be.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unoeste.fipp.ativooperante_be.db.entities.Denuncia;
import unoeste.fipp.ativooperante_be.db.entities.Usuario;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    //@Query(value = "SELECT * FROM denuncia WHERE usu_id = :id", nativeQuery = true)
    //public List<Denuncia> findAllByUsuarioId(Long id);

    @Query(value = "SELECT d FROM Denuncia d LEFT JOIN FETCH d.orgao LEFT JOIN FETCH d.tipo WHERE d.usuario = :usuario")
    public List<Denuncia> findAllByUsuario(Usuario usuario);

}
