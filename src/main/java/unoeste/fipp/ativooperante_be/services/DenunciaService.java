package unoeste.fipp.ativooperante_be.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.ativooperante_be.db.entities.Denuncia;
import unoeste.fipp.ativooperante_be.db.entities.Usuario;
import unoeste.fipp.ativooperante_be.db.repositories.DenunciaRepository;

import java.util.List;

@Service
public class DenunciaService {
    @Autowired
    private DenunciaRepository repo;

    public List<Denuncia> getAll(){
        List<Denuncia> denuncias;
        denuncias = repo.findAll();
        return denuncias;
    }

    public Denuncia save(Denuncia denuncia) {
        return repo.save(denuncia);
    }

    public void excluirId(Long id) {
        repo.deleteById(id);
    }

    public Denuncia buscaPorId(Long id) {
        return repo.findById(id).get();
    }

    public List<Denuncia> buscaPorUsuario(Usuario user) {
        return repo.findAllByUsuarioId(user.getId());
    }
}
