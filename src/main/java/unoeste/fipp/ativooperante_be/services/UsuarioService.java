package unoeste.fipp.ativooperante_be.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.ativooperante_be.db.entities.Usuario;
import unoeste.fipp.ativooperante_be.db.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> getAll(){
        List<Usuario> usuarios;
        usuarios = repo.findAll();
        return usuarios;
    }

    public Usuario consultaPorId(Long usuarioId) {
        return repo.findById(usuarioId).get();
    }
}
