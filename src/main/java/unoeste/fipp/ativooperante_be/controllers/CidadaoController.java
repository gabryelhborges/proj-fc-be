package unoeste.fipp.ativooperante_be.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.ativooperante_be.db.entities.Denuncia;
import unoeste.fipp.ativooperante_be.services.DenunciaService;
import unoeste.fipp.ativooperante_be.services.FeedbackService;
import unoeste.fipp.ativooperante_be.services.OrgaoService;
import unoeste.fipp.ativooperante_be.services.TipoService;

/*
 A ser consumida pelo cidadao
- Enviar a denúncia: OK
- Listar orgãos competentes: OK
- Listar tipos de problemas: OK
- Listar denuncias de um determinado usuário cidadão:
- Visualizar feedback: +- OK
 */

@CrossOrigin
@RequestMapping("apis/cidadao")
@RestController
public class CidadaoController {
    @Autowired
    private OrgaoService orgService;
    @Autowired
    private TipoService tipoService;
    @Autowired
    private DenunciaService denunciaService;
    @Autowired
    private FeedbackService feedbackService;

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
