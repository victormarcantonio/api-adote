package com.example.apiadote.api.controller;

import com.example.apiadote.api.controller.dto.UsuarioDTO;
import com.example.apiadote.exception.ErroAutenticacao;
import com.example.apiadote.exception.RegraNegocioException;
import com.example.apiadote.model.entity.Usuario;
import com.example.apiadote.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value="autenticar")
    public ResponseEntity autenticar  (@RequestBody UsuarioDTO dto) {
       try {
           Usuario usuarioAutenticado = usuarioService.authenticate(dto.getEmail(), dto.getSenha());
           return ResponseEntity.ok(usuarioAutenticado);
       }catch(ErroAutenticacao e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO salvar(@RequestBody UsuarioDTO dto) {
       Usuario usuario = toEntity(dto);

       return toModel(usuarioService.createUsuario(usuario));
    }

    private UsuarioDTO toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }



    private Usuario toEntity(UsuarioDTO dto) {
        return modelMapper.map(dto, Usuario.class);

    }

    
}
