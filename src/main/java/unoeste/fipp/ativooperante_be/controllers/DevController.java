package unoeste.fipp.ativooperante_be.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.ativooperante_be.db.entities.Denuncia;
import unoeste.fipp.ativooperante_be.db.entities.Orgao;
import unoeste.fipp.ativooperante_be.db.entities.Tipo;
import unoeste.fipp.ativooperante_be.services.*;

/*
A ser consumida pelo administrador:

- CRUD de tipo de problema (inserir, alterar, apagar, listar um e listar todos)
- CRUD de orgãos (inserir, alterar, apagar, listar um e listar todos)
- Listar denúncias
- Excluir denúncia
- Registrar feedback em denúncia

 A ser consumida pelo cidadão:

- Enviar a denúncia:
- Listar orgãos competentes: OK
- Listar tipos de problemas: OK
- Listar denuncias de um determinado usuário cidadão:
- Visualizar feedback:
*/
@CrossOrigin
@RequestMapping("secret/dev")
@RestController
public class DevController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private DenunciaService denunciaService;
    @Autowired
    private OrgaoService orgaoService;
    @Autowired
    private TipoService tipoService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private OrgaoService orgService;


    @PutMapping("/alterar-tipo")
    public ResponseEntity<Object> atualizarTipo(@RequestBody Tipo tipo){
        Tipo t = tipoService.atualizar(tipo);
        if(t == null){
            return ResponseEntity.badRequest().body("Erro ao atualizar tipo!");
        }
        else{
            return ResponseEntity.ok("Tipo atualizado com sucesso!");
        }
    }

    @PutMapping("/alterar-orgao")
    public ResponseEntity<Object> atualizarOrgao(@RequestBody Orgao orgao){
        Orgao org = orgaoService.atualizar(orgao);
        if(org == null){
            return ResponseEntity.badRequest().body("Erro ao atualizar órgão!");
        }
        else{
            return ResponseEntity.ok("Órgão atualizado com sucesso!");
        }
    }

    //inserir
    @PostMapping("/add-tipo")
    public ResponseEntity<Object> addTipo(@RequestBody Tipo tipo){
        Tipo t = tipoService.save(tipo);
        if(t == null){
            return ResponseEntity.badRequest().body("Erro ao inserir Tipo!");
        }
        else{
            return ResponseEntity.ok("Tipo cadastrado com sucesso!");
        }
    }

    @PostMapping("/add-orgao")
    public ResponseEntity<Object> addOrgao(@RequestBody Orgao orgao){
        Orgao org = orgaoService.save(orgao);
        if(org == null){
            return ResponseEntity.badRequest().body("Erro ao inserir orgão!");
        }
        else{
            return ResponseEntity.ok("Orgão cadastrado com sucesso!");
        }
    }


    //Apagar
    @DeleteMapping("/del-orgao-id/{id}")
    public void delOrgaoId(@PathVariable Long id){
        orgaoService.excluirId(id);
    }
    @DeleteMapping("/del-tipo-id/{id}")
    public void delTipoId(@PathVariable Long id){
        tipoService.excluirId(id);
    }
    @DeleteMapping("/del-denuncia-id/{id}")
    public void delDenunciaId(@PathVariable Long id){
        denunciaService.excluirId(id);
    }


    //Listar um
    @GetMapping("/get-denuncia-id/{id}")
    public ResponseEntity<Object> getDenunciaId(@PathVariable Long id){
        Denuncia den = denunciaService.buscaPorId(id);
        return ResponseEntity.ok(den);
    }
    @GetMapping("/get-tipo-id/{id}")
    public ResponseEntity<Object> getTipoId(@PathVariable Long id){
        return ResponseEntity.ok(tipoService.buscaPorId(id));
    }
    @GetMapping("/get-orgao-id/{id}")
    public ResponseEntity<Object> getOrgaoId(@PathVariable Long id){
        return ResponseEntity.ok(orgaoService.buscaPorId(id));
    }


    //Listar todos
    /*
    @GetMapping("/get-all-usuarios")
    public ResponseEntity<Object> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.getAll());
    }
     */







    @PostMapping("/add-denuncia")
    public ResponseEntity<Object> addDenuncia(@RequestBody Denuncia denuncia){
        Denuncia d = denunciaService.save(denuncia);
        if(d == null){
            return ResponseEntity.badRequest().body("Erro ao inserir denúncia!");
        }
        else{
            return ResponseEntity.ok("Denúncia cadastrada com sucesso!");
        }
    }


    //Listar todos
    @GetMapping("/get-all-orgaos")
    public ResponseEntity<Object> getAllOrgaos() {
        return ResponseEntity.ok(orgService.getAll());
    }

    @GetMapping("/get-all-denuncias")
    public ResponseEntity<Object> getAllDenuncias(){
        return ResponseEntity.ok(denunciaService.getAll());
    }

    @GetMapping("/get-all-tipos")
    public ResponseEntity<Object> getAllTipos(){
        return ResponseEntity.ok(tipoService.getAll());
    }

    @GetMapping("/get-all-feedbacks")
    public ResponseEntity<Object> getAllFeedbacks(){
        return ResponseEntity.ok(feedbackService.getAll());
    }
}
