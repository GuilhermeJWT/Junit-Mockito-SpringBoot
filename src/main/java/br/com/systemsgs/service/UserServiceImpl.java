package br.com.systemsgs.service;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.dto.ModelUserDTO;
import br.com.systemsgs.exception.DataIntegratyViolationException;
import br.com.systemsgs.exception.ObjectNotFoundException;
import br.com.systemsgs.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ModelUser findById(Integer id) {
        Optional<ModelUser> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado!"));
    }

    public List<ModelUser> findAll(){
        return repository.findAll();
    }

    @Override
    public ModelUser create(ModelUserDTO dto) {
        findByEmail(dto);
        return repository.save(mapper.map(dto, ModelUser.class));
    }

    private void findByEmail(ModelUserDTO dto){
        Optional<ModelUser> user = repository.findByEmail(dto.getEmail());
        if(user.isPresent()){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }

}
