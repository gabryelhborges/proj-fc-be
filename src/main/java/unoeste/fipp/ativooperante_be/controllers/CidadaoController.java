package unoeste.fipp.ativooperante_be.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.ativooperante_be.db.entities.*;
import unoeste.fipp.ativooperante_be.services.*;

import java.util.List;

/*
 A ser consumida pelo cidadao
- Enviar a denúncia: OK
- Listar orgãos competentes: OK
- Listar tipos de problemas: OK
- Listar denuncias de um determinado usuário cidadão:
- Visualizar feedback: +- OK
 */

@CrossOrigin
@RestController
@RequestMapping("apis/cidadao")
public class CidadaoController {
    @Autowired
    private OrgaoService orgService;
    @Autowired
    private TipoService tipoService;
    @Autowired
    private DenunciaService denunciaService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add-denuncia")
    public ResponseEntity<Object> addDenuncia(@RequestBody DenunciaDTO dto){
        Usuario user = usuarioService.consultaPorId(dto.getUsuarioId());
        Orgao org = orgService.consultaPorId(dto.getOrgaoId());
        Tipo t = tipoService.consultaPorId(dto.getTipoId());

        Denuncia denuncia = new Denuncia(0L, dto.getTitulo(), dto.getTexto(), dto.getUrgencia(), org, dto.getData(), t, user);

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

    @GetMapping("/get-denuncias-cidadao")
    public ResponseEntity<Object> getAllDenuncias(@RequestParam Long userId){
        Usuario user = usuarioService.consultaPorId(userId);
        List<Denuncia> denuncias;
        denuncias= denunciaService.buscaPorUsuario(user);
        return ResponseEntity.ok(denuncias);
    }

    @GetMapping("/get-all-tipos")
    public ResponseEntity<Object> getAllTipos(){
        return ResponseEntity.ok(tipoService.getAll());
    }

    @GetMapping("/get-feedbacks-cidadao")
    public ResponseEntity<Object> getAllFeedbacks(@RequestParam Long userId){

        return ResponseEntity.ok(feedbackService.getAll());
    }
}
