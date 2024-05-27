package unoeste.fipp.ativooperante_be.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unoeste.fipp.ativooperante_be.db.entities.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findAllByEmail(String email);
}
