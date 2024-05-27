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



}
