package unoeste.fipp.ativooperante_be.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.ativooperante_be.db.entities.Tipo;
import unoeste.fipp.ativooperante_be.db.repositories.TipoRepository;

import java.util.List;

@Service
public class TipoService {
    @Autowired
    private TipoRepository rep;

    public List<Tipo> getAll(){
        return rep.findAll();
    }

    public Tipo save(Tipo tipo) {
        return rep.save(tipo);
    }

    public Tipo atualizar(Tipo tipo) {
        if(tipo.getId() == null || !rep.existsById(tipo.getId())){
            return null;
        }
        return rep.save(tipo);
    }

    public void excluirId(Long id) {
        rep.deleteById(id);
    }

    public Tipo buscaPorId(Long id) {
        return rep.findById(id).get();
    }
}
