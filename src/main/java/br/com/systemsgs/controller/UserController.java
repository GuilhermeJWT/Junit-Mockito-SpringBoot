package br.com.systemsgs.controller;

import br.com.systemsgs.dto.ModelUserDTO;
import br.com.systemsgs.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ModelUserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), ModelUserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ModelUserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().
                stream().map(x -> mapper.map(x, ModelUserDTO.class)).collect(Collectors.toList()));
    }

}
