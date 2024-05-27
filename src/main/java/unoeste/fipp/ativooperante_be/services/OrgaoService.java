package unoeste.fipp.ativooperante_be.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.ativooperante_be.db.entities.Orgao;
import unoeste.fipp.ativooperante_be.db.repositories.OrgaoRepository;

import java.util.List;

@Service
public class OrgaoService {
    @Autowired
    private OrgaoRepository repo;
    public List<Orgao> getAll()
    {
        return repo.findAll();
    }

    public Orgao save(Orgao orgao) {
        return repo.save(orgao);
    }

    public Orgao atualizar(Orgao orgao) {
        if(orgao.getId() == null || !repo.existsById(orgao.getId())){
            return null;
        }
        return repo.save(orgao);
    }

    public void excluirId(Long id) {
        repo.deleteById(id);
    }

    public Object buscaPorId(Long id) {
        return repo.findById(id).get();
    }
}
