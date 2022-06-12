package br.com.systemsgs.service;

import br.com.systemsgs.domain.ModelUser;

public interface UserService {

    ModelUser findById(Integer id);

}
