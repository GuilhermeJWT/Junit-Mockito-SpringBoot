package br.com.systemsgs.controller;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ModelUser> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
