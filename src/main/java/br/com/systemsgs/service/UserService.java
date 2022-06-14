package br.com.systemsgs.service;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.dto.ModelUserDTO;

import java.util.List;

public interface UserService {

    ModelUser findById(Integer id);

    List<ModelUser> findAll();

    ModelUser create(ModelUserDTO dto);

}
