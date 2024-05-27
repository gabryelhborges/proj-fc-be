package unoeste.fipp.ativooperante_be.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unoeste.fipp.ativooperante_be.db.entities.Usuario;
import unoeste.fipp.ativooperante_be.db.repositories.UsuarioRepository;
import unoeste.fipp.ativooperante_be.security.JWTTokenProvider;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/")
public class AccessController {
    @Autowired
    UsuarioRepository usuarioRep;
    @PostMapping("logar")
    public ResponseEntity<Object> logar(@RequestBody Usuario usu){
        String token = "NAO AUTENTICADO";
        //buscar usuario no banco de dados e envia-lo por parametro no getToken
        List<Usuario> users = usuarioRep.findAllByEmail(usu.getEmail());
        Usuario user= null;
        if(!users.isEmpty()) {
            user= users.get(0);
        }
        if(user != null) {
            if (usu.getSenha() == user.getSenha()) {
                token = JWTTokenProvider.getToken(user);
            }
        }
        return ResponseEntity.ok(token);
    }

    @PostMapping("cadastro-cidadao")
    public ResponseEntity<Object> cadastroCidadao(Usuario u){
        return ResponseEntity.ok(usuarioRep.save(u));
    }
}
