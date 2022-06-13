package br.com.systemsgs.service;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.exception.ObjectNotFoundException;
import br.com.systemsgs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public ModelUser findById(Integer id) {
        Optional<ModelUser> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado!"));
    }

}
