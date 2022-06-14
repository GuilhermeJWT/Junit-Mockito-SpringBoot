package br.com.systemsgs.service;

import br.com.systemsgs.domain.ModelUser;

import java.util.List;

public interface UserService {

    ModelUser findById(Integer id);

    List<ModelUser> findAll();
}
